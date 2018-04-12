package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import loadBalancer.LBlistener;
import loadBalancer.LoadBalancer;
import loadBalancer.RequestMaker;

class RequestMakerTests {

	private RequestMaker requestMaker;
	private LoadBalancer loadBalancer;
	
	@BeforeEach
	void setUp() throws Exception {
		loadBalancer = new LoadBalancer();
		requestMaker = new RequestMaker(loadBalancer, 0);
	}

	@Test
	void test() {
		requestMaker.makeRequest();
		assertEquals(requestMaker.isRequestSuccess(), false);
	}

}
