package com.example.thomastournoux.counterfeittrap.object;

public class Trader {

    private String tradeId;
    private String firstName;
    private String lastName;

    public Trader() {

    }

    public Trader(String tradeId, String firstName, String lastName) {
        this.tradeId = tradeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
