package loadBalancer;

public class RequestMaker {
	
	private LoadBalancer loadBalancer;
	
	public LoadBalancer getLoadBalancer() {
		return loadBalancer;
	}

	public void setLoadBalancer(LoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}

	private int objNumber;
	private int numSuccesses = 0;
	private boolean requestSuccess = false ;

	public RequestMaker(LoadBalancer loadBalancer, int objNumber) {
		this.loadBalancer = loadBalancer;
		this.objNumber = objNumber;
	}
	
	public boolean isRequestSuccess() {
		return requestSuccess;
	}

	public void setRequestSuccess(boolean requestSuccess) {
		System.out.println("Cannot manually set requestSuccess");
	}
	
	public void makeRequest() {
		requestSuccess = false;
		loadBalancer.makeRequest(objNumber);
	}
	
	synchronized public void finishRequest(boolean requestSuccess) {
		this.requestSuccess = requestSuccess;
		requestDone();
	}
	
	synchronized private void requestDone() {
		if(requestSuccess) {
			numSuccesses++;
			System.out.println("Successful Request Object" + objNumber + " - Total successful requests: " + numSuccesses);
		}
		else
			System.out.println("Failed Request Object" + objNumber + " - Total successful requests: " + numSuccesses);
	}
}
