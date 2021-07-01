package helloWorld;

import java.util.Scanner;

public class PrintClass {
	public int inputPrice = 0;
	public Scanner scan = new Scanner(System.in);
	//총 금액 출력 및 
	//	지불한 금액입력
	public void inputPrice() {
		System.out.print("지불한 금액??");
		inputPrice = scan.nextInt();
		System.out.println("\n===========================================");
	}
	
	public void printTotalPrice(int totalPrice) {
		System.out.println("===========================================");
		System.out.printf("총 금액은 %d 원입니다.\n",totalPrice);
	}
	
	public void justPrint() {
		System.out.printf("%20s\n","[영수증]");
		System.out.println();
		System.out.printf("%s\n","[매장명] 해리스커피파크(신논현본점)");
		System.out.printf("%s\n","[사업자] 787-85-00443");
		System.out.printf("%s\n","[주 소] 서울 강남구 봉은사로4길 1,1층(역삼동)");
		System.out.printf("%s\n","[대표자] 최현숙  [TEL] 02-512-0542");
		System.out.print("[매출일] 2016-12-03 16:12:06");
		System.out.printf("\t%s\n","01-관리자");
		System.out.printf("%s\n","[영수증] 20161203-01-0080");
		System.out.println();
		System.out.println("=======================================");
		System.out.println();
		System.out.printf("%7s \t %s\t %s\t %s\t\n","상 품 명", "단가", "수량", "금액");
		System.out.println("---------------------------------------");
	}
	
	public void finalPrice(int totalPrice) {
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t %d\n","합 계 금 액",totalPrice);
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t\t %d\n","받은 금액",inputPrice);
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t\t %d\n","거스름 금액",inputPrice-totalPrice);
	}
}
