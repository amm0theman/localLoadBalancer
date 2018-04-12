package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import loadBalancer.LoadBalancer;
import loadBalancer.RequestMaker;

class LBListenerTests {
	RequestMaker[] manyRequests;
	LoadBalancer loadBalancer;
	
	@BeforeEach
	void setup() throws Exception {
		loadBalancer = new LoadBalancer();
		manyRequests = new RequestMaker[10000];
		
		for(int i = 0; i < manyRequests.length; i++) {
			manyRequests[i] = new RequestMaker(loadBalancer, i);
		}
	}
	
	@Test
	void test() {
		for(int i = 0; i < manyRequests.length; i++) {
			System.out.println(i);
			manyRequests[i].makeRequest();
		}
		assertEquals(loadBalancer.isListEmpty(), false);
	}

}
