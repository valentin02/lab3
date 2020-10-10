package ua.politeh;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

    Database db = new Database();
    FuncUtils.menu(db);
    db.copyFileUsingChannel(new File(db.PATH + "db.txt"));

    }
}


