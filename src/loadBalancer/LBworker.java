package loadBalancer;

public class LBworker implements Runnable {

	private LoadBalancer loadBalancer;
	private WhereIsWaldo[] manyWaldos;
	
	LBworker(LoadBalancer loadBalancer, WhereIsWaldo[] manyWaldos) {
		this.loadBalancer = loadBalancer;
		this.manyWaldos = manyWaldos;
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
