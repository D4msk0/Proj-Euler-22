import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Using names.txt (right click and 'Save Link/Target As...'), 
 * a 46K text file containing over five-thousand first names, 
 * begin by sorting it into alphabetical order. 
 * Then working out the alphabetical value for each name, 
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * 
 * For example, 
 * when the list is sorted into alphabetical order, 
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, 
 * is the 938th name in the list. 
 * So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */

public class Names_Scores_22 {
    public static void main(String[] args) {
        try {
            File myFile = new File("names.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNext()){

                String data = myReader.next();
                List<String> namesList = Arrays.asList(data.split(","));
                List<String> sortedList = namesList.stream().sorted().collect(Collectors.toList());
                
                int nameEpic = 0;
                for (String string : sortedList) {
                    int number = sortedList.indexOf(string) + 1; // #th name on list
                    // System.out.println("\n#number on list: " + number);

                    int sum = 0;
                    for (int i = 0; i < string.length(); i++) {
                        Character c = string.charAt(i);
                        if (c != '"') {
                            int charme = c;
                            sum += (charme - 64);

                            // System.out.println(c + " " + (charme - 64));
                        }  
                    }
                    // System.out.println("Sum of name: " + sum);
                    int nameTotal = number * sum;
                    // System.out.println("Nametotal: " + nameTotal);
                    nameEpic += nameTotal;
                    
                }   
                System.out.println("Total of all the name scores: " + nameEpic);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }  
    }
}


