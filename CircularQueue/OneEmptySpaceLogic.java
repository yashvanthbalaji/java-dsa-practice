//Implement a circular queue using an array by following the one empty space logic - front and rear = 0 not -1
//where one slot is always kept empty to differentiate between full and empty conditions

package CircularQueue;
import java.util.Scanner;
public class OneEmptySpaceLogic {

    int[] queue;
    int front =0 , rear =0;
    int size =0;
    OneEmptySpaceLogic(int size)
    {
        this.size = size;
        queue = new int[size];
    }
//front=0 nad rear = 0 ---- 
    void enqueue(int num)
    {
        if (front == (rear+1)%size)   
        {
            throw new RuntimeException("Queue overflow");
        }
        else
        {
            queue[rear] = num;   // here first we add value add increment rear because initial itself rear = 0 .
            rear = (rear+1)%size;

        }
    }

    int dequeue()
    {
        if(front == rear)
        {
            throw new RuntimeException("Queue underflow");
        }
        int removed = queue[front];
        front = (front+1)%size;
        return removed;
    }
    
    void display()
    {
        if(front == rear)
        {
            throw new RuntimeException("Queue underflow");
        }
        int i = front;
        while (true) {
            System.out.print(queue[i]+ " ");
            i = (i+1)%size;
            if (i==rear) {
                break;
            }
            
        }

    }

    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the queue size : ");
        int size = scanner.nextInt();
        OneEmptySpaceLogic obj1 = new OneEmptySpaceLogic(size);
        obj1.enqueue(10);
        obj1.enqueue(20);
        obj1.enqueue(30);
        obj1.enqueue(40);
        obj1.enqueue(50);     // size is 6 but we add only 5 elements because this probelm logic is we leave one index empty
        obj1.display();             
        System.out.println();

        System.out.println("after dequeue");

        obj1.dequeue();
        obj1.dequeue();

        obj1.display();
        scanner.close();

    }
}
