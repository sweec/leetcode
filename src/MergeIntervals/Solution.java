package MergeIntervals;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null)
        	return null;
        ArrayList<Interval> mis = new ArrayList<Interval>();
        if (intervals.isEmpty())
            return mis;
        Interval iv = intervals.get(0);
        mis.add(new Interval(iv.start, iv.end));
        for (int i=1;i<intervals.size();i++) {
        	iv = intervals.get(i);
        	int start = iv.start, end = iv.end;
        	int size = mis.size();
        	Interval iv0 = mis.get(0), ivn = mis.get(size-1);
        	if (end < iv0.start) {
        		mis.add(0, new Interval(start, end));
        	} else if (end <= iv0.end) {
        		iv0.start = Math.min(start, iv0.start);
        	} else if (start > ivn.end) {
        		mis.add(new Interval(start, end));
        	} else if (start >= ivn.start) {
        		ivn.end = Math.max(end, ivn.end);
        	} else {
        		int starti = 0;
        		if (iv0.start < start)
        			starti = getLoc(mis, start, 0, size);
        		int endi = starti;
        		if (mis.get(starti).start < end)
        			endi = getLoc(mis, end, starti, size);
        		if (starti == endi) {
        			Interval before = mis.get(starti-1), after = mis.get(endi);
        			if (before.end >= start) {
        				if (end < after.start)
        					before.end = Math.max(before.end, end);
        				else {
        					before.end = after.end;
        					mis.remove(endi);
        				}
        			} else {
        				if (end == after.start)
        					after.start = start;
        				else
        					mis.add(starti, new Interval(start, end));
        			}
        		} else {
        			for (int j=endi-2;j>=starti;endi--,j--)
        				mis.remove(j);
        			size = mis.size();
        			Interval pre = mis.get(endi-1), before = null, next = null;
        			if (starti > 0)
        				before = mis.get(starti-1);
        			if (endi < size)
        				next = mis.get(endi);
        			if (before == null || before.end < start)
        				pre.start = start;
        			else {
        				pre.start = before.start;
        				mis.remove(starti-1);
        				endi--;
        			}
        			if (next == null || end < next.start)
        				pre.end = Math.max(pre.end, end);
        			else {
        				pre.end = next.end;
        				mis.remove(endi);
        			}
         		}
        	}
        }
        return mis;
    }

    private int getLoc(ArrayList<Interval> intervals, int value, int start, int end) {
     	int a = start, b = end;
    	do {
    		int m = (a+b)/2;
    		if (m == a)
    			return b;
    		Interval iv = intervals.get(m);
    		if (iv.start == value)
    			return m;
    		if (iv.start < value)
    			a = m;
    		else
    			b = m;
    	} while (true);
    }
    
    public class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }
}
