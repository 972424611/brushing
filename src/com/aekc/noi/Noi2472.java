package com.aekc.noi;

import java.util.*;

public class Noi2472 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length() + 1; j++) {
                String temp = s.substring(i, j);
                if(!map.containsKey(temp)) {
                    map.put(temp, 1);
                } else {
                    map.put(temp, map.get(temp) + 1);
                }
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

        }

    }
}
