import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
class Node{
	int value;
	Node left;
	Node right;
	public Node(int value)
	{
		this.value=value;
	}
}

public class BiTree{
	public static Node Gen_Tree(int []num,int start,int end)
	{
		Node n=null;
		if(num.length!=0&&start<=end)
		{
			n=new Node(num[start]);
			n.left=Gen_Tree(num,2*start+1,end);
			n.right=Gen_Tree(num,2*start+2,end);
		}
		return n;
	}
	public static void PreScan(Node n)
	{
		if(n!=null)
		{
			System.out.print(n.value);
			PreScan(n.left);
			PreScan(n.right);
		}
	}
	public static void MidScan(Node n)
	{
		if(n!=null)
		{
			MidScan(n.left);
			System.out.print(n.value);
			MidScan(n.right);
		}
	}
	
	public static void PostScan(Node n)
	{
		if(n!=null)
		{
			PostScan(n.left);
			PostScan(n.right);
			System.out.print(n.value);
		}
	}
	public static void LevelScan(Node n,Queue<Node> q)
	{
		if(n!=null)
		{
			System.out.print(n.value);
			if(n.left!=null) q.add(n.left);
			if(n.right!=null) q.add(n.right);
		}
		if(!q.isEmpty())
			LevelScan(q.poll(),q);
		
	}
	
	public static int Height(Node n)
	{
		int h=0;
		if(n!=null)
		{
			int left=Height(n.left);
			int right=Height(n.right);
			h=(left>right)?left+1:right+1;
		}
		return h;
	}
	public static int maxWidth(Node head)
	{
		int max=0;
		Queue<Node> tmp1=new LinkedList<Node>();
		if(head!=null)
		{
			tmp1.add(head);
			while(!tmp1.isEmpty())
			{
				int count=tmp1.size();
				max=(max>count)?max:count;
				Queue<Node> tmp2=new LinkedList<Node>();
				Iterator it=tmp1.iterator();
				while(it.hasNext())
				{
					tmp2.add((Node) it.next());
				}
				tmp1.clear();
				while(!tmp2.isEmpty())
				{
					Node t=tmp2.poll();
					if(t.left!=null) tmp1.add(t.left);
					if(t.right!=null) tmp1.add(t.right);
				}
			}
			
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]={1,2,3,4,5,6,7};
		Queue<Node> q=new LinkedList<Node>();
		Node n=Gen_Tree(num,0,num.length-1);
		PreScan(n);
		System.out.println();
		System.out.println(Height(n));
		System.out.println(maxWidth(n));
		LevelScan(n,q);
	}

}
