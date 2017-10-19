package com.example.thomastournoux.counterfeittrap.object;

public class Trade {

    private String rolex;
    private String newOwner;
    private String transactionId;
    private String timestamp;

    public Trade() {

    }

    public Trade(String rolex, String newOwner, String transactionId, String timestamp) {
        this.rolex = rolex;
        this.newOwner = newOwner;
        this.transactionId = transactionId;
        this.timestamp = timestamp;
    }

    public String getRolex() {
        return rolex;
    }

    public void setRolex(String rolex) {
        this.rolex = rolex;
    }

    public String getNewOwner() {
        return newOwner;
    }

    public void setNewOwner(String newOwner) {
        this.newOwner = newOwner;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
