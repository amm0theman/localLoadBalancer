package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import loadBalancer.LBlistener;
import loadBalancer.LoadBalancer;
import loadBalancer.RequestMaker;
import loadBalancer.WhereIsWaldo;

class RequestMakerTests {

	public static RequestMaker[] requestMaker = new RequestMaker[1];
	public static LoadBalancer loadBalancer;
	public static WhereIsWaldo[] whereIsWaldo;
	public static Thread[] myThread;
	
	@BeforeEach
	void setUp() throws Exception {
		requestMaker[0] = new RequestMaker(loadBalancer, 0);
		whereIsWaldo = new WhereIsWaldo[4];
		whereIsWaldo[0] = new WhereIsWaldo(loadBalancer);
		whereIsWaldo[1] = new WhereIsWaldo(loadBalancer);
		whereIsWaldo[2] = new WhereIsWaldo(loadBalancer);
		whereIsWaldo[3] = new WhereIsWaldo(loadBalancer);
		myThread = new Thread[4];
		for (int i = 0; i < 4; i++) {
			myThread[i] = new Thread(whereIsWaldo[i]);
		}
		loadBalancer = new LoadBalancer(whereIsWaldo, requestMaker);
	}
	
	//Test if when a request is made if we get a timely result telling us true
	@Test
	void testRequestDone() {
		requestMaker[0].setLoadBalancer(loadBalancer);
		
		whereIsWaldo[0].setLoadBalancer(loadBalancer);
		whereIsWaldo[1].setLoadBalancer(loadBalancer);
		whereIsWaldo[2].setLoadBalancer(loadBalancer);
		whereIsWaldo[3].setLoadBalancer(loadBalancer);
		
		for(int i = 0; i < 4; i++) {
			myThread[i].start();
		}
	
		for (int i = 0; i < 1000; i++){
			requestMaker[0].makeRequest();
		}

		//Wait ten seconds
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(requestMaker[0].isRequestSuccess(), true);
	}
}
