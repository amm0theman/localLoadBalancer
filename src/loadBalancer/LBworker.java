package loadBalancer;

public class LBworker implements Runnable {

	private LoadBalancer loadBalancer;
	
	LBworker(LoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}
	
	@Override
	public void run() {
		
		Integer i = null;
		
		while(true) {
			i = loadBalancer.requestListInt();
			if(i != null) {
				
			}
		}
	}

	//for testing
}
