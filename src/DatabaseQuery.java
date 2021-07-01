package helloWorld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseQuery {
	
	public Scanner scan = new Scanner(System.in);
	public int inputNo;
	public int totalPrice = 0;
	public int choiceAdd =0;
	public ArrayList<DataClass> arrData = new ArrayList<DataClass>();
	public void dbQuery() {
		
		DataClass item = new DataClass();
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
		    	item.goodsName=(String)rset.getString(2);
		    	item.goodsPrice=rset.getInt(3);
		    } else {
		    	System.out.println("�ش��ϴ� ��ǰ�� �����ϴ�.");
		    }
		    rset.close(); 
		    stmt.close(); 
		    conn.close(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		arrData.add(item);
		System.out.println("����?");
		item.goodsCount = scan.nextInt();
		totalPrice = item.goodsPrice*item.goodsCount;
		
		System.out.print("1.�߰�?    2.����?\n");
		choiceAdd = scan.nextInt();
	}

	//������ ��ǰ ���
	//������ ��ǰ ���
	public void purchasedGoods() {
		for(int i=0;i<arrData.size();i++) {
			System.out.printf("%-12s\t %d\t %d\t %d\n",arrData.get(i).goodsName, arrData.get(i).goodsPrice,
					arrData.get(i).goodsCount, (arrData.get(i).goodsPrice*arrData.get(i).goodsCount));
		}
	}
}
