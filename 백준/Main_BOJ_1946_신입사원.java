package BOJ_1946_신입사원;
// ver3에서 LinkedList를 사용하였는데, LinkedList의 특성상 get(i)를 할 때 처음 노드부터 타고들어가야한다는 약점 존재
// input의 개수가 10만개일 때 시간복잡도가 O(n)으로 보이더라도, get연산을 모두 한번씩 수행한다면 (1+n)*(n/2)의 시간복잡도를 가지게 되어 O(n^2)의 시간복잡도를 가지게 된다
// 보통 10억개의 연산을 하는데에 1초가 소요된다고 어림잡으면 10만*10만 = 100억이므로 최악의 경우 10초 이상이 소요될 수 있음
// LinkedList를 ArrayList로 바꾸어 시간복잡도를 줄였다
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1946_신입사원4 {
	static class order implements Comparable<order>{
		int order1, order2;
		
		public order(int order1, int order2) {
			super();
			this.order1 = order1;
			this.order2 = order2;
		}

		@Override
		public int compareTo(order o) {
			return (this.order1 - o.order1) * (-1);	// 내림차순 정렬
		}
		
	}
	static int T, N;
	static int order[];
	static StringTokenizer st;
	static List<order> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int tc = 1; tc <= T; tc++) {
			list.clear();
			
			N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {	// 리스트에 석차 정보 담아줌
				st = new StringTokenizer(br.readLine());
				list.add(new order(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(list); // 1차 서류심사(석차1)에 대한 내림차순으로 정렬
			
			int min = list.get(list.size()-1).order2;
			int cnt = 1;	// 최초 1명은 비교없이 시작(석차1에대해 1등이기때문)
			for(int i = list.size()-1; i >= 0; i--) {
				if(min > list.get(i).order2) {
					cnt++;
					min = list.get(i).order2;
				}
			}
			
			System.out.println(cnt);
			
		}
	}
}
