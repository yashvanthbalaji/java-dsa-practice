// simple queue
package QueueProblems;
import java.util.Scanner;
public class BasicImplementation {

    int[] queue;
    int front =-1 , rear =-1;
    int size = 0;

    BasicImplementation(int size)
    {
        this.size = size;
        queue = new int[size];
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
    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size : ");
        int size = scanner.nextInt();
        BasicImplementation obj = new BasicImplementation(size);
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.enqueue(40);
        obj.enqueue(50);
        obj.display();
        System.out.println();
        obj.dequeue();
        obj.display();
        System.out.println();
        System.out.println(obj.peek());
        System.out.println("Empty : "+ obj.isEmpty());
        System.out.println("Full : "+obj.isFull());

        scanner.close();

    }
}
