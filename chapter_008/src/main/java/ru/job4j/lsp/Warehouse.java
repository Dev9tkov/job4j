package ru.job4j.lsp;

import java.text.ParseException;
import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class Warehouse implements PlaceStrategy {

    @Override
    public boolean add(Food food, List<Food> foods) throws ParseException {
        boolean rsl = false;
        if (food.getExpirePersent() < PlaceStrategy.LOW_EXPIRE) {
            rsl = foods.add(food);
        }
        return rsl;
    }
}
