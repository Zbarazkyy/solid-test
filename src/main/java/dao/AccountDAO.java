package dao;

import model.Account;

public interface AccountDAO {
    void add(Account account);

    Account get(String accountNumber);

    void update(Account account);
}

