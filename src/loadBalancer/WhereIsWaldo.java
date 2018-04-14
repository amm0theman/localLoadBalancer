package loadBalancer;

import java.util.ArrayList;
import java.util.concurrent.*;

public class WhereIsWaldo implements Runnable {
	public LoadBalancer getLoadBalancer() {
		return loadBalancer;
	}

	public void setLoadBalancer(LoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}

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
	
	public void makeRequest(Integer requestNum) {
		synchronized(newRequests) {
			newRequests.add(requestNum);
		}
	}

	@Override
	public void run() {
		while(true) {
			//if there i a request on the queue
			synchronized(newRequests) {
			if(!newRequests.isEmpty()) {
				//get the request and do below
				whatNum = newRequests.remove(0);
				if(whatNum == -1)
					return;
				int r = 10001;
				while(r != whatNum) {
					r = ThreadLocalRandom.current().nextInt(0, 10000);
				}
				//System.out.println("Making return request in WhereIsWaldo\n");	//DEBUG
				//if we get to here we succeeded so tell LB we succeeded
				loadBalancer.makeReturnRequest(whatNum);
			}
			}
		}
	}
}
