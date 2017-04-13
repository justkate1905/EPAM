package epam.collections.customLists;

import java.util.*;

public class CustomArrayList<T> implements List<T> {

    public static final int CAPACITY = 10;

    private Object[] data = new Object[CAPACITY];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                if (o == null) {
                    return true;
                }
            } else if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[current];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        return toArray(array);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] array = a;
        for (int i = 0; i < size; i++) {
            array[i] = data[i];
        }
        return (T1[]) array;
    }

    @Override
    public boolean add(T t) {
        if (size == data.length) {
            int newLength = (data.length * 3) / 2 + 1;
            data = Arrays.copyOf(data, newLength);
        }
        data[size++] = t;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        data = new Object[CAPACITY];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }

    @Override
    public T set(int index, T element) {
        T prevElement = (T) data[index];
        data[index] = element;
        return prevElement;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == data.length) {
            int newLength = (data.length * 3) / 2 + 1;
            data = Arrays.copyOf(data, newLength);
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
    }

    @Override
    public T remove(int index) {
        int length = data.length - index;
        T value = (T) data[index];
        System.arraycopy(data, index + 1, data, index, length - 1);
        size--;
        return value;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIterator<T>() {
            int current = index;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[current++];
            }

            @Override
            public boolean hasPrevious() {
                return current > 0;
            }

            @Override
            public T previous() {
                if(!hasPrevious()){
                    throw new NoSuchElementException();
                }
                return (T) data[current--];
            }

            @Override
            public int nextIndex() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return current + 1;
            }

            @Override
            public int previousIndex() {
                if(!hasPrevious()){
                    throw new NoSuchElementException();
                }
                return current - 1;
            }

            @Override
            public void remove() {
                CustomArrayList.this.remove(data[current--]);
            }

            @Override
            public void set(T element) {
                data[index] = element;
            }

            @Override
            public void add(T element) {
                CustomArrayList.this.add(current++, element);
            }
        };
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
