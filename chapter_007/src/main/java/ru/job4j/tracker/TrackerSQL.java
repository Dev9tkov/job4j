package ru.job4j.tracker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 03.02.2020
 */
public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;

    public TrackerSQL(Connection connection) {
        this.connection = connection;
    }

    private static final Logger LOG = LogManager.getLogger(TrackerSQL.class.getName());

    /**
     * осуществление коннетка к БД. Проверяет, есть ли наличие таблицы item. Если нет -
     * переход к методу createTable
     * @return
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            ResultSet rset = this.connection.getMetaData().getTables(null, null, "item", null);
            if (!rset.next()) {
                createTable();
            }
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
                new InputStreamReader(TrackerSQL.class.getClassLoader().getResourceAsStream("createTable.sql")))) {
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

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @Override
    public Item add(Item item) {
        String insertItem = "insert into item (item_name, item_description) values (?, ?)";
        try (PreparedStatement ps = this.connection.prepareStatement(insertItem, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.executeUpdate();
            LOG.info(ps.toString());
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int itemId = keys.getInt("item_id");
                item.setId(Integer.toString(itemId));
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        String replace = "update item set item_name = ?, item_description = ? where item_id = ?";
        try (PreparedStatement ps = this.connection.prepareStatement(replace)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            int keyId = Integer.parseInt(id);
            ps.setInt(3, keyId);
            LOG.info(ps.toString());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        String delete = "delete from item where item_id = ?";
        try (PreparedStatement ps = this.connection.prepareStatement(delete)) {
            int keyId = Integer.parseInt(id);
            ps.setInt(1, keyId);
            LOG.info(ps.toString());
            if (ps.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        String findAll = "select item_id, item_name, item_description from item";
        try (PreparedStatement ps = this.connection.prepareStatement(findAll)) {
            LOG.info(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String itemId, name, desc;
                itemId = String.valueOf(rs.getInt("item_id"));
                name = rs.getString("item_name");
                desc = rs.getString("item_description");
                Item item = new Item(itemId, name, desc);
                result.add(item);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        String findByName = "select item_id, item_name, item_description from item where item_name = ?";
        try (PreparedStatement ps = this.connection.prepareStatement(findByName)) {
            ps.setString(1, key);
            LOG.info(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String itemId, name, desc;
                itemId = String.valueOf(rs.getInt("item_id"));
                name = rs.getString("item_name");
                desc = rs.getString("item_description");
                Item item = new Item(itemId, name, desc);
                result.add(item);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        String findById = "select item_id, item_name, item_description from item where item_id = ?";
        try (PreparedStatement ps = this.connection.prepareStatement(findById)) {
            int keyId = Integer.parseInt(id);
            ps.setInt(1, keyId);
            LOG.info(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String itemId, name, desc;
                itemId = String.valueOf(rs.getInt("item_id"));
                name = rs.getString("item_name");
                desc = rs.getString("item_description");
                item = new Item(itemId, name, desc);
                }
            } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }
}
