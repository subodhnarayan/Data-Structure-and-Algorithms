import java.util.*;

class single {
    node head = null;
    node tail = null;
    node first = null;
    int size = 0;

    class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void creation() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter how many data you want to insert in the linkedlist");
        n = sc.nextInt();
        System.out.println("Enter the data");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            node newnode = new node(data);
            if (head == null) {
                head = tail = newnode;
            } else {
                tail.next = newnode;
                tail = newnode;
            }
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("No linklist exist");
        } else {
            node curr = head;
            while (curr != null) {
                System.out.println(curr.data);
                curr = curr.next;
            }
        }
    }

    public void addfirst(int data) {
        node newnode = new node(data);
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }

    }

    public void addbefore(int index, int data) {
        node newnode = new node(data);
        if (head == null) {
            head = tail = newnode;
        } else if (index <= 2) {
            addfirst(data);
        } else {
            node curr = head;
            for (int i = 1; i < index - 2; i++) {
                curr = curr.next;
            }
            node nex = curr.next;
            curr.next = newnode;
            newnode.next = nex;
        }
    }

    public void addafter(int index, int data) {
        node newnode = new node(data);
        if (head == null) {
            head = tail = newnode;
        } else if (index == 1) {
            node nex = head.next;
            head.next = newnode;
            newnode.next = nex;

        } else {
            node curr = head;
            for (int i = 1; i < index; i++) {
                curr = curr.next;
            }
            node nex = curr.next;
            curr.next = newnode;
            newnode.next = nex;
        }

    }

    public void addlast(int data) {
        node newnode = new node(data);
        if (head == null) {
            head = tail = newnode;
        } else {
            node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newnode;
        }
    }

    public void addatindex(int index, int data) {
        node newnode = new node(data);
        if (head == null) {
            head = tail = newnode;
        } else if (index == 1) {
            addfirst(data);
        } else {
            node curr = head;
            for (int i = 1; i < index - 1; i++) {
                curr = curr.next;
            }
            node nex = curr.next;
            curr.next = newnode;
            newnode.next = nex;
        }
    }

    public void deleteatindex(int index) {
        if (head == null) {
            System.out.println("No link list exist");
        } else if (index <= 0 || index >= size) {
            System.out.println("Invalid index");
        } else if (index == 1) {
            deletefirst();
        } else {
            node curr = head;
            for (int i = 1; i < index - 1; i++) {
                curr = curr.next;
            }
            node nex = curr.next;
            System.out.println(curr.next.data + "is deleted");
            curr.next = nex.next;
            size--;
        }
    }

    public void deletefirst() {
        if (head == null) {
            System.out.println("No linklist exist");
        } else if (head.next == null) {
            System.out.println(head.data + " is deleted");
            head = tail = null;
            size--;
        } else {
            System.out.println(head.data + " is deleted");
            head = head.next;
            size--;
        }
    }

    public void deletelast() {
        if (head == null) {
            System.out.println("No linklist exist");
        } else if (head.next == null) {
            System.out.println(head.data + " is deleted");
            head = tail = null;
            size--;
        } else {
            node curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            System.out.println(curr.next.data + " is deleted");
            curr.next = null;
            size--;
        }
    }

    public void updateatindex(int index, int data) {
        if (head == null) {
            System.out.println("No linkedlist exist");
        } else if (index <= 0) {
            System.out.println("invalid index");
        } else {
            node curr = head;
            for (int i = 1; i < index; i++) {
                curr = curr.next;
            }
            curr.data = data;
        }
    }

    public void getsize() {
        System.out.println("The size is " + size);
    }

    public void bubblesortascending() {
        if (head == null) {
            return;
        }
        node curr = head;
        while (curr != null) {
            node index = curr.next;
            while (index != null) {
                if (curr.data > index.data) {
                    int temp = curr.data;
                    curr.data = index.data;
                    index.data = temp;
                }
                index = index.next;

            }
            curr = curr.next;
        }
    }

    public void bubblesortdecending() {
        if (head == null) {
            System.out.println("The linklist doesnot exist");
            return;
        }

        node curr = head;
        while (curr != null) {
            node boy = curr.next;
            while (boy != null) {
                if (curr.data < boy.data) {
                    int temp = curr.data;
                    curr.data = boy.data;
                    boy.data = temp;

                }
                boy = boy.next;
            }
            curr = curr.next;
        }
    }

    public void insertionsort() {
        // if (head == null) {
        // return;
        // }
        // node curr = head;
        // while (curr != null) {
        // node index = curr.next;
        // while (index != null) {
        // if (curr.data > index.data) {
        // int temp = curr.data;
        // index.data = curr.data;
        // curr.data = temp;
        // }
        // index = index.next;

        // }
        // curr = curr.next;
        // }

    }

    public void reverse() {

        node prev = null;
        node curr = head;
        node nex = head;
        while (nex != null) {
            nex = nex.next;
            curr.next = prev;
            prev = curr;
            curr = nex;

        }
        head = prev;
    }

    public void concatenate(single s, single t) {
        node curr = s.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = t.head;
    }

    public static void printalternatenode(node s) {
        if (s == null) {
            return;
        }
        node curr = s;
        int i = 0;
        while (curr != null) {
            if (i % 2 == 0) {
                System.out.println(curr.data);

            }
            i++;
            curr = curr.next;
        }
    }

    // public static void storealternatenode(node s, node t) {
    // if (s == null) {
    // return;
    // }
    // node curr = s;
    // int i = 0;
    // while (curr != null) {
    // if (i % 2 == 0) {
    // // System.out.println(curr.data);
    // if (t == null) {
    // t = curr;
    // } else {
    // node test = t;
    // while (test.next != null) {
    // test = test.next;
    // }
    // test.next = curr;
    // }

    // }
    // i++;
    // curr = curr.next;
    // }
    // }

    public single skipalternatestorereaming() {
        single result = new single();
        if (head == null && head.next == null) {
            return result;
        }
        node curr = head;
        while (curr != null && curr.next != null) {
            result.addlast(curr.data);
            curr = curr.next.next;
        }
        if (curr != null) {
            result.addlast(curr.data);
        }
        return result;

    }

    public static void print(node head) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public single[] split(int count) {
        single firstlist = new single();
        single secondlist = new single();

        if (head == null) {
            return new single[] { firstlist, secondlist };
        }
        int cou = 0;
        node curr = head;
        while (curr != null && cou < count) {
            firstlist.addlast(curr.data);
            curr = curr.next;
            cou++;
        }
        while (curr != null) {
            secondlist.addlast(curr.data);
            curr = curr.next;
        }
        return new single[] { firstlist, secondlist };
    }

    public single[] splitwithoutcount() {
        single firstlist = new single();
        single secondlist = new single();

        if (head == null) {
            return new single[] { firstlist, secondlist };
        }

        node prev = null;
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        if (prev != null) {
            prev.next = null;
        } else {
            firstlist.head = head;
        }

        firstlist.head = head;
        secondlist.head = slow;
        return new single[] { firstlist, secondlist };
    }

    public void removeduplicate() {
        if (head == null) {
            return;
        }
        node curr = head;
        while (curr != null) {
            node check = curr;
            while (check.next != null) {
                if (curr.data == check.next.data) {
                    check.next = check.next.next;
                } else {
                    check = check.next;
                }
            }
            curr = curr.next;
        }
    }

    public void largestelement() {
        if (head == null) {
            System.out.println("The linklist doesnot exist");
            return;
        }
        node curr = head.next;
        int max = head.data;
        while (curr != null) {
            if (curr.data > max) {
                max = curr.data;
            }
            curr = curr.next;
        }
        System.out.println("The largest element in the linkedlist is " + max);

    }



    public static void main(String args[]) {
        // System.out.println("Hi this is subodh narayan sah");
        single s = new single();
        s.creation();
        // System.out.println("The element in the linkedlist is");
        // s.display();
        single p = new single();
        // t.creation();
        // System.out.println("The element in the linkedlist is");
        // t.display();
        // s.addfirst(6);
        // s.addfirst(5);
        // s.addfirst(4);
        // s.addfirst(2);
        // s.addfirst(1);
        // System.out.println("The element in the linkedlist is");
        // s.display();
        // s.addbefore(2, 3);
        // s.addlast(7);
        // s.addafter(1, 9);
        // System.out.println("The element in the linkedlist is");
        // s.display();
        // System.out.println("The insetion of element at index in the linkedlist is");
        // s.addatindex(3, 27);
        // s.display();
        // System.out.println("The deletion of element at index in the linkedlist is");
        // s.deleteatindex(1);
        // s.display();
        // System.out.println("The deletion of element at first and last in the
        // linkedlist is");
        // s.deletefirst();
        // s.deletelast();
        // s.display();
        // System.out.println("The upadation of element at index in the linkedlist is");
        // s.updateatindex(3, 0);
        // s.display();
        // s.getsize();
        // System.out.println("The sorting of element by bubble sort in the linkedlist
        // is");
        // s.bubblesortdecending();
        // s.display();
        // System.out.println("The linkedlist after reverse");
        // s.reverse();
        // s.display();
        // single con = new single();
        // s.concatenate(s, t);
        // System.out.println("Print alternate");
        // printalternatenode(s.head);
        // System.out.println("skip alternate and store remaining in new liked list");
        // single result = s.skipalternatestorereaming();
        // result.display();
        // single[] splitlist = s.split(3);
        // single firstlist = splitlist[0];
        // single secondlist = splitlist[1];

        // System.out.println("First list: count =3");
        // firstlist.display();

        // System.out.println("Secong list");
        // secondlist.display();

        // System.out.println("split linkedlist wihtout count");
        // single[] result2 = s.splitwithoutcount();
        // single firstlist1 = result2[0];
        // single secondlist1 = result2[1];
        // System.out.println("First list");
        // firstlist1.display();
        // System.out.println("Second list");
        // secondlist1.display();
        System.out.println("Entered data");
        s.display();
        s.removeduplicate();
        System.out.println("The linklist element without duplicates");
        s.display();
        s.largestelement();

    }
}