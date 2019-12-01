package ru.job4j.departure;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 23.11.2019
 */
public class Departurelist {

    /**
     * Метод заполняет список недостающими элементами, по идее, если
     * мы используем TreeSet, то конечный лист уже будет осортирован
     * по Natural Order..
     *
     * @param orgs лист департаментов
     * @return полный лист
     */
    public List<String> fillGaps(List<String> orgs) {
        Set<String> set = new TreeSet<>(orgs);
        for (String value : orgs) {
            if (value.contains("//")) {
                set.add(value.substring(0, value.lastIndexOf("//")));
            }
            set.add(value);
        }
        return new ArrayList<>(set);
    }

    /**
     * Сортировка в прямом порядке
     * @param orgs Входящий лист департаментов
     * @return
     */
    public List<String> abs(List<String> orgs) {
        List<String> result = fillGaps(orgs);
        Collections.sort(result);
        return result;
    }

    /**
     * Сортировка в обратном порядке
     * @param orgs
     * @return
     */
    public List<String> desc(List<String> orgs) {
        List<String> list = fillGaps(orgs);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                int length = Math.min(o1.length(), o2.length());
                for (int i = 0; i < length; i++) {
                    result = Character.compare(o2.charAt(i), o1.charAt(i));
                    if (result != 0) {
                        break;
                    } else {
                        result = Integer.compare(o1.length(), o2.length());
                    }
                }
                return result;
            }
        });
        return list;
    }
}
