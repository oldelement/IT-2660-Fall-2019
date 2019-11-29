package Assignment1;

import java.util.Scanner;

                                      //Question 41

public class Listing {
	
	                                 // private global variables name and age
  private String name;
  private int age;
  
                                    // default constructor set name to " " and age to 0
  public Listing() {
      name = " ";
      age = 0;
  }
  
                                            //parameter constructor with string name and Integer age

  public Listing(String name, int age) {
      this.name = name;
      this.age = age;
  }
  
                                            // String to string method
  public String toString() {               
      return "Name: " + name  + "\nAge: " + age;
  }
  
                                         
  public void input() {
      Scanner Scanner = new Scanner(System.in);     // void user input for name and age 
      System.out.print("Enter your Name: ");
      name = Scanner.nextLine();                                                                
      System.out.print("Enter your Age: ");
      age = Scanner.nextInt();
      
  }
  
  

  
  public void setName(String name) {
      this.name = name;				  //setter method for name and age variables
  }
  

  public void setAge(int age) {
      this.age = age;
  }
  

  
  public String getName() {         //getter method for name and age variables
      return name;
  }


  public int getAge() {
      return age;
  }

  
}
