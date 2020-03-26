package HW0;

public class HW0_Ex4_windowPosSum {
	public static void windowPosSum(int[] a, int n) {
		int l = a.length;
		for (int x=0; x<l; x++) {
			int sum = a[x];
			if (a[x]<0) {
				continue;
			}
			for (int y=x+1; y<=x+n; y++) {
				if (y==l) {
					break;
				}
				sum = sum + a[y];
			}
			a[x] = sum;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] a = {1, -1, -1, 10, 5, -1};
	    int n = 3;
	    windowPosSum(a, n);

	    // Should print 4, 8, -3, 13, 9, 4
	    System.out.println(java.util.Arrays.toString(a));
	}

}
