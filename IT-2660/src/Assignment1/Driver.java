package Assignment1;

//Gabriel Holder
//IT2660_D - Fall19 - CRN 83665 (Santos - Data Structures & Algorithms)
//Assignment 1 Programming Exercise #41 and #42

public class Driver {

	
	public static void main(String[] args) {  //driver program (progressively developed)
		
		                                                // Question 42 
		                                               
      Listing[] threeListings = new Listing[3];         //array of three Listings input
      for(int j = 0; j < threeListings.length; j++) {   //"input" is user definded. 
      	 threeListings[j] = new Listing();
      	 threeListings[j].input();
      	 }
      
      System.out.println("\nIn reverse order: \n");
                                                        
      for(int j = threeListings.length-1;j >= 0; j--) { //prints output in reverse order 
          System.out.println( threeListings[j]);
      }	
}
}