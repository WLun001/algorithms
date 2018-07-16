package collection;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0;

    /**
     * Create a default list
     */
    protected MyAbstractList() {
    }

    /**
     * Create a list from an array of objects
     */
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /**
     * Add a new element at the end of this list
     */
    @Override
    public void add(E e) {
        add(size, e);
    }

    /**
     * Adds the elements in otherList to this list.
     * Returns true if this list changed as a result of the call
     */
    public boolean addAll(MyList<E> otherList) {
        boolean flag = false;
        for (int i = 0; i < otherList.size(); i++) {
            add(otherList.get(i));
            flag = true;
        }
        return flag;
    }

    /**
     * Return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Remove the first occurrence of the element e
     * from this list. Shift any subsequent elements to the left.
     * Return true if the element is removed.
     */
    @Override
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else
            return false;
    }

    /**
     * Removes all the elements in otherList from this list.
     * Returns true if this list changed as a result of the call
     */
    public boolean removeAll(MyList<E> otherList) {
        boolean flag = false;
        for (int i = 0; i < otherList.size(); i++) {
            while (true) {
                if(!remove(otherList.get(i))) break;
                else flag = true;
            }
        }
        return flag;
    }

    /**
     * Retains the elements in this list that are also in otherList.
     * Returns true if this list changed as a result of the call
     */
    public boolean retainAll(MyList<E> otherList) {
        boolean flag = false;
        // add item based on otherList
        for (int i = 0; i < otherList.size(); i++) {
            E item = otherList.get(i);
            if (!contains(item)) {
                    add(item);
                    flag = true;
            }
        }
        //remove item based on otherList
        for (int i = 0; i < this.size(); i++) {
            E item = this.get(i);
            if (!otherList.contains(item)) {
                remove(item);
                flag = true;
            }
        }
        return flag;
    }
}
