package loadBalancer;

import java.util.ArrayList;

public class RequestMaker {
	
	private LoadBalancer loadBalancer;
	
	public boolean requestSuccess;
	
	public RequestMaker(LoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}
	
	public void makeRequest() {
		requestSuccess = loadBalancer.makeRequest();
	}
	
	public boolean hasFalse() {
		
	}
}
