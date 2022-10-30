/*
Name: Claudio Gutierrez
Class: CS4306 / 04
Term: Fall 2022
Instructor: Dr. Haddad
Assignment 2
*/

//Algorithm design block
/*
Problem Statement
    There is a sorted array of size 1024 with random distinct values between 1 and 9999. We are asked to implement interpolation
    search, to search through the array and get insight on the performance of interpolation search
 */

/*
Algorithm logical steps
    Given array of size 1024 with int values and an int key
    1.check if the value of the key is within the high and low values
    2.get pos pointer by using slope function with high,low,key. call recursively
    3.if the key is not at index of pos compare key with element at values[pos]
    4.if key is greater search upper partition. if key is smaller search lower partition
 */

/*
Algorithm pseudocode syntax
    result() returns void, takes interpolation object{
        int[] arr = inputArray
        index = search() to find index of object key return -1 if not found

        if index != -1
            found = true
     }

    search() returns int for index. takes int[] values, int low, int high{
        if key < low or key > high
            return -1

        int pos = low + (((key - input[low]) * (high - low)) / (input[high] - input[low]))

        if key > pos
             divisions++
             return search(input, pos +1, high, key)
        else if (key > input[pos])
            divisions++
            return search(input, pos +1, high, key)

        else if (key < input[pos])
            divisions++
            return search(input, low, pos - 1, key)

        else
        return -1
     }
 */

public class InterpolationSearch {
    private boolean found = false;
    private int index = -1;
    private int divisions = 0;
    private Integer[] input;
    private int key;

    public InterpolationSearch(Integer[] input, int key){
         this.key = key;
         this.input = input;
    }

    public int getIndex(){
        return index;
    }

    public int getDivisions() {
        return divisions;
    }

    public boolean getFound() {
        return found;
    }

    public void result(InterpolationSearch in){
        //Method uses search algorithm to find the index and set found to true if the key is in th set
        Integer[] arr = in.input;
        index = search(arr, 0, arr.length - 1, in.key);

        if (index != -1)
            found = true;
    }

    public int search(Integer[] input, int low , int high, int key){
        //Method does interpolation search recursively by using position function to get the initial position in a partition
        //if the key is not in the set return -1
        //then compare input[pos] with the key
        //if the key is larger pass the right partition to the method
        //if the key is smaller pas the left partition to the method
        //For every partition increase divisions by 1
        if (key > input[high] || key < input[low]){
            return -1;
        }
        //Position function
        int pos = low + (((key - input[low]) * (high - low)) / (input[high] - input[low]));

        if (input[pos] == key){
            divisions++;
            return pos;
        }
        //partitioning
        else if (key > input[pos]){
            divisions++;
            return search(input, pos +1, high, key);
        }
        else if (key < input[pos]){
            divisions++;
            return search(input, low, pos - 1, key);
        }
        else
        return -1;
    }
}
