package dao;

import model.Account;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOusingFailImpl implements AccountDAO {
    private static final String FILE_NAME = "data_base.csv";

    @Override
    public void add(Account account) {

    }

    @Override
    public Account get(String accountNumber) {
        List<String> account = new ArrayList<>();

        try {
            account = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Incorrect path to file");
        }
        return account.stream()
                .filter(line -> line.equals(accountNumber))
                .map(lineToPars -> getAccountFromFile(lineToPars))
                .findFirst().get();
    }

    @Override
    public void update(Account account) {

    }

    private Account getAccountFromFile(String line) {
        String[] fields = line.split(",");
        Account account = new Account();
        account.setNumbers(fields[0]);
        account.setAmount(new BigDecimal(fields[1]));
        account.setType(Account.Type.valueOf(fields[2]));
        return account;
    }

}
