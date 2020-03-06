package ru.job4j.lsp;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Ilya Devyatkov
 * @since 06.03.2020
 */
public class ControllQualityTest {
    private List<Storage> storages;
    private Storage trash;
    private Storage shop;
    private Storage warehouse;

    @Before
    public void before() {
        trash = new Storage(new Trash());
        shop = new Storage(new Shop());
        warehouse = new Storage(new Warehouse());
        storages = List.of(trash, shop, warehouse);
    }

    @Test
    public void whenExpiredThenAddToTrash() throws ParseException {
        ControllQuality controllQuality = new ControllQuality(storages);
        Date create = new SimpleDateFormat("yyyy.MM.dd").parse("2020.03.01");
        Date exp = new SimpleDateFormat("yyyy.MM.dd").parse("2020.03.04");
        Food expired = new Fruits("banans", create, exp, 58.5, 0);
        controllQuality.add(expired);
        List<Food> list = new ArrayList<>();
        list.add(expired);
        assertThat(trash.getFoods(), is(list));
    }

    @Test
    public void whenRateMoreThan25AndLowerThan75ThenAddToShop() throws ParseException {
        ControllQuality controllQuality = new ControllQuality(storages);
        Date create = new SimpleDateFormat("yyyy.MM.dd").parse("2020.03.01");
        Date exp = new SimpleDateFormat("yyyy.MM.dd").parse("2020.03.08");
        Food expMore25 = new Fruits("banans", create, exp, 58.5, 0);
        controllQuality.add(expMore25);
        List<Food> list = new ArrayList<>();
        list.add(expMore25);
        assertThat(shop.getFoods(), is(list));
    }

    @Test
    public void whenRateMoreThan75ThenAddToShopAndAddDiscount() throws ParseException {
        ControllQuality controllQuality = new ControllQuality(storages);
        Date create = new SimpleDateFormat("yyyy.MM.dd").parse("2020.03.01");
        Date exp = new SimpleDateFormat("yyyy.MM.dd").parse("2020.03.18");
        Food expMore75 = new Fruits("banans", create, exp, 58.5, 0);
        controllQuality.add(expMore75);
        List<Food> list = new ArrayList<>();
        list.add(expMore75);
        assertThat(shop.getFoods(), is(list));
        assertEquals(expMore75.getDiscount(), 10, 0.01);
    }
}