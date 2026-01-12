package StackProblems;

import java.util.Scanner;
public class BasicStackImplementation{
    int[] stack ;
    int size ;
    int top = -1 ;
    Scanner scanner = new Scanner(System.in);

    public void stackInitialize()
    {
        System.out.println("Enter the size : ");
        size = scanner.nextInt();
        stack = new int[size];
    }

    public void push(int num)
    {
        if(top == stack.length -1)
        {
            System.out.println("Stack overflow");
            return;
        }
    top++;
    stack[top]=num;

    }

    public int pop()
    {
        if (top==-1) {
            System.out.println("Stack underflow");
            return -1;
            
        }
    int removed = stack[top];
    top--;
    return removed;    
    }


    public void display()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return;
        }
    for (int i =0 ;i<=top;i++)
        {
            System.out.print(stack[i]+" ");
        }
        System.out.println();    
    }

    public static void main (String[]args)
    {
        BasicStackImplementation stack1 = new BasicStackImplementation();
        stack1.stackInitialize();

        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.display();

        stack1.pop();
        stack1.display();
        
        stack1.scanner.close();


    }



}