package discussion01;

//public class Fibonacci_number {
//	public static int fib(int n) {
//		if (n<2) {
//			return n;
//		}
//		else {
//			return fib(n-1) + fib(n-2);
//		}
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.print(fib(5));
//
//	}
//
//}

public class Fibonacci_number {
	public static int fib(int n, int k, int f0, int f1) {
		if (n<2) {
			return n;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(fib(5));

	}

}