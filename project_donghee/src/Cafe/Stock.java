package Cafe;

import java.util.List;

public class Stock {
	private   String  Ingredients  ; 
	private   int StockNum; 
	
	public Stock( String Ingredients, int StockNum) {
		this.Ingredients = Ingredients;
		this.StockNum = StockNum;
	
	} 
	
//	public static void StockList () {
//		int num = 0 ;
//		Map<String, Integer> stock = new HashMap<>();
//		stock.put(Ingredients, StockNum);
//	
//	 Set<Entry <String, Integer>> sm  =  stock.entrySet();
//	 Iterator<Entry<String, Integer>>  StockMg = sm.iterator();
//	 while(StockMg.hasNext()) {
//		 Entry<String, Integer> entry = StockMg.next();
//		
//		 setIngredients(entry.getKey());
//		 setStockNum(entry.getValue());
//
//		 num ++ ;
//	 	System.out.println();
//	 	System.out.println(num  +" . "+ "재료명: " + getIngredients() + "        재고량: " + getStockNum() + " \n");
//	 }
//	}



	public  String getIngredients() {
		return Ingredients;
	}

	public void setIngredients(String ingredients) {
		Ingredients = ingredients;
	}

	public   int getStockNum() {
		return StockNum;
	}

	public   void setStockNum(int stockNum) {
		StockNum = stockNum;
	}


	
	
}