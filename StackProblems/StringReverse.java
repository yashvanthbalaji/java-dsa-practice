package StackProblems;
import java.util.Scanner;
public class StringReverse {
    char [] array ;
    int size;
    int top = -1;
    public StringReverse (int size)
    {
        this.size = size;
        array  = new char[size];
    }

    public void push(char num)
    {
        if(top==size-1)
        {
            System.out.println(" Overflow ");
            return;
        }
        top++;
        array[top]=num;
    }
    public char pop()
    {
        if(top==-1)
        {
            System.out.println(" underflow ");
            return '\0';
        }
        char returned = array[top];
        top--;
        return returned; 

    }
    public boolean isEmpty()
    {
        return top==-1;
    }

    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);
        String string = "";
        System.out.println(" Enter the String : ");
        string = scanner.nextLine();
        if(string.length() ==0)
        {
            System.out.println(" Empty String , nothing to reverse");
            scanner.close();
            return;
        }
        int size = string.length();
        StringReverse obj1 = new StringReverse(size);
        char temp;
        for(int i =0 ; i<size ;i++)
        {
            temp=string.charAt(i);
            obj1.push(temp);
            
        }
        System.out.println("Reversed String : ");
        while (!obj1.isEmpty()) {
            System.out.print(obj1.pop());
            
        }

        scanner.close();

    }
    
}
