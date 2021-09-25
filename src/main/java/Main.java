import Service.*;
import Service.commission.*;
import dao.AccountDAO;
import dao.AccountDAOImpl;
import data_base.Storage;
import model.Account;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Account.Type, CommissionHandler> map = new HashMap<>();
        map.put(Account.Type.GOLD, new GoldCommissionHandler());
        map.put(Account.Type.PLATINUM, new PlatinumCommissionHandler());
        map.put(Account.Type.REGULAR, new RegularCommissionHandler());
        map.put(Account.Type.USUAL, new UsualCommissionHandler());

        CommissionStrategy commissionStrategy = new CommissionStrategyImpl(map);

        AccountDAO accountDAO = new AccountDAOImpl();
        AccountService accountService = new AccountServiceImpl(accountDAO);
        accountService.createNawAccount("123");
        accountDAO.get("123").setAmount(BigDecimal.valueOf(1250));
        accountDAO.get("123").setType(Account.Type.PLATINUM);

        accountService.createNawAccount("456");
        accountDAO.get("456").setAmount(BigDecimal.valueOf(1000));
        accountDAO.get("456").setType(Account.Type.GOLD);

        accountService.createNawAccount("789");
        accountDAO.get("789").setAmount(BigDecimal.valueOf(2000));
        accountDAO.get("789").setType(Account.Type.REGULAR);

        BankService bankService = new BankServiceImpl(accountDAO, commissionStrategy);
        bankService.transfer("123", "789", BigDecimal.valueOf(100));


    }
}
