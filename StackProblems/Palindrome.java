    package StackProblems;
    import java.util.Scanner;
    public class Palindrome {
        char [] array ;
        int size;
        int top = -1;
        public Palindrome (int size)
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
            String reversedString = "";
            System.out.println(" Enter the String : ");
            string = scanner.nextLine();

            // clean the string before processing if you can for example R A C E car = racecar
            //string = string.replaceAll(" ", "").toLowerCase();

            if(string.length() ==0)
            {
                System.out.println(" Empty String , nothing to reverse");
                scanner.close();
                return;
            }
            int size = string.length();
            Palindrome obj1 = new Palindrome(size);
            char temp;
            for(int i =0 ; i<size ;i++)
            {
                temp=string.charAt(i);
                obj1.push(temp);
                
            }
            System.out.println("Reversed String : ");
            while (!obj1.isEmpty()) {
                reversedString = reversedString + obj1.pop();
                
            }
            System.out.println(reversedString);

            if(string.equals(reversedString))
            {
                System.out.println(" It is palindrome");
            }
            else{
                System.out.println(" It is not a palindrome");
            }

            scanner.close();

        }
        
    }
