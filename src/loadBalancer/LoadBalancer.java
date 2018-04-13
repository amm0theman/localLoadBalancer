package loadBalancer;

import java.util.ArrayList;

public class LoadBalancer {
	private ArrayList<Integer> lbList = new ArrayList<Integer>();	//For incoming requests
	private ArrayList<Boolean> lbReturnList = new ArrayList<Boolean>();
	private LBworker[] lbWorker = new LBworker[12];
	private Thread[] lbWorkerThreads = new Thread[12];
	private LBlistener lbListener = new LBlistener(lbList);
	private WhereIsWaldo[] manyWaldos;
	private RequestMaker[] manyConnections;
	
	//Initializes threads and psuedo tcp connections
	public LoadBalancer(WhereIsWaldo[] taskDoers, RequestMaker[] manyConnections) {
		//We pass these into the constructor to simulate where our tcp connections would be :)
		this.manyWaldos = taskDoers;
		this.manyConnections = manyConnections;
		
		//Initialize workers
		for(int i = 0; i < lbWorker.length; i++) {
			lbWorker[i] = new LBworker(this, taskDoers);
		}
		//make threads on workers
		for(int i = 0; i < lbWorker.length; i++) {
			lbWorkerThreads[i] = new Thread(lbWorker[i]);
		}
		//Start workers threads
		for(int i = 0; i < lbWorker.length; i++) {
			System.out.println(i);
			lbWorkerThreads[i].start();
		}
	}
	
	//REQUESTS
	//pass along request to listener
	public void makeRequest(int user) {
		lbListener.makeRequest(user);
	}
	
	public void makeReturnRequest(int user) {
		manyConnections[user].finishRequest(true);
	}
	
	//will remove an item from the list (if there is something on the list) and return it, otherwise return null
	public Integer requestListInt() {
		synchronized (lbList) {
		if(!lbList.isEmpty()) {
			return lbList.remove(0);
		}
		else
			return null;
		}
	}
	
	//Simply for testing purposes
	public boolean isListEmpty() {
		return lbList.isEmpty();
	}
}
