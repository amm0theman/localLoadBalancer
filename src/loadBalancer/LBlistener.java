package loadBalancer;

import java.util.ArrayList;

public class LBlistener {

	private ArrayList<Integer> lbList;
	
	//Pass the list
	LBlistener(ArrayList<Integer> lbList) {
		this.lbList = lbList;
	}
	
	//whenever you get a request add it to the queue as fast as possible
	public void makeRequest(int user) {
		synchronized (lbList) {
			lbList.add(user);
		}
	}
}
