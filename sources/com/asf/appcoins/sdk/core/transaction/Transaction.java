package com.asf.appcoins.sdk.core.transaction;

public final class Transaction {
    private String from;
    private String hash;
    private final Status status;

    /* renamed from: to */
    private final String f10211to;
    private final String value;

    public enum Status {
        PENDING((String) -1),
        ACCEPTED((String) 1),
        FAILED((String) 0);
        
        private final String value;

        private Status(int value2) {
            this.value = Integer.toString(value2);
        }

        private Status(String value2) {
            this.value = value2;
        }

        public String getValue() {
            return this.value;
        }
    }

    public Transaction(String hash2, String from2, String to, String value2, Status status2) {
        this.hash = hash2;
        this.from = from2;
        this.f10211to = to;
        this.value = value2;
        this.status = status2;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash2) {
        this.hash = hash2;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from2) {
        this.from = from2;
    }

    public String getTo() {
        return this.f10211to;
    }

    public String getValue() {
        return this.value;
    }

    public Status getStatus() {
        return this.status;
    }
}
