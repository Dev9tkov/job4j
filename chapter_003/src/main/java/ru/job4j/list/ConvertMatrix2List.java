package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. Конвертация двумерного массива в ArrayList[#187415]
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 11.11.2019
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                list.add(i * array.length + j, array[i][j]);
            }
        }
        return list;
    }
}
