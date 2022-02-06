package com.greatlearning.service;

import java.util.Stack;

public class Sorting {
	
	public static Stack<Integer> sortStack(Stack<Integer> stack){
		Stack<Integer> tmpStack = new Stack<Integer>();
        while(!stack.isEmpty())
        {
        	// pop out the first element
            int tmp = stack.pop();

           // while temporary stack is not empty and top of stack is greater than temp
           while(!tmpStack.isEmpty() && tmpStack.peek() > tmp)
           {
        	   // pop from temporary stack and push it to the input stack
               stack.push(tmpStack.pop());
           }

            // push temp in temporary of stack
           tmpStack.push(tmp);
        }
        
        return tmpStack;
   }

}
