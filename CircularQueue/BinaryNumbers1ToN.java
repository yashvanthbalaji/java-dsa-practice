/* Generate binary numbers from 1 to N using queue
Logic:
1. Start with "1" in queue
2. For each number:
- Print front
- Add front+"0" and front+"1" to queue */
package CircularQueue;
import java.util.Scanner;
public class BinaryNumbers1ToN{
    String[] queue;
    int front=-1;
    int rear =-1;
    int size=0;
    BinaryNumbers1ToN(int size)
    {
        size = size*2;
        this.size = size;
        queue = new String[size];

    }

    void enqueue(String Val)
    {
        if(front == (rear+1)%size)
        {
            throw new RuntimeException("Overflow");
        }
        if(front==-1)
        {
            front=0;
        }
        rear = (rear+1)%size;
        queue[rear] = Val;
    }

    String dequeue()
    {
        if(front==-1)
        {
            throw new RuntimeException("Underflow");
        }
        String returned = queue[front];
        if (front==rear) {
            front=-1;
            rear=-1;
        }
        else{
            front = (front+1)%size;

        }
        return returned;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N : ");
        int n = scanner.nextInt();
        BinaryNumbers1ToN obj = new BinaryNumbers1ToN(n);
        obj.enqueue("1");
        for(int i =0 ; i<n ; i++){
            String temp = obj.dequeue();
            System.out.println(temp);
            obj.enqueue(temp+"0");
            obj.enqueue(temp+"1" );
        }

        scanner.close();
    }
}
