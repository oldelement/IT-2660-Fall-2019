package Assignment7;
//Gabriel Holder
//IT2660_D - Fall19 - CRN 83665 (Santos - Data Structures & Algorithms)
//Assignment 7 exercises #30 and #31

import java.util.Scanner;

public class Driver {
    public static void main(String[] args)  {
    
        int op = 0;

        BinaryTree binaryT = new BinaryTree();
        Node newStudent;
        while (op != 6) {
            
            Scanner input = new Scanner(System.in);      //grabs input for the selection
            
            
            Scanner scanner = new Scanner(System.in);    //grabs input for the information
            Menu();
            op = scanner.nextInt();
            if (op == 1) {
                System.out.println("Enter the name: ");
                String studentName = input.nextLine();
                System.out.println("Enter the student's ID: ");
                int studentId = input.nextInt();
                System.out.println("Enter the student's G.P.A: ");
                double studentGpa = input.nextDouble();
                newStudent = new Node(studentId,studentName,studentGpa);
                binaryT.insert(newStudent);                                     //take id, into tree, then adds it into the insert method via newStudent node
            }
            if (op == 2) {
                System.out.println("Enter the student ID number");              //this could be done with a switch statement, but went with this.
               int studentFind = input.nextInt();							    //take id, when adds it into the fetch method
               Node student = binaryT.fetch(studentFind);
                System.out.println("Student Name: " + student.name + "\nStudent ID: " + student.key + "\n" + "Student G.P.A.: " + student.gpa + "\n");

            }
            if (op == 3) {
                System.out.println("Enter the ID of the student you wish to delete");
                int deleteStudent = input.nextInt();                             //take id, when adds it into the delete method
                binaryT.delete(deleteStudent);

            }
            if (op == 4) {
                System.out.println("Enter student's ID you wish to update");
                int updateStudentId = input.nextInt();
                System.out.println("Enter new student's name");
                String updateStudentName = input.next();
                System.out.println("Enter new student's ID");
                int newStudentId = input.nextInt();
                System.out.println("Enter new student's GPA");
                double newStudentGpa = input.nextDouble();
                newStudent = new Node(newStudentId,updateStudentName,newStudentGpa);
                binaryT.updateNode(updateStudentId, newStudent);                  //take id, when adds it into the update method

            }
            if (op == 5) {
                
            	binaryT.outputAll(binaryT.root);             //must pass it the root as a parameter(node.child)-- starting point
            }
        }
    }

  
    public static void Menu()    {                              
        System.out.println("Enter 1 to insert a new student's information.\n" +       
        "Enter 2 to fetch and output a student's information.\n" +          //menu
        "Enter 3 to delete a student's information.\n" +
        "Enter 4 to update a student's information.\n" +
        "Enter 5 to output all the student information.\n" + 
        "Enter 6 to exit the program."); 
        System.out.println("\nEnter your selection: ");  //gives choices to user
    }
}