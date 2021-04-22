package BOJ_7562_나이트의이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7562_나이트의이동 {
	static int T, I, start[], dest[];
	static Queue<int[]> q = new ArrayDeque<>();
	static boolean[][] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			I = Integer.parseInt(br.readLine());
			isVisited = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine());
			start = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			st = new StringTokenizer(br.readLine());
			dest = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			q.clear();
			int tempR = start[0], tempC = start[1];
			q.offer(new int[] {tempR, tempC});
			isVisited[tempR][tempC] = true;
			System.out.println(bfs());
		}
	}
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};
	private static int bfs() {
		int count = -1;
		while(!q.isEmpty()) {
			count++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int r = q.peek()[0];
				int c = q.poll()[1];
				if(r==dest[0] && c==dest[1]) return count;
				for(int d = 0; d < 8; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < 0 || nc < 0 || nr >= I || nc >= I || isVisited[nr][nc]) continue;
					isVisited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		return -1;
	}
}
