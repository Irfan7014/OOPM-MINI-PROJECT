package Maintainance;

public class Maintainance {
    String name, flat;

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
