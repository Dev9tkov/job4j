package ru.job4j.bank;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 19.11.2019
 */
public class BankTest {
    @Test
    public void whenAddUserTest() {
        Bank bank = new Bank();
        User user1 = new User("Mitya", "571-17456");
        bank.addUser(user1);
        assertThat(bank.getUserAccounts("571-17456").size(), is(0));
    }

    @Test
    public void whenDeleteUserThenNoAccounts() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "571-17451");
        bank.addUser(user1);
        bank.deleteUser(user1);
        List<Account> pustoi = new ArrayList<>();
        assertThat(bank.getUserAccounts("571-17451"), is(pustoi));
    }

    @Test
    public void whenAddAccountToUserhThenHaveAccount() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "571-17451");
        bank.addUser(user1);
        Account acount1 = new Account(245.0, "12748-F");
        bank.addAccountToUser("571-17451", acount1);
        assertThat(bank.getUserAccounts("571-17451").get(0), is(acount1));
    }

    @Test
    public void deleteAccountFromUserThenHaveAccount() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "571-17452");
        bank.addUser(user1);
        Account acount1 = new Account(245.0, "12748-F");
        Account acount2 = new Account(458.0, "48748-A");
        bank.addAccountToUser("571-17452", acount1);
        bank.addAccountToUser("571-17452", acount2);
        bank.deleteAccountFromUser("571-17452", acount1);
        assertThat(bank.getUserAccounts("571-17452").get(0), is(acount2));
    }

    @Test
    public void getUserAccountsThenHaveListOfAccount() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "571-17452");
        bank.addUser(user1);
        Account acount1 = new Account(245.0, "12748-F");
        Account acount2 = new Account(458.0, "48748-A");
        Account acount3 = new Account(851.0, "84148-C");
        bank.addAccountToUser("571-17452", acount1);
        bank.addAccountToUser("571-17452", acount2);
        bank.addAccountToUser("571-17452", acount3);
        List<Account> expected = new ArrayList<>();
        expected.add(acount1);
        expected.add(acount2);
        expected.add(acount3);
        List<Account> result = bank.getUserAccounts("571-17452");
        assertThat(result, is(expected));
    }

    @Test
    public void getAccRequisites() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "571-17452");
        bank.addUser(user1);
        Account acount1 = new Account(245.0, "12748-F");
        Account acount2 = new Account(458.0, "48748-A");
        List<Account> result = new ArrayList<>();
        result.add(acount1);
        result.add(acount2);
        assertThat(bank.getAcc(result, "12748-F"), is(acount1));
    }

    @Test
    public void transferMoneyTest() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "571-17452");
        bank.addUser(user1);
        Account acount1 = new Account(245.0, "12748-F");
        Account acount2 = new Account(458.0, "48748-A");
        bank.addAccountToUser("571-17452", acount1);
        bank.addAccountToUser("571-17452", acount2);

        User user2 = new User("Nik", "563-95452");
        bank.addUser(user2);
        Account acount3 = new Account(124.0, "59548-R");
        bank.addAccountToUser("563-95452", acount3);

        boolean result = bank.transferMoney("571-17452", "48748-A", "563-95452", "59548-R", 35.0);
        assertEquals(acount3.getValue(), 159.0, 0.01);
    }
}
