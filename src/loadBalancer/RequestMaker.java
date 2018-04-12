package loadBalancer;

public class RequestMaker {
	
	private LoadBalancer loadBalancer;
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
		loadBalancer.makeRequest(objNumber);
	}
	
	public void requestDone() {
		if(requestSuccess)
			System.out.println("Successful Request Object" + objNumber + " - Total successful requests: " + numSuccesses);
	}
}
