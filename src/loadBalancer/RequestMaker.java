package loadBalancer;

import java.util.ArrayList;

public class RequestMaker {
	
	private LBlistener lbListener;
	private ArrayList<Boolean> myList;
	
	public RequestMaker(LBlistener lbListener) {
		myList = new ArrayList<Boolean>();
		this.lbListener = lbListener;
	}
	
	public void makeRequest() {
		myList.add(lbListener.makeRequest());
	}
	
	public boolean hasFalse() {
		return myList.contains(false);
	}
}
