public interface L<E> extends Iterable<E> {

    public abstract L<E> add(E val);
    public abstract E get(int index);
    public abstract int size();

}