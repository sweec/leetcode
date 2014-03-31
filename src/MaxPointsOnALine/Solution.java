package MaxPointsOnALine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int maxPoints(Point[] points) {
    	if (points == null)
    		return 0;
    	int len = points.length;
    	if (len < 3)
    		return len;
    	ArrayList<ArrayList<Point>> lines = new ArrayList<ArrayList<Point>>();
    	ArrayList<Point> line = new ArrayList<Point>();
    	line.add(points[0]);
    	// make sure first line is defined by avoiding repeated points
    	int index = 1;
    	for (;index<len;index++)
    		if (points[index].x != points[0].x || points[index].y != points[0].y) {
    			line.add(points[index]);
    			for (int i=1;i<index;i++)
    				line.add(points[i]);
    			break;
    		}
    	if (index >= len-1)
    		return len;
    	lines.add(line);
    	int max = line.size(), maxrepeat = index;
    	HashSet<Point> inlines = new HashSet<Point>();
    	HashMap<Point, ArrayList<Point>> repeats = new HashMap<Point, ArrayList<Point>>();
    	for (int i=index+1;i<len;i++) {
    		Point p0 = points[i];
    		index = 0;
    		do {
    			line = lines.get(index);
    			int size = line.size();
    			if (size+len-i <= max)
    				lines.remove(index);
    			else {
        			Point p1 = line.get(0), p2 = line.get(1);
        			if ((p0.x-p1.x)*(p1.y-p2.y) == (p0.y-p1.y)*(p1.x-p2.x)) {
        				size++;
        				max = Math.max(max, size);
        				if (len-i+maxrepeat > max)
        					for (Point p:line)
        						inlines.add(p);
        				line.add(p0);
        			}
        			index++;
    			}
    		} while (index<lines.size());
			if (len-i+maxrepeat > max) {
				boolean isrepeat = false;
				for (int j=0;j<i;j++) {
					Point p = points[j];
					// keep a copy of all repeated points
					if (!isrepeat && p0.x == p.x && p0.y == p.y) {
						isrepeat = true;
						ArrayList<Point> repeat = repeats.get(p);
						if (repeat == null)
							repeat = new ArrayList<Point>();
						repeat.add(p0);
						repeats.put(p, repeat);
						maxrepeat = Math.max(maxrepeat, repeat.size()+1);
					}
					if (!inlines.contains(p)) {
						int size = 1;
						ArrayList<Point> repeat = repeats.get(p);
						if (repeat != null)
							size += repeat.size();
						if (len-i+size > max) {
							ArrayList<Point> newline = new ArrayList<Point>();
							newline.add(p0); newline.add(p);
							// add repeat points to the same line and avoid them later
							if (repeat != null) {
								for (Point rp:repeat) {
									newline.add(rp);
									inlines.add(rp);
								}
							}
							lines.add(newline);
						}
					}
				}
	    		inlines.clear();
			}
    	}
    	return max;
    }

    class Point {
    	int x;
    	int y;
    	Point() { x = 0; y = 0; }
    	Point(int a, int b) { x = a; y = b; }
    }
}
