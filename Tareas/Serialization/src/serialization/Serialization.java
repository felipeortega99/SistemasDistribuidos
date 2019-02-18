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
    
    public static void main(String[] args) throws JAXBException, FileNotFoundException {        
        Scanner input = new Scanner(System.in);            
        List<Job> jobs = new ArrayList<>();
        Address address;
        Curriculum curriculum;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        // Address
        String street;
        int number;
        String state;
        String city;
        String zipcode;
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
        System.out.print("Ciudad: ");
        city = input.nextLine();
        System.out.println(".................");
        System.out.print("Estado: ");
        state = input.nextLine();  
        System.out.println(".................");
        System.out.print("Codigo postal: ");
        zipcode = input.nextLine();
        
        System.out.print("\n------------Empleo-------------");
        
        boolean oneMoreJob = false;
        do {                           
            System.out.print("\nNombre de la empresa: ");
            companyName = input.nextLine();
            System.out.println(".................");
            System.out.print("\nPuesto: ");
            jobPosition = input.nextLine();            
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
            
            Job newJob = new Job(companyName, jobPosition, formatter.format(startDate.getTime()), formatter.format(endDate.getTime()));
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
        
        address = new Address(street, number, city, state, zipcode);
        image = SerializeImg(photoPath); 
        curriculum = new Curriculum(name, cel,  birthPlace, new Email(email, emailType.toUpperCase()), image, address, jobs);
        SerializeXML(curriculum);

    }    
    
    public static void SerializeXML (Curriculum resume) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Curriculum.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders",
                "\n<?xml-stylesheet type=\"text/xsl\" href=\"CurriculumView.xsl\"?>"
                        + "\n<!DOCTYPE curriculum SYSTEM \"curriculum.dtd\">");
        marshaller.marshal(resume, new File("Curriculum.xml"));
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
