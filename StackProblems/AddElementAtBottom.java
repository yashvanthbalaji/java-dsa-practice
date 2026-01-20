package StackProblems;

import java.util.Scanner;

public class AddElementAtBottom {

    int top =-1;
    int size = 0;
    int[] stack ;

    AddElementAtBottom(int size)
    {
        this.size = size;
        stack = new int[size];

    }

    void push(int num){
        if (top == size-1) {
            System.out.println("overflow");
            return;
        }
        top ++ ;
        stack[top]=num;
    }

    int pop(){
        if (top == -1) {
            System.out.println("underflow");
            return -1;

            
        }

        int returned = stack[top];
        top--;
        return returned;
    }
    
    void display()
    {
        if(top==-1) return;
        int temp = pop();
        System.out.print(temp+" ");
        display();
        push(temp);
    }

    void AddElement(int num)
    {
        if(top==-1)
        {
         push(num);
         return;   
        }
        int temp = pop();

        AddElement(num);
        push(temp);


    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size : ");
        int size = scanner.nextInt();
        System.out.println();
        AddElementAtBottom obj1 = new AddElementAtBottom(size+1);
        for(int i = 0 ; i<size ; i++)
        {
            System.out.print("Element " + (i+1) + ": ");
            obj1.push(scanner.nextInt());
        }
        System.out.println("Before adding");
        obj1.display();
        System.out.println("Enter number to add : ");
        int addNum = scanner.nextInt();
        obj1.AddElement(addNum);
        System.out.println("After adding");
        obj1.display();





        scanner.close();

    }
}
