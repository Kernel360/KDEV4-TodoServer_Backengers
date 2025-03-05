package list;

public interface ListInterface<E> {
    public void insertElement(int index, E element);
    public void addElement(E element);
    public E removeElement(int index);
    public E getElement(int index);
    public int getSize(); // 실제로 가지고 있는 요소의 개수 반환.
    public boolean isEmpty();
    public void removeAll();
    public void printAll();
}
