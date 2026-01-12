package StackProblems;

public class BasicStackOperation {

    int[] stack;
    int size;
    int top=-1;
    public BasicStackOperation( int size)

    {
        this.size = size;
        stack = new int[size];
    }

    public void push (int num)
    {
        if (top == size-1) {
            System.out.println("Stack overflow");
        return;            
        }
        top++;
        stack[top] = num;
    }
    public int pop()
    {

        if (top ==-1) {
            System.out.println("Stack underflow");
            return -1;
            
        }
        int returned = stack[top];
        top--;
        return returned;
    }

    public int peek(){
        if (top ==-1) {
            System.out.println("Stack underflow");
            return -1;
            
        }
        return stack[top];
    }

    public boolean isEmpty()
    {
        return top ==-1;
    }
    public boolean isFull()
    {
        return top ==size-1;
    }

    public void display()
    {
        if (top==-1) {
        System.out.println("Stack is Empty");    
        return;        
        }
    for (int i = 0; i <= top; i++) {
        System.out.print(stack[i] + " ");
     }
    System.out.println();
}   
}



    

