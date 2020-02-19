package ru.job4j.vacansyparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

/**
 * @author Ilya Devyatkov
 * @since 17.02.2020
 */
public class DataBase implements AutoCloseable {
    private Connection connection;
    private static final Logger LOG = LogManager.getLogger(DataBase.class.getName());

    /**
     * Соединение с БД
     * @return true or false
     */
    public boolean init() {
        try (InputStream in = DataBase.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
                createTable();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    /**
     * Создание БД из скрипта
     */
    public void createTable() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(DataBase.class.getClassLoader().getResourceAsStream("createTable.sql"))))) {
            String line;
            try (Statement st = this.connection.createStatement()) {
                while ((line = br.readLine()) != null) {
                    st.execute(line);
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Добавление вакансий в БД
     * Если в БД существуют записи, то происходит апдейт записей, появляются только новые
     * @param vacansies Set вакансий
     */
    public void addVacansys(Set<Vacansy> vacansies) {
        String addVacansy = "insert into vacancy (name, description, link) values (?, ?, ?)";
        String updateVacansy = "insert into vacancy (name, description, link) values (?, ?, ?) ON CONFLICT DO NOTHING";
        PreparedStatement ps;
        try (ResultSet rset = this.connection.getMetaData().getTables(null, null, "vacancy", null)) {
            if (!rset.next()) {
                ps = this.connection.prepareStatement(addVacansy);
            } else {
                ps = this.connection.prepareStatement(updateVacansy);
            }
            this.connection.setAutoCommit(false);
            for (Vacansy vac : vacansies) {
                ps.setString(1, vac.getName());
                ps.setString(2, vac.getText());
                ps.setString(3, vac.getLink());
                ps.addBatch();
            }
            ps.executeBatch();
            try {
                this.connection.commit();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
                this.connection.rollback();
            }
            this.connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
