package BOJ_1759_암호만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_1759_암호만들기 {
	static int L, C;
	static char[] alphabet, isSelected;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[C];
		isSelected = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet);
		
		comb(0, 0);
	}
	private static void comb(int cnt, int start) {
		if(cnt==L) {
			if(Validation()) {
				sb.setLength(0);
				for(int i = 0; i < L; i++) {
					sb.append(isSelected[i]);
				}
				System.out.println(sb);
			}
			return;
		}
		for(int i = start; i < C; i++) {
			isSelected[cnt] = alphabet[i];
			comb(cnt+1, i+1);
		}
	}
	private static boolean Validation() {
		int ja = 0, mo = 0;
		for(int i = 0; i < L; i++) {
			if(isSelected[i]=='a' 
				|| isSelected[i]=='e'
				|| isSelected[i]=='i'
				|| isSelected[i]=='o'
				|| isSelected[i]=='u') mo++;
			else ja++;
			if(mo >=1 && ja >=2) return true;
		}
		return false;
	}
}
