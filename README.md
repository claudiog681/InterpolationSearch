# InterpolationSearch
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
