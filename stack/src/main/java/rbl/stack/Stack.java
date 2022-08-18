package rbl.stack;

public class Stack {
    int top, stack[];
    
    Stack(){
        top = -1;
        stack = new int[5];
    }
    
    void push(int item){
        if(top == stack.length-1){
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = item;
    }
    
    int pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }
    
    void display(){
        for(int i=top;i>=0;i--){
            System.out.println(stack[i]+" ");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(2);
        stack.pop();
        stack.push(2);
        stack.display();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
