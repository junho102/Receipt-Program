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
			   
			    System.out.print("상품 번호를 입력하세요: ");
			    inputNo = scan.nextInt();
			    
			    Statement stmt = conn.createStatement(); 
			    ResultSet rset = stmt.executeQuery("select * from goods where no="+inputNo); 
			    if (rset.next()) { 
			          //결과물 처리 
			    	System.out.printf("=> %d %s %d원 %s\n",rset.getInt(1),rset.getString(2),
			    			rset.getInt(3),rset.getString(4));
			    	GoodsName=(String)rset.getString(2);
			    	GoodsPrice=rset.getInt(3);
			    } else {
			    	System.out.println("해당하는 상품이 없습니다.");
			    }
			    
			    
			    rset.close(); 
			    stmt.close(); 
			    conn.close(); 
			} catch(Exception e) {
				e.printStackTrace();
			}
			 
			System.out.println("수량?");
			count = scan.nextInt();
			
			arrGoodsPrice.add(GoodsPrice);
			arrGoodsName.add(GoodsName);
			arrGoodsCount.add(count);
			
			System.out.print("1.추가?    2.종료?\n");
			choiceAdd = scan.nextInt();
		}while(choiceAdd==1); 
		
		
		for(int i=0;i<arrGoodsCount.size();i++) {
			totalPrice += (arrGoodsPrice.get(i)*arrGoodsCount.get(i));
		}
		System.out.println("===========================================");
		System.out.printf("총 금액은 %d 원입니다.\n",totalPrice);
		System.out.print("지불한 금액??");
		inputPrice = scan.nextInt();
		System.out.println("\n===========================================");
		
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
		
		
		for(int i=0;i<arrGoodsName.size();i++) {
			System.out.printf("%-12s\t %d\t %d\t %d\n",arrGoodsName.get(i), arrGoodsPrice.get(i),
					arrGoodsCount.get(i), (arrGoodsPrice.get(i)*arrGoodsCount.get(i)));
		}
		
		
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t %d\n","합 계 금 액",totalPrice);
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t\t %d\n","받은 금액",inputPrice);
		System.out.println("---------------------------------------");
		System.out.printf("%s\t\t\t\t %d\n","거스름 금액",inputPrice-totalPrice);
		
		
		
		
	}


}
