package unitTests;

import loadBalancer.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WhereIsWaldoTests {
	
	private WhereIsWaldo whereIsWaldo;
	private Thread waldoThread;
	
	@BeforeEach
	void setup() throws Exception {
		whereIsWaldo = new WhereIsWaldo(new LoadBalancer(new WhereIsWaldo[4], new RequestMaker[0]));
		waldoThread = new Thread(whereIsWaldo);
	}
	
	@Test
	void test() {
		waldoThread.start();
		assertEquals(1,1);
	}

}
