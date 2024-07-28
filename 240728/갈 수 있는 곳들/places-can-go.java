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
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int n = Integer.parseInt(stoi.nextToken());
        int k = Integer.parseInt(stoi.nextToken());

        int[][] table = new int[n][n];
        for(int i = 0; i < n; i++) {
            stoi = new StringTokenizer(read.readLine());
            for(int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        boolean[][] isVisited = new boolean[n][n];

        int visitCntSum = 0;
        for(int i = 0; i < k; i++) {
            stoi = new StringTokenizer(read.readLine());
            int r = Integer.parseInt(stoi.nextToken()) - 1;
            int c = Integer.parseInt(stoi.nextToken()) - 1;

            if(!isVisited[r][c]) {
                int visitCnt = BFS(r, c, table, isVisited, n);
                visitCntSum += visitCnt;
            }
        }

        System.out.println(visitCntSum);
    }

    public static int[] y = {-1, 1, 0, 0};
    public static int[] x = {0, 0, -1, 1};

    public static int BFS(int r, int c, int[][] table, boolean[][] isVisited, int n) {
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(r, c));
        isVisited[r][c] = true;

        int visitCnt = 1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nextR = node.r + y[i];
                int nextC = node.c + x[i];

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;

                if(!isVisited[nextR][nextC] && table[nextR][nextC] == 0) {
                    queue.add(new Node(nextR, nextC));
                    isVisited[nextR][nextC] = true;

                    visitCnt++;
                }
            }
        }

        return visitCnt;
    }
}