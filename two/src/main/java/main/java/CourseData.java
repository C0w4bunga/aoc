package main.java;

public class CourseData {

    String direction;
    int unit;

    public CourseData(String direction, int unit) {
        this.direction = direction;
        this.unit = unit;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
