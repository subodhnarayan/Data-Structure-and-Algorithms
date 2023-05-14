public class stackusinglinkedlist {
    static int size = 0;

    public static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }

    }

    public static class stack {
        int max = 5;
        node top = null;

        public boolean isempty() {
            return top == null;
        }

        public boolean isfull() {
            return size == max;
        }

        public void push(int data) {
            if (isfull()) {
                System.out.println("The stack is full");
                return;
            }
            node newnode = new node(data);
            System.out.println(data + " is pushed");
            newnode.next = top;
            top = newnode;

        }

        public void pop() {
            if (isempty()) {
                System.out.println("The stack is empty");
            } else {
                System.out.println(top.data + " is poped out");
                top = top.next;
            }
        }

        public void printstack() {
            if (isempty()) {
                System.out.println("The stack is empty");
                return;
            } else {
                node curr = top;
                while (curr != null) {
                    System.out.println(curr.data);
                    curr = curr.next;
                }
            }
        }

        public void peek() {
            if (isempty()) {
                System.out.println("The stack is empty");
            } else {
                System.out.println("The peek element is " + top.data);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("subodh narayan sah");
        stack s = new stack();
        s.printstack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.printstack();
        s.push(6);
        s.peek();
    }
}
