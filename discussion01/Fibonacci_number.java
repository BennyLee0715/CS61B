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
		 fib2(n,0,0,1)����ӡ����n��fib����
		 */
		if (n == k) {
			return f0;
		}
		else {
		/**
		 ÿ�ݹ�һ�Σ�k+1������f0,f1ʵ���Ͼ������������쳲�����������
		 */
			return fib(n, k+1, f1, f0+f1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 k,f0,f1��ʼΪ0��0��1  
		 */
		System.out.print(fib(3,0,0,1));

	}

}