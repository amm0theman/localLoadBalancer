package loadBalancer;

import java.util.ArrayList;

public class LBlistener {

	private ArrayList<Integer> lbList;
	
	LBlistener(ArrayList<Integer> lbList) {
		this.lbList = lbList;
	}
	
	public void makeRequest(int user) {
		synchronized (lbList) {
			lbList.add(user);
		}
	}
	
	//For testing
	
}
