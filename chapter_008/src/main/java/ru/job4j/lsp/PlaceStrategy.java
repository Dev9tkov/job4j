package ru.job4j.lsp;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public interface PlaceStrategy {

    /**
     *Нижняя граница срока годности
     */
    double LOW_EXPIRE = 0.25;

    /**
     * Верхняя граница срока годности
     */
    double HIGH_EXPIRE = 0.75;

    boolean add(Food food, List<Food> foods) throws ParseException;

}
