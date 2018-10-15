package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Twilight
 * @date 18-10-15 下午7:22
 */
public class MergeIntervals {

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
        MergeIntervals mergeIntervals = new MergeIntervals();
        List<Interval> intervalList = new ArrayList<>();
        Interval interval = new MergeIntervals().new Interval(1, 4);
        intervalList.add(interval);
        interval = new MergeIntervals().new Interval(0, 0);
        intervalList.add(interval);
        intervalList = mergeIntervals.merge(intervalList);
        for(Interval interval1 : intervalList) {
            System.out.println(interval1.start + "-" + interval1.end);
        }
    }
}
