package ru.job4j.magnit;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 10.02.2020
 */
public class StoreSQLTest {
    @Test
    public void whenGenerateTenThenAddTenFields() {
        Config config = new Config();
        config.init();
        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.generate(10);
        List<Entry> result = storeSQL.load();
        assertThat(result.size(), is(10));
    }
}
