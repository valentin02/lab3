package ua.politeh;

import ua.politeh.triangle.Triangle;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    final String PATH = "//home//valik//IdeaProjects//lab3//src//ua//politeh//files//";

    private ArrayList<Triangle> triangles = new ArrayList<>();

    /**
     * This method add new triangle to list
     * @param side1 side1
     * @param side2 side2
     * @param side3 side3
     */
    public void addTriangle(double side1, double side2, double side3) {
        this.triangles.add(new Triangle(side1, side2, side3)) ;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.triangles.size(); i++) {
            result += "\nTriangle #" + ++i + "\n" + triangles.get(--i).toString() + "\n_________________________";
        }
        return result;
    }

    /**
     * This method save data in file
     * @param filename name of file
     * @throws IOException
     */
    public void save(String filename) throws IOException {

        FileOutputStream outStream = new FileOutputStream(PATH + filename);
        BufferedOutputStream bw = new BufferedOutputStream(outStream);

        double[] temp;
        String _t = "";
        for (int i = 0; i < triangles.size(); i++) {
            temp = triangles.get(i).getSides();
            _t += temp[0] + "\n " + temp[1] + "\n " + temp[2] + "\n";
        }

        byte[] b = _t.getBytes();
        bw.write(b, 0, b.length);
        bw.close();
        outStream.close();
        copyFileUsingChannel(new File(PATH + "db.txt"));
    }

    /**
     * This method read data from the file
     * @param filename name of file
     * @throws IOException
     */
    public void load(String filename) throws IOException {
        triangles.clear();
        Scanner scanner = new Scanner(new FileInputStream(PATH + filename));
        double s1 = -1, s2 = -1, s3 = -1;
        while (scanner.hasNextLine()) {
            try {
                s1 = Double.valueOf(scanner.nextLine());
                s2 = Double.valueOf(scanner.nextLine());
                s3 = Double.valueOf(scanner.nextLine());
                addTriangle(s1, s2, s3);
            } catch (NumberFormatException exception) {
                continue;
            }
        }
        scanner.close();
    }

    /**
     * This method make backup document of main document "db.txt"
     * @param filename name of file
     * @throws IOException
     */
    private void copyFileUsingChannel(File filename) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        File dest = new File(this.nameFile());
        try {
            sourceChannel = new FileInputStream(filename).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            sourceChannel.close();
            destChannel.close();
        }
    }

    /**
     * this method output list names of document
     * @return Array of names of document
     */
    public String[] listFilesUsingJavaIO() {
        File f = new File(PATH);
        return f.list();
    }

    /**
     * This method return name of document which will be backup
     * @return name of document
     */
    public String nameFile() {
        String[] l = this.listFilesUsingJavaIO();
        String n = PATH + "db" + (l.length) + ".txt";
        return n;
    }
}


