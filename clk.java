import java.util.*;
class node
{
int data;
node next;
node(int data)
{
    this.data=data;
    this.next=null;
}
}

class circular_linked_list
{
    node head;
    node tail;
    circular_linked_list()
    {
        this.head=null;
        this.tail=null;
    }
//insert the elements in the beginning of the circular linked list
    public void insert_at_beg(int data)
    {
        node newnode=new node(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
        }
        else{
            newnode.next=head;
            tail.next=newnode;
            head=newnode;
          
           
        }
    }

    public void insert_last(int data)
    {
         node newnode=new node(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
        }
        else{
            newnode.next=head;
            tail.next=newnode;
            tail=newnode;
        }
    }
    //  to insert element in the middle of the circular linked list
    public void insert_middle(int data , int before_which_data)
   {
     node newnode=new node(data);
     node current=head.next;
     node second=head;
     while(current.data!=before_which_data)
     {
        current=current.next;
        second=second.next;

     }
     newnode.next=current;
     second.next=newnode;
     second=newnode;
   }
   // to delete from the begining of the circular linked list
   public void del_beg()
   {
    if(head==null)
    {
        System.out.println("the list is empty");
    }
    else{
        head=head.next;
        tail.next=head;
    }
   }
   // to delete the last node of the circular linked list
   public void del_end()
   {
    if(head==null)
    {
        System.out.println("the list is empty");
    }
    else{
        node current=head.next;
        node second_last=head;
        while(current.next!=head)
        {
            current=current.next;
            second_last=second_last.next;
        }
        second_last.next=head;
    }

   }
   // to delete the node from the middle of the circular linked list
   public void del_middle(int which_to_delete)
   {
   node current=head;
        while(current.next.data!=which_to_delete)
        {
            current=current.next;
        }
        current.next=current.next.next;
   }
    // to display the elements of the list
    public void display()
{
    node current=tail.next;
    if(head==null)
    {
         System.out.println("the list is empty");
    }
    else{


    while(current.next!=head)
    {
        System.out.print(current.data+"->");
        current=current.next;
    }
        System.out.print(current.data + " ");   
    }
}
    

}
 class clk
{
        public static void main(String[] args)
    {
circular_linked_list aa=new circular_linked_list();
aa.insert_at_beg(56);
aa.insert_at_beg(568);
aa.insert_at_beg(66);
aa.insert_last(99);
aa.insert_last(956);
aa.insert_middle(500,56);
aa.del_beg();
aa.del_end();
aa.del_middle(500);
aa.display();
}
}
