package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 05.02.2020
 */
public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;
    private static final Logger LOG = LogManager.getLogger(StoreSQL.class.getName());

    public StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * Генерация в таблице size записей
     * addBatch() добавляет отдельный sql запрос в "пакет"
     * executeBatch() выполнение всех запросов, находящихся в "пакете"
     * .setAutoCommit(false) Отмена автоматической фиксации транзакции
     * .commit() - завершение всех изменений в БД
     * .setAutoCommit(true) восстановленте по умолчанию
     * .rollback() откат к начальному состоянии базы, если не удалось закомитить запросы
     * @param size - кол-во записей
     */
    public void generate(int size) {
        createTable();
        String insert = "insert into entry (field) values (?)";
        try (PreparedStatement ps = this.connect.prepareStatement(insert)) {
            this.connect.setAutoCommit(false);
            for (int i = 1; i != size + 1; i++) {
                ps.setInt(1, i);
                ps.addBatch();
            }
            ps.executeBatch();
            try {
                this.connect.commit();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
                this.connect.rollback();
            }
            this.connect.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Создание таблицы entry, если она не смуществует.
     * Если сущесвует - очистка всех записей
     */
    public void createTable() {
        try {
            this.connect = DriverManager.getConnection(config.get("url"));
            Statement st = this.connect.createStatement();
            st.executeUpdate("create table if not exists entry(field integer)");
            st.executeUpdate("delete from entry");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Добавляет значения из БД в List
     * @return List
     */
    public List<Entry> load() {
        List<Entry> values = new ArrayList<>();
        String load = "select field from entry";
        try (Statement ps = this.connect.createStatement()) {
            ResultSet rs = ps.executeQuery(load);
            while (rs.next()) {
                values.add(new Entry(rs.getInt("field")));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return values;
    }

    @Override
        public void close() throws Exception {
            if (connect != null) {
                connect.close();
            }
        }
    }
