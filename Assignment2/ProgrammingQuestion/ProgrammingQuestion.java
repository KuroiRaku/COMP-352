
package programmingquestion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Le Cherng
 */
public class ProgrammingQuestion {

    /**
     * @param args the command line arguments
     */
    /**
     * In the lectures, we discussed about Evaluating Arithmetic Expressions (refer to your slides and the text book).
In this programming assignment, you will design, using pseudo code, and implement, in Java, two versions of arithmetic calculators. 
* The first version will be based on the pseudo code in the lecture notes that uses two different stacks. The second version must be completely based on recursion. 
* This means that you have to replace the explicit use of stacks (in the first version) by using recursion (that implicitly uses the JVM runtime stack). 
* Your arithmetic calculators must read lines of text from a text file, where each line contains a syntactically correct arithmetic expression. 
* Your output file must repeat the input line and print the computed result on the next line. 
* Your calculators must support the following operators on integers or reals and observe the standard operator precedence as shown below (1-8, highest to lowest; same precedence evaluated left to right).
• 1. Parentheses (possibly nested ones): ( , )
• unary operators
2. factorial: !
3. minus: -
• binary operators
4. power function: xy
5. operators: *, /
6. operators: +, -
7. operators: >, ≥, ≤, <
8. operators: ==, !=
For the implementation of factorial and power function you have to use your own code (refer to your slides and the text book) that should be as efficient as possible.
a) Briefly explain the time and memory complexity for both versions of your calculator. 
*   You can write your answer in a separate file and submit it together with the other submissions.
b) For the second version of your calculator describe the type of recursion used in your implementation. 
*   Does the particular type of recursion have an impact on the time and memory complexity? Justify your answer.
c) Provide test logs for at least 20 different and sufficiently complex arithmetic expressions that use all types of operators (including parentheses) in varying combinations.
You are required to submit a fully commented Java source files, the compiled files (.class files), and the text files. 
*   - You additionally need to submit the pseudo code of your program, together with your experimental results. Keep in mind that Java code is not pseudo code.
     * @param args 
     */
    
    

    static Stack valStk = new Stack<>();
    static Stack opStk = new Stack<>();
    static int x;
    static int y;
    static String op;

    public static void doOp()
    {
        
        x = ((Number)valStk.pop()).intValue();
        y = ((Number) valStk.pop()).intValue();
        
        op = opStk.pop().toString();
        int answer = EvalExp(x,y,op);
        System.out.println(answer);
        valStk.push(answer);
        
    }
    
    public static int EvalExp(int y, int x, String op){
        int answer =0;
        switch(op){
            case "+":
                System.out.println("passed through");
                return x+y;
            case "^":
                return (int) Math.pow(x, y);
            case "*":
                return x*y;
            case "/":
                return x/y;
            case "-":
                return x-y;
            case ">":
                if(x>y){
                    return 1;
                }
                return 0;
            case ">=":
                if(x>=y){
                    return 1;
                }
                return 0;
            case "<":
                if(x<y){
                    return 1;
                }
                return 0;
            case "<=":
                if(x<=y){
                    return 1;
                }
                return 0;
            case "≥":
                if(x>=y){
                    return 1;
                }
                return 0;
            case "≤":
                if(x<=y){
                    return 1;
                }
                return 0;
            case "==":
                if(x==y){
                    return 1;
                }
                return 0;
            case "!=":
                if(x!=y){
                    return 1;
                }
                return 0;
            default:
                return 0;
        }
    }

    public static void repeatOps (String refOp)
    {
        while (valStk.size() > 1 && (prec(refOp) <= prec(opStk.peek().toString())))
        {
                    doOp();
        }
    }

