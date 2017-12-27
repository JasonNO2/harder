package ceshi.WaitAndSleep;

/*
* 仓库
* */
public class Store {
	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public synchronized void push(){
		if (count==20) {
			try {
				System.out.println("仓库已满");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
		System.out.println("生产一个产品,剩下"+count+"个商品");
		notify();
	}

	public synchronized void pop(){
		if (count==0) {
			System.out.println("仓库已空,等待生产");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count--;
		System.out.println("出库成功,剩余"+count+"个商品");
		notify();
	}

}
