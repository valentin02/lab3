package ua.politeh.triangle;

import ua.politeh.triangle.Triangle;

public class RightTriangle extends Triangle {

    public RightTriangle(double side0, double side1, double side2) {
        super(side0, side1, side2);
    }

    @Override
    public boolean isExists() {
        boolean isRightTriangle = false;
        double[] temp = this.getAngle();
        if (super.isExists()) {
            if (Math.abs(temp[0] - 90) < 10e-15 || Math.abs(temp[1] - 90) < 10e-15 || Math.abs(temp[2] - 90) < 10e-15)
                isRightTriangle = true;
        }
        return isRightTriangle;
    }

    @Override
    public String toString() {
        return super.toString().replace("triangle", "right triangle").replace("Triangle", "Right triangle");
    }
}
