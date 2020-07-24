package collection;

import java.util.*;

public class MultiDimensionalArray<E> implements Array<E> {

    private Map<Integer, List<E>> arrayElementsContainer;
    private int numberOfRows;

    public MultiDimensionalArray(int numbersOfRow){
        this.numberOfRows = numbersOfRow;
        arrayElementsContainer = new HashMap<>();
        for(int i = 0 ; i < numbersOfRow ; i++){
            arrayElementsContainer.put(i, new ArrayList<>());
        }
    }

    @Override
    public boolean add(E element, int row) {
        isRowInRange(row);

        List<E> specifyRow = getRow(row);
        specifyRow.add(element);
        return true;
    }

    @Override
    public boolean add(E element, int row, int column) {
        isRowInRange(row);
        List<E> specifyRow = getRow(row);

        isColumnInRange(column, specifyRow);

        specifyRow.add(column, element);
        return true;
    }

    @Override
    public boolean removeRow(int row) {
        isRowInRange(row);
        Map<Integer, List<E>> arrayAfterRemove = new HashMap<>();
        for(int i = 0 ; i < numberOfRows ; i++){
            if(i < row)
                arrayAfterRemove.put(i, arrayElementsContainer.get(i));
            else if(i > row)
                arrayAfterRemove.put(i - 1, arrayElementsContainer.get(i));
        }
        this.numberOfRows = arrayAfterRemove.size();
        this.arrayElementsContainer = arrayAfterRemove;
        return true;
    }

    @Override
    public boolean removeElement(int row, int column) {
        isRowInRange(row);
        List<E> specifyRow = getRow(row);

        isColumnInRange(column, specifyRow);

        specifyRow.remove(column);
        return true;
    }

    @Override
    public boolean set(E element, int row, int column) {
        isRowInRange(row);

        List<E> specifyRow = getRow(row);

        isColumnInRange(column, specifyRow);

        specifyRow.add(column, element);
        return true;
    }

    @Override
    public E get(int row, int column) {
        isRowInRange(row);

        List<E> specifyRow = getRow(row);

        isColumnInRange(column, specifyRow);

        List<E> specifiedRow = getRow(row);

        return specifiedRow.get(column);
    }

    @Override
    public int size() {
        int counter = 0;
        for(int i  = 0 ; i < numberOfRows ; i++){
            counter += getRow(i).size();
        }
        return counter;
    }

    @Override
    public int size(int row) {
        isRowInRange(row);

        return getRow(row).size();
    }

    @Override
    public void clear() {
        arrayElementsContainer.clear();
        this.numberOfRows = arrayElementsContainer.size();
    }

    @Override
    public void clearRow(int row) {
        isRowInRange(row);
        List<E> specifiedRow = getRow(row);
        specifiedRow.clear();
    }

    @Override
    public boolean contains(E element) {
        for(int i = 0 ; i < numberOfRows ; i++){
            for(E value : arrayElementsContainer.get(i)){
                if(value.equals(element))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAtRow(E element, int row) {
        isRowInRange(row);
        List<E> specifiedRow = getRow(row);

        for(E value : specifiedRow)
            if(value.equals(element))
                return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MultiDimensionalArrayIterator<E>(toList());
    }

    @Override
    public void trimToSize() {
        Map<Integer, List<E>> arrayAfterRemove = new HashMap<>();
        int newIndex = 0;

        for(int i = 0 ; i < numberOfRows ; i++){
            List<E> row = getRow(i);
            if(row.size() > 0)
                arrayAfterRemove.put(newIndex++, row);
        }
        this.numberOfRows = arrayAfterRemove.size();
        this.arrayElementsContainer = arrayAfterRemove;
    }

    @Override
    public List<E> toList() {
        List<E> resultList = new ArrayList<>();
        for(int i = 0 ; i < numberOfRows ; i++){
            resultList.addAll(getRow(i));
        }
        return resultList;
    }

    public void isRowInRange(int row) {
        if(row > numberOfRows - 1 || row < 0)
            throw new IndexOutOfBoundsException("Not enough rows");
    }

    public void isColumnInRange(int column, List<E> specifyRow) {
        if(column > specifyRow.size() - 1 || column < 0)
            throw new IndexOutOfBoundsException("Not enough column");
    }

    public List<E> getRow(int row){
        isRowInRange(row);
        return arrayElementsContainer.get(row);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }
}
