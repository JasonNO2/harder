package ceshi.WaitAndSleep;

/*
* 消费者
* */
public class Customer implements Runnable{
	public Store store ;
	public Customer(Store store){
		this.store=store;
	}

	@Override
	public void run() {
		consume();
		
	}
	public void consume(){
		for (int i = 0; i < 50; i++) {
			store.pop();
		}

}
}
