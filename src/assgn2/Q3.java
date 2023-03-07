package assgn2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Q3 {
	public static int n=100000;
	
	//this method creates n randomstrings of length len 
	public static String[] randomStrings(int n,int len) {

		String[] s1 = new String[n];
		int k=0;
		while(k<n) {
			String s = "";
			for(int j = 0 ; j < len ; j++) 
			{
				int randomNum = ThreadLocalRandom.current().nextInt(97,122);
				s = s + (char)randomNum;
			}
			s1[k] = s;
			k++;
		}
		return s1;
	}

	public static void main(String[] args) {
		long Mavg,Qavg,Havg,DPavg,RSavg,start,end=0;
		Mavg=Qavg=Havg=DPavg=RSavg=0;
		int x=100,n=100000,times=10,len;
		for(len=4;len<=10;len=len+2)
		{
			Mavg=Qavg=Havg=DPavg=RSavg=0;	
			for (int k=0;k<times;k++)
			{
				String[] str=randomStrings(n, len);
				//below method calls are similar to prev calculations
				start=System.nanoTime();
				Sort.mergeSort(str);
				end=System.nanoTime();
				Mavg+=(end-start);

				start=System.nanoTime();
				Sort.quicksort(str);
				end=System.nanoTime();
				Qavg+=(end-start);

				start=System.nanoTime();
				Sort.heapsort(str);
				end=System.nanoTime();
				Havg+=(end-start);

				start=System.nanoTime();
				Arrays.sort(str);
				end=System.nanoTime();
				DPavg+=(end-start);

				start = System.nanoTime( );
				RadixSort.radixSortA( str, len );
				end = System.nanoTime( );
				RSavg+=(end-start);
			}

			System.out.print("\nAverage time taken in nanoseconds to sort the Strings of length "+len+" \nMergeSort= "+Mavg/times);
			System.out.println("\nQuickSort= "+Qavg/times+"\nHeapSort= "+Havg/times+"\nDPQuicksort= "+DPavg/times+"\nRedixsort= "+RSavg/times);

		}
		System.out.println("\nE.O.O");
	}
}
