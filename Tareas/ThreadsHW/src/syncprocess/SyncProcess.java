
package syncprocess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Felipe
 */
public class SyncProcess {

    static int totalRegistros;
    static int totalPares;
    static int totalImpares;
    static int totalRepetidos;
    static long processTime;
    static long startTime;       
    static Set<Integer> idsSet = new HashSet<Integer>();            

    
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> idsList = new ArrayList<>();
        final String FILE_NAME = "../matriculas.txt";
        Scanner idsFile = new Scanner(new File(FILE_NAME));
        
        // Read Matriculas File
        while(idsFile.hasNext()) {
            idsList.add(Integer.parseInt(idsFile.next()));
        }
        idsFile.close(); 
        
        calcularValores(idsList);       
    }
    
    public static void calcularValores(List idsList) {
        startTime = System.currentTimeMillis();
        int id;         
        for (int i = 0; i < idsList.size(); i++) {
            id = (int) idsList.get(i);
            
            if(id%2==0) {
                totalPares++;
            }else {
                totalImpares++;
            }            
            if(!idsSet.add(id))
                totalRepetidos++;                    
        }
        
        totalRegistros = totalPares + totalImpares;
        processTime = System.currentTimeMillis()-startTime;
        printResults();
    }
    
    public static void printResults() {
        System.out.println("------------Proceso sin hilos------------");
        System.out.println("Total de registros procesados: "+totalRegistros);
        System.out.println("Total de registros pares: "+totalPares);
        System.out.println("Total de registros impares: "+totalImpares);
        System.out.println("Total de registros repetidos: "+totalRepetidos);
        System.out.println("Tiempo total del proceso: "+processTime+" ms");
        System.out.println("Tiempo total del proceso: "+processTime/1000+" s");
    }
}
