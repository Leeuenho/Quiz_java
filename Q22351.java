package beakjoon;

import java.io.*;

public class Q22351 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String S = bf.readLine();
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		
		// 시작 숫자 = A/ 종료 숫자 = B
		
		//모든 자리 숫자가 동일한 한개의 숫자만 적혀있을 경우 검증(ex. 11/ 999)
		if(S.length()<4) {
			char n = S.charAt(0);
			for(int i=1; i<S.length(); i++) {
				if(n != S.charAt(i)) { //동일한 값이 아니라고 판별될 경우
					flag = false;
					break;
				}
			}
			if(flag == true) {
				sb.append(S + " " + S);
			}
		}

		if(S.length()>=4  || flag==false){
			for(int i = 1; i<=999; i++) {
				if(S.startsWith(Integer.toString(i))) {//A값 알아내기
					String str = S;
					for(int j = i; j<=999; j++) { // B값 알아내기
						if(str.startsWith(Integer.toString(j))) {
							//자리수만큼 str 지워나가기
							str = str.substring(Integer.toString(j).length());
						}
						else { //i와 j가 연속된 숫자가 아닐경우 i증가 후 재검증
							break;
						}
						if(str.length() == 0) { 
							sb.append(i+" "+j);
							break;
						}
					}
				}
				if(sb.length() != 0) {
					break;
				}
			}
		}
		System.out.print(sb);
	}
}

