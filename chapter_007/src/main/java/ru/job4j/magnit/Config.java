package ru.job4j.magnit;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Ilya Devyatkov
 * @since 05.02.2020
 */
public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("sqlite_app.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
