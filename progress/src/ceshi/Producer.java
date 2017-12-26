package ceshi;

/*
* 生产者
* */
public class Producer implements Runnable {
	private Store store = null;
	public Producer(Store store){
		this.store=store;
	}

	@Override
	public void run() {
		product();
	}
	public void product(){
		for (int i = 0; i < 50; i++) {
			store.push();
		}
		
	}

}
