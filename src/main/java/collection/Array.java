package collection;

import java.util.List;

public interface Array<E> {

    /**
     *  Appends element to the end of specified row in this MultiDimensionalArray
     * @param element element to be appended to specify row
     * @param row specified row indexing from 0
     * @return true if element has been added
     * @throws IndexOutOfBoundsException if the row is out of range
     */
    public boolean add(E element, int row);

    /**
     * Inserts the specified element at the specified position in this MultiDimensionalArray.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right
     * @param element added element
     * @param row specified row indexing from 0
     * @param column specified column indexing from 0
     * @return true if element has been added
     * @throws IndexOutOfBoundsException if the row or column is out of range
     */
    public boolean add(E element, int row, int column);

    /**
     * Removes the row in this MultiDimensionalArray
     * @param row specified row that will be removed indexing from 0
     * @return true if row has been removed
     * @throws IndexOutOfBoundsException if the row is out of range
     */
    public boolean removeRow(int row);

    /**
     * Removes the element at the specified position in this MultiDimensionalArray
     * @param row specified row indexing from 0
     * @param column specified column indexing from 0
     * @return true if element has been removed
     * @throws IndexOutOfBoundsException if the row or column is out of range
     */
    public boolean removeElement(int row, int column);

    /**
     * Replaces the element at the specified position in this MultiDimensionalArray
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
     * Returns the element at the specified position in this MultiDimensionalArray.
     * @param row specified row indexing from 0
     * @param column specify column indexing from 0
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the row or column is out of range
     */
    public E get(int row, int column);

    /**
     * Removes all of the elements from this MultiDimensionalArray
     */
    public void clear();

    /**
     * Removes all of the elements in specified row from this MultiDimensionalArray
     * @param row specified row indexing from 0
     * @throws IndexOutOfBoundsException if the row is out of range
     */
    public void clearRow(int row);

    /**
     * Returns the List containing all of the elements in this MultiDimensionalArray in proper sequence (from first to last element).
     * @return List containing all of the elements in this MultiDimensionalArra
     */
    public List<E> toList();
}
