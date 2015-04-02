import java.util.Arrays;


public class sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={49,38,65,97,76,13,27};
		//int s[]=quick_sort(a,0,a.length-1);
		//int s[]=bubble_sort(a);
		//int s[]=insert_sort(a);
		//int s[]=select_sort(a);
		//int s[]=merge_sort(a,0,a.length-1);
		int s[]=headSort(a);
		System.out.println(Arrays.toString(s));
		
	}
	//冒泡排序
	public static int[] bubble_sort(int num[])
	{
		for(int i=0;i<num.length-1;i++)
		{
			for(int j=0;j<num.length-1;j++)
			{
				if(num[j]>num[j+1])
				{
					int tmp=num[j+1];	
					num[j+1]=num[j];
					num[j]=tmp;
				}
			}
		}
		return num;
	}
	//快速排序
	public static int[] quick_sort(int num[],int start,int end)
	{
		if(start<end)
		{
			int low=start,high=end,pivot=num[start];
			while(low<high)
			{
				while(low<high&&pivot<num[high])
					high--;
				num[low]=num[high];
				while(low<high&&num[low]<pivot)
					low++;
				num[high]=num[low];
			}
			num[low]=pivot;
			quick_sort(num,start,low-1);
			quick_sort(num,low+1,end);
		}
		return num;
	}
	//插入排序
	public static int[] insert_sort(int num[])
	{
		for(int i=1;i<num.length;i++)
		{
			if(num[i-1]>num[i])
				{
					int tmp=num[i];
					int j=i;
					while(j>0&&num[j-1]>tmp)
					{
						num[j]=num[j-1];
						j--;
					}
					num[j]=tmp;
				}
		}
		return num;
	}
	//选俄排序
	public static int[] select_sort(int num[])
	{
		if(num.length<2) return num;
		int index=0;
		for(int i=0;i<num.length;i++)
		{
			int min=num[i];
			for(int j=i;j<num.length;j++)
			{
				if(num[j]<min)
				{
					min=num[j];
					index=j;
				}
			}
			num[index]=num[i];
			num[i]=min;
		}
		return num;
	}
	public static int[] merge_sort(int num[],int left,int right)
	{
		if(left<right)
		{
			int mid=(left+right)/2;
			merge_sort(num,left,mid);
			merge_sort(num,mid+1,right);
			merge(num,left,mid,right);
		}
		return num;
	}
	public static int[] merge(int num[],int left,int mid,int right)
	{
		int[] tmp=new int[right-left+1];
		int i=left,j=mid,k=right,n=0,t=mid+1;
		while(i<=j&&t<=k)
		{
			if(num[i]<=num[t])
				tmp[n++]=num[i++];
			else 
				tmp[n++]=num[t++];
		}
		while(i<=j)
			tmp[n++]=num[i++];
		while(t<=k)
			tmp[n++]=num[t++];
		for(i=0;i<tmp.length;i++)
		{
			num[left+i]=tmp[i];
		}
		
		
		return num;
	}

		
		public static int[] headSort(int[] sortArray)
		{
			for(int i=0;i<sortArray.length-1;i++)
			{
			   buildMaxHeap(sortArray,sortArray.length-1-i);
			   swap(sortArray,0,sortArray.length-1-i);
			}
			return sortArray;
		}
		//交换两个数据的方法
		public static void swap(int[] data,int i,int j)
		{
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
		//建立大顶堆
		public static void buildMaxHeap(int[] data,int lastIndex)
		{
			//从lastIndex节点的父节点开始舰堆
			for(int i=(lastIndex-1)/2;i>=0;i--)
			{
				//保存正在判断的节点
				int k = i;
				//这里为每个节点建立大顶堆,只要这个根节点还有子节点
				while((2*k+1) <= lastIndex)
				{
					//假设左节点的值时最大的
					int biggerIndex = 2*k+1;
					//说明还有右节点是存在的
					if(biggerIndex < lastIndex)
					{
						//选出子节点中最大的值
						if(data[biggerIndex] < data[biggerIndex+1])
						{
							biggerIndex++;
						}
					}
					//将跟节点与子节点进行比较
					if(data[k] < data[biggerIndex])
					{
						swap(data,k,biggerIndex);
						k = biggerIndex;
					}else
					{
						break;
					}
				}
			}
		} 
}
