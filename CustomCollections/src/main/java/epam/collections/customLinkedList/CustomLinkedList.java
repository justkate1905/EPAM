package epam.collections.customLinkedList;

import java.nio.file.NoSuchFileException;
import java.util.*;

public class CustomLinkedList<T> implements List<T> {

    private Node<T> head = new Node<>(null);
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !head.hasNext();
    }

    @Override
    public boolean contains(Object o) {
        Node<T> node = head;
        while (node.hasNext()) {
            node = node.next;
            if (node.value == null) {
                if (o == null) {
                    return true;
                }
            } else if (node.value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current.hasNext();
            }

            @Override
            public T next() {
                current = current.next;
                return current.value;
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
        Node<T> current = head;
        Object[] array = a;
        int index = 0;
        while (current.hasNext()) {
            current = current.next;
            array[index] = current.value;
            index += 1;
        }
        return (T1[]) array;
    }

    @Override
    public boolean add(T t) {
        Node<T> iterator = head;

        while (iterator.hasNext()) {
            iterator = iterator.next;
        }
        iterator.next = new Node<>(t);
        size++;
        return false;

    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head.next;
        Node<T> prev = head;
        while (current != null) {
            if (o.equals(current.value)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
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
    public void clear() {
        head = new Node<>(null);
        size = 0;
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).value;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        T currentElem = getNodeByIndex(index).value;
        getNodeByIndex(index).value = element;
        return currentElem;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> previous;
        Node<T> insertNode = new Node<T>(element);

        if (index != 0) {
            previous = getNodeByIndex(index - 1);
            insertNode.next = previous.next;
            previous.next = insertNode;
        } else {
            insertNode.next = head.next;
            head.next = insertNode;
        }


        size++;
    }

    @Override
    public T remove(int index) {
        Node<T> current = getNodeByIndex(index - 1);
        size--;
        T value = current.next.value;
        current.next = current.next.next;
        return value;
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
                return getNodeByIndex(current++).value;
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
                return getNodeByIndex(current - 1).value;
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
                CustomLinkedList.this.remove(getNodeByIndex(current--));
            }

            @Override
            public void set(T element) {
                getNodeByIndex(index).value = element;
            }

            @Override
            public void add(T element) {
                CustomLinkedList.this.add(current++, element);
            }
        };
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private Node<T> getNodeByIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    private class Node<T> {

        private Node<T> next;
        private T value;

        Node(T value) {
            this.value = value;
        }

        boolean hasNext() {
            return next != null;
        }

    }
}
