package HW0;

public class HW0_Ex2_max {
	public static int max(int[] m) {
		int l = m.length;
		int max = m[0];
		for (int x=1; x<l; x++) {
			if (m[x]>max) {
				max = m[x];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[] {9,2,15,2,22,10,6};
		System.out.print(max(numbers));
	}

}
