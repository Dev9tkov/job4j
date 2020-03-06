package ru.job4j.lsp;

import java.text.ParseException;
import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class ControllQuality {
    private List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public boolean add(Food food) throws ParseException {
        boolean rsl = false;
        for (Storage val : storages) {
            if (val.addFood(food)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
