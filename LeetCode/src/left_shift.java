
public class left_shift {
	public static void main(String[] args)
	{
		String a="abcdef";
		System.out.println(lefShift(3,a));
		
	}
	public static String lefShift(int num,String s)
	{
		StringBuffer sb=new StringBuffer();
		char[]c=s.toCharArray();
		sb.append(c, num,c.length-num);
		sb.append(c,0,num);
		return sb.toString();
	}
}
