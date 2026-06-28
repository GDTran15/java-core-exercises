/* 1. Code class ImmutableBankAccount với balance (BigDecimal), không setter,
withdraw/deposit return new instance. */

import java.math.BigDecimal;
import exception.*;

public class ImmutableBankAccount {
    private BigDecimal balance;

    public ImmutableBankAccount(BigDecimal balance){
        checkIfInputIsNegative(balance);
        this.balance = balance;
    }

    public ImmutableBankAccount withdraw(BigDecimal amount){
        checkIfInputIsNegative(amount);
        if (amount.compareTo(balance) > 0) {
            throw new BalanceNotEnoughException("Your balance not enough");
        }
        return new ImmutableBankAccount(balance.subtract(amount));
    }

    public ImmutableBankAccount deposit(BigDecimal amount){
        checkIfInputIsNegative(amount);
    
        return new ImmutableBankAccount(balance.add(amount));
    }

    private void checkIfInputIsNegative(BigDecimal amount){
        if (amount.signum() == -1) {
           throw new NegativeInputException("Invalid input. The input cannot be negative");
        }
    }
    
}