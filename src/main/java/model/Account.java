package model;

import java.math.BigDecimal;

public class Account {
    private String numbers;
    private BigDecimal amount = new BigDecimal(0);
    private Type type;

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        REGULAR, GOLD, PLATINUM, USUAL;
    }
}
