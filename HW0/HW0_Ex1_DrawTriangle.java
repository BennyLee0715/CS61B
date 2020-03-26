package HW0;

public class HW0_Ex1_DrawTriangle {
	public static void drawTriangle(int n){
		for (int x=0; x<n; x++) {
			for (int y=0; y<=x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		drawTriangle(10);
	}

}
