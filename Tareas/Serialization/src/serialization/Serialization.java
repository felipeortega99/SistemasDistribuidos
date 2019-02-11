/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Felipe
 */
public class Serialization {

    /**
     * @param args the command line arguments
     * @throws javax.xml.bind.JAXBException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Scanner input = new Scanner(System.in);            
        List<Job> jobs = new ArrayList<>();
        Address address;
        Resume resume;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        // Address
        String street;
        int number;
        String suburb;
        String city;
        // Job
        GregorianCalendar startDate = new GregorianCalendar();
        GregorianCalendar endDate = new GregorianCalendar();
        int day;
        int month;
        int year;
        String companyName;
        String jobPosition;        
        // Resume
        String name;
        String cel;
        String photoPath;
        byte[] image;
        String email;
        String emailType;
        String birthPlace;
        
        System.out.println("------------Curriculum-------------");
        System.out.print("\nNombre: ");
        name = input.nextLine();
        System.out.println(".................");
        System.out.print("\nTelefono: ");
        cel = input.nextLine();
        System.out.println(".................");
        System.out.print("\nFoto (path): ");
        photoPath = input.nextLine();
        System.out.println(".................");
        System.out.print("\nEmail: ");
        email = input.nextLine();
        System.out.println(".................");
        System.out.print("\nTipo de email: ");
        emailType = input.nextLine();
        System.out.println(".................");
        System.out.print("\nLugar de nacimiento: ");
        birthPlace = input.nextLine();
        System.out.print("\n------------Direccion-------------");
        System.out.print("\nCalle: ");
        street = input.nextLine();
        System.out.println(".................");
        System.out.print("Numero exterior: ");
        number = input.nextInt();
        input.nextLine();
        System.out.println(".................");
        System.out.print("Colonia: ");
        suburb = input.nextLine();
        System.out.println(".................");
        System.out.print("Ciudad: ");
        city = input.nextLine();        
        
        System.out.print("\n------------Empleo-------------");
        // System.out.print("\nCantidad de empleos a agregar: ");
        //int numberJobs = input.nextInt();
        boolean oneMoreJob = false;
        do {                    
        // for (int i = 0; i < numberJobs; i++) {
            // System.out.print("\n------------Empleo "+i+1+"-------------");            
            System.out.print("\n.....Fecha de inicio (dd/mm/YYYY).....");
            System.out.print("\nDia: ");
            day = input.nextInt();
            System.out.print("\nMes: ");
            month = input.nextInt();
            System.out.print("\nAño: ");
            year = input.nextInt();   
            
            startDate.set(GregorianCalendar.DATE, day);
            startDate.set(GregorianCalendar.MONTH, month);
            startDate.set(GregorianCalendar.YEAR, year);
            
            System.out.print("\n.....Fecha de termino (dd/mm/YYYY).....");
            System.out.print("\nDia: ");
            day = input.nextInt();
            System.out.print("\nMes: ");
            month = input.nextInt();
            System.out.print("\nAño: ");
            year = input.nextInt();
            
            endDate.set(GregorianCalendar.DATE, day);
            endDate.set(GregorianCalendar.MONTH, month);
            endDate.set(GregorianCalendar.YEAR, year);
            
            System.out.println(".................");
            input.nextLine();
            System.out.print("\nNombre de la empresa: ");
            companyName = input.nextLine();
            System.out.println(".................");
            System.out.print("\nPuesto: ");
            jobPosition = input.nextLine();            
            
            Job newJob = new Job(formatter.format(startDate.getTime()), formatter.format(endDate.getTime()), companyName, jobPosition);
            jobs.add(newJob);
            
            System.out.print("\nDeseas agregar otro empleo (si/no): ");
            String answ = input.nextLine();
            if(answ.charAt(0) == 's') {
             oneMoreJob = true;   
            }                
            else{
               oneMoreJob = false; 
            }
            
        }while(oneMoreJob);        
        
        address = new Address(street, number, suburb, city);
        image = SerializeImg(photoPath); 
        resume = new Resume(name, cel, new Email(email, emailType), image, birthPlace, address, jobs);
        SerializeXML(resume);

    }    
    
    public static void SerializeXML (Resume resume) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Resume.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders","\n<!DOCTYPE resume SYSTEM \"curriculum.dtd\">");
        marshaller.marshal(resume, new File("curriculum.xml"));
        marshaller.marshal(resume, System.out);
    }
    
    public static byte[] SerializeImg(String path){
        byte[] image = null;
        try{            
            BufferedImage img = ImageIO.read(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            image = baos.toByteArray();
        } catch(FileNotFoundException ex) {
            System.out.println("Exception: "+ex);
        } catch(IOException ex) {
            System.out.println("Exception: "+ex);
        }
        return image;
    }
}
