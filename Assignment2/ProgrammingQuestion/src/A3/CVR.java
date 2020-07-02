/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A3;

import static A3.Car.stringCompare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/**
 *Only Camel Case since C++ > java
 * @author Le Cherng
 */
public class CVR {
    
    //All Camel Case :P
    
    private int Threshold;
    private int KeyLength;
    private AVLCar Tree;
    private Car CarArray[];
    private int SizeOfArray;
    
    public CVR(){
        Threshold=0;
        KeyLength=0;
        Tree=null;
        CarArray=null;
        SizeOfArray=0;
    }
    
    public void setThreshold(int Threshold)
    {
        if(Threshold>900000 || Threshold<100){
            System.out.println("Please enter a valid Threshold");
        }
        
        this.Threshold=Threshold;
        CarArray= new Car[Threshold];
    }
    
    public void setKeyLength(int Length) throws Exception{
        if(Length<10 || Length>17){
            throw new Exception("Please enter a number between 17 and 10");
        }
        
        KeyLength = Length;
    }
    
    public ArrayList prevAccids(String key)
    {
        ArrayList Result=null;
        if (Tree==null){
            for(int i=0;i<this.SizeOfArray;i++){
                    if(CarArray[i].VIN.equals(key)){
                        Result = CarArray[i].Accidents;
                        Collections.sort(Result, Collections.reverseOrder());
                        return Result;
                    }
                }
        }else{
            Result = this.Tree.find(key).Accidents;
            Collections.sort(Result, Collections.reverseOrder());
            
        }
        
        return Result;
    }
    
    public void add(String VIN, String CarModel,Date Accident){
        Car newCar = new Car(VIN, CarModel,Accident);
        if(Tree==null){
            if(newCar.VIN.length()!=KeyLength){
                System.out.println("Please enter VIN of same keylength");
                return;
            }
            for(int i=0;i<SizeOfArray;i++){
                if(CarArray[i].equals(newCar.VIN)){
                    System.out.println("This VIN exist!");
                    return;
                }
            }
            CarArray[SizeOfArray] = newCar;
            SizeOfArray++;
            if(SizeOfArray>=Threshold){
                System.out.println("Start Using AVLCar!");
                Tree = new AVLCar();
                for(Car car: CarArray){
                    Tree.root=Tree.insert(Tree.root, car);
                }
            }
        }else{
            if(newCar.VIN.length()!=KeyLength){
                System.out.println("Please enter VIN of same keylength");
                return;
            }
            if(Tree.findKey(newCar.VIN)!=null)
                return;
            Tree.root=Tree.insert(Tree.root, newCar);
        }
    }
    
    public void add(String VIN, String CarModel,ArrayList<Date> Accidents){
        Car newCar = new Car(VIN, CarModel,Accidents);
        if(Tree==null){
            if(newCar.VIN.length()!=KeyLength){
                System.out.println("Please enter VIN of same keylength");
                return;
            }
            for(int i=0;i<SizeOfArray;i++){
                if(CarArray[i].equals(newCar.VIN)){
                    System.out.println("This VIN exist!");
                    return;
                }
            }
            CarArray[SizeOfArray] = newCar;
            SizeOfArray++;
            if(SizeOfArray>=Threshold){
                System.out.println("Start Using AVLCar!");
                Tree = new AVLCar();
                for(Car car: CarArray){
                    
                    Tree.root=Tree.insert(Tree.root, car);
                }
            }
        }else{
            if(newCar.VIN.length()!=KeyLength){
                System.out.println("Please enter VIN of same keylength");
                return;
            }
            if(Tree.findKey(newCar.VIN)!=null)
                return;
            Tree.root=Tree.insert(Tree.root, newCar);
        }
    }
    
    public void add(Car newCar)
    {
        if(Tree==null){
            if(newCar.VIN.length()!=KeyLength){
                System.out.println("Please enter VIN of same keylength");
                return;
            }
            for(int i=0;i<SizeOfArray;i++){
                if(CarArray[i].equals(newCar.VIN)){
                    System.out.println("This VIN exist!");
                    return;
                }
            }
            
            CarArray[SizeOfArray] = newCar;
            SizeOfArray++;
            if(SizeOfArray>=Threshold){
                System.out.println("Start Using AVLCar!");
                Tree = new AVLCar();
                for(Car car: CarArray){
                    System.out.println("Added to AVL: "+ car);
                    Tree.root=Tree.insert(Tree.root, car);
                }
                
            }
        }else{
            if(newCar.VIN.length()!=KeyLength){
                System.out.println("Please enter VIN of same keylength");
                return;
            }
            if(Tree.findKey(newCar.VIN)!=null)
                return;
            Tree.root=Tree.insert(Tree.root, newCar);
        }
    }
    
    public void displayNull(){
        for(int i=0;i<Threshold;i++){
            System.out.println(i+""+CarArray[i]);
        }
    }
    
    public void remove(String key){
        if (Tree==null){
            System.out.println("Before Removal "+ SizeOfArray);
            for(int i=0;i<this.SizeOfArray;i++){
                    if(CarArray[i].VIN.equals(key)){
                        while(CarArray[i+1]!=null){
                            CarArray[i]=CarArray[i+1];
                            i++;
                        }
                        SizeOfArray--;
                        System.out.println("After Removal: "+ SizeOfArray);
                        System.out.println("Threshold+ "+ Threshold);
                        return;
                    }
                }
        }else{
            Tree.deleteNode(Tree.root, getValues(key));
        }
    }
    
