/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mortage.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class App {

    public static void main(String[] args) throws IOException {

        System.setProperty("file.encoding", "UTF-8");
        
        JFrame frame = new JFrame("Mortage");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        frame.add(textArea);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);


        String userDirectory = System.getProperty("user.dir");
        File file = new File (userDirectory+"\\src\\main\\resources\\prospects.txt");
        
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

            //System.out.println("Prospect "+customerNo+": "+str.split(",")[0]+" wants to borrow "+str.split(",")[1]+"€ for a period of "+str.split(",")[3]+" years and pay "+mortage+"€ each month");
            textArea.append("Prospect "+customerNo+": "+str.split(",")[0]+" wants to borrow "+str.split(",")[1]+"€ for a period of "+str.split(",")[3]+" years and pay "+mortage+"€ each month\n");
            customerNo++;
            } catch (Exception e){
                //ignore invalid rows
            }
        }
        
        br.close();
        
    }
}
