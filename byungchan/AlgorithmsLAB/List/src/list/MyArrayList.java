package list;

public class MyArrayList<E> implements ListInterface<E> {
    private int count; // 리스트 안에 요소의 개수가 몇 개인가?
    private E[] objectList;
    private int DEFAULT_CAPACITY = 10;
    private static final int ERROR_NUM = -999999999;

    public MyArrayList() {
        objectList = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int size) {
        DEFAULT_CAPACITY = size;
        objectList = (E[]) new Object[size];
    }

    @Override
    public void insertElement(int position, E element) {
        if (count > DEFAULT_CAPACITY) {
            System.out.println("not enough memory");
            return;
        }

        if (position < 0 || position > count) {
            System.out.println("insert position error");
            return;
        }

        if (position == count) {
            objectList[count++] = element;
            return;
        }

        for (int i = count - 1; i >= position; i--) {
            objectList[i+1] = objectList[i];
        }

        objectList[position] = element;
        count++;
    }

    @Override
    public void addElement(E element) {
        if (count > DEFAULT_CAPACITY) {
            System.out.println("not enough memory");
            return;
        }

        objectList[count++] = element;
    }

    @Override
    public E removeElement(int position) {
        if (isEmpty()) {
            System.out.println("no element");
            return null;
        }

        if (position < 0 || position >= count) {
            System.out.println("remove position error");
            return null;
        }

        E removedElement = objectList[position];

        for (int i = position; i < count - 1; i++) {
            objectList[i] = objectList[i+1];
        }
        count--;

        return removedElement;
    }

    @Override
    public E getElement(int index) {
        return objectList[index];
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (count == 0) return true;
        else return false;
    }

    @Override
    public void removeAll() {
        objectList = (E[]) new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    @Override
    public void printAll() {
        if (count == 0) {
            System.out.println("Array is empty");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(objectList[i]);
        }
    }
}
