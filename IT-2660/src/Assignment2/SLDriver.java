package Assignment2;

import java.util.Scanner;
public class SLDriver {



    public static void main(String[] args) {

        StudentListings newStudent = new StudentListings(); //listing instance
        StudentListings copyOfnewStudent;
        SLDriver studentListingsDriver = new SLDriver();
        StudentListings studentListings = new StudentListings();


        newStudent = studentListingsDriver.getInput(newStudent);
        copyOfnewStudent = studentListings.deepCopy();
        int compareToInfo = newStudent.compareTo("Ray");     // ("Ray", "23", "2.5"));
        System.out.println(compareToInfo);  // compare string info
        System.out.println(newStudent.toString());


    }

    public StudentListings getInput(StudentListings newStudent) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Student Name");
        newStudent.name = input.nextLine();
        System.out.println("Enter the StudentID");
        newStudent.id = input.nextLine();
        System.out.println("Enter the Student's GPA");
        newStudent.gpa = input.nextLine();
        return newStudent;
        
    }
   
}