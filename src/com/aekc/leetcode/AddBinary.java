package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-10-21 下午1:47
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = (a.length() > b.length() ? a.length() : b.length()) + 1;
        int[] temp = new int[index];
        int x = a.length() - 1, y = b.length() - 1;
        while(--index >= 1) {
            if(x >= 0) {
                temp[index] += (a.charAt(x--) - '0');
            }
            if(y >= 0) {
                temp[index] += (b.charAt(y--) - '0');
            }
            if(temp[index] >= 2) {
                temp[index] -= 2;
                temp[index - 1]++;
            }
            stringBuilder.append(temp[index]);
        }
        if(temp[0] != 0) {
            return String.valueOf(temp[0]) + stringBuilder.reverse().toString();
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
    }
}
