package loadBalancer;

import java.util.ArrayList;
import java.util.concurrent.*;

public class WhereIsWaldo implements Runnable {
	private LoadBalancer loadBalancer;
	private int whatNum;
	private ArrayList<Integer> newRequests = new ArrayList<Integer>();
	
	public WhereIsWaldo(LoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}
	
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
		//if there i a request on the queue
			//get the request and do below
			if(whatNum == -1)
				return;
			int r = 10001;
			while(r != whatNum) {
				r = ThreadLocalRandom.current().nextInt(0, 10000);
			}
			//if we get to here we succeeded so tell LB we succeeded
			loadBalancer.makeReturnRequest(whatNum);
	}
}
