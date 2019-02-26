/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsprocess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Felipe
 */
public class ThreadsProcess {

    static int totalRegistros;
    static int totalPares;
    static int totalImpares;
    static int totalRepetidos;
    static long processTime;
    static long startTime;   
    static Set<Integer> idsSet = new HashSet<>();
    static List<Integer> idsListFirstHalf;
    static List<Integer>  idsListSecondHalf;    
    static ReentrantLock counterLock = new ReentrantLock(true);
    
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> idsList = new ArrayList<>();
        final String FILE_NAME = "../matriculas.txt";
        Scanner idsFile = new Scanner(new File(FILE_NAME));
        
        // Read Matriculas File
        while(idsFile.hasNext()) {
            idsList.add(Integer.parseInt(idsFile.next()));
        }
        idsFile.close();               
        
        // Split idsList
        if(idsList.size()%2 == 0) {            
            idsListFirstHalf = idsList.subList(0, idsList.size()/2);
            idsListSecondHalf = idsList.subList((idsList.size()/2), idsList.size());            
        } else {
            idsListFirstHalf = idsList.subList(0, (idsList.size()-1)/2);
            idsListSecondHalf = idsList.subList(((idsList.size()-1)/2), idsList.size());
        }                 
        
        Thread threadOne = new Thread() {
            @Override
            public void run() {
                CalcularValores(idsListFirstHalf, "Hilo 1");
            }
        };
        
        Thread threadTwo = new Thread() {
            @Override
            public void run() {
                CalcularValores(idsListSecondHalf, "Hilo 2");
            }
        };  
        
        threadOne.start();
        threadTwo.start();                     
    }
    
    public static void CalcularValores(List idsList, String threadNum) {
        startTime = System.currentTimeMillis();
        int id;                 
        for (int i = 0; i < idsList.size(); i++) {
            id = (int) idsList.get(i);                        
            counterLock.lock();
            
            try{
                 if(id%2==0) {
                    totalPares++;
                }else {
                    totalImpares++;
                }

                if(idsSet.add(id) == false)
                    totalRepetidos++;            
            }finally{
                counterLock.unlock();
            }
        }
        totalRegistros = totalPares + totalImpares;
        processTime = System.currentTimeMillis()-startTime;
        printResults(threadNum);
    }
    
    public static void printResults(String threadNum) {
        System.out.println("------------ Proceso de "+threadNum +" ------------");
        System.out.println("Total de registros procesados: "+totalRegistros);
        System.out.println("Total de registros pares: "+totalPares);
        System.out.println("Total de registros impares: "+totalImpares);
        System.out.println("Total de registros repetidos: "+totalRepetidos);
        System.out.println("Tiempo total del proceso: "+processTime+" ms");
        System.out.println("Tiempo total del proceso: "+processTime/1000+" s");
    }
}
