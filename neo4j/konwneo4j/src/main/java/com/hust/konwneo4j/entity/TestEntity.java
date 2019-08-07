package com.hust.konwneo4j.entity;


public class TestEntity {
    private AccountSubject accountSubject;
    private EconomicMatter economicMatter;
    private Purpose purpose;

    public void setAccountSubject(AccountSubject accountSubject) {
        this.accountSubject = accountSubject;
    }

    public void setEconomicMatter(EconomicMatter economicMatter) {
        this.economicMatter = economicMatter;
    }


    public AccountSubject getAccountSubject() {
        return accountSubject;
    }

    public EconomicMatter getEconomicMatter() {
        return economicMatter;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }
}
