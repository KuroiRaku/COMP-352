/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A3;

import static A3.Car.stringCompare;
import static A3.Driver.Brand.RandomBrand;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Le Cherng
 */
public class Driver {
    
    public static void main (String[]args) throws Exception{
        
        CVR test = new CVR();
        CVR testAVL = new CVR();
        
        
        test.setKeyLength(10);
        test.setThreshold(100);
        test.generate(3);
       
        
        
        ArrayList<String> testList = test.generate(40,"Yea");
        System.out.println(testList);
        Car newCar;
        System.out.println("\n\n");
        for(String newVIN: testList){
            newCar = new Car(newVIN,RandomBrand(), getRandomDate());
            test.add(newCar);
        }
        test.allKeys();
        
        testAVL.setKeyLength(12);
        testAVL.setThreshold(150);
        System.out.println("\n\n");
        testAVL.generate(5);
        testList = testAVL.generate(180,"Yeah");
        
        newCar = new Car("000000000001", RandomBrand(), getRandomDate());
        testAVL.add(newCar);
        
        newCar = new Car("000000000003", RandomBrand(), getRandomDate());
        testAVL.add(newCar);
        
        newCar = new Car("000000000002", RandomBrand(), getRandomDate());
        testAVL.add(newCar);
        
        System.out.println(newCar.toString());
        
        
        System.out.println("\n\nTesting next key function");
        System.out.println(testAVL.nextKey("000000000002"));
        
        System.out.println("\n\nTesting prevKey function");
        System.out.println(testAVL.prevKey("000000000002"));
        
        System.out.println("\n\nTesting prevAccid function");
        System.out.println(testAVL.prevAccids("000000000002"));
        
        System.out.println("\n\nTesting getValues function");
        System.out.println(testAVL.getValues("000000000002"));
        
        System.out.println("\n\nTesting remove function");
        testAVL.remove("000000000002");
        
        //testAVL.displayNull();
        System.out.println("\n\nAll keys in the array");
        testAVL.allKeys();
        
        for(String newVIN: testList){
            newCar = new Car(newVIN,RandomBrand(), getRandomDate());
            testAVL.add(newCar);
        }
        
        System.out.println("\n\nAll keys in the AVL");
        testAVL.allKeys();
//        System.out.println("\n\n\n");
//        testAVL.allKeys_2();
        
        
        
        
        
        
    }
    
    public enum Brand {
        Honda, Ghoul, Renault, Raku, Mitsubishi, Toyota;

        public static String RandomBrand() {
            int Pick = new Random().nextInt(Brand.values().length);
            return Brand.values()[Pick].toString();
        }
    }
    
    /**
     *
     */
    static ArrayList<Date> getRandomDate() throws ParseException{
        int r = (int) (Math.random()*5);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        ArrayList <ArrayList> name = new ArrayList();
        ArrayList<Date> insideList = new ArrayList();
        ArrayList<Date> insideList2= new ArrayList();
        insideList.add(sdf.parse("2015-02-14"));
        insideList.add(sdf.parse("2020-01-22"));
        insideList.add(sdf.parse("2020-08-22"));
        name.add(insideList);
        insideList2.add(sdf.parse("2018-02-14"));
        name.add(insideList2);
        insideList2.add(sdf.parse("2015-07-14"));
        name.add(insideList2);
        insideList2.add(sdf.parse("2016-05-14"));
        name.add(insideList2);
        insideList2.add(sdf.parse("2018-02-08"));
        name.add(insideList2);
        ArrayList result = name.get(r);
        return result;
    }
    
    public static ArrayList randomString(int n, int keyLength) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(10); 
        int j=0;
        ArrayList<String> Result = new ArrayList<String>();
        while(j<n){
            for (int i = 0; i < keyLength; i++) { 
  
                // generate a random number between 
                // 0 to AlphaNumericString variable length 
                int index= (int)(AlphaNumericString.length()* Math.random()); 
  
                // add Character one by one in end of sb 
                sb.append(AlphaNumericString.charAt(index)); 
                
            }
            if(Result.contains(sb.toString())){
                sb=new StringBuilder(keyLength);
            }else{
                Result.add(sb.toString());
                sb= new StringBuilder(keyLength);
                j++;
            }
        }
        return Result; 
    }
    
    static void sort(String arr[], int n) 
    { 
         
        for (int i = 1; i < n; ++i) { 
            String key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            
            //arr[j] > key
            while (j >= 0 && stringCompare(arr[j], key)>0) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
    
}
