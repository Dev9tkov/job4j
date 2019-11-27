package ru.job4j.departure;

import java.util.*;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 23.11.2019
 */
public class Departurelist {

//    private Comparator<String> reverse = new Comparator<String>() {
//        @Override
//        public int compare(String o1, String o2) {
//            int compared = o2.compareTo(o1);
//            if (o1.indexOf(o2) == 0) {
//                compared = 1;
//            }
//            if (o2.indexOf(o1) == 0) {
//                compared = -1;
//            }
//        }
//    }

    /**
     * Сортировка в прямом порядке
     * @param orgs Входящий лист департаментов
     * @return
     */
    public List<String> abs(List<String> orgs) {
        Collections.sort(orgs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return orgs;
    }

}
