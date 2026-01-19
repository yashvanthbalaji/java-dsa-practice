package StackProblems;

import java.util.Scanner;

public class RemoveMiddleElement {

    int top =-1;
    int [] stack;
    int size = 0;

    RemoveMiddleElement (int size)
    {
        this.size = size;
        stack = new int[size];
    }


    void push(int num)
    {
        if (top == size-1) {
            System.out.println(" Stack overflow ");
            return;
        }

        top++;
        stack[top] = num;
        
    }

    int pop ()
    {
        if (top == -1)
        {
            System.out.println("Stack underflow");
            return -1;
        }

       int returned = stack[top];
       top--;
       return returned;
            
    }

    boolean isEmpty()
    {
        return top == -1;


    }

    void display ()
    {
       if (top == -1) return;

        int temp = pop();
        System.out.print(temp + " ");
        display();
        push(temp);
    }

    void delete (int middleIndex , int currentIndex)
    {

        if (top == -1)
        {
            return;
        }

        int temp = pop();

        if ( currentIndex == middleIndex)
        {
            return;
        }

        delete(middleIndex, currentIndex + 1);

        push(temp);


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size : ");
        System.out.println();
        int size = scanner.nextInt();
        RemoveMiddleElement obj1 = new RemoveMiddleElement(size);
        for ( int i =0 ; i<size ; i++)
        {
            obj1.push(scanner.nextInt());
        }
        System.out.print("Before deletion : ");
        obj1.display();
        int middleIndex = size/2;
        obj1.delete(middleIndex, 0);
        System.out.println();
        System.out.print("After Deletion : ");
        obj1.display();


        scanner.close();
    }
















}
