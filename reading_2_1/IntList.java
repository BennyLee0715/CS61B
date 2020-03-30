package reading_2_1;


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
	
    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
   public static IntList incrList(IntList L, int x) {
	   IntList Q = new IntList(L.first-x, L.rest);
	   if(Q.rest == null) {
		   return Q;		   
	   }
       return incrList(Q.rest, x); 
       
   }

   /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
   public static IntList dincrList(IntList L, int x) {
	   L.first = L.first + x;
	   if(L.rest == null) {
		   return L;
	   }
       return dincrList(L.rest, x); 
   }

	
	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
//		System.out.println(L.size());
//		System.out.println(L.get(0));
		incrList(L,2);
		System.out.println(L.get(1));
		dincrList(L,2);
		System.out.println(L.get(1));
		
		}		
}
