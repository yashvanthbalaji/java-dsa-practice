/*         For every number in an array, find the first number to its right that is bigger than it.
If nothing bigger exists → answer is -1           TIME COMPLEXITY = O(N)   */

package StackProblems;
import java.util.Scanner;

public class NextGreaterElement
{
    int[] arrInput,arrOutput;
    int[] stack ;
    int top=-1;
    int size=0;

    NextGreaterElement(int size)
    {
        this.size = size;
        arrInput = new int[size];
        arrOutput = new int[size];
        for(int i =0 ; i<size ; i++)
        {
            arrOutput[i] =-1;
        }
        stack = new int[size];
    }

    void push(int num)
    {
        if (top == size-1)
        {
            throw new RuntimeException("Stack Overflow: Cannot push into stack");
        }
        top++;
        stack[top] = num;
    }
    int pop()
    {
        if (top ==-1) 
        {
            throw new RuntimeException("Stack Underflow: Cannot pop from empty stack");
        }
        int returned = stack[top];
        top--;
        return returned;
    }

    public static void main(String[] args) { 

     {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size : ");
        int size = scanner.nextInt();
        NextGreaterElement obj1 = new NextGreaterElement(size);
        System.out.print("Enter elements :  ");
        for(int i=0;i<size;i++)
        {
            obj1.arrInput[i]=scanner.nextInt();
       
        }

        // for reference i put this input [5,4,8,6,9,10,15]

        for(int i =0 ; i<size ; i++)
        {
            int current = obj1.arrInput[i];
            while (obj1.top != -1 && current > obj1.arrInput[obj1.stack[obj1.top]] ) {
                int index = obj1.pop();
                obj1.arrOutput[index] = current;
                
            }
            obj1.push(i);   // we pushing index here


        }

        for (int num : obj1.arrOutput) {
            System.out.print(num +" ");
            
        }
        scanner.close();    
        
    }

}
}