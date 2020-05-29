package lotto;

import java.util.Scanner;

public class Lotto {
	
	Scanner sc = new Scanner(System.in);
	
	private int[] lottoNum;
	
	public Lotto() {
		lottoNum = new int[6];
	}
	
	public void start(){
		System.out.println("\t\t 로또 생성기");
		
		
		while(true) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("1.자동 생성 | 2.직접 생성 | 종료는 아무키나 입력해주세요.");
			System.out.println("-----------------------------------------------------------------------");
			int selectKey = 0;
				selectKey = sc.nextInt();
			
			if(selectKey == 1) {
				System.out.println("자동 생성 개수 설정: 1~5사이의 번호를 입력하시오");
				int count =  sc.nextInt();
				if(count < 1 || count > 5){
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				}else {
					for(int i = 0; i<count; i++) {
						makeAuto();
						System.out.println();
					}
				}
				
			}else if(selectKey == 2) {
				
			}else {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				break;
			}
		}
	}
	
	private void makeAuto() {
		for(int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = (int)(Math.random()*45)+1;
			
			for(int j = 0; j < i; j++) {
				if(lottoNum[i] == lottoNum[j]) {
					i--;
				}
			}
		}
		lottoNum =  sortLottoArr(lottoNum);
		System.out.println("-----------------------------");
		System.out.print(" ");
		for(int num : lottoNum) {
			System.out.print(num+" | ");
		}
		System.out.println("\n-----------------------------");
	}
	
	private int[] sortLottoArr(int[] arr) {
		for(int i = 0; i<lottoNum.length; i++) {
			for(int j = 0; j<i; j++) {
				if(lottoNum[i] < lottoNum[j]) {
					int temp = lottoNum[i];
					lottoNum[i] = lottoNum[j];
					lottoNum[j] = temp;
				}
			}
		}
		return lottoNum;
	}
}
