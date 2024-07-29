import java.io.*;
import java.util.*;

public class Main {
    public static int[] y = {-1, 0, 0, 1};
    public static int[] x = {0, -1, 1, 0};

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
        // 상 좌 우 하
        for(int i = 0; i < n; i++) {
            stoi = new StringTokenizer(read.readLine());
            for(int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        stoi = new StringTokenizer(read.readLine());
        int r = Integer.parseInt(stoi.nextToken()) - 1;
        int c = Integer.parseInt(stoi.nextToken()) - 1;

        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][n];

        queue.add(new Node(r, c));
        isVisited[r][c] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.println(node.r + " " + node.c);

            int max = 0;
            Node maxNode = node;
            for(int i = 0; i < 4; i++) {
                int nextR = node.r + y[i];
                int nextC = node.c + x[i];

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;

                if(!isVisited[nextR][nextC] && table[nextR][nextC] < table[node.r][node.c]) {
                    if(table[nextR][nextC] > max) {
                        max = table[nextR][nextC];
                        maxNode.r = nextR;
                        maxNode.c = nextC;
                    }
                }
            }

            if(max == 0) {
                System.out.println(node.r + " " + node.c);
                break;
            };

            queue.add(new Node(maxNode.r, maxNode.c));
            isVisited[maxNode.r][maxNode.c] = true;

            if(k-- == 0) {
                System.out.println(node.r + " " + node.c);
                break;
            }

        }
    }
}