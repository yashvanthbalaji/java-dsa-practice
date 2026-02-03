package CircularQueue;
import java.util.Scanner;
public class CostlyDequeue {
    int[] stack1 ; int[] stack2;
    int top1 =-1;
    int top2=-1;
    int size =0;
    CostlyDequeue(int size)
    {
        this.size = size ;
        stack1 = new int[size];
        stack2 = new int[size];  
    }
    void enqueue(int num)

    {
        if(top1 ==size-1)
        {
            throw new RuntimeException("Overflow");
        }
        push1(num);
    }

    int dequeue()
    {
        if (top1==-1) {
             throw new RuntimeException("Underflow");
        }
        while (top1!=-1) {
            push2(pop1());
        }
        int returned =pop2();
        while (top2!=-1) {
            push1(pop2());
            
        }
        return returned;


    }
    void push1(int num)
    {
        if(top1 == size-1)
        {
            throw new RuntimeException("Overflow");
        }
        stack1[++top1] = num;  

    }

    void push2(int num)
    {
        if (top2 == size -1){
            throw new RuntimeException("Overflow");
        }
        stack2[++top2] = num;

    }

    int pop1()
    {
        if(top1 ==-1)
        {
            throw new RuntimeException("Underflow");
        }
        int returned = stack1[top1--];
        return returned;

    }
    int pop2()
    {
        if(top2 ==-1)
        {
            throw new RuntimeException("Underflow");
        }
        int returned = stack2[top2--];
        return returned;

    }
    void display()
    {
        int temp = top1;
        while (temp!=-1) {
            System.out.print(stack1[temp--] +" ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size : ");
        int size = scanner.nextInt();
        CostlyDequeue obj = new CostlyDequeue(size);
        System.out.println();
        for (int i =0 ; i<size  ;i++)
        {
            System.out.print("Element "+(i+1)+" : ");
            obj.enqueue(scanner.nextInt());
        }
        System.out.println();
        System.out.print("After Enqueue");
        System.out.println();
        obj.display();
        System.out.println();
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
        System.out.println("After dequeue");
        obj.display();
        System.out.println();
        scanner.close();



    }
    
}
