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
		/**
		 fib2(n,0,0,1)将打印出第n个fib数；
		 */
		if (n == k) {
			return f0;
		}
		else {
		/**
		 每递归一次，k+1，参数f0,f1实际上就是在往后计算斐波那契额数列
		 */
			return fib(n, k+1, f1, f0+f1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 k,f0,f1初始为0，0，1  
		 */
		System.out.print(fib(3,0,0,1));

	}

}