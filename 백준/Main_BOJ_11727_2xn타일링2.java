package BOJ_11727_2xn타일링2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_11727_2xn타일링2 {
	static int n;
	static long f[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		long mod = 10007;
		
		f = new long[1001];
		f[1] = 1;
		f[2] = 3;
		for(int i = 3; i <= 1000; i++) {
			f[i] = ((f[i-1] % mod) + (2 * f[i-2] % mod)) % mod;
		}
		
		int answer = (int)f[n];
		System.out.println(answer);
	}
}
