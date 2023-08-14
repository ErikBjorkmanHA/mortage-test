/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mortage.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static String utf8Encode(String input){

        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        String encodedString = new String(bytes,StandardCharsets.UTF_8);
        return encodedString;
    }

    public static void main(String[] args) throws IOException {

        File file = new File ("C:\\Users\\erikb\\OneDrive\\Dokument\\GitHub\\mortage-test\\app\\src\\main\\resources\\prospects.txt");

        double mortage;

        BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
        Counter counter = new Counter();
        String str;
        Integer customerNo = 1;
        while((str = br.readLine()) != null){
            try{
            //System.out.println(str);
            mortage = counter.getMortage(Double.parseDouble(str.split(",")[1]),Double.parseDouble(str.split(",")[2]),Integer.parseInt(str.split(",")[3]));
            //System.out.println(mortage);
            System.out.println("Prospect "+customerNo+": "+str.split(",")[0]+" wants to borrow "+str.split(",")[1]+"€ for a period of "+str.split(",")[3]+" years and pay "+mortage+"€ each month");
            customerNo++;
            } catch (Exception e){

            }
        }
        

        br.close();
        
        double value = counter.getMortage(4356,1.27,6);
        System.out.println(value);
    }
}