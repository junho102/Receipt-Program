package helloWorld;


public class helloMain {
	
	
	
	public static int count =0;
	public static String GoodsName = null;
	public static int GoodsPrice =0;
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseQuery dbQuery = new DatabaseQuery();
		PrintClass print = new PrintClass();
		
		do {
			dbQuery.dbQuery();
			
		}while(dbQuery.choiceAdd==1); 
		
		print.printTotalPrice(dbQuery.totalPrice);
		print.inputPrice();
		print.justPrint();
		
		dbQuery.purchasedGoods();
		
		
		print.finalPrice(dbQuery.totalPrice);
		
	}

}
