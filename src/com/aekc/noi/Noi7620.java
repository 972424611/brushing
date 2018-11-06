package com.aekc.noi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Noi7620 {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 1) {
            return new ArrayList<>();
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = intervals.get(0).start, end = intervals.get(0).end;
        List<Interval> intervalList = new ArrayList<>();
        for(Interval interval : intervals) {
            if(interval.start > end) {
                intervalList.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
                continue;
            }
            start = interval.start < start ? interval.start : start;
            end = interval.end > end ? interval.end : end;
        }
        intervalList.add(new Interval(start, end));
        return intervalList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Noi7620 noi7620 = new Noi7620();
        List<Interval> intervalList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            intervalList.add(noi7620.new Interval(x, y));
        }
        intervalList = noi7620.merge(intervalList);
        if(intervalList.size() > 1) {
            System.out.println("no");
            return;
        }
        System.out.println(intervalList.get(0).start + " " + intervalList.get(0).end);
    }
}
