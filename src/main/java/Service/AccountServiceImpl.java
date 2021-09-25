package Service;

import dao.AccountDAO;
import model.Account;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void createNawAccount(String accountNumber) {
        Account account = new Account();
        account.setNumbers(accountNumber);
        accountDAO.add(account);
    }
}
