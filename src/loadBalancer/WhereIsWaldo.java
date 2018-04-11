package loadBalancer;

import java.util.concurrent.*;

public class WhereIsWaldo implements Runnable {
	
	private int whatNum;
	
	public int getWhatNum() {
		return whatNum;
	}

	public void setWhatNum(int whatNum) {
		if (whatNum <= 9999 && whatNum > 0)
			this.whatNum = whatNum;
		else 
			whatNum = -1;
	}

	@Override
	public void run() {
		if(whatNum == -1)
			return;
		int r = 0;
		while(r != whatNum) {
			r = ThreadLocalRandom.current().nextInt(0, 10000);
		}
	}
}
