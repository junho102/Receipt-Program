package helloWorld;

import java.util.Scanner;

public class PrintClass {
	public int inputPrice = 0;
	public Scanner scan = new Scanner(System.in);
	//�� �ݾ� ��� �� 
	//	������ �ݾ��Է�
	public void inputPrice() {
		System.out.print("������ �ݾ�??");
		inputPrice = scan.nextInt();
		System.out.println("\n===========================================");
	}
	
	public void printTotalPrice(int totalPrice) {
		System.out.println("===========================================");
		System.out.printf("�� �ݾ��� %d ���Դϴ�.\n",totalPrice);
	}
	
	public void justPrint() {
		System.out.printf("%20s\n","[������]");
		System.out.println();
		System.out.printf("%s\n","[�����] �ظ���Ŀ����ũ(�ų�������)");
		System.out.printf("%s\n","[�����] 787-85-00443");
		System.out.printf("%s\n","[�� ��] ���� ������ �������4�� 1,1��(���ﵿ)");
		System.out.printf("%s\n","[��ǥ��] ������  [TEL] 02-512-0542");
		System.out.print("[������] 2016-12-03 16:12:06");
		System.out.printf("\t%s\n","01-������");
		System.out.printf("%s\n","[������] 20161203-01-0080");
		System.out.println();
		System.out.println("=======================================");
		System.out.println();
		System.out.printf("%7s \t %s\t %s\t %s\t\n","�� ǰ ��", "�ܰ�", "����", "�ݾ�");
		System.out.println("---------------------------------------");
	}
	
	public void finalPrice(int totalPrice) {
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t %d\n","�� �� �� ��",totalPrice);
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t\t %d\n","���� �ݾ�",inputPrice);
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t\t %d\n","�Ž��� �ݾ�",inputPrice-totalPrice);
	}
}
