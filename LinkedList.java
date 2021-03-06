class Node{
    int data;
    Node next;
    Node(){
        data=0;
        next=null;
    }
    Node(int n, Node p){
        data=n;
        next=p;
    }
}
class LL{
    Node head;
    int getsize(){
        int count=0;
        Node curr=head;
        while(curr!=null){//we want to traverse the entire list  
            curr=curr.next;//take care of this part
            count++;
        }
        return count; 
    }
    void insertAtHead(int n){
        Node curr=head;
        Node front=new Node(n,curr);
        head=front;
    }   
    void insertAtTail(int n){
    Node curr=head;
    while(curr.next!=null){//we want to stop at the last element
        curr=curr.next;
    }
    Node last=new Node(n,null);
    curr.next=last;
}
void insertAt(int position,int n){
    if (position==1){
        this.insertAtHead(n);
    }
    else if(position==this.getsize()+1)
    {
        this.insertAtTail(n);
    }
    else{
    Node middle=new Node(n,null);
    Node p=head;
    for(int i=0;i<position-1;i++){
        p=p.next;
    }
    Node q=p.next;
    middle.next=q;
    p.next=middle;
    }
}
void delete(int position){
    position=position-1;
    if(position==0){
        head=head.next;
        }
    else if(position==this.getsize()-1){
        Node prev=head;
        while(prev.next.next!=null){
            prev=prev.next;
    }
    prev.next=null;

    }
    else{
        Node previous=head;
        Node nextnode=head.next.next;
        for(int i=0;i<position-1;i++){
            previous=previous.next;
            nextnode=nextnode.next;
        }
        previous.next=nextnode;
    }
    }
    //Reversal of linkedlist by making a new one
Node reverse(){
    LL l1=new LL();
    Node curr=this.head;
    while(curr!=null){
        l1.insertAtHead(curr.data);
        curr=curr.next;
        }
        return l1.head;
    }
    //In place reversal
void inreverse(){
    Node curr,prev,nextnode;
    curr=head;
    prev=null;
    nextnode=null;
    while(curr!=null){
        nextnode=curr.next;
        curr.next=prev;
        prev=curr;
        curr=nextnode;
    }
    head=prev;  //important step
    }
}

public class LinkedList{
    public static void main(String[] args){
        LL L1=new LL();
        System.out.println("Hello World");
        L1.insertAtHead(1);
        L1.insertAtTail(2);
        L1.insertAt(1,5);
        L1.insertAt(4,10);
        L1.insertAt(3,13);
        
        L1.insertAtTail(23);
        L1.insertAt(L1.getsize()-2, 45);
       
       

        L1.inreverse();
        
        Node cur=L1.head;
       // curr=L1.reverse();      for reversal of ll by making a copy
       
        while(cur!=null){
            System.out.println(cur.data);
            cur=cur.next;
        }
        
    }
}