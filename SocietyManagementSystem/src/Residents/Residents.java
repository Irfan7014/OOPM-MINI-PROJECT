package Residents;
public class Residents 
{
    String name,buildingNum,flatNum,DOB,occupation,maritalStatus,rentOrOwner;
    int yearOfArrival,totalMembers;

    @Override
    public String toString() {
        return "Residents{" + "name=" + name + ", buildingNum=" + buildingNum + ", flatNum=" + flatNum + ", DOB=" + DOB + ", occupation=" + occupation + ", maritalStatus=" + maritalStatus + ", rentOrOwner=" + rentOrOwner + ", yearOfArrival=" + yearOfArrival + ", totalMembers=" + totalMembers + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(String flatNum) {
        this.flatNum = flatNum;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRentOrOwner() {
        return rentOrOwner;
    }

    public void setRentOrOwner(String rentOrOwner) {
        this.rentOrOwner = rentOrOwner;
    }

    public int getYearOfArrival() {
        return yearOfArrival;
    }

    public void setYearOfArrival(int yearOfArrival) {
        this.yearOfArrival = yearOfArrival;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }
}
