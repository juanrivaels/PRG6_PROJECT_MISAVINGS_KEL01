package model;

public class Finance {
    private int financialId;
    private int userId;
    private int typeOfFinance;
    private String dateCreated;
    private double amount;
    private int storageId;
    private String description;


    public int getFinancialId() {
        return financialId;
    }

    public void setFinancialId(int financialId) {
        this.financialId = financialId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTypeOfFinance() {
        return typeOfFinance;
    }

    public void setTypeOfFinance(int typeOfFinance) {
        this.typeOfFinance = typeOfFinance;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
