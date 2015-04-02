import java.util.Hashtable;

public class TwoSum {

	public static void main(String args[])
	{
		int number[]={24,11,8,9};
		int index[]=new int[2];
		index=TwoSum(number,17);
		System.out.println(index[0]+" , "+index[1]);
		
	}
	public static int[] TwoSum(int[] num,int target)
	{
		int index[]=new int[2];
		Hashtable<Integer, Integer> h=new Hashtable<Integer, Integer>();
		for(int i=0;i<num.length;i++)
		{
			Integer n=h.get(num[i]);
			if(n==null) 
				h.put(num[i], i);
			n=h.get(target-num[i]);
			if(n!=null&&n<i)
			{
				index[0]=n+1;
				index[1]=i+1;
			}
			
		}
		return index;
	}
}


