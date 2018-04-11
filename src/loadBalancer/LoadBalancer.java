package loadBalancer;

import java.util.Queue;

public class LoadBalancer {
	
	private LBlistener lbListener = new LBlistener();
	private LBworker[] lbWorker = new LBworker[12];
	
	private Queue<Integer> lbQueue;
	
	LoadBalancer() {
		
	}
	
	public boolean makeRequest() {
		return false;
	}
}
