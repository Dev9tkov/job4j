package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        int result1 = result > third ? result : third;
        return result1;
    }
}