    public String nextKey(String key)
    {
        String Result="";
        if (Tree==null){
            //Insertion Sort
            for(int i=0;i<SizeOfArray;i++){
                try{
                    sort(CarArray, SizeOfArray);
                    if(CarArray[i].VIN.equals(key)){
                        return CarArray[i+1].VIN;
                    }
                }catch(NullPointerException e){
                    return null;
                }
            }
        }else{
            Result = Tree.inOrderSuccessor(key);
        }
        return Result;
    }
    
    public String prevKey(String key)
    {
        String Result="";
        if (Tree==null){
            //Insertion Sort
            for(int i=0;i<SizeOfArray;i++){
                try{
                    if(CarArray[i].VIN.equals(key)){
                        sort(CarArray, SizeOfArray);
                        return CarArray[i-1].VIN;
                    }
                }catch(NullPointerException e){
                    return null;
                }
            }
        }else{
            Result = Tree.inOrderPredecessor(key);
        }
        return Result;
    }
    
    public void allKeys(){
        
        if (Tree==null){
            //Insertion Sort
            sort(CarArray,SizeOfArray);
            for(int i=0;i<SizeOfArray;i++){
                System.out.println(CarArray[i].VIN);
            }
        }else{
            System.out.println("Touched AVL Car In Orders");
            Tree.inOrder(Tree.root, "VIN");
            System.out.println("Finished inOrder");
        }
    }
    
    public void allKeys_2(){
        if (Tree==null){
            //Insertion Sort
            sort(CarArray,SizeOfArray);
            for(int i=0;i<SizeOfArray;i++){
                System.out.println(CarArray[i].VIN);
            }
        }else{
            System.out.println("Touched AVL Car In Orders");
            Tree.inOrder(Tree.root);
            System.out.println("Finished inOrder");
        }
    }
    
    
    public Car getValues(String Key)
    {
        Car Result = null;
        if (CarArray!=null){
            for(int i=0;i<this.SizeOfArray;i++){
                    if(CarArray[i].VIN.equals(Key)){
                        Result = CarArray[i];
                        return Result;
                    }
                }
        }else{
            Result = this.Tree.find(Key);
            
        }
        return Result;
    }
    
    public void generate(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(this.KeyLength); 
        int j=0;
        ArrayList<String> Result = new ArrayList<String>();
        while(j<n){
            for (int i = 0; i < this.KeyLength; i++) { 
  
                // generate a random number between 
                // 0 to AlphaNumericString variable length 
                int index= (int)(AlphaNumericString.length()* Math.random()); 
  
                // add Character one by one in end of sb 
                sb.append(AlphaNumericString 
                          .charAt(index)); 
            }
            if(Tree!=null){
                if(Tree.find(sb.toString())==null ){
                    if(Result.contains(sb.toString())){
                        sb=new StringBuilder(this.KeyLength);
                    }else{
                        Result.add(sb.toString());
                        sb= new StringBuilder(this.KeyLength);
                        j++;
                    }
                }else{
                    sb= new StringBuilder(this.KeyLength);
                }
            }else{
                if(SizeOfArray==0){
                    if(Result.contains(sb.toString())){
                        sb=new StringBuilder(this.KeyLength);
                    }else{
                        Result.add(sb.toString());
                        sb= new StringBuilder(this.KeyLength);
                        j++;
                    }
                }else{
                    for(int i=0;i<this.SizeOfArray;i++){
                        if(CarArray[i].VIN.equals(sb.toString())){
                            sb= new StringBuilder(this.KeyLength);
                            break;
                        }else if(i==SizeOfArray-1){
                            if(Result.contains(sb.toString())){
                                sb=new StringBuilder(this.KeyLength);
                            }else{
                                Result.add(sb.toString());
                                sb= new StringBuilder(this.KeyLength);
                                j++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Result); 
    }
    
    public ArrayList<String> generate(int n, String indicator) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(this.KeyLength); 
        int j=0;
        ArrayList<String> Result = new ArrayList<String>();
        while(j<n){
            for (int i = 0; i < this.KeyLength; i++) { 
  
                // generate a random number between 
                // 0 to AlphaNumericString variable length 
                int index= (int)(AlphaNumericString.length()* Math.random()); 
  
                // add Character one by one in end of sb 
                sb.append(AlphaNumericString 
                          .charAt(index)); 
            }
            if(Tree!=null){
                if(Tree.find(sb.toString())==null ){
                    if(Result.contains(sb.toString())){
                        sb=new StringBuilder(this.KeyLength);
                    }else{
                        Result.add(sb.toString());
                        sb= new StringBuilder(this.KeyLength);
                        j++;
                    }
                }else{
                    sb= new StringBuilder(this.KeyLength);
                }
            }else{
                if(SizeOfArray==0){
                    if(Result.contains(sb.toString())){
                        sb=new StringBuilder(this.KeyLength);
                    }else{
                        Result.add(sb.toString());
                        sb= new StringBuilder(this.KeyLength);
                        j++;
                    }
                }else{
                    for(int i=0;i<this.SizeOfArray;i++){
                        if(CarArray[i].VIN.equals(sb.toString())){
                            sb= new StringBuilder(this.KeyLength);
                            break;
                        }else if(i==SizeOfArray-1){
                            if(Result.contains(sb.toString())){
                                sb=new StringBuilder(this.KeyLength);
                            }else{
                                Result.add(sb.toString());
                                sb= new StringBuilder(this.KeyLength);
                                j++;
                            }
                        }
                    }
                }
            }
        }
        return Result; 
    }
    
    
    static void sort(Car arr[], int n) 
    { 
         
        for (int i = 1; i < n; ++i) { 
            Car key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            
            //arr[j] > key
            while (j >= 0 && stringCompare(arr[j].VIN, key.VIN)>0) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
    
    
    
    
    
}
