package NumIslands;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int num = 0;
        // method 1, recursive search for island, 295ms
        /*
        boolean[][] done = new boolean[row][col];
        for (int x=0;x<row;x++)
        for (int y=0;y<col;y++) {
            if (!done[x][y] && grid[x][y] == '1') {
                num++;
                searchIsland(grid, done, x, y);
            }
        }
        */
        
        // method 2, record and merge island, 314ms with ArrayList, 270ms with HashSet
        int[][] ids = new int[row][col];
        //ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        int id = 0;
        for (int x=0;x<row;x++)
        for (int y=0;y<col;y++) {
            if (grid[x][y] == '1') {
                if ((x == 0 || grid[x-1][y] != '1') && (y == 0 || grid[x][y-1] != '1')) {
                    num++;
                    ids[x][y] = id;
                    //list.add(new ArrayList<Integer>());
                    list.add(new HashSet<Integer>());
                    id++;
                } else if (x>0 && grid[x-1][y] == '1' && y>0 && grid[x][y-1] == '1') {
                    int id1 = ids[x-1][y], id2 = ids[x][y-1];
                    ids[x][y] = id1;
                    if (id1 != id2 && !list.get(id1).contains(id2)) {
                        num--;
                        //ArrayList<Integer> l1 = list.get(id1), l2 = list.get(id2);
                        HashSet<Integer> l1 = list.get(id1), l2 = list.get(id2);
                        ArrayList<Integer> l1copy = new ArrayList<Integer>(l1);
                        ArrayList<Integer> l2copy = new ArrayList<Integer>(l2);
                        for (int i:l1copy) {
                            list.get(i).add(id2);
                            l2.add(i);
                        }
                        for (int i:l2copy) {
                            list.get(i).add(id1);
                            l1.add(i);
                        }
                        l1.add(id2);     
                        l2.add(id1);  
                    }
                } else if (x>0 && grid[x-1][y] == '1') {
                    ids[x][y] = ids[x-1][y];
                } else if (y>0 && grid[x][y-1] == '1') {
                    ids[x][y] = ids[x][y-1];
                }
            }
        }
        return num;
    }
    // method 1 function
    /*
    public void searchIsland(char[][] grid, boolean[][] done, int x, int y) {
        done[x][y] = true;
        int row = grid.length, col = grid[0].length;
        if (x>0 && !done[x-1][y] && grid[x-1][y] == '1')
            searchIsland(grid, done, x-1, y);
        if (x<row-1 && !done[x+1][y] && grid[x+1][y] == '1')
            searchIsland(grid, done, x+1, y);
        if (y>0 && !done[x][y-1] && grid[x][y-1] == '1')
            searchIsland(grid, done, x, y-1);
        if (y<col-1 && !done[x][y+1] && grid[x][y+1] == '1')
            searchIsland(grid, done, x, y+1);
    }
    */
}