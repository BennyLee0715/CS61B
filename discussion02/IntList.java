package discussion02;

public class IntList {
	public int first;
	public IntList rest;
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}
	
	/**return the size of this IntList*/
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size(); 
	}
	
	public int get(int i) {
		if(i == 0) {
			return first;
		}
		return this.rest.get(i - 1);
	}
	
	/**return the square of IntList L without changing L
	 * use item 'new'
	 * recursion
	 */
	public static IntList square(IntList L) {
		   if(L == null) {
			   return L;
		   }
		   IntList rest = square(L.rest);
		   IntList M = new IntList(L.first * L.first, rest);
	       return M; 
	   }
	   
	/**return the square of IntList L 
	 * Destructive
	 * recursion
	 */
	   public static IntList squareDestructive(IntList L) {
		   if(L == null) {
			   return L;
		   }
		   L.first = L.first * L.first;
	       return squareDestructive(L.rest); 
	   }
		
		public static void main(String[] args) {
			IntList L = new IntList(15, null);
			L = new IntList(10, L);
			L = new IntList(5, L);
//			square(L);
			squareDestructive(L);
			System.out.println(L.get(2));
//			System.out.println(square(L).get(0));
			
		}		

}
