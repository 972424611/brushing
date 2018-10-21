package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Twilight
 * @date 18-10-21 下午2:45
 */
public class TextJustification {

    public String just(List<String> list , int length, int maxWidth, boolean flag) {
        int k = list.size() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        if(k == 0) {
            stringBuilder.append(list.get(0));
            for(int i = 0; i < maxWidth - length; i++) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }
        if(flag) {
            int sum = 0;
            for(int i = 0; i < list.size() - 1; i++) {
                stringBuilder.append(list.get(i)).append(" ");
                sum++;
            }
            stringBuilder.append(list.get(list.size() - 1));
            for(int i = 0; i < maxWidth - length - sum; i++) {
                stringBuilder.append(" ");
            }
            return stringBuilder.toString();
        }
        int[] nums = new int[k];
        int sum = maxWidth - length;
        int i = 0;
        while(sum > 0) {
            nums[i++]++;
            sum--;
            if(i >= k) {
                i = 0;
            }
        }
        for(i = 0; i < k; i++) {
            stringBuilder.append(list.get(i));
            for(int j = 0; j < nums[i]; j++) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.append(list.get(k)).toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int sum = 0;
        List<String> list = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(sum + words[i].length() > maxWidth) {
                list.add(just(tempList, sum - tempList.size(), maxWidth, false));
                sum = 0;
                tempList.clear();
            }
            sum += words[i].length() + 1;
            tempList.add(words[i]);
        }
        list.add(just(tempList, sum - tempList.size(), maxWidth, true));
        return list;
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        List<String> list = textJustification.fullJustify(new String[] {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16);
        list.forEach(System.out::println);
    }
}
