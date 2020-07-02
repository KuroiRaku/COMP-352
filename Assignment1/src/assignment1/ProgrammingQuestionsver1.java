/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Le Cherng
 */
public class ProgrammingQuestionsver1 {
    static long starttime;
    static long endtime;
    static int count;
    
    public static void main(String[]args){
        String testString= "abcdefghijklmnopapslcbeuqidlabcdbaiodbcdcaabchugha";
        System.out.println(testString.length());
        Instant start;
        Instant end;
        ArrayList <String> OMG;
        long timeElapsed;
        /**
         * Calculating the total time required
         */
        /*
        System.out.println("permu2");
        starttime=System.nanoTime();
        permu2("abc", "abchughakldbcab");
        endtime=System.nanoTime();
        System.out.println(endtime-starttime);
        */
        
        try{
            long result;
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("out.txt",false));
            
            System.out.println("permu1");
            starttime=System.nanoTime();
            OMG = permu1("abc");
            for(String omg: OMG){
                System.out.println(omg);
                if(testString.contains(omg)){
                    System.out.println("Found a match: "+ omg+" is in "+testString+" at location "+ testString.indexOf(omg));
                }  
            }
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            result = endtime-starttime;
            outputStream.println("Versopm 1: 3 characters in 50 characters\n Time taken: "+result+" nanoseconds");
            
            /*
            System.out.println("\n\n\npermu2");
            starttime=System.nanoTime();
            permu2("abc", testString,0);
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            result = endtime-starttime;
            outputStream.println("version 2: 3 characters in 50 characters\n Time taken: "+result+" nanoseconds");
            
            //I have created other version which doesn't change that much
            System.out.println("\n\n\npermu3");
            starttime=System.nanoTime();
            permu3("","abc", testString);
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            result = endtime-starttime;
            outputStream.println("Similar to version 2: 3 characters in 50 characters\n Time taken: "+result+" nanoseconds");
            */
            
            System.out.println("\n\n\npermu4");
            starttime=System.nanoTime();
            permu4("abc", testString);
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            result = endtime-starttime;
            outputStream.println("Version3: 3 characters in 50 characters\n Time taken: "+result+" nanoseconds");
            
            outputStream.println("\n\n\n");
            
            
            System.out.println("\n\n\npermu1");
            starttime=System.nanoTime();
            OMG = permu1("abcde");
            for(String omg: OMG){
                System.out.println(omg);
                if(testString.contains(omg)){
                    System.out.println("Found a match: "+ omg+" is in "+testString+" at location "+ testString.indexOf(omg));
                }  
            }
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            result = endtime-starttime;
            outputStream.println("Versopm 1: 3 characters in 50 characters\n Time taken: "+result+" nanoseconds");
            
            /*
            
            System.out.println("\n\n\npermu2");
            starttime=System.nanoTime();
            permu2("abcde", testString,0);
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            result = endtime-starttime;
            outputStream.println("version 2: 5 characters in 50 characters\n Time taken: "+result+" nanoseconds");
            
            
            
            System.out.println("\n\n\npermu3");
            starttime=System.nanoTime();
            permu3("","abcde", testString);
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            result = endtime-starttime;
            outputStream.println("Similar to version 2: 5 characters in 50 characters\n Time taken: "+result+" nanoseconds");
            */
            
            
            
            System.out.println("\n\n\npermu4");
            starttime=System.nanoTime();
            permu4("abcde", testString);
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            result = endtime-starttime;
            outputStream.println("Version4: 5 characters in 50 characters\n Time taken: "+result+" nanoseconds");
            
            /*
            System.out.println("\n\n\npermu2");
            starttime=System.nanoTime();
            permu2("abcdefghijklmnop", "abcdefghijklmnopapslcbeuqidlabcdbaiodbcdcaabchughakldbcab");
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            */
            
            outputStream.println("\n\n\n");
            
            
            
            System.out.println("\n\n\npermu1");
            start = Instant.now();
            OMG = permu1("abcdefghij");
            for(String omg: OMG){
                System.out.println(omg);
                if(testString.contains(omg)){
                    System.out.println("Found a match: "+ omg+" is in "+testString+" at location "+ testString.indexOf(omg));
                }  
            }
            end = Instant.now();
            timeElapsed= Duration.between(start, end).getSeconds();
            System.out.println(timeElapsed);
            outputStream.println("version 1: 10 characters in 50 characters\n Time taken: "+timeElapsed+" seconds");
            
            
            /*
            System.out.println("\n\n\npermu2");
            start = Instant.now();
            permu2("abcdefghij", testString,0);
            end = Instant.now();
            timeElapsed= Duration.between(start, end).getSeconds();
            System.out.println(timeElapsed);
            outputStream.println("version 2: 10 characters in 50 characters\n Time taken: "+timeElapsed+" seconds");
            
            
            System.out.println("\n\n\npermu3");
            start = Instant.now();
            permu3("","abcdefghij", testString);
            end = Instant.now();
            timeElapsed= Duration.between(start, end).getSeconds();
            System.out.println(timeElapsed);
            outputStream.println("Similar to version 2: 15 characters in 50 characters\n Time taken: "+timeElapsed+" seconds");
            
            outputStream.println("\n\n\n");
            
            */
            /*
            System.out.println("\n\n\npermu1");
            start = Instant.now();
            OMG = permu1("abcdefghijklmno");
            for(String omg: OMG){
                System.out.println(omg);
                if(testString.contains(omg)){
                    System.out.println("Found a match: "+ omg+" is in "+testString+" at location "+ testString.indexOf(omg));
                }  
            }
            end = Instant.now();
            timeElapsed= Duration.between(start, end).getSeconds();
            System.out.println(timeElapsed);
            outputStream.println("version 1: 15 characters in 50 characters\n Time taken: "+timeElapsed+" seconds");
        
            System.out.println("\n\n\npermu2");
            start = Instant.now();
            permu2("abcdefghijklmno", testString,0);
            end = Instant.now();
            timeElapsed= Duration.between(start, end).getSeconds();
            System.out.println(timeElapsed);
            outputStream.println("version 2: 15 characters in 50 characters\n Time taken: "+timeElapsed+" seconds");
            
            
            System.out.println("\n\n\npermu3");
            start = Instant.now();
            permu3("","abcdefghijklmno", testString);
            end = Instant.now();
            timeElapsed= Duration.between(start, end).getSeconds();
            System.out.println(timeElapsed);
            outputStream.println("Similar to version 2: 10 characters in 50 characters\n Time taken: "+timeElapsed+" seconds");
            */
            /*
            System.out.println("\n\n\npermu4");
            starttime=System.nanoTime();
            permu4("abcde", testString);
            endtime=System.nanoTime();
            System.out.println(endtime-starttime);
            result = endtime-starttime;
            outputStream.println("Version3: 10 characters in 50 characters\n Time taken: "+result+" nanoseconds");
            */
            
            outputStream.close();
        }catch(FileNotFoundException e){
            
        }
        /*
       
        System.out.println("\n\n\npermu1");
        starttime=System.currentTimeMillis();
        permu1("","abcdefghijklmno", testString);
        endtime=System.currentTimeMillis();
        System.out.println(endtime-starttime);
        
        System.out.println("\n\n\npermu2");
        starttime=System.currentTimeMillis();
        permu2("abcdefghijklmno", testString,0);
        endtime=System.currentTimeMillis();
        System.out.println(endtime-starttime);
        
        System.out.println("\n\n\npermu3");
        starttime=System.currentTimeMillis();
        permu3("","abcdefghijklmno", testString);
        endtime=System.currentTimeMillis();
        System.out.println(endtime-starttime);
        */
        
        
    }
    
    /**
     * This will combined all different permutations
     * time complexity for this code is n!+ n-1! +....1
     * plus printing outside the code and it will be O(n^2*n!)
     * In the end you still need to times n which makes the time complexity to be insanely huge
     * For example: When doing a permutation of three characters "abc", the process will go through permutations of two characters 
     * @param shortstr 
     * ArrayList causes the code uses even more time
     * This return ArrayList and will uses a lot more time later 
     * The time complexity of this algorithm is not acceptable, it uses a lot of run time when the shortstr is larger in length 
     */
     public static ArrayList<String> permu1(String shorstr){
        if (shorstr.length() == 0){
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }
        char ch = shorstr.charAt(0);
        String subString = shorstr.substring(1);
        System.out.println(subString);
        ArrayList<String> prevResult = permu1(subString);
        /**
         * It will go through ab, ba which is not needed if we do the code correctly then it will replace it
         */
        ArrayList<String> res = new ArrayList<>();
        for (String val: prevResult){
            for (int i = 0; i<= val.length(); i++){
                String str1=val.substring(0, i)+ ch+ val.substring(i); 
                res.add(str1);
            }
        }
        return res;
    }
    
    
     /**
     * This the second version
     * time complexity is O(n*n!)
     * This code avoid all the unnecessary permutations 
     * n because of printing n! because of permutation 
     * You need n! to calculate the permutations through swapping etc 
     * @param shortstr
     * @param longstr
     * @param index
     */
    public static void permu2(String shortstr, String longstr, int index){
        
        
        
        if(index == shortstr.length()){
            System.out.println(shortstr);
            
            if(longstr.contains(shortstr)){
                System.out.println("Found a match: "+ shortstr+" is in "+longstr+" at location "+ longstr.indexOf(shortstr));
            }
            
        }            
        else {
            /**
            * 
            * recursively solve this by placing all other chars at current first pos
            */
            permu2(shortstr, longstr, index+1);
            for (int i = index+1; i < shortstr.length(); i++) {
            /**
             * start swapping all other chars with current first char
             */
                shortstr = swap(shortstr,index, i);
                permu2(shortstr, longstr, index+1);
                shortstr = swap(shortstr,i, index);
            }
        }
        
        
    }
    
    
    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
    /**
     * Very inefficient method, because time complexity is n! * n-1* .... 1
     * But it doesn't need to do recursion
     * @param shortstr
     * @param longstr 
     */
    
    /*
    public static void permu4(String shortstr, String longstr) {
        
        ArrayList<String> perms = new ArrayList<>();
        
            // Add the first character from s to the perms array list.
            perms.add(Character.toString(shortstr.charAt(0)));
            
            // Getting all individual character from shortstr.   
            for (int i = 1;  i < shortstr.length();  ++i) {
                
                // Get the next character from shortstr.
                char c = shortstr.charAt(i);

                // For each of the strings currently in perms do the following:
                int size = perms.size();
                
                
                for (int j = 0;  j < size;  ++j) {

                    // 1. remove the string
                    String p = perms.remove(0);
                    //P is for each possible combination
                    
                    int plen = p.length();

                    // 2. Add plen + 1 new strings to perms.  Each new string
                    //    consists of the removed string with the character c
                    //    inserted into it at a unique location.
                    for (int k = 0;  k <= plen;  ++k) {
                        perms.add(p.substring(0, k) + c + p.substring(k));
                       
                        
                    }
               }
            }
           //n
        for (String perm : perms) {
            
            if(longstr.contains(perm)){
                System.out.println("Found a match: "+ perm+" is in "+longstr+" at location "+ longstr.indexOf(perm));
            }
        }
        //is like n! + (n-1)! .... subsequently until + 1
        //big o is just n!
        
        
    }
    */
    
    
    /**
     * this is the another version for permutation version 2 
     * This function will avoid doing permutation of two character or fewer than the length of the shortstr
     * @param str1
     * @param shortstr 
     */
    
    public static void permu3(String str1,String shortstr, String longstr){
        
        if(shortstr.length() > 1){
            char ch = shortstr.charAt(0);
            for(int i = 0; i <= str1.length();i++)
                 permu3(str1.substring(0,i) + ch + str1.substring(i,str1.length()),
                 shortstr.substring(1,shortstr.length()), longstr);
        }else{
            char ch = shortstr.charAt(0);
            for(int i = 0; i <= str1.length();i++){
               String str=str1.substring(0,i) + ch + str1.substring(i,str1.length())+ shortstr.substring(1,shortstr.length()); 
               System.out.println(str);
               if(longstr.contains(str)){
                    System.out.println("Found a match: "+ str+" is in "+longstr+" at location "+ longstr.indexOf(str));
                }
            }
        }
    }
    
    static final int MAX = 256; 
      
    // This function returns true if contents 
    // of arr1[] and arr2[] are same, otherwise 
    // false. 
    static boolean compare(char arr1[], char arr2[]) 
    { 
        for (int i = 0; i < MAX; i++){ 
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true; 
    } 
  
    // This function search for all permutations 
    // of pat[] in txt[] 
    /**
    * time complexity of the code is O(n)
    * comparing two strings is always O(1)
    */
    static void permu4(String shortstr, String longstr) 
    { 
        int N1 = shortstr.length(); 
        int N2 = longstr.length(); 
  
        // countP[]:  Store count of all  
        // characters of pattern 
        // countTW[]: Store count of current 
        // window of text 
        char[] countN1 = new char[MAX]; 
        char[] countN2 = new char[MAX]; 
        for (int i = 0; i < N1; i++) 
        { 
            (countN1[shortstr.charAt(i)])++; 
            (countN2[longstr.charAt(i)])++; 
        } 
  
        // Traverse through remaining characters 
        // of pattern 
        for (int i = N1; i < N2; i++) 
        { 
            // Compare counts of current window 
            // of text with counts of pattern[] 
            if (compare(countN1, countN2)) {
                System.out.println("Found"+String.valueOf(countN1) + "at Index " + (i - N1)); 
            }
            // Add current character to current  
            // window 
            (countN2[longstr.charAt(i)])++; 
  
            // Remove the first character of previous 
            // window 
            countN2[longstr.charAt(i-N1)]--; 
        } 
  
        // Check for the last window in text 
        if (compare(countN1, countN2)) 
            System.out.println("Found"+String.valueOf(countN1)+" at Index " +(N2 - N1)); 
    } 
    
    

    
 }

    

