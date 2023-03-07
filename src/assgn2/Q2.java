package assgn2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Q2{

	public static int n=100000;
	//this function creates n randomkeys of type long
	public static Long[] randomkeys() {
		Long[] a=new Long[n];
		for(int j=0;j<n;j++)
		{
			Long rN = ThreadLocalRandom.current().nextLong();
			a[j]=rN;
		}

		return a;
	}
	
	public static void main(String[] args) {
		long Mavg,Qavg,Havg,DPavg,RSavg,start,end=0;
		Mavg=Qavg=Havg=DPavg=RSavg=0;
		int x=100,n=100000,times=10,len;
		
		Long[]a=new Long[n];
		
		for(int i=0;i<x;i++)
		{ 
		
		a=randomkeys();
	
		start=System.nanoTime();
		Sort.mergeSort(a);			//call mergeSort methord 
		end=System.nanoTime();	
		Mavg+=(end-start);			// calculate time taken to sort keys of type long

		start=System.nanoTime();
		Sort.quicksort(a);			//calls quicksort method
		end=System.nanoTime();
		Qavg+=(end-start);			// calculate time taken to sort keys of type long
		
		//below method calls are similar to prev calculations
		start=System.nanoTime();
		Sort.heapsort(a);
		end=System.nanoTime();
		Havg+=(end-start);
		
		start=System.nanoTime();
		Arrays.sort(a);
		end=System.nanoTime();
		DPavg+=(end-start);
		}
		System.out.print("Average time taken in nanoseconds to sort the keys by: \nMergeSort= "+Mavg/x+"\nQuickSort= "+Qavg/x);
		System.out.println("\nHeapSort= "+Havg/x+"\nDPQuicksort= "+DPavg/x);
		System.out.println("\nE.O.O");
	}
}



