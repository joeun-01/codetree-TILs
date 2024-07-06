import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        int[][] table = new int[N][N];
        for(int i = 0; i < N; i++) {
            stoi = new StringTokenizer(read.readLine());
            for(int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int k = 1;

                while(k <= N) {
                    int gold = 0;
                    int cost = (k * k) + ((k + 1) * (k + 1));

                    for(int r = k; r >= 0; r--) {
                        for(int c = 0; c <= k - r; c++) {
                            if(c == 0 && r == 0) {
                                if(table[i][j] == 1) gold++;
                                continue;
                            }

                            if(c == 0) {
                                if(i - r >= 0 && table[i - r][j] == 1) {
                                    // System.out.println((i - r) + " " + j + " " + r + " " + c);
                                    gold++;
                                }
                                if(i + r < N && table[i + r][j] == 1) {
                                    // System.out.println((i + r) + " " + j + " " + r + " " + c);
                                    gold++;
                                }

                                continue;
                            }

                            if(r == 0) {
                                if(j - c >= 0 && table[i][j - c] == 1) {
                                    // System.out.println((i) + " " + (j - c) + " " + r + " " + c);
                                    gold++;
                                }
                                if(j + c < N && table[i][j + c] == 1) {
                                    // System.out.println((i) + " " + (j + c) + " " + r + " " + c);
                                    gold++;
                                }

                                continue;
                            }

                            if(j + c < N) {
                                if(i - r >= 0 && table[i - r][j + c] == 1) {
                                    // System.out.println((i - r) + " " + (j + c) + " " + r + " " + c);
                                    gold++;
                                }
                                if(i + r < N && table[i + r][j + c] == 1) {
                                    // System.out.println((i + r) + " " + (j + c) + " " + r + " " + c);
                                    gold++;
                                }
                            }
                            if(j - c >= 0) {
                                if(i - r >= 0 && table[i - r][j - c] == 1) {
                                    // System.out.println((i - r) + " " + (j - c) + " " + r + " " + c);
                                    gold++;
                                }
                                if(i + r < N && table[i + r][j - c] == 1) {
                                    // System.out.println((i + r) + " " + (j - c) + " " + r + " " + c);
                                    gold++;
                                }
                            }
                        }
                    }

                    // System.out.println();

                    if(gold * M - cost >= 0) {
                        max = Math.max(max, gold);
                    }

                    k++;
                }
            }
        }

        System.out.println(max);
    }
}