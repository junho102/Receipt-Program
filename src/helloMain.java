package helloWorld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class helloMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arrGoodsName = new ArrayList<String>();
		ArrayList<Integer> arrGoodsCount = new ArrayList<Integer>();
		ArrayList<Integer> arrGoodsPrice = new ArrayList<Integer>();
		int totalPrice = 0;
		int inputPrice = 0;
		int count =0;
		String GoodsName = null;
		int GoodsPrice =0;
		int choiceAdd =0;
		int inputNo;
		
		Scanner scan = new Scanner(System.in);
		
		do {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver"); 
			    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/goodslist",                  
			                                       "root" , "123456");
			   
			    System.out.print("��ǰ ��ȣ�� �Է��ϼ���: ");
			    inputNo = scan.nextInt();
			    
			    Statement stmt = conn.createStatement(); 
			    ResultSet rset = stmt.executeQuery("select * from goods where no="+inputNo); 
			    if (rset.next()) { 
			          //����� ó�� 
			    	System.out.printf("=> %d %s %d�� %s\n",rset.getInt(1),rset.getString(2),
			    			rset.getInt(3),rset.getString(4));
			    	GoodsName=(String)rset.getString(2);
			    	GoodsPrice=rset.getInt(3);
			    } else {
			    	System.out.println("�ش��ϴ� ��ǰ�� �����ϴ�.");
			    }
			    
			    
			    rset.close(); 
			    stmt.close(); 
			    conn.close(); 
			} catch(Exception e) {
				e.printStackTrace();
			}
			 
			System.out.println("����?");
			count = scan.nextInt();
			
			arrGoodsPrice.add(GoodsPrice);
			arrGoodsName.add(GoodsName);
			arrGoodsCount.add(count);
			
			System.out.print("1.�߰�?    2.����?\n");
			choiceAdd = scan.nextInt();
		}while(choiceAdd==1); 
		
		
		for(int i=0;i<arrGoodsCount.size();i++) {
			totalPrice += (arrGoodsPrice.get(i)*arrGoodsCount.get(i));
		}
		System.out.println("===========================================");
		System.out.printf("�� �ݾ��� %d ���Դϴ�.\n",totalPrice);
		System.out.print("������ �ݾ�??");
		inputPrice = scan.nextInt();
		System.out.println("\n===========================================");
		
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
		
		
		for(int i=0;i<arrGoodsName.size();i++) {
			System.out.printf("%-12s\t %d\t %d\t %d\n",arrGoodsName.get(i), arrGoodsPrice.get(i),
					arrGoodsCount.get(i), (arrGoodsPrice.get(i)*arrGoodsCount.get(i)));
		}
		
		
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t %d\n","�� �� �� ��",totalPrice);
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t\t %d\n","���� �ݾ�",inputPrice);
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t\t %d\n","�Ž��� �ݾ�",inputPrice-totalPrice);
		
		
		
		
	}


}
