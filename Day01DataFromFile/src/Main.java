import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static sun.util.locale.LocaleUtils.isNumeric;

public class Main {
    static ArrayList<String> namesList = new ArrayList<>();
    static ArrayList<Double> numsList = new ArrayList<>();

    public static void main(String[] args) {
       try {
           File list = new File("Day01DataFromFile/input.txt");
           Scanner input = new Scanner(list);
           while (input.hasNextLine()) {
               String tmp = input.nextLine();
               if (isNumeric(tmp)){

               } else{

               }
           }
           input.close();
       } catch (FileNotFoundException e) {
           System.out.println("file not found");
           e.printStackTrace();
       }
    }
  public static boolean isNumeric(String tmp) {
        return tmp.matches("-?\\d+(\\.\\d+)?");
    };
}