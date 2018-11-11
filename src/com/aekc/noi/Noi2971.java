package com.aekc.noi;

import java.util.LinkedList;
import java.util.Scanner;

public class Noi2971 {

    private static final int MAX = 100000;

    private static int[] coordinate = new int[MAX + 1];

    private static int k;

    public static void bfs(int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while(!queue.isEmpty()) {
            n = queue.poll();
            if(n == k) {
                break;
            }
            if(n - 1 >= 0 && coordinate[n - 1] == 0) {
                coordinate[n - 1] = coordinate[n] + 1;
                queue.offer(n - 1);
            }
            if(n + 1 <= MAX && coordinate[n + 1] == 0) {
                coordinate[n + 1] = coordinate[n] + 1;
                queue.offer(n + 1);
            }
            if(n * 2 <= MAX && coordinate[n * 2] == 0) {
                coordinate[n * 2] = coordinate[n] + 1;
                queue.offer(n * 2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        k = scanner.nextInt();
        //bfs(n);

        System.out.println(coordinate[k]);
    }
}
