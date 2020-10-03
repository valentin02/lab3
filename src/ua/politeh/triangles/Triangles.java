package ua.politeh.triangles;

import ua.politeh.triangle.Triangle;

public class Triangles {
    private Triangle[] triangles;

    public Triangles(int numberTriangles) {
        triangles = new Triangle[numberTriangles];
    }

    public void addTriangle(double side1, double side2, double side3, int i) {
        triangles[i] = new Triangle(side1, side2, side3);
    }

    public double[] areaTriangle() {
        double[] areaTriangle = new double[triangles.length];
        for (int i = 0; i < triangles.length; i++) {
            areaTriangle[i] = triangles[i].getArea();
        }
        return areaTriangle;
    }

    public double averageAreaTriangle() {
        double[] areaTriangle = areaTriangle();
        double temp = 0;
        byte x = 0;
        for (int i = 0; i < areaTriangle.length; i++) {
            if (areaTriangle[i] > 0) {
                temp += areaTriangle[i];
                x++;
            }
        }
        if (temp > 0) return temp / (double) x;
        else return -1;
    }

    public String printResult() {
        return "\nAVERAGE AREA OF TRIANGLES = " + String.format("%2.2f", this.averageAreaTriangle());
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.triangles.length; i++) {
            result += "\nTriangle #" + ++i + "\n" + triangles[--i].toString() + "\n_________________________";
        }
        return result;
    }

     public double[] getSides(){
        double[] temp;
        temp = getSides();
        return temp;
    }
}
