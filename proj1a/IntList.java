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
        if (L == null) {
            return L;
        }
        IntList Q = new IntList(L.first + x, null);     //新的List，最终return的是这个List
        /** 定义一个C指向Q，B指向L.rest，相当于每次对Q.rest链接一个新List,
         * 这个新List的first就是原来L.rest + x；
         * 为了不改变L，我们用B一次扫描L；每次更新C为first + x；
         * 这样相当于C和B在一次指向链表后续元素并操作，L和Q始终指向链表头
         */
        IntList C = Q;
        IntList B = L.rest;
        while (B != null) {
            C.rest = new IntList(B.first + x, null);
            C = C.rest;
            B = B.rest;
        }
        return Q;
    }
////        if (L == null) {
////            return L;
////        }
////        else {
////                IntList rest = incrList(L.rest, 2);
////                IntList M = new IntList(L.first + x, rest);
////                return M;
////            }
//        }


    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        if(L == null) {
            return L;
        }
        L.first = L.first + x;
        dincrList(L.rest, x);
        return L;
//        IntList A = L;
//        while(A != null){
//            A.first = A.first + x;
//            A = A.rest;
//        }
//        return L;
    }

    public static IntList square(IntList L) {
        if(L == null) {
            return L;
        }
        IntList rest = square(L.rest);
        IntList M = new IntList(L.first * L.first, rest);
        return M;
    }

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
//		System.out.println(L.size());
//		System.out.println(L.get(0));
		incrList(L,2);
//		System.out.println(.get(1));
//		dincrList(L,2);
//		System.out.println(L.get(1));
//		square(L);
//        squareDestructive(L);
//        System.out.println(L.get(2));
//		System.out.println(square(L).get(0));

    }
}