    public static int prec(String op)
    {
        switch(op)
        {
            case "(":
            case ")":
                return 1;
            case "!":
                return 2;
            case "^":
                return 3;
            case "*":
            case "/":
                return 4;
            case "+":
            case "-":
                return 5;
            case ">":
            case ">=":
            case "<":
            case "<=":
            case "≥":
            case "≤":        
                return 6;
            case "==":
            case "!=":
                return 7;
            case "$":
                return 8;
            default:
                throw new IllegalArgumentException("Invalid Operator!");
        }
    }
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        StringBuilder sb;
        String str = "";
        String line;
        try
        {
            
                 Scanner sc = new Scanner(new FileInputStream("expression.txt"));
                
                 PrintWriter pw = new PrintWriter(new FileOutputStream("out.txt",false));
                 line = sc.nextLine();
                 while(!line.equals("$"))
                 {
                        while(line.trim().isEmpty()){
                            sc.nextLine();
                        }
                        pw.println("Expression: " + line);
                        line = line.replaceAll(" ", "");
                        char[] tokens = line.toCharArray();
                        for(int i = 0; i < tokens.length; i++)
                        {
                            
                            if(tokens[i]=='-' && i==0){
                                sb = new StringBuilder();
                                sb.append(tokens[i++]);
                                while(i <tokens.length && Character.isDigit(tokens[i])){
                                    System.out.println(tokens[i]);
                                    sb.append(Character.toString(tokens[i]));
                                    System.out.println(sb.toString());
                                    i++;
                                    System.out.println("Found Negative Number");
                                }
                                valStk.push(Integer.parseInt(sb.toString()));    
                             }
                            
                            if(i>0){
                                if(!Character.isDigit(tokens[i-1]) && tokens[i]=='-'){
                                    sb = new StringBuilder();
                                    
                                    sb.append(tokens[i]);
                                    System.out.println(tokens[i]);
                                    i++;
                                    while(i <tokens.length && Character.isDigit(tokens[i])){
                                        System.out.println(tokens[i]);
                                        sb.append(Character.toString(tokens[i]));
                                        i++;
                                        System.out.println("Found Negative Number");
                                    }
                                    System.out.println(sb.toString());
                                    valStk.push(Integer.parseInt(sb.toString())); 
                                }
                                
                            }
                            System.out.println("Every token going to be checked "+ tokens[i]);
                            if(Character.isDigit(tokens[i]))
                            {
                                
                                sb = new StringBuilder();
                                
                                    while(i <tokens.length && Character.isDigit(tokens[i])){
                                        System.out.println(tokens[i]);
                                        sb.append(Character.toString(tokens[i]));
                                        i++;
                                        System.out.println("Found Number");
                                    }
                                valStk.push(Integer.parseInt(sb.toString()));
                                
                            }
                            try{
                                
                            if(tokens[i]=='(')
                            {
                                
                                opStk.push(Character.toString(tokens[i]));
                            }
                            else if(tokens[i]==')')
                            {
                                
                                while(!opStk.peek().toString().equals("(")){
                                    doOp();
                                }
                                opStk.pop();
                            }
                            else if(tokens[i]=='!')
                            {
                                if(i+1>tokens.length){
                                    int num =((Number) valStk.pop()).intValue();;
                                    valStk.push(factorial(num));
                                }else{
                                    if(tokens[i+1]=='='){
                                        sb = new StringBuilder();
                                        sb.append(tokens[i]);
                                        sb.append(line.charAt(i + 1));
                                        i++;
                                        repeatOps(sb.toString());
                                        opStk.push(Character.toString(tokens[i]));
                                    }else{
                                        int num =((Number) valStk.pop()).intValue();;
                                        valStk.push(factorial(num));
                                    }
                                }
                                
                            }
                            else
                            {
                                
                                
                                if((tokens[i] == '>' || tokens[i] == '<'  || tokens[i] == '=') && (line.charAt(i + 1) == '='))
                                {
                                    
                                    sb = new StringBuilder();
                                    sb.append(tokens[i]);
                                    sb.append(line.charAt(i + 1));
                                    i++;
                                    repeatOps(sb.toString());
                                    opStk.push(Character.toString(tokens[i]));
                                    
                                }
                                else
                                {
                                    //if the non digit number reach and yet it is the first character
                                    
                                    
                                    System.out.println("Found Operation");
                                    repeatOps(Character.toString(tokens[i]));
                                    opStk.push(Character.toString(tokens[i]));
                                        
                                    
                                    
                                    
                                } 
                            }
                            }catch(IndexOutOfBoundsException e){
                                
                            }
                            
                        }
                        while(!opStk.empty()){
                            doOp();
                        }
                        System.out.println(valStk.peek());
                        pw.println(valStk.peek());
                        line = sc.nextLine();
                        opStk.removeAllElements();
                        valStk.removeAllElements();
                    }
                    pw.close();
                    sc.close();
        }

        catch(IOException ex)
        {
            System.out.println("Uh Oh");
        }
        catch(EmptyStackException ex)
        {
            System.out.println("Syntax Error");
        }
        
            
    }
        /**
         * O(n)
         * @param n
         * @return 
         */
        static int factorial(int n) 
        { 
        // single line to find factorial 
        if (n == 0)    
            return 1;    
        else    
            return(n * factorial(n-1));
        } 
        /**
         * Time complexity is practically O(n*n) one is due to checking the input, another one is factorial. We assume the worst case scenario. 
         */
}
    

