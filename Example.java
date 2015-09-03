
import java.util.*;

public class Example{

    public static void main(String args[]){
        
        FileIO reader = new FileIO();
        Scanner scan = new Scanner(System.in);
 
        String[] inputs = reader.load("C:\\movies");    //Reading the File as a String array
        
        for(int i=0;i<inputs.length;i++){
            System.out.println(inputs[i]);
        
        
        try{
            reader.save("C://somefile.csv",inputs);
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }

}
