/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Le Cherng
 */
public class Car {
    
    public String VIN;
    public String CarModel;
    ArrayList<Date> Accidents;
    
    
    public Car(String VIN, String CarModel,Date Accident){
        this.VIN= VIN;
        this.CarModel= CarModel;
        
        if(Accidents ==null){
            Accidents = new ArrayList<Date>();
            Accidents.add(Accident);
            
        }else{
            Accidents.add(Accident);
        }
        
    }
    
    public Car(String VIN, String CarModel,ArrayList<Date> Accidents){
        this.VIN= VIN;
        this.CarModel= CarModel;
        this.Accidents= Accidents;
        
    }
    
    public void DisplayAllAccidents(){
        Accidents.forEach((Accident) -> {
            System.out.println(Accident);
        });
    }
    
    
    public void AddAccidents(Date Accident){
        Accidents.add(Accident);
    }
    
    @Override
    public String toString(){
        return "VIN number: "+ VIN+"\nModel: "+CarModel;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static int stringCompare(String str1, 
                                    String str2) 
    { 
        for (int i = 0; i < str1.length() &&  
                    i < str2.length(); i++) { 
            if ((int)str1.charAt(i) ==  
                (int)str2.charAt(i)) { 
                continue; 
            }  
            else { 
                return (int)str1.charAt(i) -  
                    (int)str2.charAt(i); 
            } 
        } 
  
        // Edge case for strings like 
        // String 1="Geeky" and String 2="Geekyguy" 
        if (str1.length() < str2.length()) { 
            return (str1.length()-str2.length()); 
        }  
        else if (str1.length() > str2.length()) { 
            return (str1.length()-str2.length()); 
        } 
          
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
    } 
    
    
    
}
