package BOJ_2589_보물섬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2589_보물섬 {
	static int W, H, max;
	static char[][] map;
	static Queue<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		for(int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j]=='L') {
					q.offer(new int[] {i, j});
					max = Math.max(max, bfs());
				}
			}
		}
		System.out.println(max);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] isVisited;
	private static int bfs() {
		int count = -1;
		isVisited = new boolean[H][W];
		int startR = q.peek()[0];
		int startC = q.peek()[1];
		isVisited[startR][startC] = true;
		
		while(!q.isEmpty()) {
			count++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int r = q.peek()[0];
				int c = q.poll()[1];
				
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc]=='W' || isVisited[nr][nc]) continue;
					isVisited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		return count;
	}
}
