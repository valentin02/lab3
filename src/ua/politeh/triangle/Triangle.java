package ua.politeh.triangle;


import ua.politeh.IFigure;

public class Triangle implements IFigure {
    /**
     * sides array
     */
    //@Getter
    private final double[] sides;

    /**
     * @param side0 first side
     * @param side1 second side
     * @param side2 third side
     */
    public Triangle(double side0, double side1, double side2) {
        sides = new double[3];
        this.sides[0] = setSide(side0);
        this.sides[1] = setSide(side1);
        this.sides[2] = setSide(side2);
    }

    public double[] getSides() {
        return sides;
    }

    public double setSide(double side) {
        return side > 0 ? side : 1;
    }

    public boolean isExists() {
        return sides[0] + sides[1] > sides[2] && sides[0] + sides[2] > sides[1] && sides[1] + sides[2] > sides[0];
    }

    public double getArea() {
        double p = getPerimeter() / 2; // half-perimeter
        return Math.sqrt(p * (p - this.sides[0]) * (p - this.sides[1]) * (p - this.sides[2]));
    }

    public double getPerimeter() {
        return this.sides[0] + this.sides[1] + this.sides[2];
    }

    /**
     * @return array with angles
     */
    public double[] getAngle() {
        double[] angles = new double[3];
        // cosA = (B^2 + C^2 - A^2) / 2*B*C
        angles[0] = (Math.toDegrees(Math.acos((Math.pow(this.sides[1], 2) + Math.pow(this.sides[2], 2) - Math.pow(this.sides[0], 2)) / (2 * this.sides[1] * this.sides[2]))));
        angles[1] = (Math.toDegrees(Math.acos((Math.pow(this.sides[0], 2) + Math.pow(this.sides[2], 2) - Math.pow(this.sides[1], 2)) / (2 * this.sides[0] * this.sides[2]))));
        angles[2] = (Math.toDegrees(Math.acos((Math.pow(this.sides[0], 2) + Math.pow(this.sides[1], 2) - Math.pow(this.sides[2], 2)) / (2 * this.sides[0] * this.sides[1]))));

        return angles;
    }

    @Override
    public String toString() {
        double[] temp = this.getAngle();
        String result = "";
        if (!this.isExists()) {
            result = "\nAll data about this triangle aren't correct !\nTriangle with such sides doesn't exist \nSide1 = " + this.sides[0] + "\nSide2 = " + this.sides[1] + "\nSide3 = " + this.sides[2];
        } else {
            result = "\nSide1 = " + this.sides[0] + "\nSide2 = " + this.sides[1] + "\nSide3 = " + this.sides[2]
                    + "\nAngle1 = " + String.format("%2.2f", temp[0]) + "\nAngle2 = " + String.format("%2.2f", temp[1]) + "\nAngle3 = " + String.format("%2.2f", temp[2])
                    + "\nPerimeter = " + this.getPerimeter() + "\nArea of triangle = " + String.format("%2.2f", this.getArea());
        }
        return result;
    }
}
