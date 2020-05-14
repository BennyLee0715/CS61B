public class ArrayDeque<T> {
    public T[] items;
    public int size;
    /**
     * 使用circular array, 规定添加头尾元素的位置(头尾指针)
     */
    public int nextFirst;
    public int nextLast;

    public ArrayDeque(){
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public T get(int index){
        return items[index];
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (T item : items){
            System.out.print(item + " ");
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(T item){
        /**环形数组，头指针循环到尾部*/
        if (nextFirst == -1){
            nextFirst = items.length - 1;
        }
        /**头尾指针相同时，说明数组除了该index处无元素，其他位置已满，需要扩大数组*/
        if (nextFirst == nextLast){
            resize();
        }
        items[nextFirst] = item;
        nextFirst -= 1;
        size += 1;
    }

    public void addLast(T item){
        /**环形数组，尾指针循环到头部*/
        if (nextLast == items.length){
            nextLast = 0;
        }
        if (nextFirst == nextLast){
            resize();
        }
        items[nextLast] = item;
        nextFirst += 1;
        size += 1;
    }

    public void resize(){
        T[] newItems = (T []) new Object [items.length * 2];
        /**先拷贝头尾指针指向位置的前面的数组部分到新数组的最前面*/
        System.arraycopy(items, 0, newItems, 0, nextFirst + 1);
        /**
         * 再拷贝头尾指针指向位置的后面的数组部分到新数组最后
         * 这里要判断nextFirst是否指向数组尾端，因为拷贝是从nextFirst往后一个index开始拷贝的
         * 而前面你第一次拷贝中拷贝起点都是0，所以不用有前提判断条件
         */
        if(nextFirst != items.length - 1) {
            System.arraycopy(items, nextFirst + 1, newItems, items.length + nextFirst + 1, items.length - nextFirst - 1);
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T extra = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        return extra;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T extra = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;
        return extra;
    }

}
