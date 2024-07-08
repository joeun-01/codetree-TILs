import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());

        K = Integer.parseInt(stoi.nextToken());
        N = Integer.parseInt(stoi.nextToken());

        select(0);
    }

    public static void select(int idx) {
        if(idx == N) {
            print();
            return;
        }

        for(int i = 1; i <= K; i++) {
            answer.add(i);
            select(idx + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void print() {
        for(int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

        System.out.println();
    }
}