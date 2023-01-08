package com.gl.Paymoney.Driver;

import java.util.Scanner;

public class PaymoneyDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("enter size of transaction array");
		int size = sc.nextInt();
		System.out.println("enter the transaction list:");
		int transaction[] = new int[size];

		for (int i = 0; i < size; i++) {
			transaction[i] = sc.nextInt();
		}
		System.out.println("enter total number of targets need to be achieved + value of target");
		int target = sc.nextInt();
		int value = sc.nextInt();

		int sum = 0, j;
		if (size >= target) {
			for (j = 0; j < target; j++) {
				sum += transaction[j];
			}
			if (sum >= value) {
				System.out.print("target : " + target + " achieved after transaction" + j + " ");
				System.out.print("(");
				for (int k = 0; k < target; k++) {
					System.out.print(transaction[k] + " ");
				}
				System.out.print(")");
				System.out.println();
			} else {
				System.out.println("target not achieved");
			}
		} else {
			System.out.println("tansaction not enough");
		}

	}

}
