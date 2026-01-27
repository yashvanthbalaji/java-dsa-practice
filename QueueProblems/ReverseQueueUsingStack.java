// simple queue
package QueueProblems;
import java.util.Scanner;
public class ReverseQueueUsingStack {

    int[] queue;
    int[] stack;
    int front =-1 , rear =-1;
    int top=-1;
    int size = 0;

    ReverseQueueUsingStack(int size)
    {
        this.size = size;
        queue = new int[size];
        stack = new int[size];

    }

    void enqueue (int num)
    {
        if(rear == size-1)
        {
            throw new RuntimeException(" queue overflow ");
        }
        if(front == -1)
        {
            front =0;
        }
        rear++;
        queue[rear] = num;
    }

    int dequeue()
    {
        if(front ==-1 || front > rear)
        {
            throw new RuntimeException(" Queue underflow ");
        }

        int returned = queue[front];
        front++;
        return returned;
    }

    int peek()
    {
        if (front ==-1 || front>rear) {
            throw new RuntimeException("Queue underflow");
        }
        return queue[front];
    }

    boolean isEmpty()
    {
        return front ==-1 || front>rear ;
    }

    boolean isFull()
    {
        return rear==size-1;
    }

    void display()
    {
        
        for(int i=front ; i<=rear ;i++)
        {
            System.out.print(queue[i]+" ");
        }

    }

    void push(int num)
    {
        if(top == size-1) throw new RuntimeException("Stack Overflow");
        top++;
        stack[top] = num;
    }

    int pop()
    {
        if(top==-1) throw new RuntimeException("Stack Underflow");
        int returned2 = stack[top];
        top--;
        return returned2;
    }

    void reverse()
    {
       while (!isEmpty()) {
        push(dequeue());
        
       }
       front=-1;
       rear =-1;

       while (top!=-1) {
        enqueue(pop());
        
       }
    }
    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size : ");
        int size = scanner.nextInt();
        ReverseQueueUsingStack obj = new ReverseQueueUsingStack(size);
        System.out.print("How many numbers you need to add : ");
        int n = scanner.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.print("Element "+(i+1)+": ");
            obj.enqueue(scanner.nextInt());
        }
        System.out.println();
        obj.display();
        obj.reverse();
        System.out.println();
        obj.display();

        scanner.close();

    }
}