package in.kalpana.practice;

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
        return null;
    }
}
