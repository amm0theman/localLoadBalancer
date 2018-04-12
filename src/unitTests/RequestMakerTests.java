package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import loadBalancer.LBlistener;
import loadBalancer.LoadBalancer;
import loadBalancer.RequestMaker;
import loadBalancer.WhereIsWaldo;

class RequestMakerTests {

	private RequestMaker[] requestMaker = new RequestMaker[1];
	private LoadBalancer loadBalancer;
	WhereIsWaldo[] whereIsWaldo;
	
	@BeforeEach
	void setUp() throws Exception {
		loadBalancer = new LoadBalancer(null, null);
		requestMaker[0] = new RequestMaker(loadBalancer, 0);
	}

	//Test if the setter and getter work as expected
	//setter should never work
	//getter should simply return state of requestSuccess
	@Test
	void testSetAndGet() {
		//Should never be able to manually set request success
		requestMaker[0].setRequestSuccess(true);
		assertEquals(requestMaker[0].isRequestSuccess(), false);
	}
	
	//Test if when a request is made if we get a timely result telling us true
	@Test
	void testRequestDone() {
		requestMaker[0].makeRequest();
		
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
