import java.io.*;
import java.util.*;

public class Altius_Assignment_2 {

    // The function minimumDistances that calculate the min distance between two matching elements.
    // It has one parameter, which is an array of integers.
    public static int minimumDistances(int[] Tab){

    // The list "distances" to store all the distances.
    ArrayList<Integer> distances  = new ArrayList<>();

    // Two loops to traverse the array and find the matching elements.
    for (int i=0; i< Tab.length-1; i++) {
        for (int j = i + 1; j < Tab.length; j++) {
            if (Tab[i] == Tab[j]) {

                // If a matching element were found, Add the distance to the list.
                distances.add(Math.abs(j - i));
                      }
                  }
            }
        if (distances.isEmpty()){
            // If there is no matching elements.
            return -1;
        }
        else{
            // Return the minimum distance found.
            return Collections.min(distances);
        }
    }

    public static void main(String[] args) throws Exception {

        // Reading the file of the assessment
        // Please make sure to modify the path to your file path
        File file = new File("C:\\Users\\BENDJABALLAH Oussama\\" +
                "IdeaProjects\\Altius_Assignment_2\\src\\assignment02-2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        //Retrieving the size of the table
        int size = 0;
        if ((st = br.readLine()) != null) {
            size = Integer.parseInt(st);
        }
        else {
            System.out.print("The file is empty");
        }

        // Building the table from the file.
        int[] Tab = new int[size];
        st = br.readLine();
        String[] str_table = st.split(" ", 0);
        for (int i=0; i<size; i++){
            Tab[i] = Integer.parseInt(str_table[i]);
        }

        //System.out.print("The minimum distance : "+minimumDistances(Tab));
        System.out.print(minimumDistances(Tab));
    }
}