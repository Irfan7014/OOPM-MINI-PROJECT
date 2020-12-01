package Maintenance;

public class Maintenance {
    String name, building,flat,previousDueAmount,currentBillAmount;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getPreviousDueAmount() {
        return previousDueAmount;
    }

    public void setPreviousDueAmount(String previousDueAmount) {
        this.previousDueAmount = previousDueAmount;
    }

    public String getCurrentBillAmount() {
        return currentBillAmount;
    }

    public void setCurrentBillAmount(String currentBillAmount) {
        this.currentBillAmount = currentBillAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Maintainance{" +
                "name='" + name + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }
}
