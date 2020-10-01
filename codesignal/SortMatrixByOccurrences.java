package Robinhood;

import java.util.*;

public class SortMatrixByOccurrences {
    public int[][] sortMatrixByOccurrences(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return new int[0][0];
        }
        int n = m.length;
        // 1. use hashmap to count frequent
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] ints : m) {
            for (int j = 0; j < n; j++) {
                int curFreq = freq.getOrDefault(ints[j], 0) + 1;
                freq.put(ints[j], curFreq);
            }
        }
        // 2. use pq to sort
        PriorityQueue<Cell> pq = new PriorityQueue<>(new myComparator());
        // put all freq into Cells
        for(Integer i : freq.keySet()) {
            pq.offer(new Cell(i, freq.get(i)));
        }
        // 3. put it into a array
        int[] sort = new int[n * n];
        int index = 0;
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            int key = cur.key;
            int count = cur.freq;
            while (count-- > 0) {
                sort[index++] = key;
            }
        }
        // 4. put it back to the matrix diagonally
        index = 0;
        for (int j = n - 1; j >= 0; j--) {
            int k = j;
            int i = n - 1;
            while (k < n && i >= 0) {
                m[i][k] = sort[index++];
                k++;
                i--;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            int k = i;
            int j = 0;
            while (j < n && k >= 0) {
                m[k][j] = sort[index++];
                k--;
                j++;
            }
        }
        return m;

    }

    static class myComparator implements Comparator<Cell>{
        @Override
        public int compare(Cell o1, Cell o2) {
            if (o1.freq == o2.freq) {
                return o1.key < o2.key ? -1 : 1;
            }
            return o1.freq < o2.freq ? -1 : 1;
        }
    }

    static class Cell{
        int key;
        int freq;
        public Cell(int key, int freq){
            this.key = key;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{3,3,4},{3,4,1},{1,-2,-2}};
        System.out.println(Arrays.deepToString(new SortMatrixByOccurrences().sortMatrixByOccurrences(m)));
    }
}
