/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingquestion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Le Cherng
 */
public class CalculatorPart2 {
    
    public static void main(String[]args){
        
        System.out.println(evaluate("((1+-2+3!-23)+2)!=23"));
        long startTime, endTime;
        try{
            
            Scanner inputStream = new Scanner(new FileInputStream("expression.txt"));
            PrintWriter outputStream=new PrintWriter(new FileOutputStream("out2.txt",false));
            String str= inputStream.nextLine();
            System.out.println("Str"+ str);
            while(!str.equals("$")){
                
                str = str.replaceAll(" ", "");
                outputStream.println("Expression: "+ str);
                System.out.println("All the stuff in the String "+str);
                outputStream.println(evaluate(str));
                
                str= inputStream.nextLine();
            }
            inputStream.close();
            outputStream.close();
            
            
        }catch(FileNotFoundException e){
            System.out.println("Not Found");
        }
        
    }
    
    public static int evaluate(String s) {
    //Base case
        if (!s.contains("+") && !s.contains("-") && !s.contains("*")&& !s.contains("^") && !s.contains("/") && !s.contains("!")&& !s.contains("==")&& !s.contains("<")&& !s.contains("≥")&& !s.contains("≤")
                && !s.contains(")")&& !s.contains("(") && !s.contains(">") && !s.contains("<")) {
            return Integer.parseInt(s);
        }
        if(s.charAt(0)=='-' ){
            for(int index=1; index<s.length();index++){
                if(!Character.isDigit(s.charAt(index))){
                    break;
                }
                if(index==s.length()-1){
                    return Integer.parseInt(s);
                }
            }
        }

    int i, countF, result=0, b=0;
    StringBuilder sb, rebuilder;
    
    
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '('){
                sb=new StringBuilder();
                rebuilder= new StringBuilder(s);
                int j =i;
                rebuilder.deleteCharAt(j);
                i++;
                b++;
                while(s.charAt(i)!=')' || b>0){
                    rebuilder.deleteCharAt(j);
                    if(s.charAt(i)=='('){
                        System.out.println(s.charAt(i));
                        b++;
                    }
                    sb.append(s.charAt(i++));
                    
                    if(s.charAt(i)==')'){
                        b--;
                    }
                }
                System.out.println("SB\n\n"+sb.toString());
                String results=Integer.toString(evaluate(sb.toString()));
                rebuilder.deleteCharAt(j);
                if(rebuilder.toString().equals("")){
                            return Integer.parseInt(results);
                }
                s=results+rebuilder.toString();
                System.out.println(s);
                i=0;
                
            }
            if(s.charAt(i) == '!'){
                if(i+1>s.length()-1){ 
                    rebuilder = new StringBuilder(s);
                    System.out.println("rebuilder original "+ rebuilder);
                    rebuilder.deleteCharAt(i);
                    i--;
                    sb=new StringBuilder();
                    while(Character.isDigit(s.charAt(i))){
                        rebuilder.deleteCharAt(i);
                        sb.append(s.charAt(i--));
                        if(i<=0){
                            break;
                        }
                    }
                    System.out.println("rebuilder"+ rebuilder.toString());
                    String temp = Integer.toString(factorial(Integer.parseInt(sb.toString())));
                    System.out.println("Factorial: "+temp);
                    if(rebuilder.toString().equals("")){
                        return Integer.parseInt(temp);
                    }
                    s= rebuilder.insert(0, temp).toString();
                    System.out.println("S after factorial: "+ s);
                    i=0;
                }else{
                    if(s.charAt(i+1)!='='){
                        rebuilder = new StringBuilder(s);
                        System.out.println("rebuilder original "+ rebuilder);
                        rebuilder.deleteCharAt(i);
                        i--;
                        sb=new StringBuilder();
                        while(Character.isDigit(s.charAt(i))){
                            rebuilder.deleteCharAt(i);
                            sb.append(s.charAt(i--));
                            if(i<=0){
                                break;
                            }
                        }
                        System.out.println("rebuilder"+ rebuilder.toString());
                        String temp = Integer.toString(factorial(Integer.parseInt(sb.toString())));
                        System.out.println("Factorial: "+temp);
                        if(rebuilder.toString().equals("")){
                            return Integer.parseInt(temp);
                        }
                        s= rebuilder.insert(0, temp).toString();
                        System.out.println("S after factorial: "+ s);
                        i=0;
                        }else{
                            rebuilder= new StringBuilder(s);
                            rebuilder.deleteCharAt(i+1);
                            s=rebuilder.toString();
                            break;
                        }
                }
            }
            if(s.charAt(i) == '^'){
                break;
            }
            if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                break;
            }
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i-1<0 && s.charAt(i)=='-'){
                    
                }else{
                    break;
                }
            }
            if(s.charAt(i) == '>'|| s.charAt(i) == '<' || s.charAt(i)=='≤' || s.charAt(i)=='≥'){
                if(s.charAt(i+1)=='=' && s.charAt(i)=='<')
                {
                    rebuilder = new StringBuilder(s);
                    rebuilder.deleteCharAt(i);
                    rebuilder.deleteCharAt(i);
                    rebuilder.insert(i, '≤');
                    s=rebuilder.toString();
                    
                }else if(s.charAt(i+1)=='=' && s.charAt(i)=='>'){
                    rebuilder = new StringBuilder(s);
                    rebuilder.deleteCharAt(i);
                    rebuilder.deleteCharAt(i);
                    rebuilder.insert(i, '≥');
                    s=rebuilder.toString();
                    System.out.println(s.charAt(i));
                    
                }    
                System.out.println("s: "+s);  
                break;
                
                 
                
            }
            if(s.charAt(i) == '='){
                rebuilder= new StringBuilder(s);
                rebuilder.deleteCharAt(i);
                s=rebuilder.toString();
                break;
            }
            
            
            
        }
        System.out.println(s);
    String r1 = s.substring(0, i);
    System.out.println("ri: "+r1);
    System.out.println(i);
    String r2 = s.substring(i + 1, s.length());
    System.out.println(r2);
    

    switch (s.charAt(i)) {
        case '+':
            result = evaluate(r1) + evaluate(r2);
            break;
        case '-':
            result = evaluate(r1) - evaluate(r2);
            break;
        case '*':
            result = evaluate(r1) * evaluate(r2);
            break;
        case '/':
            int right = evaluate(r2);
            if (right == 0) //if denominator is zero
            {
                System.out.println("Invalid divisor");
                System.exit(1);
            } else {
                result = (evaluate(r1) / right);
            }
            break;
        case '^':
            result =(int) Math.pow(evaluate(r1), evaluate(r2));
            break;
        case '=':
            if(evaluate(r1)==evaluate(r2)){
                result =1;
            }else{
                result =0;
            }
            break;
        case '≥':
            if(evaluate(r1)>=evaluate(r2)){
                result =1;
            }else{
                result =0;
            }
            break;
        case '≤':
            if(evaluate(r1)<=evaluate(r2)){
                result =1;
            }else{
                result =0;
            }
            break;
        case '>':
            if(evaluate(r1)>=evaluate(r2)){
                result =1;
            }else{
                result =0;
            }
            break;
        case '<':
            if(evaluate(r1)<evaluate(r2)){
                result =1;
            }else{
                result =0;
            }
            break;
        case '!':
            if(evaluate(r1)!=evaluate(r2)){
                result =1;
            }else{
                result =0;
            }
            break;
    }
    return result;

}
    
    static int factorial(int n) 
        { 
        // single line to find factorial 
        if (n == 0)    
            return 1;    
        else    
            return(n * factorial(n-1));
        } 
    
}
