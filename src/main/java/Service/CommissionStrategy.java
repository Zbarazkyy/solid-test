package Service;

import Service.commission.CommissionHandler;
import model.Account;

public interface CommissionStrategy {
      CommissionHandler ger(Account.Type type);
}
