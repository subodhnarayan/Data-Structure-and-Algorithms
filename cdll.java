import java.util.*;
import java.util.Scanner;
class node{
    int data;
    node next;
    node previous;

    node(int data)
    {
        this.data=data;
        this.next=null;
        this.previous=null;
    }
}

class circular_double_linkedlist
{
    node head;
    node tail;
    circular_double_linkedlist()
    {
        this.head=null;
        this.tail=null;
    }
// to insert the element at the beginning of the circular linked list
    public void insert_beg(int data)
    {
        node newnode=new node(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
        }
        else{

            newnode.next=head;
            newnode.previous=tail;
            head.previous=newnode;
            tail.next=newnode;
            head=newnode;
        }
    }
    // to insert the element in the end of the circular double linked list

    public void insert_end(int data)
    {
        node newnode=new node(data);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
        }
        else
        {
            newnode.next=head;
            newnode.previous=tail;
            tail.next=newnode;
            head.previous=newnode;
            tail=tail.next;

        }
    }

    // insert the element at the middle of the circular linked list
    public void insert_middle(int data , int before_which_data)
    {
      node newnode=new node(data);
      node current=head;
      while(current.data!=before_which_data)
      {
        current=current.next;

      }
      newnode.next=current;
      newnode.previous=current.previous;
      current.previous.next=newnode;
      current.previous=newnode;
    }


    // to delete the node from the first of the circular double linked list
public void delete_first()
{
    if(head==null)
    {
        System.out.println("the list is empty");
    }
    else{
    tail.next=head.next;
    head.next.previous=tail;
    head=head.next;
    }
   
}
// to delete the node from the last in the circular linked list
public void delete_last()
{
    if(head==null)
    {
        System.out.println("the list is empty");
    }
    else
    {
        tail.previous.next=head;
        head.previous=tail.previous;
        tail=tail.previous;
    }

}
// to delete the node from the middle of the circular double linked list
/*public void delete_middle( int n)
{
    node current=head;
    for(int i=1;i<n-1;i++)
    {
        current=current.next;
    }
    current.previous.next=current.next;
    current.next.previous=current.previous;
}
*/
    // to display the elements of the circular double linked list
    public void display()
    {
        if(head==null)
        {
            System.out.println("the circular  double linked list is empty");
        }
        else
        {
            node current=head;
            while(current.next!=head)
            {
                 System.out.print(+current.data+"->");
                 current=current.next;
                
            }
            System.out.println(+current.data);
        }
    }

}
class cdll{
    public static void main(String[] args)
    {
        circular_double_linkedlist aa=new circular_double_linkedlist();
        aa.insert_beg(3);
        aa.insert_beg(5);
        aa.insert_beg(8);
        aa.insert_end(88);
        aa.insert_end(65);
        //aa.insert_middle(20,4);
        aa.insert_middle(100,5);
        aa.delete_first();
        aa.delete_last();
       // aa.delete_middle(3);
        aa.display();
        

    }
}

