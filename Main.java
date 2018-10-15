/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author AnhTam
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        dictionary td = new dictionary();
        td.file();
        td.readfile();
        td.delfile();
        td.use_menu();
    }

}
