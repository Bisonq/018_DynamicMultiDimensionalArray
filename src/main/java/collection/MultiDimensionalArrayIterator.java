package collection;

import java.util.Iterator;
import java.util.List;

public class MultiDimensionalArrayIterator<E> implements Iterator<E> {

    private Iterator<E> arrayElementsIterator;

    public MultiDimensionalArrayIterator(List<E> arrayElements) {
        this.arrayElementsIterator = arrayElements.iterator();
    }

    @Override
    public boolean hasNext() {
        return arrayElementsIterator.hasNext();
    }

    @Override
    public E next() {
        return arrayElementsIterator.next();
    }
}
