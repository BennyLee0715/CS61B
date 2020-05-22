public class ArrayDeque<T> {
    private T[] items;
    private int size;
    /**
     * 使用circular array, 规定添加头尾元素的位置(头尾指针)
     */
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    /**
     * helper，因为使用的是circular array，当头尾指针到达两端并继续增加时，指针会换到array另一边
     * 这两个helper帮助统一上述指针达到端点和不在端点时的 +1 方法
     * 会在add，remove中帮助改变头尾指针位置
     */

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /**return the size of array*/
    public int size() {
        return size;
    }

    /**check if the array is empty*/
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);    //加一个头元素，nextFirst前移一位
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length){
            resize(items.length * 2);
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);   //加一个尾元素，nextLast后移一位
        size += 1;
    }

    /**enlarge/shorten the size of array*/
    private void resize(int range) {
        T[] newItems = (T []) new Object [range];
        /**
         * 对于circular array，从nextFirst的后一位（plusOne()）开始, 依次往后的元素顺序即为array正序
         * 同理，从nextLast的前一位（minusOne()）开始，依次往前的元素顺序即为array倒序
         */
        int oldIndex = plusOne(nextFirst);
        for (int newIndex = 0; newIndex < size; newIndex ++) {
            newItems[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        /**
         * 这里的原array是从新array的第一个元素开始填入新array的
         * nextFirst变为新array最后一个元素位置
         * nextLast为填入的最后一个元素后一个位置
         */
        nextFirst = newItems.length - 1;
        nextLast = size;
        items = newItems;
    }

    /**检查array是否存在过多空元素，如果是，减小array容量*/
    private void reduceSize() {
        if (items.length > 3 * size){
            resize(items.length / 2);
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        /**
         * nextFirst 永远指向下一个元素的加入位置
         * 这里nextFirst指针后移一个指向的是此时array中存在的第一个元素
         * remove该元素
         * nextFirst后移一位
         */
        int first = plusOne(nextFirst);     //去掉一个头元素，nextFirst后移一位
        T tmp = items[first];
        items[first] = null;
        nextFirst = first;
        size -= 1;
        if (size != 0) {
            reduceSize();
        }
        return tmp;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int last = minusOne(nextLast);      //去掉一个尾元素，nextLast前移一位
        T tmp = items[last];
        items[last] = null;
        nextLast = last;
        size -= 1;
        if (size != 0) {
            reduceSize();
        }
        return tmp;
    }

    /**print array*/
    public void printDeque() {
        if (isEmpty()) {
            System.out.print("Empty Array!");
        }
        int index = 0;
        for (int i = 0; i < size; i ++) {
            index = plusOne(nextFirst);
            System.out.print(items[index] + " ");
        }
    }

    public T get(int index) {
        return items[(nextFirst + 1 + index) % items.length];
    }



//        public static void main(String[]args){
//        ArrayDeque a = new ArrayDeque<>();
//        a.addFirst(3);
//        a.addFirst(2);
////        System.out.println(a.isEmpty());
//        a.addFirst(1);
////        a.addFirst(7);
////        a.addFirst(6);
//        a.addLast(4);
//        a.addLast(5);
//        a.addLast(6);
//        a.addLast(7);
////        a.printDeque();
////        System.out.println("\n" + a.size());
////        a.removeFirst();
////        a.removeLast();
//        System.out.println(a.get(1));
//    }
}
