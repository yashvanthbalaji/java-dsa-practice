/*
Reverse the first K elements of a queue using a stack,
while keeping the remaining elements in the same order.
*/

package CircularQueue;
import java.util.Scanner;;
public class ReverseFirstKElements {
    int[] Queue;
    int[] stack;
    int top =-1;
    int front =-1;
    int rear =-1;
    int size;
    int k=0;
    ReverseFirstKElements(int size)
    {
        this.size = size;
        Queue = new int[size];
        stack = new int[size];
    }
    void enqueue(int num)
    {
        if(front == (rear+1)%size)
        {
            throw new RuntimeException("Overflow");

        }
        
        if(front==-1)
        {
            front = 0;
        }
        rear = (rear+1)%size;
        Queue[rear] = num;
    }

    int dequeue()
    {
        if(front ==-1)
        {
            throw new RuntimeException("Underflow");
        }
        int returned = Queue[front];
        if(front==rear)
        {
            front=-1;
            rear=-1;
            return returned;
        }
        else{
            front = (front+1)%size;
        }
        return returned;
        
    }
    void push(int num)
    {
        if (top ==size-1)
        {
            throw new RuntimeException("Overflow");
        }
        stack[++top] = num;
    }

    int pop()
    {
        if (top ==-1)
        {
            throw new RuntimeException("Undeflow");
        }
        int returned = stack[top--];
        return returned;
    }

    void reverse(int k)
    {
        int originalK = k;
        while (k!=0)
        {
         push(dequeue()); 
         k--; 
        }
        while (top!=-1)
        {
         enqueue(pop());   
        }
        int remaining = size-originalK;

        while (remaining !=0) {
            enqueue(dequeue());
            remaining--;
            
        }

    }

    void display()
    {
        int i = front;
        while (true) {
            System.out.print(Queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
    
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size : ");
        int size =scanner.nextInt();
        ReverseFirstKElements obj = new ReverseFirstKElements(size);
        for(int i =0 ; i<size ; i++)
        {
            System.out.print("Element "+(i+1)+" : ");
            obj.enqueue(scanner.nextInt());
        }
        System.out.println();
        System.out.print("Enter k : ");
        int k = scanner.nextInt();
        obj.reverse(k);
        System.out.println();
        System.out.print("After Reversing K elements : ");
        obj.display();

        scanner.close();
    }
    
}
