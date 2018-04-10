package loadBalancer;

import java.util.concurrent.*;

public class WhereIsWaldo implements Runnable {
	
	@Override
	public void run() {
		int r = 0;
		while(r != 9998) {
			r = ThreadLocalRandom.current().nextInt(0, 9999);
		}
	}

}
