//package com.aekc.leetcode;
//
//import java.util.Stack;
//
///**
// * @author Twilight
// * @date 18-9-28 下午3:51
// */
//public class LongestValidParentheses {
//
//    public int longestValidParentheses(String s) {
//        Stack<Character> stack = new Stack<>();
//        int max = 0;
//        int sum = 0;
//        for(int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == '(') {
//                stack.push(')');
//            } else {
//                if(stack.size() > 0 && s.charAt(i) == stack.pop()) {
//                    sum++;
//                } else {
//                    if(sum > max) {
//                        max = sum;
//                    }
//                    sum = 0;
//                    stack.clear();
//                }
//            }
//        }
//        if(sum > max) {
//            max = sum;
//        }
//        return max * 2;
//    }
//
//
//    public static void main(String[] args) {
//        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
//        System.out.println(longestValidParentheses.longestValidParentheses("(()(()"));
//    }
//}