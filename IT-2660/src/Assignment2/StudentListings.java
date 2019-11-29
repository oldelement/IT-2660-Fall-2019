package Assignment2;

public class StudentListings {
    String name;
    String id;
    String gpa;

    public StudentListings(String n, String num, String a){
        name = n;
        id = num;
        gpa = a;
    }
    public StudentListings(){

    }
    public String toString()    {
        return("Name is " + name + "\nG.P.A. is " + gpa + "\nStudent ID is " + id + "\n");
    }
    public StudentListings deepCopy(){
        StudentListings clone = new StudentListings(name, id, gpa);
        return clone;
    }
    public int compareTo(String targetKey){
        return (name.compareTo(targetKey));
    }


}