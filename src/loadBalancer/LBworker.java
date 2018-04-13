package loadBalancer;

public class LBworker implements Runnable {

	public LoadBalancer getLoadBalancer() {
		return loadBalancer;
	}

	public void setLoadBalancer(LoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}

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
				System.out.println("Making Request in LBWorker");	//DEBUG
				manyWaldos[0].makeRequest(i);
			}
		}
	}
	//for testing
}
