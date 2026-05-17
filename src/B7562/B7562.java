package B7562;

import java.util.*;

public class B7562 {
    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int l = sc.nextInt();
            int sr = sc.nextInt(), sco = sc.nextInt();
            int er = sc.nextInt(), ec = sc.nextInt();

            System.out.println(bfs(l, sr, sco, er, ec));
        }
    }

    static int bfs(int l, int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) return 0;

        int[][] dist = new int[l][l];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= l || nc < 0 || nc >= l) continue;
                if (dist[nr][nc] != -1) continue;

                dist[nr][nc] = dist[r][c] + 1;

                if (nr == er && nc == ec) return dist[nr][nc];

                q.offer(new int[]{nr, nc});
            }
        }

        return -1;
    }
}
