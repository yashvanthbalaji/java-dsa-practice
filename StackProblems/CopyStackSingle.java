package StackProblems;
import java.util.Scanner;

public class CopyStackSingle {

    int top = -1;
    int size;
    int[] arr;

    CopyStackSingle(int size) {
        this.size = size;
        arr = new int[size];
    }

    void push(int num) {
        if (top == size - 1) {
            System.out.println("Overflow");
            return;
        }
        arr[++top] = num;
    }

    int pop() {
        if (top == -1) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }

    void display() {
        if (isEmpty()) return;
        int temp = pop();
        System.out.print(temp + " ");
        display();
        push(temp);
    }

    // Static copy logic
    static void copyStack(CopyStackSingle original, CopyStackSingle temp, CopyStackSingle copy) {

        while (!original.isEmpty()) {
            temp.push(original.pop());
        }

        while (!temp.isEmpty()) {
            int x = temp.pop();
            original.push(x);
            copy.push(x);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack capacity: ");
        int size = sc.nextInt();

        CopyStackSingle original = new CopyStackSingle(size);
        CopyStackSingle temp = new CopyStackSingle(size);
        CopyStackSingle copy = new CopyStackSingle(size);

        System.out.print("How many elements do you want to push now: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            original.push(sc.nextInt());
        }

        System.out.println("\nOriginal Stack before copy:");
        original.display();

        copyStack(original, temp, copy);

        System.out.println("\n\nOriginal Stack after copy:");
        original.display();

        System.out.println("\nCopied Stack:");
        copy.display();

        sc.close();
    }
}
