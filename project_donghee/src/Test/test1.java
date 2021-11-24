package Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import Cafe.Stock;

public class test1 {
public static void main(String[] args) {
	List<Stock> stockList = Arrays.asList(
			new Stock("커피가루", 5),
			new Stock("테이크아웃 컵", 10)
			);
	System.out.println(stockList.get(0).getStockNum());
//	Stream<Stock> stream = stockList.stream();

}

}
