package Assignment2;

//Gabriel Holder
//IT2660_D - Fall19 - CRN 83665 (Santos - Data Structures & Algorithms)
//Assignment 2 Programming Exercise #19,#20, and #21

public class Driver {
    public static void main(String[] args)  {          //19

        SortedArray sortedArray = new SortedArray(4);
      
        System.out.println("Insert Method \n");
        sortedArray.insert(new StudentListings("Gabriel", "32", "2.5"));
        sortedArray.insert(new StudentListings("Malachi", "33", "3.5"));  //manual insert values into sorted array. 
        sortedArray.insert(new StudentListings("Mereidith", "28", "3.5"));
        sortedArray.insert(new StudentListings("Ray", "23", "2.5"));

        sortedArray.sortArray(sortedArray.students);
        for (StudentListings student : sortedArray.students)
        {
            System.out.println(student.toString());
        }
        
        System.out.println("Fetch Method \n");          
        StudentListings fetch = sortedArray.fetch("Ray"); //fetch ray and 
            System.out.println(fetch.toString());

        //Testing delete method
        System.out.println("Delete Method \n");
        sortedArray.delete("Malachi");                  //delete malachi and print the rest of studentlist
        for (StudentListings student : sortedArray.students)
        {
            System.out.println(student.toString());
        }
        //Testing update method
        System.out.printf("Update Method \n\n");
        sortedArray.update("Gabriel", new StudentListings("Gabe", "37", "6.0")); //updated Gabriels numbers
        sortedArray.sortArray(sortedArray.students);
        for (StudentListings student : sortedArray.students)
        {
            System.out.println(student.toString());
        }
    }

}