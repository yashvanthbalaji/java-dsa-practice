package StackProblems;
import java.util.Scanner;

public class ReverseStack
{
    public static void main ( String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size : ");
        int size = scanner.nextInt();
        BasicStackOperation obj1 = new BasicStackOperation(size);
        System.out.println("Enter elements");
        for(int i=0;i<size;i++)
        {
            obj1.push(scanner.nextInt());
        }

        System.out.println("Reversed Stack");
        while (!obj1.isEmpty()) {
            System.out.print(obj1.pop());
        }
        System.out.println();








    scanner.close();
    }
}