package BOJ_2661_좋은수열;
import java.util.Scanner;
public class Main_BOJ_2661_좋은수열_solved_DFS {
	static int N, selected[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		selected = new int[N];
		
		dfs(0);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(selected[i]);
		}
		System.out.println(sb);
	}
	
	static boolean success;
	private static void dfs(int i) {
		if(i==N) {
			success = true;
			return;
		}
		
		for(int j = 1; j <=3; j++) {	// 1~3중에 선택
			boolean chk = true;			// 좋은 수열이면 chk == true
			selected[i] = j;			// 우선 작은 수부터 차례로 넣어서 체크해본다
			
			for(int k = 1; k <= (i+1)/2; k++) {
				for(int n = 0; n < k; n++) {
					if(selected[i-n] != selected[i-k-n]) break;
					if(n==k-1) chk = false;		// 인접한 부분수열 중 반복된 수열이 있는 경우 나쁜 수열이므로 chk = false로 바꾸어준다.
				}
			}
			
			if(chk) dfs(i+1);
			if(success) break;
		}
		
	}
}
