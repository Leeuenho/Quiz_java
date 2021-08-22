package beakjoon;

import java.io.*;

public class Q22351 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String S = bf.readLine();
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		
		// ���� ���� = A/ ���� ���� = B
		
		//��� �ڸ� ���ڰ� ������ �Ѱ��� ���ڸ� �������� ��� ����(ex. 11/ 999)
		if(S.length()<4) {
			char n = S.charAt(0);
			for(int i=1; i<S.length(); i++) {
				if(n != S.charAt(i)) { //������ ���� �ƴ϶�� �Ǻ��� ���
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
				if(S.startsWith(Integer.toString(i))) {//A�� �˾Ƴ���
					String str = S;
					for(int j = i; j<=999; j++) { // B�� �˾Ƴ���
						if(str.startsWith(Integer.toString(j))) {
							//�ڸ�����ŭ str ����������
							str = str.substring(Integer.toString(j).length());
						}
						else { //i�� j�� ���ӵ� ���ڰ� �ƴҰ�� i���� �� �����
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

