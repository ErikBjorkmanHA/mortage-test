/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mortage.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class AppTest {

    @Test void calculateMortage(){
        Counter counter = new Counter();
        assertEquals(62.87, counter.getMortage(4356,1.27,6));
    }

     @Test void readFile() throws IOException{
        File file = new File ("C:\\Users\\erikb\\OneDrive\\Dokument\\GitHub\\mortage-test\\app\\src\\test\\resources\\testFile.txt");
        String fileInformation = "";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while((str = br.readLine()) != null)
        fileInformation+=str;

        assertEquals("this?is!a@test#file123TestingMultipleRows!?", fileInformation);
        br.close();
     }

}
