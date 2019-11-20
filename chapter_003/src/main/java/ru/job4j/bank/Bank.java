package ru.job4j.bank;

import java.util.*;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 18.11.2019
 */
public class Bank {
    private Map<User, List<Account>> spisok = new HashMap<>();

    /**
     * Добавление user
     * .putIfAbsent добавит пару, если ее нет в Map
     *
     * @param user
     */
    public void addUser(User user) {
        List<Account> acc = new ArrayList<>();
        this.spisok.putIfAbsent(user, acc);
    }

    /**
     * Удаление User
     *
     * @param user
     */
    public void deleteUser(User user) {
        this.spisok.remove(user);
    }

    /**
     * Добавление акаунта по паспорту
     *
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : spisok.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                if (!(entry.getValue().contains(account))) {
                    entry.getValue().add(account);
                }
            }
        }
    }

    /**
     * Удаление акаунта по паспорту
     *
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : spisok.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                entry.getValue().remove(account);
            }
        }
    }

    /**
     * Возвращает список всех аккаунтов у пользователя
     *
     * @param passport
     * @return list аков
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> entry : spisok.entrySet()) {
            if (passport.equals(entry.getKey().getPassport())) {
                accounts = entry.getValue();
                break;
            }
        }
        return accounts;
    }

    /**
     * Поиск акканута по реквизитам из списка аккаунтов.
     *
     * @param accounts
     * @param requisites
     * @return нужный аккаунт
     */
    public Account getAcc(List<Account> accounts, String requisites) {
        Account acc = null;
        for (Account value : accounts) {
            if (value.getRequisites().equals(requisites)) {
                acc = value;
            }
        }
        return acc;
    }

    /**
     * Перевод суммы от отдного к другому
     * Сначала найдем список аккаунтов по пасспорту
     * Потом найдем аккаунт по реквизитам из списка аккаунтов
     * Если значения аккаунтов не null, то осуществялем перевод суммы
     *
     * @param srcPassport  Пас отправителя
     * @param srcRequisite Реквиз отправителя
     * @param destPassport Пас получателя
     * @param dstRequisite Реквиз получателя
     * @param amount       сумма
     * @return успех операции
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result;
        List<Account> srcacc = getUserAccounts(srcPassport);
        Account srcaccount = getAcc(srcacc, srcRequisite);
        if (srcaccount == null) {
            result = false;
        }
        List<Account> dstacc = getUserAccounts(destPassport);
        Account destaccount = getAcc(dstacc, dstRequisite);
        if (destaccount == null) {
            result = false;
        }
        srcaccount.transfer(destaccount, amount);
        result = true;
        return result;
    }
}
