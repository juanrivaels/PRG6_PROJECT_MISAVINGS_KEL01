package model;

public class Goal {
    private int goalId;
    private int userId;
    private String goalName;
    private String dateCreated;
    private String targetDate;
    private double targetAmount;
    private double savedAlready;
    private String modiDate;
    private String goalColor;
    private byte[] goalIcon;
    private int status;

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public double getSavedAlready() {
        return savedAlready;
    }

    public void setSavedAlready(double savedAlready) {
        this.savedAlready = savedAlready;
    }

    public String getModiDate() {
        return modiDate;
    }

    public void setModiDate(String modiDate) {
        this.modiDate = modiDate;
    }

    public String getGoalColor() {
        return goalColor;
    }

    public void setGoalColor(String goalColor) {
        this.goalColor = goalColor;
    }

    public byte[] getGoalIcon() {
        return goalIcon;
    }

    public void setGoalIcon(byte[] goalIcon) {
        this.goalIcon = goalIcon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
