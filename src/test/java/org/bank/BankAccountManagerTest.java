package org.bank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountManagerTest {
    @InjectMocks
    private BankAccountManager bankAccountManager;
    @Mock
    private BankAccountHelper helper;

    @Test
    public void testAddMoney() {

        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountCurrency("BYN");
        double balance = new Random().nextDouble();
        bankAccount.setCurrentBalance(balance);
        double amountToAdd = new Random().nextDouble();
        when(helper.convertCurrency("BYN", "BYN", amountToAdd)).thenReturn(amountToAdd);

        bankAccountManager.addMoney(bankAccount, amountToAdd, "BYN");

        assertEquals(amountToAdd + balance, bankAccount.getCurrentBalance(), 0.001);
    }

    @Test
    public void testWithdrawMoney() throws InvalidBankOperationException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountCurrency("BYN");
        double dailyLimit = new Random().nextDouble();
        bankAccount.setDailyLimit(dailyLimit);
        double amount = new Random().nextDouble();
        double balance = new Random().nextDouble();
        bankAccount.setCurrentBalance(balance);

        when(helper.isBalanceValidForWithdraw(bankAccount, amount, bankAccount.getAccountCurrency())).thenReturn(true);
        when(helper.isAvailableForDailyWithdraw(bankAccount, amount)).thenReturn(true);
        when(helper.convertCurrency("BYN", bankAccount.getAccountCurrency(), amount)).thenReturn(amount);

        double convertAmount = bankAccountManager.withdrawMoney(bankAccount, amount, "BYN");

        assertEquals(convertAmount, amount, 0.001);
    }


    @Test(expected = org.bank.InvalidBankOperationException.class)
    public void testWithdrawMoneyExc() throws InvalidBankOperationException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountCurrency("BYN");
        double dailyLimit = new Random().nextDouble();
        bankAccount.setDailyLimit(dailyLimit);
        double amount = new Random().nextDouble();
        double balance = new Random().nextDouble();
        bankAccount.setCurrentBalance(balance);

        when(helper.isBalanceValidForWithdraw(bankAccount, amount, bankAccount.getAccountCurrency())).thenReturn(false);

        double convertAmount = bankAccountManager.withdrawMoney(bankAccount, amount, "BYN");
        assertEquals(convertAmount, amount, 0.001);
    }

    @Test
    public void testTransferMoney() throws InvalidBankOperationException {
        BankAccount fromAccount = new BankAccount();
        BankAccount toAccount = new BankAccount();
        fromAccount.setAccountNumber("BYN");
        toAccount.setAccountNumber("BYN");
        double balanceTo = new Random().nextDouble();
        double balanceFrom = new Random().nextDouble();
        toAccount.setCurrentBalance(balanceTo);
        fromAccount.setCurrentBalance(balanceFrom);
        double dailyLimitTo = new Random().nextDouble();
        double dailyLimitFrom = new Random().nextDouble();
        toAccount.setDailyLimit(dailyLimitTo);
        fromAccount.setDailyLimit(dailyLimitFrom);

        double amount = new Random().nextDouble();

        when(helper.isBalanceValidForWithdraw(fromAccount,amount,fromAccount.getAccountCurrency())).thenReturn(true);
        when(helper.isAvailableForDailyWithdraw(fromAccount,amount)).thenReturn(true);


        when(helper.convertCurrency(fromAccount.getAccountCurrency(), toAccount.getAccountCurrency(), amount)).thenReturn(amount);
        bankAccountManager.transferMoney(fromAccount, toAccount, amount);

        assertEquals(fromAccount.getCurrentBalance(), balanceFrom - amount, 0.001);
        assertEquals(fromAccount.getDailyLimit(), dailyLimitFrom - amount, 0.001);
        assertEquals(toAccount.getDailyLimit(), dailyLimitTo - amount, 0.001);
    }


}