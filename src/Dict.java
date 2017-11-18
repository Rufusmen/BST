public interface Dict <T extends Comparable<T> > {
    void insert(T t) throws Exception;
    void remove(T t) throws NoSuchFieldException;
    boolean search(T t);
    T max();
    T min();
}
