package Service;

import Service.commission.CommissionHandler;
import model.Account;

import java.util.Map;

public class CommissionStrategyImpl implements CommissionStrategy {
    private Map<Account.Type, CommissionHandler> commissionHandlerMap;

    public CommissionStrategyImpl(Map<Account.Type, CommissionHandler> commissionHandlerMap) {
        this.commissionHandlerMap = commissionHandlerMap;
    }

    @Override
    public CommissionHandler ger(Account.Type type) {
        return commissionHandlerMap.get(type);
    }
}
