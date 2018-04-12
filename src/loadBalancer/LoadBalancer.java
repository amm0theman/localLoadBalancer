package loadBalancer;

import java.util.ArrayList;

public class LoadBalancer {
	private ArrayList<Integer> lbList = new ArrayList<Integer>();
	private LBworker[] lbWorker = new LBworker[12];
	private LBlistener lbListener = new LBlistener(lbList);
	private WhereIsWaldo[] taskDoers;
	
	public LoadBalancer(WhereIsWaldo[] taskDoers) {
		this.taskDoers = taskDoers;
	}
	
	public void makeRequest(int user) {
		lbListener.makeRequest(user);
	}
	
	public Integer requestListInt() {
		synchronized (lbList) {
		if(!isListEmpty()) {
			return lbList.get(0);
		}
		else
			return null;
		}
	}
	
	//for testing
	public boolean isListEmpty() {
		return lbList.isEmpty();
	}
}
