/*
Queue using two stacks (Costly Enqueue)
Logic:
1. While main stack is not empty → pop and push into temporary stack
2. Push the new element into main stack
3. While temporary stack is not empty → pop and push back into main stack */


package CircularQueue;
import java.util.Scanner;
public class CostlyEnqueue {
    int[] stack ;
    int[] tempStack;
    int top =-1;
    int top2=-1;
    int size = 0;

    CostlyEnqueue(int size)
    {
        this.size = size ;
        stack = new int[size];
        tempStack = new int[size];
    }


    void enqueue(int input)
    {
        if (top == size - 1) {
            throw new RuntimeException("Queue is Full");
        }

        
            while(top != -1)
            {
                push2(pop());   
            }

            push(input);

            while(top2 != -1)
            {
                push(pop2());
            }
        

    }

    int dequeue()
    {
         if(top ==-1)
        {
            throw new RuntimeException("Underflow");
        }
        int returned = stack[top];
        top--;
        return returned;
    }
    
    void push (int num)
    {
        if(top == size-1)
        {
            throw new RuntimeException("overflow");
        }

        top++;
        stack[top] = num;

    }

    void push2(int num)
    {

        if(top2 == size-1)
        {
            throw new RuntimeException("overflow");
        }

        top2++;
        tempStack[top2] = num;

    }

    int pop()
    {
        if(top ==-1)
        {
            throw new RuntimeException("Underflow");
        }
        int returned = stack[top];
        top--;
        return returned;
    }

    int pop2()
    {
        if(top2 ==-1)
        {
            throw new RuntimeException("Underflow");
        }
        int returned = tempStack[top2];
        top2--;
        return returned;

    }
    void display()
    {
        int temptop = top;
        while (temptop != -1) {
            System.out.print(stack[temptop]+ " ");
            temptop--;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size : ");
        int size = scanner.nextInt();
        CostlyEnqueue obj1 = new CostlyEnqueue(size);
        for(int i = 0 ; i< size ; i++)
        {
            System.out.print("Enter element "+(i+1)+" : ");
            obj1.enqueue(scanner.nextInt());
        }
        obj1.display();
        System.out.println();
        System.out.println("After dequeue");
        System.out.print(obj1.dequeue()+" ");
        System.out.print(obj1.dequeue());
        System.out.println();
        obj1.display();

        scanner.close();
    }
}
