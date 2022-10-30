/*
Name: Claudio Gutierrez
Class: CS4306 / 04
Term: Fall 2022
Instructor: Dr. Haddad
Assignment 2
*/

import java.util.*;

public class TestIS {
    static Integer[] RandomDistinct(){
        //Generating random number
        Integer[] values = new Integer[1024];
        ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 1; i < 10001; i++){
            numList.add(i);
        }
        Collections.shuffle(numList);

        for (int i = 0; i < 1024; i++){
            values[i] = numList.get(i);
        }

        //sorting
        sort(values, 0, 1023);
        return values;
    }


    static int partition(Integer in[], int low, int high) {
        //quickSort partitioning
        int p = in[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (in[j] <= p)
            {
                i++;

                // swap
                int temp = in[i];
                in[i] = in[j];
                in[j] = temp;
            }
        }

        int temp = in[i+1];
        in[i+1] = in[high];
        in[high] = temp;

        return i+1;
    }

    static void sort(Integer in[], int low, int high) {
        //quickSort
        if (low < high)
        {

            Integer p = partition(in, low, high);

            sort(in, low, p-1);
            sort(in, p+1, high);
        }
    }

    static void RunIS(){
        Scanner input = new Scanner(System.in);

        int menu =0;
        int tableSize =0;
        Integer[] values = new Integer[1024];
        while(menu != 4){
            //menu screen
            System.out.println("---------------Main Menu---------------");
            System.out.println(" 1.  Create and display array values[]\n" +
                    " 2.  Read output table size\n" +
                    " 3.  Run algorithm and display outputs\n" +
                    " 4.  Exit program\n\n" +
                    "Enter option number:");
            menu = input.nextInt();


            switch (menu){
                case 1:
                    //allow user to enter table size
                    //create values[] and display it in rows of 30
                    System.out.println("Input table size");
                    tableSize = input.nextInt();
                    values = RandomDistinct();

                    System.out.println("Values of array");
                    for (int i = 0; i < values.length; i++) {
                        if (i%30==0){
                            System.out.println("");
                        }
                        System.out.print(values[i] + "    ");
                    }
                    System.out.println("");

                    break;
                case 2:
                    System.out.println("Table size is " + tableSize + "\n");
                    break;
                case 3:
                    //run loop to each iteration
                    //generate key 1 to 9999
                    //add object data to table takes generated key and values[] from case 1
                    //run algo to get outputs
                    //display outputs like example table

                    //random number generator
                    ArrayList<Integer> numList = new ArrayList<>();
                    for (int i = 1; i < 10001; i++){
                        numList.add(i);
                    }
                    Collections.shuffle(numList);

                    //output loop
                    System.out.println("  Key       Found       Index       Divisions\n" +
                            "-------------------------------------------");
                    double divAvg = 0;
                    for(int i = 0; i < tableSize; i++){
                        Integer key = numList.get(i);
                        InterpolationSearch obj = new InterpolationSearch(values, key);
                        obj.result(obj);
                        System.out.println("  " + key +"        " + obj.getFound() + "      " +
                        obj.getIndex() + "      " + obj.getDivisions());
                        divAvg+= obj.getDivisions();
                    }
                    System.out.println("\n\nDivisions average: " + (divAvg/tableSize));
                    System.out.println("Difference: " + (3.322 - (divAvg/tableSize)));
                    System.out.println();

                    break;
                case 4:
                    break;
                default:
                    System.out.println("invalid input");
            }
        }
    }

    public static void main(String args[]){
        RunIS();
    }
}