package com.gl.Transaction;

import java.util.Arrays;
import java.util.Scanner;

public class TransactionDriver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of currency denominations");
		int size = sc.nextInt();

		int currency[] = new int[size];
		System.out.println("enter the currency denominations value");
		for(int i=0 ; i < size ;i++) {		
			currency[i] =sc.nextInt();
		}

		MergeSort(currency,0,currency.length-1);
		System.out.println("sorted denomination:");
		for (int i : currency) {
			System.out.print(i+" ");
		}
		System.out.println();

		System.out.println("enter the amount you want to pay");
		int pay =sc.nextInt();

		int counter[] = new int[size];
		Arrays.fill(counter, 0);

		for(int k=size-1 ;k !=0 ;k-- ) {
//			System.out.println("currency"+pay+" : "+currency[k]);
			if(pay > 0) {
				counter[k]=pay / currency[k];
				pay = pay % currency[k];
				
//				System.out.println("debug pay"+counter[k]);
			}
		}

		for(int i=0;i< size;i++) {
			System.out.print(counter[i]+","+currency[i]);
			System.out.println();
		}
		System.out.println();
		System.out.print("paychange : " +pay);
	}

	private static void MergeSort(int[] arr, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			MergeSort(arr, left, mid);
			MergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		{
			// Find sizes of two subarrays to be merged
			int n1 = m - l + 1;
			int n2 = r - m;

			/* Create temp arrays */
			int L[] = new int[n1];
			int R[] = new int[n2];

			/* Copy data to temp arrays */
			for (int i = 0; i < n1; ++i)
				L[i] = arr[l + i];
			for (int j = 0; j < n2; ++j)
				R[j] = arr[m + 1 + j];

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0, j = 0;

			// Initial index of merged subarray array
			int k = l;
			while (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}
		}
	}

}
