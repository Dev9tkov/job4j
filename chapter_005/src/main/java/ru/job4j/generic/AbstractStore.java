package ru.job4j.generic;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 09.12.2019
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private final SimpleArray<T> array;

    public AbstractStore(int size) {
        this.array = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        this.array.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int position = this.findIndexById(id);
        if (position != -1) {
            this.array.set(position, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int position = this.findIndexById(id);
        if (position != -1) {
            this.array.remove(position);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        int position = this.findIndexById(id);
        if (position != -1) {
            result = this.array.get(position);
        }
        return result;
    }

    private int findIndexById(String id) {
        int result = -1;
        for (int i = 0; i < array.size(); i++) {
            if (this.array.get(i).getId().equals(id)) {
                result = i;
            }
        }
        return result;
    }
}
