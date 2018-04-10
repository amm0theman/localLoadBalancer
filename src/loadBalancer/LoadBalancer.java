package loadBalancer;

public class LoadBalancer {
	
	private LBlistener lbListener;
	private LBworker[] lbWorker;
	
	LoadBalancer() {
		
	}
	
	public boolean makeRequest() {
		return false;
	}
}
