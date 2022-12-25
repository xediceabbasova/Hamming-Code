package com.mycompany.hammingcode;

import java.util.Scanner;

public class Hammingcode {

    public static void main(String[] args) {
        /*
        Qayda:m+r+1<=2^r
        m-data bit sayi
        r-parity bit sayi
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("how many bits is your data?");
        int data_count = sc.nextInt();
        int parity_count = 0;

        while (Math.pow(2, parity_count) < (data_count + parity_count + 1)) {

            parity_count++;
        }
        System.out.println("parity count:" + parity_count);

        int[] a = new int[data_count];
        System.out.println("Enter data:");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int[] common = new int[data_count + parity_count];
        int k = 0;
        int j = 0;
        for (int i = 1; i <= common.length; i++) {
            if (i == Math.pow(2, k)) {
                common[i - 1] = -1;
                k++;
            } else {
                common[k + j] = a[j++];
            }
        }
        common[0] = common[2] ^ common[4] ^ common[6] ^ common[8] ^ common[10];
        common[1] = common[2] ^ common[5] ^ common[6] ^ common[9] ^ common[10];
        common[3] = common[4] ^ common[5] ^ common[6] ^ common[11];
        common[7] = common[8] ^ common[9] ^ common[10] ^ common[11];

        for (int i = 0; i < common.length; i++) {
            System.out.print(common[i] + " ");
        }
        System.out.println();
        System.out.println("Other data:");
        int[] check = new int[parity_count + data_count];

        for (int i = 0; i < check.length; i++) {
            check[i] = sc.nextInt();
        }
        int c1 = check[0] ^ check[2] ^ check[4] ^ check[6] ^ check[8] ^ check[10];
        int c2 = check[1] ^ check[2] ^ check[5] ^ check[6] ^ check[9] ^ check[10];
        int c4 = check[3] ^ check[4] ^ check[5] ^ check[6] ^ check[11];
        int c8 = check[7] ^ check[8] ^ check[9] ^ check[10] ^ check[11];

        int ch = c1 * 1 + c2 * 2 + c4 * 4 + c8 * 8;

        if (ch == 0) {
            System.out.println("true");
            return;
        } else {
            System.out.println("false");
            System.out.println("wrong bit:" + ch);

        }

        if (check[ch - 1] == 0) {
            check[ch - 1] = 1;
        } else {
            check[ch - 1] = 0;
        }
        for (int i = 0; i < check.length; i++) {
            System.out.print(check[i] + " ");
        }
    }
}
