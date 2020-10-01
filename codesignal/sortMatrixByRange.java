import java.util.*;

public class sortMatrixByRange{
    public static int[][] sortMatrix(int[][] board, int[][] queries) {
        int n = board.length;
        int m = board[0].length;
        
        for (int[] querie : queries) {
            int x = querie[0];
            int y = querie[1];
            int w = querie[2];
            //black
            PriorityQueue<Integer> pqEven = new PriorityQueue<>();
            //white
            PriorityQueue<Integer> pqOdd = new PriorityQueue<>();
            for (int i = x; i < x + w; i++) {
                for (int j = y; j < y + w; j++) {
                    if ( (i + j) % 2 == 0) {
                        pqEven.add(board[i][j]);
                    } else {
                        pqOdd.add(board[i][j]);
                    }
                }
            }
            
            for (int i = x; i < x + w; i++) {
                for (int j = y; j < y + w; j++) {
                    if ( (i + j) % 2 == 0) {
                        board[i][j] = pqEven.poll();
                    } else {
                        board[i][j] = pqOdd.poll();
                    }
                }
            }
        }
        return board;
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // String s = scanner.nextLine();
        int[][] board = sortMatrix(new int[][] { { 1, 4, 3, 2 }, { 8, 4, 7, 1 }, { 1, 5, 2, 1 } },
                new int[][] { { 0, 1, 3 }, {1, 0, 2} });
                                                      
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } 

}