import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Main {
	static int count = 0;
	static int combinations = 0;
	static int nPoints = 25;

	public static void main(String args[]) throws Exception{
		//Log files
		purgeLogs();

		//f1
		System.out.println("F1");
		for (int i = 1; i <= nPoints; i++) {
			long startTime = System.nanoTime();
			count = 0;
			f1(i);
			long estimatedTime = System.nanoTime() - startTime;
			double ms = (double)estimatedTime / 1000000.0;
			System.out.println(	"n: " + i
								+ "\tOpCount: " + count
								+ "\tTime: " + ms + "ms");
			appendLog("F1", i + " " + count);
		}
		System.out.println("=========================");

		//f2
		System.out.println("F2");
		for (int i = 1; i <= nPoints; i++) {
			long startTime = System.nanoTime();
			count = 0;
			f2(i);
			long estimatedTime = System.nanoTime() - startTime;
			double ms = (double)estimatedTime / 1000000.0;
			System.out.println(	"n: " + i + "\tOpCount: " + count
				+ "\tTime: " + ms + "ms");
			appendLog("F2", i + " " + count);
		}
		System.out.println("=========================");

		//f3
		System.out.println("F3");
		for (int i = 1; i <= nPoints; i++) {
			long startTime = System.nanoTime();
			count = 0;
			f3(i);
			long estimatedTime = System.nanoTime() - startTime;
			double ms = (double)estimatedTime / 1000000.0;
			System.out.println(	"n: " + i + "\tOpCount: " + count
				+ "\tTime: " + ms + "ms");
			appendLog("F3", i + " " + count);
		}
		System.out.println("=========================");

		//f4
		System.out.println("F4");
		for (int i = 1; i <= nPoints; i++) {
			long startTime = System.nanoTime();
			count = 0;
			f4(i);
			long estimatedTime = System.nanoTime() - startTime;
			double ms = (double)estimatedTime / 1000000.0;
			System.out.println(	"n: " + i + "\tOpCount: " + count
				+ "\tTime: " + ms + "ms");
			appendLog("F4", i + " " + count);
		}
		System.out.println("=========================");

		//f5
		System.out.println("F5");
		for (int i = 1; i <= nPoints; i++) {
			long startTime = System.nanoTime();
			count = 0;
			f5(i);
			long estimatedTime = System.nanoTime() - startTime;
			double ms = (double)estimatedTime / 1000000.0;
			System.out.println(	"n: " + i + "\tOpCount: " + count
				+ "\tTime: " + ms + "ms");
			appendLog("F5", i + " " + count);
		}
		System.out.println("=========================");

		//f6
		System.out.println("F6");
		for (int i = 1; i <= 100; i++) {
			long startTime = System.nanoTime();
			count = 0;
			f6(i);
			long estimatedTime = System.nanoTime() - startTime;
			double ms = (double)estimatedTime / 1000000.0;
			System.out.println(	"n: " + i + "\tOpCount: " + count
				+ "\tTime: " + ms + "ms");
			appendLog("F6", i + " " + count);
		}
		System.out.println("=========================");

		//f7
		System.out.println("F7");
		for (int i = 1; i <= nPoints; i++) {
			long startTime = System.nanoTime();
			count = 0;
			f7(i);
			long estimatedTime = System.nanoTime() - startTime;
			double ms = (double)estimatedTime / 1000000.0;
			System.out.println(	"n: " + i + "\tOpCount: " + count
				+ "\tTime: " + ms + "ms");
			appendLog("F7", i + " " + count);
		}
		System.out.println("=========================");

		//f8
		System.out.println("F8");
		for (int i = 1; i <= 5; i++) {
			long startTime = System.nanoTime();
			count = 0;
			combinations = 0;
			ArrayList<Integer> c = new ArrayList<>();
			for(int j=1; j<=i; j++) c.add(j);
			f8("", c);
			long estimatedTime = System.nanoTime() - startTime;
			double ms = (double)estimatedTime / 1000000.0;
			System.out.println(	"n: " + i + "\tOpCount: " + count
				+ "\tCombinations: " + combinations
				+ "\tTime: " + ms + "ms");
			appendLog("F8", i + " " + count);
		}
		System.out.println("=========================");

	}

	public static int f1(int n) {
		int r = 0;
		for(int i = 1; i <= n; i++) {
			r += i;
			count++;
		}
		return r;
	}

	public static int f2(int n) {
		int r = 0;
		for (int i = 1; i < n; i++) {
			for (int j = i+1; j <= n; j++) {
				r = r + 2;
				count++;
			}
		}
		System.out.println("r: " + r);
		return r;
	}

	public static int f3(int n) {
		int r = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= 2*i; j++) {
				for (int k = i; k <= j; k++) {
					r = r + 1;
					count++;
				}
			}
		}
		System.out.println("r: " + r);
		return r;
	}

	public static int f4(int n) {
		int r = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= i+3; j++) {
				for (int k = i; k <= j; k++) {
					r = r + 1;
					count++;
				}
			}
		}
		System.out.println("r: " + r);
		return r;
	}

	public static int f5(int n) {
		count++;
		if(n == 0) return 1;
		return f5(n-1) + f5(n-1);
	}

	public static int f6(int n) {
		count++;
		if(n==0) return 1;
		return 2 * f6(n-1);
	}

	public static int f7(int n) {
		int b;
		int r = 0;
		for(int i = 1; i <= n; i++) {
			b = i;
			while(b > 0) {
				r += 1;
				b = b / 2;
				count++;
			}
		}
		System.out.println("r: " + r);
		return r;
	}

	public static void f8(String s, ArrayList<Integer> c) {
		count++;
		if (c.isEmpty()) {
			System.out.println(s);
			combinations++;
			return;
		}			
		int aux = c.get(c.size()-1);
		c.remove(c.size()-1);
		//c.remove(aux);
		f8(s, new ArrayList<Integer>(c));
		f8(s + " " + aux, new ArrayList<Integer>(c));
	}


	print([, first);
	
	public static void print(String s, Node n)
		if(n == null) {
			System.out.println(s + "]");
		}
		print(s + " " + n.data, n.next);
	}

	public static void purgeLogs() throws Exception {
		for(int i=1; i<=8; i++)
		{
			File f = new File("F"+i);
			if(f.exists()) f.delete();
		}
	}

	public static void appendLog(String fileName, String data)  throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
		bw.write(data);
		bw.newLine();
		bw.close();
	}
}