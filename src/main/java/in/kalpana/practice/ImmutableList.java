package in.kalpana.practice;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImmutableList<T> implements List<T> {

    ImmutableList<T> tail;
    T head;


    public ImmutableList(T head, ImmutableList<T> tail) {
        this.tail = tail;
        this.head = head;
    }

    public static <T> ImmutableList<T> EmptyList() {
        return new ImmutableList<T>(null, null);
    }

    public ImmutableList<T> add(T elem) {
        return new ImmutableList<T>(elem, this);
    }


    public boolean exists(T elem) {
        return null != head && (head.equals(elem) || tail.exists(elem));
    }

    public int size() {
        return (head == null) ? 0 : 1 + tail.size();
    }

    public ImmutableList<T> delete(T elem) {
        if (head == null || tail == null || !exists(elem)) return this;
        else if (head.equals(elem)) return tail;
        else return new ImmutableList<T>(head, tail.delete(elem));
    }

    public Iterator<T> iterator() {
        final ImmutableList<T> me = this;
        return new Iterator<T>() {

            ImmutableList<T> list = me;

            public boolean hasNext() {
                return list.head != null;
            }

            public T next() {
                if(!hasNext()) throw new NoSuchElementException("List is empty");
                T next = list.head;
                list = list.tail;
                return next;
            }

            public void remove() {
            }
        };
    }
}
