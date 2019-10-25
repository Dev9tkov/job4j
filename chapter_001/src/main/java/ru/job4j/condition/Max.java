package ru.job4j.condition;

public class Max {

    public int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }

    public int max(int left, int right, int third) {
        return max(left, max(right, third));
    }

    public int max(int left, int right, int third, int fourth) {
        return max(left, max(right, max(third, fourth)));
    }
}
