package com.greatlearning.driver;
import java.util.*;
import com.greatlearning.service.*;

public class FloorAssemble {

	public static void main(String[] args) {
				
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> t2stack = new Stack<Integer>();
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the total number of the floors in the building: ");
		int n = s.nextInt();
		for(int i=0; i<n; i++) {
			System.out.println("Please enter the floor size given on the day : " + (i+1));
			int flsz =s.nextInt();
			stack.add(flsz);
		}
		Iterator<Integer> value = stack.iterator();
		while(value.hasNext()){
            t2stack.push(value.next());
        }
	    
		Stack<Integer> tempstack = Sorting.sortStack(t2stack);
        //System.out.println(stack);
        //System.out.println(tempstack);
		System.out.println("                      ");
		System.out.println("The order of the construction is as follows: ");
		
		for(int i=0; i<stack.size(); i++) {
			System.out.println("Day " + (i+1) +": ");
            Iterator<Integer> value2 = stack.iterator();
            while(value2.hasNext()) {
            
                if(value2.next() == n)
                {
                    System.out.println(tempstack.pop());
                    n--;
                    break;
                }
                else
                {
                    System.out.println("      ");
                    break;
                }
            }
		}
	}

}
