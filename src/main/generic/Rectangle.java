package generic;

import org.jetbrains.annotations.NotNull;

public class Rectangle extends GeometricObject implements Comparable<Rectangle>{
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /** Return width */
    public double getWidth() {
        return width;
    }

    /** Set a new width */
    public void setWidth(double width) {
        this.width = width;
    }

    /** Return height */
    public double getHeight() {
        return height;
    }

    /** Set a new height */
    public void setHeight(double height) {
        this.height = height;
    }

    /** Return area */
    public double getArea() {
        return width * height;
    }

    /** Return perimeter */
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "area = " + getArea() +
                " perimeter = " + getPerimeter() +
                " width =  " + getWidth() +
                " height = " + getHeight();
    }

    @Override
    public int compareTo(@NotNull Rectangle o) {
        return Double.compare(this.getArea(), o.getArea());
    }
}
