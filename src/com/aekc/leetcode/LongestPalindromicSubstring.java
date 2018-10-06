package com.aekc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Twilight
 * @date 18-9-12 下午7:18
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s.length() < 2) {
            return s;
        }
        String palindromic = "";
        int j, k;
        for(int i = 1; i < s.length(); i++) {
            if(s.length() - i <= palindromic.length() / 2) {
                break;
            }
            int sum = 1;
            for(j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--, k++) {
                if(s.charAt(j) != s.charAt(k)) {
                    break;
                }
                sum = sum + 2;
            }
            if(sum > palindromic.length()) {
                palindromic = s.substring(j + 1, k);
            }
            sum = 0;
            for(j = i - 1, k = i; j >= 0 && k < s.length(); j--, k++) {
                if(s.charAt(j) != s.charAt(k)) {
                    break;
                }
                sum = sum + 2;
            }
            if(sum > palindromic.length()) {
                palindromic = s.substring(j + 1, k);
            }
        }
        return palindromic;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        //String s = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
        String s = "bb";
        s = longestPalindromicSubstring.longestPalindrome(s);
        System.out.println(s);
    }
}
