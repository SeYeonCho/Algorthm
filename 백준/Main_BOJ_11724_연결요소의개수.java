package BOJ_11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_11724_연결요소의개수 {
	static int N, M, count;
	static Queue<Integer> q = new ArrayDeque<>();
	static ArrayList<Integer>[] adjList;
	static boolean[] isChecked;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 정점
		M = Integer.parseInt(st.nextToken());	// 간선
		
		isChecked = new boolean[N+1];	// 연결요소로써 이미 묶여있는 수는 check하여 중복되지 않도록 한다.
		adjList = new ArrayList[N+1];	// 인접리스트를 만들어 인접한 정점의 정보를 저장하기 위한 ArrayList 배열
		
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();	// ArrayList 배열의 각 요소에 ArrayList를 할당한다.
		}
		
		for(int i = 0; i < M; i++) {	// 연결된 정점을 각각의 인접정점리스트에 담아준다.
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for(int i = 1; i <= N; i++) {	// 연결요소의 개수 구하는 Logic, bfs사용
			if(!isChecked[i]) {
				q.offer(i);
				isChecked[i] = true;
				count++;
				bfs();
			}
		}
		System.out.println(count);
		
	}
	/** 연결요소의 개수 구하기
	 * - 큐에 담긴 수에 해당하는 인접정점리스트로 가서 인접한 모든 정점을 체크하고, 아직 체크되지 않은 정점이 있으면 체크하고 다시 큐에 넣는다.
	 * - 더이상 큐에 들어간 수가 없으면 종료 ( 하나의 연결요소 완성 )
	 *  */
	private static void bfs() {
		while(!q.isEmpty()) {
			int from = q.poll();
			int size = adjList[from].size();
			for(int i = 0; i < size; i++) {
				int to = adjList[from].get(i);
				if(isChecked[to]) continue;
				isChecked[to] = true;
				q.offer(to);
			}
		}
	}
}
