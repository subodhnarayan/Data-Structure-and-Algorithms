public class queueusinglinkedlist {
    static int size = 0;

    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }

    }

    static class queue {
        node front = null;
        node rear = null;
        int max = 5;

        public boolean isempty() {
            return front == null;
        }

        public void enque(int data) {
            node newnode = new node(data);
            if (isempty()) {
                front = rear = newnode;
            }
            rear.next = newnode;
            rear = newnode;
        }

        public void deque() {
            if (isempty()) {
                System.out.println("The queue is empty");
                return;
            }
            int data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            System.out.println(data + " is removed from the queue");
        }
    }

    public static void main(String args[]) {
        queue q = new queue();
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.deque();
    }
}
