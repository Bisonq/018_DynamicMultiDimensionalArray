package collection;

public interface Array<E> {

    /**
     *  Appends element to the end of specified row
     * @param element element to be appended to the Array
     * @param row specified row indexing from 0
     * @return true if element has been added
     * @throws IndexOutOfBoundsException if the row is out of range
     */
    public boolean add(E element, int row);

    /**
     * Replaces the element at the specified row in specify column
     * @param element new element
     * @param row specified row indexing from 0
     * @param column specify column indexing from 0
     * @return true if element has been replaced
     * @throws IndexOutOfBoundsException if the row or column is out of range
     */
    public boolean set(E element, int row, int column);

    /**
     * Return the numbers of elements in this MultiDimensionalArray
     * @return the numbers of elements
     */
    public int size();

    /**
     * Return the numbers of elements in specified row in this MultiDimensionalArray
     * @param row specified row indexing from 0
     * @return the numbers of elements in specified row
     * @throws IndexOutOfBoundsException if the row is out of range
     */
    public int size(int row);

    /**
     * Returns the element at the specified position in this list.
     * @param row specified row indexing from 0
     * @param column specify column indexing from 0
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the row or column is out of range
     */
    public E get(int row, int column);
}
