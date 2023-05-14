import java.util.*;
import java.lang.*;
 class node
    {
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
 class doublell
{
    node head;
    node tail;

    public doublell(){
        this.head = null;
        this.tail = null;
    }
       
    //insert in the beginning
    public void insert_beginning(int data)
    {
        node newnode=new node(data);
       if(head==null)
       {
        head=newnode;
        tail = newnode;
       }
       else
       {
        newnode.next=head;
        head.previous=newnode;
        head=newnode;
       }
    }
//insert in the last
    public void insert_end(int data)
    {
        node newnode = new node(data);
       
        if(head==null)
        {
            head=newnode;
            tail=newnode;

        }
        else{
            newnode.previous=tail;
            tail.next=newnode;
            tail=newnode;
        }
    }
    // insert in the middle
    public void insert_middle(int data, int where_to_insert)
    {
        node newnode=new node(data);
        node current=head.next;
        node second=head;
        while(current.data!=where_to_insert)
        {
            current=current.next;
            second=second.next;
        }
        newnode.next=current;
        newnode.previous=second;
        current.previous=newnode;
        second.next=newnode;
        second=second.next;
        

    }
//delete from the first
public void delete_beg()
{
    if(head==null)
    {
        System.out.println("the list is empty");
    }
    else 
    {
        head=head.next;
        head.previous=null;
    }
}

//delete the elements from the last
public void del_last()
{
    if(head==null)
    {
        System.out.println("the list is empty");
    }
    else{
        tail=tail.previous;
        tail.next=null;
    }

}
//delete from the middle
public void del_middle(int which_data)
{
    node current=head;
        while(current.data!=which_data)
        {
            current=current.next;

        }
        current.previous.next=current.next;
        current.next.previous=current.previous;
}
    
    public void display()
    {
        node current=head;
        while(current!=null)
        {
            System.out.print(current.data + "->");
            current=current.next;
        }
    }
    // to find the max element in a linked list;
   public void max_ele()
    {
       
        int max=Integer.MIN_VALUE;
        node current=head;
       System.out.println("  ");
        while(current!=null)
        {
            if(max<=current.data)
            {
                max=current.data;
            }
             current=current.next;
            
        }
         System.out.println("the maximum element of the linked list is"+max);
    } 
    // to find the minimum element of a linked list
     public void min_ele()
    {
       
        int min=Integer.MAX_VALUE;
        node current=head;
       System.out.println("  ");
        while(current!=null)
        {
            if(min>=current.data)
            {
                min=current.data;
            }
             current=current.next;
            
        }
         System.out.println("the smallest element of the linked list is"+min);
    } 

// to sort the linked list in ascending order
public void sorting()
{
   
    
    if(head==null)
    {
        return ;
    }
    else
    { 
      
        node current=head;
    
    while(current!=null)
    {
       node present=current.next;
        while(present!=null)
        {
            if(current.data>present.data)
            {
               int  temp=current.data;
                current.data=present.data;
                present.data=temp;
            }
            present=present.next;
        }
        current=current.next;
    }
    }
}
//to reverse the element of the linked list
public void reverse()
{
    node previous=null;
    node current=head;
    node nextnode=head;
    while(nextnode!=null)
    {
        nextnode=nextnode.next;
        current.next=previous;
        previous=current;
        current=nextnode;

    }
    head=previous;

}
//to remove the dublicate elements of the linked list

public void find_dublicate()
{
    System.out.println("the dublicate elements are");
    node current=head;
    if(head==null)
    {
        System.out.println("no dublicate element");
    }
    else
    {
    while(current!=null)
    {
        node present=current.next;
        while(present!=null)
        {
            if(current.data==present.data)
            {
                System.out.println(+current.data);
                break;
            }
            present=present.next;
        }
        current=current.next;
    }
    }
}
// to remove the element from the sorted list

// to delete the dublicate elements of the list
//  public void delete_dublicate()
//     {

        
//        // int count=0;
//         node current=head;
        
//         while(current!=null)
//         {
//             node last_present=current;
//             node present=current.next;
//             while(present!=null)
//             {
//                 // System.out.println("the");
//                 if(current.data==present.data)
//                 {

                   
//                   //  System.out.println("the");
//                    // count++;
//                     last_present.next=present.next;
//                  //present=present.next;


//                 }
//                 present=present.next;
//                 last_present=last_present.next;
//             }
            
           
//             current=current.next;
            
//         }
    

//     }

}


public class dll {
         public static void main(String[] args)
    {
        doublell aa=new doublell();
        aa.insert_beginning(20);
        aa.insert_beginning(10);
        aa.insert_beginning(780);
        aa.insert_beginning(70);
        aa.insert_beginning(500);
        aa.insert_beginning(234);
         aa.insert_middle(10,70);
          aa.insert_middle(67,10);
         aa.insert_beginning(10); 
        aa.insert_beginning(100);
        aa.insert_end(5000);
        aa.insert_middle(6789,780);
        aa.delete_beg();
        aa.del_last();
        aa.del_middle(6789);
        aa.display();
        //aa.find_dublicate();
       aa.max_ele();
        aa.min_ele();
        System.out.println("the linked list after sorting is:");
        aa.sorting();
        aa.display();
        aa.reverse();
        System.out.println(" the reverse of the linked list is ");
        aa.display();
       aa.find_dublicate();
      // aa.delete_dublicate();
       aa.display();
        
    }
}