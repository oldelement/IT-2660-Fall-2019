package Assignment3;
//Gabriel Holder
//IT2660_D - Fall19 - CRN 83665 (Santos - Data Structures & Algorithms)
//Assignment 3 Programming Exercise #19 and #20


public class Driver {

	public static void main(String[] args) {
		
	Stack number = new Stack();
	
	number.push(1); //<- pushes number and is filled with zeros "1 0 0 0"
	number.show();

	number.push(2); //<- pushes number 2 and display both 1 and 2, then fills zeros "1 2 0 0"
	number.show();
	
	number.push(3); //pushes again, but now adds a 3 to the stack. displaying "1 2 3 0"
	number.show();
	
	number.push(4); // continues the stack "1 2 3 4"
	number.show();
	
	number.push(5); // << since the stack is full, displays "Could not insert data, Stack is Full"
	
	
	
	System.out.println(number.pop()); //4th number
	System.out.println(number.pop()); //3rd number
	System.out.println(number.pop()); //2nd number
	//System.out.println(number.pop()); //2nd number  // would trigger error message, because stack would be empty and out of bounds
	System.out.println(number.peek());	//1st number

		
	}
}