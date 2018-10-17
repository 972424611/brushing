package com.aekc.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Twilight
 * @date 18-10-17 下午3:17
 */
public class InsertInterval {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = intervals.get(0).start, end = intervals.get(0).end;
        List<Interval> intervalList = new ArrayList<>();
        for (Interval interval : intervals) {
            if (interval.start > end) {
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
}
