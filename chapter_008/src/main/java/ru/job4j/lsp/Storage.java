package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 05.03.2020
 */
public class Storage {
    private PlaceStrategy placeStrategy;
    private List<Food> foods;

    public Storage(PlaceStrategy placeStrategy) {
        this.placeStrategy = placeStrategy;
        this.foods = new ArrayList<>();
    }

    public List<Food> getFoods() {
        return foods;
    }

    public boolean addFood(Food food) throws ParseException {
        return this.placeStrategy.add(food, this.foods);
    }
}
