package hust.soict.khmt.aims.utils;

import java.lang.*;

public class MemoryDaemon implements Runnable {

	long memoryUsed = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Runtime rt = Runtime.getRuntime();
		long used;

		while (true) {
			used = rt.totalMemory() - rt.freeMemory();
			if (used != memoryUsed) {
				System.out.println("\tMemory used = " + used);
				memoryUsed = used;
			}
		}
	}

}
