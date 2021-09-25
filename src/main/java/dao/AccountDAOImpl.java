package dao;

import data_base.Storage;
import model.Account;

public class AccountDAOImpl implements AccountDAO {


    public void add(Account account) {
        Storage.accountStorage.add(account);

    }

    public Account get(String accountNumber) {
        return Storage.accountStorage
                .stream().filter(a -> a.getNumbers().equals(accountNumber))
                .findFirst().get();
    }

    @Override
    public void update(Account account) {
        Account accountFromDb = get(account.getNumbers());
        Storage.accountStorage.remove(accountFromDb);
        add(account);
    }
}

