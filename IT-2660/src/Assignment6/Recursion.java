package Assignment6;
//Gabriel Holder
//IT2660_D - Fall19 - CRN 83665 (Santos - Data Structures & Algorithms)
//Assignment 6 Recursion merge sort. 

public class Recursion {

	   
    public static void main(String[] args) {
      
         
        int[] randomNums=new int[100];          //array for set of 100 random numbers
        
        System.out.println("Random sequence: \n");
        
        for (int i=0;i<randomNums.length;i++){
        	randomNums[i] = (int)Math.floor(Math.random() * 101);           //calls the random built-in function and fills our array with numbers between 1-100
        }
        
       
          for(int i= 0; i < randomNums.length; i++){
			System.out.print(randomNums[i] + ", " );        //prints array of random numbers
			
			}
          
            System.out.print("\n");
          
          randomNums = recursiveMergeSort(randomNums);  //assign the recursive method to the array
          
        System.out.println("\nOrdered top down sequence: \n");
        
          for(int i = 0; i < randomNums.length; i++){
				System.out.print(randomNums[i] + ", " );           //prints array, but after we call the recursive sort. Making the an array of ordered numbers
			}
          System.out.print("\n\n\nScroll ---> to see full array output ");
    }
    
    
    public static int[] recursiveMergeSort(int[] randomNums){  // Recursive method that takes an array
        
        
        if(randomNums.length <= 1)                     
        {
            return randomNums;
        }
        
             int split = randomNums.length/2;                   //splits random list into two arrays and sorts 
             
			 int[] left = new int[split];
			 int[] right = new int[randomNums.length - split];
	    
			 int[] awn = new int[randomNums.length];   
			 
			 
			 for(int i = 0; i < split; i++)
			 {
				left[i] = randomNums[i];
			 }
			 
			 int x = 0;
			 for(int y = split; y < randomNums.length; y++)
			 {
				right[x] = randomNums[y];
				x++;  
			 }
			 
			 
			 left = recursiveMergeSort(left);      //assigning 
			 right = recursiveMergeSort(right);
			 
			  
			 awn = merge(left, right);    // using the merge method and passing the two arrays left and right ...left unsorted and right sorted low - high
			 
			 return awn;    
      }
		
		public static int[] merge(int[] left, int[] right){
			
		  int resultLength = left.length + right.length;    //final list thats sorted
		  
		  int[] result = new int[resultLength]; 
		  
		  int leftIndex = 0;
		  int rightIndex = 0;
		  int resultIndex = 0; 
		  
		  while (leftIndex < left.length || rightIndex < right.length)
		  {
			 if (leftIndex < left.length && rightIndex < right.length)
			 {
				
				if (left[leftIndex] <= right[rightIndex]) 
				{
				   result[resultIndex] = left[leftIndex];   //if else if else logic for the merge sort
				   leftIndex++;
				   resultIndex++; 
				}
				
				
				else                            
				{
				   result[resultIndex] = right[rightIndex];
				   rightIndex++;
				   resultIndex++; 
				}

			 }
			 
			 else if (leftIndex < left.length)
			 {
				result[resultIndex] = left[leftIndex];
				   leftIndex++;
				   resultIndex++;
			 }
			 else if (rightIndex < right.length)
			 {
				result[resultIndex] = right[rightIndex];
				   rightIndex++;
				   resultIndex++;
			 }
		  }
		  return result; 
		}
}