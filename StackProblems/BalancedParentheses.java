package StackProblems;
import java.util.Scanner;
public class BalancedParentheses 
{ 
    char[] stack ;
    int top = -1;
    int size =0;
    String string="";
    BalancedParentheses(int size , String string)
    {
        this.size = size;
        stack = new char[size];
        this.string = string;

    }

    void push(char letter)
    {
        if (top == size-1)
        {
            throw new RuntimeException("Stack Overflow: Cannot push into stack");
        }
        top++;
        stack[top] = letter;
    }
    char pop()
    {
        if (top ==-1) 
        {
            throw new RuntimeException("Stack Underflow: Cannot pop from empty stack");
        }
        char returned = stack[top];
        top--;
        return returned;
    }

    void checking()
{

    /* if(size%2 != 0)
        {
            System.out.println("No , Not balanced");
        return;
        }            --------------this line not needed if the input is not only parantheses   */

    for(int i=0 ; i<size;i++)
    {
        char temp = string.charAt(i);
        if(temp == '[' || temp == '{' || temp == '(')
        {
            push(temp);
        }
        else if(temp == ']' || temp == '}' || temp == ')')
        {
            if (top == -1)
                    {                                   
                       System.out.println("No, Not Balanced");
                       return;
                    }           
            char temp2 = pop();

            if(temp==')')
            { 
            if(temp2 != '('){
                System.out.println("No, Not Balanced parentheses");
                return;
            }
            }
            else if(temp=='}')
            {
                if(temp2!='{')
                {
                    System.out.println("No, Not Balanced parentheses");
                    return;
                }
            }
            else if(temp==']')
            {
                if(temp2!='[')
                {
                System.out.println("No, Not Balanced parentheses");
                return;
                }
            }
    
           
        }
    }
    if(top==-1)
    {
    System.out.println("Yes, Balanced parentheses");
    }
    else
    {
        System.out.println("No, Not Balanced parentheses"); 
        return;
    }

}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the string: ");
        String string = scanner.nextLine();
        System.out.println(string);
        int size = string.length();
        BalancedParentheses obj1 = new BalancedParentheses(size,string);
        obj1.checking();

        scanner.close();
    }
    
}




