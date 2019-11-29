package Assignment2;

import java.util.Scanner;

public class StudentInfo {
    public static SortedArray sortedArray;         //21
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        System.out.println("Enter the maximum size of the data set");
        sortedArray = new SortedArray(input.nextInt());
        
       

        while (choice != 6) {
           Menu();
            choice = input.nextInt();
            if (choice == 1) {
                sortedArray.insert(addStudent());
            } else if (choice == 2) {                                 //could have use a switch statement, but went with if, else if
                System.out.println(retrieveStudent());
            }
            else if (choice == 3)   {
                System.out.println("Enter the student's name you wish to delete");
                sortedArray.delete(input.next());
            }
            else if (choice == 4)   {
                System.out.println("Enter the student's record you wish to replace");
                String targetStudent = input.next();
                StudentListings newStudent = addStudent();
                sortedArray.update(targetStudent, newStudent);
            }
            else if (choice == 5) {
                sortedArray.sortArray(sortedArray.students);
                for (StudentListings student : sortedArray.students) {
                    System.out.println(student);
                }
            }
            else    {
                    System.out.println("INCORRECT value, please try again! \n");
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
        
    }
    public static StudentListings addStudent() {
        Scanner input = new Scanner(System.in);

        String studentName;
        String studentId;
        String studentGpa;

        System.out.println("Enter the name of the student");
        studentName = input.nextLine();
        System.out.println("Enter the student's ID");
        studentId = input.nextLine();
        System.out.println("Enter the Students G.P.A.");
        studentGpa = input.nextLine();
        return new StudentListings(studentName, studentId, studentGpa);
    }
    public static StudentListings retrieveStudent() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter student's name that you want to view" + "\n");
        String fetch = input.nextLine();
        return sortedArray.fetch(fetch);
    }
}