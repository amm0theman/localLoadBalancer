package loadBalancer;

public class LBworker implements Runnable {

	public LoadBalancer getLoadBalancer() {
		return loadBalancer;
	}

	public void setLoadBalancer(LoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}

	static volatile Integer roundRobinPosition = 0;
	private LoadBalancer loadBalancer;
	private WhereIsWaldo[] manyWaldos;
	
	LBworker(LoadBalancer loadBalancer, WhereIsWaldo[] manyWaldos) {
		this.loadBalancer = loadBalancer;
		this.manyWaldos = manyWaldos;
	}
	
	@Override
	public void run() {
		System.out.println("Running an LBWorker");					//DEBUG
		Integer i = null;
		while(true) {
			i = null;
			i = loadBalancer.requestListInt();
			if(i != null) {
				//System.out.println("Making Request in LBWorker");	//DEBUG
				synchronized(roundRobinPosition) {
				manyWaldos[roundRobinPosition].makeRequest(i);
				incrementRobin();
				}
			}
		}
	}
	//for testing

	private void incrementRobin() {
		if(roundRobinPosition < 3)
			roundRobinPosition++;
		else
			roundRobinPosition = 0;
	}
}
