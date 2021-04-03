package hust.soict.khmt.garbage;

import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String[] args) {
		Random r = new Random(123);
		long start = System.currentTimeMillis();
		String str = "";
		for (int i = 0; i < 2147483647; i++)
			str += r.nextInt(2);
		System.out.println(System.currentTimeMillis() - start);
		
		r = new Random(123);
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2147483647; i++)
		{
			sb.append(r.nextInt(2));
		}
			
		str = sb.toString();
		System.out.println(System.currentTimeMillis() - start);
		
		r = new Random(123);		
		StringBuffer strbuf = new StringBuffer();
		start = System.currentTimeMillis();
		for (int i = 0; i < 214748364; i++)
			strbuf.append(r.nextInt(2));
		str = strbuf.toString();
		System.out.println(System.currentTimeMillis() - start);

	}
}
