package assgn2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Q5 {

	public static int editDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		//iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);

				//if last two chars equal
				if (c1 == c2) {
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}

		return dp[len1][len2];
	}

	public static void calculateAverage(int n,int len) {

		long s,e,avg=0; int k=0; 
		while(k<n) {
			String s0 = ""; String s1="";
			for(int j = 0 ; j < len ; j++)
			{
				int randomNum = ThreadLocalRandom.current().nextInt(97,122);
				s0 = s0 + (char)randomNum;
				int rN = ThreadLocalRandom.current().nextInt(97,122); s1 = s1 + (char)rN;

			}
			s=System.nanoTime();
			int dis=editDistance(s0,s1); e=System.nanoTime(); avg+=(e-s);
			k++;
		}
		System.out.println("\nThe avg time to find distance between strings of length "+len+" is "+avg/n);
	}


	public static void main(String[] args) {

		int n=100;
		calculateAverage(n,10);// call the function pass string length as 10
		calculateAverage(n,20); 
		calculateAverage(n,50);
		calculateAverage(n,100);// similarly call the function string length as 100
		System.out.println("E.O.O");
	}//main
}//class