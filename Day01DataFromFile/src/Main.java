import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static ArrayList<String> namesList = new ArrayList<>();
    static ArrayList<Double> numsList = new ArrayList<>();

    public static void main(String[] args) {

        try {
           File list = new File("input.txt");
           Scanner input = new Scanner(list);
           while (input.hasNextLine()) {
               String tmp = input.nextLine();
               if (isNumeric(tmp)){
                   numsList.add(Double.parseDouble(tmp));
               } else{
                   namesList.add(tmp);
               }
           }
           input.close();
       } catch (FileNotFoundException e) {
           System.out.println("file not found");
           e.printStackTrace();
       }
        Collections.sort(namesList);
        System.out.println("Names sorted: " + namesList.toString());
        Collections.sort(numsList);
        System.out.println("Numbers sorted: " + numsList.toString());

        int totalChars = 0;
        int wordCount = 0;
        for (String name : namesList){
            totalChars += name.length();
            wordCount++;
        }
        double avg = totalChars / wordCount;
        System.out.println("The average word length is: " + avg);
        HashMap<String, Integer> nameCount = new HashMap<String, Integer>();
            for (String name : namesList) {
                if (nameCount.containsKey(name)){
                    nameCount.put(name, nameCount.get(name) + 1);
                } else {
                    nameCount.put(name, 1);
                }
            }
        for (String name : nameCount.keySet()) {
            if (nameCount.get(name) > 1){
                System.out.println("Repeated name: " + name + " appears " + nameCount.get(name) + " times.");
            }
        }
    }
  public static boolean isNumeric(String tmp) {
        return tmp.matches("-?\\d+(\\.\\d+)?");
    }
}