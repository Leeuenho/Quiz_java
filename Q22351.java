package beakjoon;
import java.util.Scanner;

public class Q22351 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String S;
		do{S = scan.next();
		}while((S.length()) > 889);
		
		int len = S.length();
		int [] s = new int[len];
		int i = 0;
		for( i=0; i<len; i++) {
			s[i] = Character.getNumericValue(S.charAt(i));
		}
		
		int fir = 0;
		int end = 0;
		
		if(len == 2) {
			if((s[0]+1) != s[1]) {
				fir = s[0]*10 + s[1];
				end = s[0]*10 + s[1];
			}
		}
		
		else if(len == 3) {
			if((s[0]+1) != s[1]*10 + s[2]) {
				fir = s[0]*100 + s[1]*10 + s[2];
				end = s[0]*100 + s[1]*10 + s[2];
			}
		}
		
		//100의 자리인지 확인
		else if(len>=6) {
			if(s[0]*100+s[1]*10+s[2]+1 == s[3]*100+s[4]*10+s[5]) {
				fir = s[0]*100 +s[1]*10 +s[2] ;
				end = hun(s, len-1);
			}
			else if((s[0]*10 +s[1]+1) == (s[2]*10+s[3])) {
				fir = s[0]*10 + s[1] ;
				end = ten(s, len-1, 0);
			}
			else {
				fir = s[0];
				end = one(s, len-1, 0);
			}
		}
		
		else if(len >= 4) {
			if((s[0]*10 +s[1]+1) == (s[2]*10+s[3])) {
				fir = s[0]*10 + s[1] ;
				end = ten(s, len-1, 0);
			}
			else {
				fir = s[0];
				end = one(s, len-1, 0);
			}
		}
		
		else {
			fir = s[0];
			end = one(s, len-1, 0);
		}
		
		if(fir >= 1 && fir <= 999 & end>=1 && end<=999 && fir<=end) {
			System.out.print(fir + " " + end);
		}
	}
	
	public static int one(int[] s, int len, int k) {
		int res = s[len];
		
		for(int i = k; i<len; i++) {
			if(s[i] == 9) {
				res = ten(s, len, i+1);
				break;
			}
		}
		return res;
	}
	
	public static int ten(int [] s, int len, int k) {
		int res = 0;
		res = s[len]+s[len-1]*10;
		
		for(int i = k; i<len; i+=2) {
			if((s[i]*10+s[i+1]) == 99) {
				res = hun(s, len);
				break;
			}
		}
		
		return res;
	}
	
	public static int hun(int [] s, int len) {
		int res = 0;
		res = s[len]+s[len-1]*10+s[len-2]*100;
		return res;
	}
}

