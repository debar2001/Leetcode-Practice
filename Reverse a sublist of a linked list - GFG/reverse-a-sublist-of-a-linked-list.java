// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
		 int t=Integer.parseInt(br.readLine());
		 while(t>0)
         {
            String S[] = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);
		
		    String S1[] = br.readLine().split(" ");
			insertion llist = new insertion(); 
			int a1=Integer.parseInt(S1[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = Integer.parseInt(S1[i]);
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		Node newhead=ob.reverseBetween(llist.head, m, n);
		llist.printList(newhead);
		
        t--;		
        }
    }}// } Driver Code Ends


//User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
   public static Node reverseBetween(Node head, int m, int n)
   {
     Node temp=head;
      Node t=head;
      int c=0;
      ArrayList<Integer> arrli=new ArrayList<>();
      
      while(t!=null){
          arrli.add(t.data);
          t=t.next;
          c++;
      }
      ArrayList<Integer> arrli1= new ArrayList<>();
      for(int i=m-1;i<n;i++){
          arrli1.add(arrli.get(i));
      }
      int k=0;
      Collections.reverse(arrli1);
      for(int i=0;i<c;i++){
          if(i+1>=m && i+1<=n){
              int a=arrli1.get(k);
              k++;
              temp.data=a;
              temp=temp.next;
          }
          else{
              int b=arrli.get(i);
              temp.data=b;
              temp=temp.next;
          }
      }
      return head;
   }
}