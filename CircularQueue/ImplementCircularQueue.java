package CircularQueue;
import java.util.Scanner;
public class ImplementCircularQueue
{

    int[] queue;
    int front=-1;
    int rear =-1;
    int size =0;

    ImplementCircularQueue(int size)
    {
        this.size = size;
        queue = new int[size];
    }

    void enqueue(int num)
    {
        if(front == (rear+1)%size)
        {
            throw new RuntimeException(" queue overflow ");
        }

        if(front==-1)
        {
            front=0;
        }
        rear = (rear+1)%size;
        queue[rear] = num;
    }

    int dequeue()
    {
        if(front ==-1)
        {
            throw new RuntimeException("queue underflow");
        }

        int value = queue[front];
        if (front==rear) {
            front=-1;
            rear=-1;
            
        }
        else{
            front = (front+1)%size;
        }
        return value;
    }


    boolean isFull()
    {
        return  (front == (rear+1)%size) ;
            
    }

    boolean isEmpty()
    {
        return (front==-1);
    }

    void display()
    {
    if (isEmpty()) {
        System.out.println("Queue is Empty");
        return;
    }
        int i = front;
        while (true) {
            System.out.print(queue[i]+ " ");
            if (i == rear ) break;
            i = (i+1)%size;
            
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size : ");
        int size = scanner.nextInt();
        ImplementCircularQueue obj1 = new ImplementCircularQueue(size);
        obj1.enqueue(10);
        obj1.enqueue(20);
        obj1.enqueue(30);
        obj1.enqueue(40);
        obj1.enqueue(50);
        obj1.display();
        System.out.println();
        obj1.dequeue();
        obj1.dequeue();
        obj1.display();
        System.out.println();
        obj1.enqueue(100);
        obj1.enqueue(200);
        obj1.display();

        scanner.close();
    }









}
