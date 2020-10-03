package ua.politeh.triangles;

import ua.politeh.triangle.RightTriangle;

public class RightTriangles extends Triangles {

    RightTriangle[] triangles;

    public RightTriangles(int numberRightTriangles) {
        super(numberRightTriangles);
        triangles = new RightTriangle[numberRightTriangles];
    }


    public void addTriangle(double side1, double side2, double side3, int i) {
        triangles[i] = new RightTriangle(side1, side2, side3);
    }

    public double getHypotenuse(RightTriangle triangle) {
        double[] side = triangle.getSides();
        double temp = side[0];
        for (int i = 1; i < side.length; i++) {
            if (side[i] > temp)
                temp = side[i];
        }
        return temp;
    }

    public RightTriangle getTriangleWithMaxHypotenuse() {
        int triangleWithMaxHypotenuseNumber = 0;

        if (triangles.length > 1) {
            for (int i = 1; i < triangles.length; i++) {
                if (triangles[i].isExists())
                    if (getHypotenuse(triangles[i]) > getHypotenuse(triangles[triangleWithMaxHypotenuseNumber]))
                        triangleWithMaxHypotenuseNumber = i;
            }
        }
        return triangles[triangleWithMaxHypotenuseNumber];
    }


    @Override
    public String printResult() {
        return "\nTHE LONGEST HYPOTENUSES OF RIGHT TRIANGLES = " + (getTriangleWithMaxHypotenuse().isExists() ? getTriangleWithMaxHypotenuse() : "-1");
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.triangles.length; i++) {
            result += "\nTriangle #" + ++i + "\n" + triangles[--i].toString() + "\n_________________________";
        }
        return result;
    }
}
