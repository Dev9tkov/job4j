package ru.job4j.list;

import java.util.List;


/**
 * 3. Конвертация ArrayList в двухмерный массив[#187416]
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 11.11.2019
 */
public class ConvertList2Array {

    /**
     * Метод переводит List в двумерный массив.
     *
     * @param list list
     * @param rows кол-во столбцов
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = ((list.size() + (rows - 1)) / rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
            for (Integer volume : list) {
                    array[i][j++] = volume;
                    if (j == cells) {
                        i++;
                        j = 0;
                    }
            }
        return array;
    }
}







