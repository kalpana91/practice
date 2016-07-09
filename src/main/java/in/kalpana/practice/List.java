package in.kalpana.practice;

public interface List<T> {
    List<T> add(T elem);

    List<T> delete(T elem);

    boolean exists(T elem);

    int size();
}
