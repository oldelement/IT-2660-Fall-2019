package Assignment3;

public class Stack {
	int stack[] = new int[4]; //initializes and sets the bound of the stack to 4
	int top = 0;
	
	
	public void push (int data)// push method
	
	{
		if(top==4){                //if top is equal to 4(full) display message 
			
			System.out.println("Could not insert data, Stack is full");
		}
		else {
			stack[top] = data;    //else if the stack is not full(top) continue to accept values(data). 
			top++;                //Increment stack when values is added
		}
		
	}
	
	public int pop() {           // pop method
		int data = 0;            //sets data to zero, or deletes
		
		
		if (isEmpty()) {
		System.out.println("Couldn not retrieve data, Stack is Empty");	 //triggers when empty
		}
		
		else 
		{
			top--;                     //else lowers top value, makes its the data value, and sets it to zero. deletes. 
			data = stack[top];
			stack[top] = 0;
		}
		return data;
		
		
		
	}
	
	
	
	public int peek() //peek method 
	
	{
		int data;
		data = stack[top-1];
		return data;
	}
	
	
	public boolean isEmpty() {       // if top is less than 0 return method is Stack is empty 
		return top<=0;
	}
	
	public void show() {        //show method used to print the pushes. 
		for(int n : stack)      //takes a stack instance
		{
			System.out.print(n + " ");
		}
		System.out.println();  //extra line
	}
}