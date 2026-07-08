import java.util.*;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class AddTwoNo {
    public static Node add(Node head, Node head1){
        
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;

        while(head != null || head1 != null || carry != 0){
            int sum = carry;

            if(head != null){
                sum += head.data;
                head = head.next;
            }

            if(head1 != null){
                sum += head1.data;
                head1 = head1.next;
            }

            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }

        return dummy.next;
    }
    public static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node createList (Scanner sc, int n){
        Node dummy=new Node(0);
        Node temp=dummy;
        for(int i=0; i<n; i++){
            temp.next=new Node(sc.nextInt());
            temp=temp.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n1=sc.nextInt();
        Node head=createList(sc, n1);

        int n2=sc.nextInt();
        Node head1=createList(sc, n2);

        Node result=add(head, head1);
        print(result);

        sc.close();
    }
}
