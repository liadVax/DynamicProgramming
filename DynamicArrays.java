package dynamic;

import java.util.Arrays;

public class DynamicArrays {

//return the largest sum in array
//rules:
//sum=even+odd GOOD , sum=odd+odd GOOD  , sum=even+even BAD 	
//A=[1,2,9,4,5,0,4,10,4]
//return 31 (1+2+9+4+5+0+10)
//time complexity O(n) 	
	static int theLargestSum(int[] arr) {
		int[] b=new int[arr.length];
		b[0]=arr[0];
		if(bothEven(arr[0],arr[1])) {
			b[1]=Integer.max(arr[1],arr[0]);
		}
		else
			b[1]=Integer.max(b[0],b[0]+arr[1]);
		
		for(int i=2;i<arr.length;i++) {
			if(bothEven(arr[i], arr[i-1])) {
				b[i]=Integer.max(b[i-1], b[i-2]+arr[i]);
			}
			else
				b[i]=Integer.max(arr[i], b[i-1]+arr[i]);
		}
		System.out.println("B="+Arrays.toString(b));
		return b[b.length-1];
		}
	
	static boolean bothEven(int x,int y) {
		if(x%2==0 && y%2==0)
			return true;
		return false;
	}
	
//return the length of the longest ascending series in the array
//numbers are not required to be next to each other
//A=[1,2,3,-10,7,8,9,2]
//return 6 (1,2,3,7,8,9)
//time complexity O(n^2)
	static int longestSeries(int[] arr) {
		int b[]=new int[arr.length];
		b[0]=1;
		for(int i=1;i<arr.length;i++) {
			int max=0;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]&&b[j]>max)
					max=b[j];
			}
			b[i]=max+1;
		}
		int maxlen=0;
		for(int i=0;i<b.length;i++) {
			if(b[i]>maxlen)
				maxlen=b[i];
		}
		System.out.println("B="+Arrays.toString(b));
		return maxlen;
	}
	
	
	public static void main(String[] args) {
		System.out.println(theLargestSum(new int[] {1,2,9,4,5,0,4,10,4}));
		System.out.println(longestSeries(new int[] {1,2,3,-10,7,8,9,2}));
	}
	
	
}
