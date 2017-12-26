package ceshi;

import java.util.ArrayList;
import java.util.List;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
//		Producer producer = new Producer(store);
//		Customer customer = new Customer(store);
//		new Thread(producer).start();
//		new Thread(customer).start();
		List<Integer> list = new ArrayList<>();
		test(store);
		System.out.println(store.hashCode());
//		for (int i = 0; i < list.size(); i++) {
//			Integer integer =  list.get(i);
//			System.out.println(integer);
//		}
		System.out.println(store.getCount());
	}
	public static void test(Store store){
		store.setCount(100);
		System.out.println(store.hashCode());
	}
}
