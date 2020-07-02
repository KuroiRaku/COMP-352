package assignment1;

/**
 *
 * @author Le Cherng
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String test = "aaaadbbbcc";
        test=replaceAtIndex(test,3, 'a');
        System.out.println(test);
        System.out.println(changePassword(test));
        // TODO code application logic here
        
    }
    
    /**
    *Part 1
     * @param input
     * @return 
    */
    public static String changePassword(String input){
        StringBuilder build = new StringBuilder(input);
        int count=1;
        String str= input;
        String output="";
        int n1=0;
        int n2=1;
        if(input.equals("")){
            return "Empty";
        }
        while(true){
            try{
               while(build.charAt(n1)==build.charAt(n2)){
                build.deleteCharAt(n2);
                count++;
                System.out.println(build.toString());
            }
            build.insert(n1+1, Integer.toString(count));
            count=1;
            n2++;
            n1=n2;
            n2++;
            if(n1==build.length()-1){
                break;
            } 
            }catch(StringIndexOutOfBoundsException exception){
                System.out.println("Reached the end!");
                build.insert(n1+1, Integer.toString(count));
                output = build.toString().replaceAll("1", "");
                return output;
            }
            
        }
        
        
        output = build.toString().replaceAll("1", "");
        return output;
    }
    
    public static String replaceAtIndex(String str, int index, char replace){     
    if(str==null){
        return str;
    }else if(index<0 || index>=str.length()){
        return str;
    }
    char[] chars = str.toCharArray();
    chars[index] = replace;
    return String.valueOf(chars);       
}
    
}
