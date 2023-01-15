import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
public class Utils {
    public static String loadFileAsString(String path){//method for loading a file as a string
        StringBuilder builder = new StringBuilder();//string builders make things easier to add stuff to strings
    
        try{
                BufferedReader br = new BufferedReader(new FileReader(path));//buffered readers read images, and file readers read files
            String line;
            while((line = br.readLine()) != null)//while there's a line
                builder.append(line + "\n");//have the builder add the line to the string

            br.close();
            }catch(IOException e){//try catch statement to prevent things from going haywire
                e.printStackTrace();//print error to the screen
            }

            return builder.toString();//returns the string just created by the builder
        
    }

    public static int parseInt(String number){//going to turn a string into a number
        try{
            return Integer.parseInt(number);
        }catch(NumberFormatException e){//tests for this error and returns 0 and an error message
            e.printStackTrace();
            return 0;
        }
    }
}