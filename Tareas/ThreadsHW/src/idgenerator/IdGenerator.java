
package idgenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Felipe
 */
public class IdGenerator {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int idsNumber;
        int id = 0;
        List<String> idsList = new ArrayList<>();
        Random rnd = new Random();
        final String FILE_NAME = "../matriculas.txt";
        final int MIN = 10000;
        final int MAX = 99999;
        
        System.out.print("Cantidad de matriculas a crear: ");
        idsNumber = input.nextInt();
        
        // Add random number to idsList
        for (int i = 0; i < idsNumber; i++) {
            id = rnd.nextInt((MAX - MIN) + 1) + MIN;
            idsList.add(Integer.toString(id));
        }        
        
        // File Writer
        BufferedWriter bw = new BufferedWriter (new FileWriter (FILE_NAME)); 
        for (String line : idsList) {
            bw.write (line);
            bw.newLine();
        }			        
        bw.close ();		        
        System.out.println("Archivo creado!!");
    }
    
}
