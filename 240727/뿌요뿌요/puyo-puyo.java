import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] table;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        table = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            for(int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        isVisited = new boolean[n][n];

        int maxBlockNum = 0, bomb = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!isVisited[i][j]) {
                    int blockNum = BFS(i, j, n);

                    if(blockNum >= 4) bomb++;
                    if(blockNum > maxBlockNum) maxBlockNum = blockNum;
                }
            }
        }

        System.out.println(bomb + " " + maxBlockNum);
    }

    static int[] y = {-1, 1, 0, 0};
    static int[] x = {0, 0, -1, 1};

    public static int BFS(int row, int col, int n) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(row, col));
        isVisited[row][col] = true;

        int blockNum = 1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int number = table[node.r][node.c];

            for(int i = 0; i < 4; i++) {
                int nextR = node.r + y[i];
                int nextC = node.c + x[i];

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;

                if(!isVisited[nextR][nextC] && table[nextR][nextC] == number) {
                    queue.add(new Node(nextR, nextC));
                    isVisited[nextR][nextC] = true;

                    blockNum++;
                }
            }
        }

        return blockNum;
    }
}