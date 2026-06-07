package B15657;

import java.util.*;

public class B15657 {
    static int N, M;
    static int[] nums;
    static int[] selected;
    static Set<String> resultSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        selected = new int[M];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        dfs(0, 0);

        StringBuilder sb = new StringBuilder();
        for (String s : resultSet) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                if (i > 0) sb.append(" ");
                sb.append(selected[i]);
            }
            resultSet.add(sb.toString());
            return;
        }

        for (int i = start; i < N; i++) {
            selected[depth] = nums[i];
            dfs(depth + 1, i);
        }
    }
}
