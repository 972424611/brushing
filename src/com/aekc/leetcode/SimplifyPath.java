package com.aekc.leetcode;

import java.util.Stack;

/**
 * @author Twilight
 * @date 18-10-22 下午7:23
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        path = path + "/";
        Stack<String> stack = new Stack<>();
        int k = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < path.length(); i++) {
            char indexChar = path.charAt(i);
            if(indexChar == '.') {
                k++;
                stringBuilder.append('.');
            } else if(indexChar == '/') {
                if(k == 2 && !stack.empty()) {
                    stack.pop();
                } else if(k >= 3) {
                    stack.push(stringBuilder.toString());
                }
                if(stringBuilder.length() != 0 && k <= 0) {
                    stack.push(stringBuilder.toString());
                }
                if(stringBuilder.length() > 0) {
                    stringBuilder = new StringBuilder();
                }
                k = 0;
            } else {
                k--;
                stringBuilder.append(indexChar);
            }
        }
        stringBuilder = new StringBuilder();
        while(!stack.empty()) {
            stringBuilder.insert(0, "/" + stack.pop());
        }
        if(stringBuilder.length() == 0) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/..hidden"));
    }
}
