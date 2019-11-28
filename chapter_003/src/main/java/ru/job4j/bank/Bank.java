package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

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
     * Метод putIfAbsent добавит пару, если ее нет в Map
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
     * Поиск юзера по паспорту
     *
     * @param passport
     * @return юзер
     */
    public User searchUser(String passport) {
        User result = null;
        Map.Entry<User, List<Account>> entry = spisok.entrySet()
                .stream()
                .filter(user -> passport.equals(user.getKey().getPassport()))
                .findFirst()
                .get();
        result = entry.getKey();
        return result;
    }


    /**
     * Добавление акаунта по паспорту
     *
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        spisok.entrySet().stream()
                .filter(value -> value.getKey().equals(searchUser(passport)))
                .forEach(user -> user.getValue().add(account));
    }

    /**
     * Удаление акаунта по паспорту
     *
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        spisok.entrySet().stream()
                .filter(value -> value.getKey().equals(searchUser(passport)))
                .forEach(user -> user.getValue().remove(account));
    }


    /**
     * Возвращает список всех аккаунтов у пользователя
     *
     * @param passport
     * @return list аков
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = new ArrayList<>();
        accounts = spisok.entrySet().stream()
                .filter(value -> value.getKey().equals(searchUser(passport)))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(new ArrayList<>());
        return accounts;
    }


    /**
     * Поиск акканута по реквизитам из списка аккаунтов.
     *
     * @param accounts
     * @param requisites
     * @return нужный аккаунт
     */
    private Account getAcc(List<Account> accounts, String requisites) {
        Account acc = null;
        acc = accounts.stream()
                .filter(account -> account.getRequisites().equals(requisites))
                .findFirst()
                .orElse(null);
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
        boolean result = false;
            List<Account> srcacc = getUserAccounts(srcPassport);
            List<Account> dstacc = getUserAccounts(destPassport);
            if (!(srcacc.isEmpty() || dstacc.isEmpty())) {
                Account srcaccount = getAcc(srcacc, srcRequisite);
                Account destaccount = getAcc(dstacc, dstRequisite);
                if (srcaccount != null && destaccount != null && srcaccount.getValue() >= amount) {
                    srcaccount.transfer(destaccount, amount);
                    result = true;
                }
            }
        return result;
    }
}
