package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for(int i  = 0 ; i < arrayElementsContainer.size() ; i++){
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
    }

    @Override
    public void clearRow(int row) {
        isRowInRange(row);
        List<E> specifiedRow = getRow(row);
        specifiedRow.clear();
    }

    @Override
    public List<E> toList() {
        List<E> resultList = new ArrayList<>();
        for(int i = 0 ; i < arrayElementsContainer.size() ; i++){
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
}
