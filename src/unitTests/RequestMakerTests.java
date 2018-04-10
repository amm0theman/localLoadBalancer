package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import loadBalancer.LBlistener;
import loadBalancer.RequestMaker;

class RequestMakerTests {

	private RequestMaker requestMaker;
	private LBlistener lbListener;
	
	@BeforeEach
	void setUp() throws Exception {
		lbListener = new LBlistener();
		requestMaker = new RequestMaker(lbListener);
	}

	@Test
	void test() {
		requestMaker.makeRequest();
		assertEquals(requestMaker.hasFalse(), true);
	}

}
