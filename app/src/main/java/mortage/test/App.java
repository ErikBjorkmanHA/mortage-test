/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mortage.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        File file = new File ("C:\\Users\\erikb\\OneDrive\\Dokument\\GitHub\\mortage-test\\app\\src\\main\\resources\\prospects.txt");
        System.setProperty("file.encoding", "UTF-8");
        
        double mortage;

        BufferedReader br = new BufferedReader(new FileReader(file));
        Counter counter = new Counter();
        String str;
        Integer customerNo = 1;
        while((str = br.readLine()) != null){
            try{

            //One of the names in the file uses an alternative way of displaying both first- and lastname by using "-symbols . 
            //This code escape those symbols
            if (str.contains("\"")){
                str = str.replaceFirst(","," ").replace("\"","");
            }
            
            mortage = counter.getMortage(Double.parseDouble(str.split(",")[1]),Double.parseDouble(str.split(",")[2]),Integer.parseInt(str.split(",")[3]));

            System.out.println("Prospect "+customerNo+": "+str.split(",")[0]+" wants to borrow "+str.split(",")[1]+"€ for a period of "+str.split(",")[3]+" years and pay "+mortage+"€ each month");
            
            customerNo++;
            } catch (Exception e){
                //ignore invalid rows
            }
        }
        
        br.close();
        
    }
}
