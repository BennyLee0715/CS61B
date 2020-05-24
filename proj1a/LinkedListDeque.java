public class LinkedListDeque<T> {
    private class IntNode {
        /**
         * Use Doubly Linked List (head to last & last to head)
         */
        private T item;
        private IntNode next;
        private IntNode prev;

        public IntNode(T i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private IntNode sentinel;
    private int size;

    /**
     * create a null IntNode
     * sentinel不在List的计算中，sentinel后的第一个节点index为0，从该节点开始算size
     */
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);     //initialization
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        /**
         * 1. 加入的新头节点，他的next为原来的sentinel.next, prev为sentinel，这一步为创建new IntNode
         * 2. 原sentinel.next。prev 指向新节点
         * 3. sentinel。next变为new IntNode
         */
        sentinel.next.prev = new IntNode(item, sentinel.next, sentinel);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    public void addLast(T item) {
        /**
         * 1. 加入的新尾节点，他的next是原第一个节点sentinel, prev为之前的尾节点，这一步为创建new IntNode
         * 2. 原来的尾节点sentinel.prev的next指向新节点
         * 3. 头节点sentinel的prev指向新节点
         */
        sentinel.prev.next = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    /**如果是空链表返回true*/
    public boolean isEmpty() {
        return (size == 0);
    }

    /**返回链表size大小*/
    public int size() {
        return size;
    }

    /**打印链表*/
    public void printDeque() {
        IntNode i = sentinel.next;
        for (int j = 0; j < size(); j++) {
            System.out.print(i.item + " ");
            i = i.next;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T extra = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return extra;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T extra = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return extra;
    }

    /**Gets the item at the given index*/
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        IntNode j = sentinel;
        for (int i = 0; i <= index; i++) {
            j = j.next;
        }
        return j.item;
    }

    /**
     *     使用recursion来获得相应index的item
     *     需要一个getRecursiveHelp子方法
     */
    private T getRecursiveHelp(IntNode a, int i) {
        if (i == 0) {
            return a.item;
        }
        else {
            a = a.next;
            i--;
        }
        return getRecursiveHelp(a, i);
    }

    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }

    /**test*/
//    public static void main(String[]args){
//        LinkedListDeque a = new LinkedListDeque();
//        a.addFirst(3);
//        a.addFirst(7);
//        System.out.println(a.isEmpty());
//        a.addFirst(3);
//        a.addFirst(7);
//        a.addFirst(6);
//        a.addLast(79);
//        a.addLast(80);
//        a.printDeque();
//        System.out.println("\n" + a.size());
//        a.removeFirst();
//        a.removeLast();
//        System.out.println(a.get(6));
//    }


}