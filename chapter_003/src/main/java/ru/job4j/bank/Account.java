package ru.job4j.bank;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 18.11.2019
 */
public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }



    /**
     * Перевод на счет другого аккаунта
     * @param account
     * @param amount
     * @return
     */
    public boolean transfer(Account account, double amount) {
        boolean result = false;
        if (!(this.value < amount)) {
            this.value -= amount;
            account.setValue(account.getValue() + amount);
            result = true;
        }
        return result;
    }

}

