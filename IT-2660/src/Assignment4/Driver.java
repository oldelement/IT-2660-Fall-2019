package Assignment4;

//Gabriel Holder
//IT2660_D - Fall19 - CRN 83665 (Santos - Data Structures & Algorithms)
//Assignment 4 Programming Exercise #25,26 and #27

import java.util.Scanner;
public class Driver {
	
    public static void main(String[] args)  {
      
        String studentName, updateStudent;
        int Id;
        int num = 0;
        double Gpa;
        LinkedList linkedList = new LinkedList();

        while(num != 6) {
        	
            Scanner input = new Scanner(System.in);
            Menu();
            num = input.nextInt();
            
            
            Scanner scanner = new Scanner(System.in);    
            
            													     	//could of also of used a switch statement, but went with this
            if (num == 1) {
                System.out.println("Enter student's name: ");
                studentName = scanner.nextLine();
                System.out.println("Enter Student's ID: ");               //enter new student info
                Id = scanner.nextInt();
                System.out.println("Enter Student's GPA: ");
                Gpa = input.nextDouble();
                linkedList.insert(new Listing(studentName, Id, Gpa));    //insert into linkedlist
                
            }
            if (num == 2) {
                System.out.println("Enter the student's name: ");
                String fetchStudent = scanner.nextLine();
                Listing studentOutput = linkedList.fetch(fetchStudent);
                if (studentOutput != null) {
                    System.out.println("Student Info: \n" + "Name: "+ studentOutput.name + "\n" + "ID: "+ studentOutput.id + "\n" + "GPA: "+ studentOutput.gpa+ "\n");  //fetch
                } else {
                    System.out.println("No Records Found");             //message incase no students of that name
                }
            }
            if (num == 3) {
                System.out.println("Enter the student's name you wish to delete");
                String deleteStudent = scanner.nextLine();              //deletes targeted student

                if (linkedList.delete(deleteStudent) == false)  {        //message incase no students of that name
                    System.out.println("No students in list");
                }
            }
            if (num == 4) {
                System.out.println("Enter student's name that you wish to update");
                updateStudent = input.next();
                System.out.println("Enter new Student's name");
                studentName = scanner.nextLine();                      //updates targeted students info 
                System.out.println("Enter new Student's ID");
                Id = scanner.nextInt();
                System.out.println("Enter new Student's GPA");
                Gpa = input.nextDouble();
                linkedList.update(updateStudent, new Listing(studentName, Id, Gpa));
            }
            if (num == 5) {
                linkedList.showAll();                          //calls the showall method to print the linkedlist
            }
            
        }
      
    }
    public static void Menu()    {
    	System.out.println("Enter 1 to insert a new student's information.\n" +       
                "Enter 2 to fetch and output a student's information.\n" +
                "Enter 3 to delete a student's information.\n" +
                "Enter 4 to update a student's information.\n" +
                "Enter 5 to output all the student's information and.\n" + 
                "Enter 6 to exit the program.\n"); 
        System.out.println("Enter your choice: "); 
    }
  
}