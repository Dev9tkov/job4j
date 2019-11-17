package ru.job4j.list;



import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 13.11.2019
 */
public class SortUser {
    public Set<Usernew> sort(List<Usernew> list) {
        Set<Usernew> result = new TreeSet<>(list);
        return result;
    }

    /**
     * Comparator для метода Collections.sort и отсортировать List<User> по длине имени
     * @param list
     * @return
     */
    public List<Usernew> sortNameLength(List<Usernew> list) {
        list.sort(new Comparator<Usernew>() {
            @Override
            public int compare(Usernew o1, Usernew o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    /**
     * Comparator для метода Collections.sort и отсортировать List<User> по обоим полям,
     * сначала сортировка по имени в лексикографическом порядке, потом по возрасту
     * @param list
     * @return
     */
    public List<Usernew> sortByAllFields(List<Usernew> list) {
        list.sort(new Comparator<Usernew>() {
            @Override
            public int compare(Usernew o1, Usernew o2) {
                int a = o1.getName().compareTo(o2.getName());
                return a != 0 ? a : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
