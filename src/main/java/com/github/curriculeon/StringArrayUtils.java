package com.github.curriculeon;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(String ele : array){
            if(ele.equals(value)){
                return true;
            }
        }
        return false;

    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        Collections.reverse(Arrays.asList(array));
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static Boolean isPalindromic(String[] array) {
        String [] arr = Arrays.copyOf(array, array.length);
        String []reversed = reverse(arr);
        for(int i=0; i< array.length; i++){
            if(!array[i].equals(reversed[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static Boolean isPangramic(String[] array) {
        boolean[] lettersBoolean = new boolean[27];

        for(int i=0; i< array.length;i++){
            char[] letter = array[i].toCharArray();
           for(int j =0; j <letter.length; j++){
               if((letter[j]>= 'a' && letter[j] <= 'z') ){
                   int letterIndex = (int)letter[j] - 'a' +1;
                   System.out.println(letterIndex + " : letter: "+ letter[j]);
                   lettersBoolean[letterIndex] = true;
               }else if( letter[j]>= 'A' && letter[j] <= 'Z'){
                   int letterIndex = (int)letter[j] - 'A' +1;
                   System.out.println(letterIndex + " : letter: "+ letter[j]);

                   lettersBoolean[letterIndex] = true;

               }
           }

        }
        int count = 0;
        for(boolean lett : lettersBoolean){
            System.out.println(lett);
            if(lett == false && count != 0){
                return false;
            }
            count++;


        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int result = 0;
        for(String element: array){
            if(element.equals(value)){
                result++;
            }
        }
        return result;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String [] result = new String[]{};

        for(String element : array){
            if(!element.equals(valueToRemove)){
                result = Arrays.copyOf(result, result.length+1);
                result[result.length-1] = element;
            }
        }
        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String [] result = new String[]{array[0]};
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j< array.length; j++){
                if(!array[i].equals(array[j])){
                    result = Arrays.copyOf(result, result.length +1);
                    result[result.length-1] = array[j];
                    break;
                }else{
                    break;
                }
            }
        }

        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        String [] result = new String[]{};
        boolean isDup = false;
        String duplicates ="";
        for(int i=0; i< array.length; i++){
            if(i+1 >= array.length && isDup){
                duplicates += array[i];
                result = Arrays.copyOf(result, result.length +1);
                result[result.length-1] = duplicates;
                break;
            }else if(i+1 >= array.length){
                result = Arrays.copyOf(result, result.length +1);
                result[result.length-1] = array[i];
                break;
            }

            //System.out.println("result: " + result[result.length-1]);
            if(array[i].equals(array[i+1])){
                // first check if current is same as next element , if so make isDup true and add char to dual str,
                isDup =true;
                duplicates+= array[i];
                //System.out.println(duplicates);
            }else{
                // if not (if isDup is true add element to duplicates and add duplicates to results and make isDup false and empty dup then continue),
                // otherwise add element to result
                if(isDup==true){
                    duplicates += array[i];
                    result = Arrays.copyOf(result, result.length +1);
                    result[result.length-1] = duplicates;
                    isDup = false;
                    duplicates ="";
                }else{
                    result = Arrays.copyOf(result, result.length +1);
                    result[result.length-1] = array[i];
                }
            }

        }

        return result;
    }


}
