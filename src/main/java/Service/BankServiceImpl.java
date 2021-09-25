package Service;

import Service.commission.CommissionHandler;
import dao.AccountDAO;
import data_base.Storage;
import model.Account;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {
    private AccountDAO accountDAO;
    private CommissionStrategy commissionStrategy;

    public BankServiceImpl(AccountDAO accountDAO, CommissionStrategy commissionStrategy) {
        this.accountDAO = accountDAO;
        this.commissionStrategy = commissionStrategy;
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Account fromAccount = accountDAO.get(fromAccountNumber);
        Account toAccount = accountDAO.get(toAccountNumber);

        BigDecimal commission = commissionStrategy.ger(fromAccount.getType()).getCommission(amount);

        BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount).subtract(commission);
        fromAccount.setAmount(newValueFrom);

        BigDecimal newValueTo = toAccount.getAmount().add(amount);
        toAccount.setAmount(newValueTo);

        accountDAO.update(fromAccount);
        accountDAO.update(toAccount);

    }


}

