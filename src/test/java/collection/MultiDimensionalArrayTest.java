package collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MultiDimensionalArrayTest {

    @Test
    public void shouldThrowIndexOutOfBoundsExceptionWhenRowIsOutOfRange(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);

        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() ->array.isRowInRange(2));
    }

    @Test
    public void shouldReturnTrueWhenElementHasBeenAddedAtSpecifyRowCorrectly(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);

        //when
        boolean result = array.add(5, 0);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenElementHasBeenAddedAtSpecifyPositionCorrectly(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(3, 0);

        //when
        boolean result = array.add(5, 0, 0);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void elementsInTheArrayShouldBeInTheCorrectOrder(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(5, 0);
        array.add(4, 0);
        array.add(3, 0, 0);

        //when
        int element1 = array.get(0,0);
        int element2 = array.get(0,1);
        int element3 = array.get(0,2);

        //then
        assertThat(element1).isEqualTo(3);
        assertThat(element2).isEqualTo(5);
        assertThat(element3).isEqualTo(4);
    }

    @Test
    public void shouldThrowIndexOutOfBoundsExceptionWhenColumnIsOutOfRange(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(4, 0);
        List<Integer> specifiedRow = array.getRow(0);

        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() ->array.isColumnInRange(1, specifiedRow));
    }

    @Test
    public void shouldReturnTrueWhenElementHasBeenChangedAtSpecifyPositionCorrectly(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(4, 0);

        //when
        boolean result = array.set(5, 0, 0);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnCorrectMultiDimensionalArraySize(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(4, 0);
        array.add(3, 0);
        array.add(null, 0);

        //when
        int size = array.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @Test
    public void shouldReturnCorrectSizeOfTheSpecifiedRow(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(4, 0);
        array.add(3, 0);
        array.add(null, 0);

        //when
        int size = array.size(0);

        //then
        assertThat(size).isEqualTo(3);
    }

    @Test
    public void shouldReturnSpecifiedRow(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(4, 0);
        array.add(3, 0);
        array.add(null, 0);

        //when
        List<Integer> specifiedRow = array.getRow(0);

        //then
        assertThat(specifiedRow.get(0)).isEqualTo(4);
        assertThat(specifiedRow.get(1)).isEqualTo(3);
        assertThat(specifiedRow.get(2)).isEqualTo(null);
    }

    @Test
    public void shouldReturnCorrectElementAtSpecifiedPosition(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(4, 0);

        //when
        int element1 = array.get(0, 0);

        //then
        assertThat(element1).isEqualTo(4);
    }

    @Test
    public void arrayShouldNotContainsElementsAfterClear(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(4, 0);
        array.add(5, 0);

        //when
        array.clear();
        int actualArraySize = array.size();

        //then
        assertThat(actualArraySize).isEqualTo(0);
    }

    @Test
    public void arrayShouldNotContainsElementsAtSpecifiedRowAfterClear(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(4, 0);
        array.add(5, 0);

        //when
        array.clearRow(0);
        int actualRowSize = array.getRow(0).size();

        //then
        assertThat(actualRowSize).isEqualTo(0);
    }

    @Test
    public void shouldReturnListThatContainsAllElementsFromTheArray(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        //when
        List<Integer> resultList = array.toList();

        //then
        assertThat(resultList.size()).isEqualTo(3);
    }

    @Test
    public void shouldReturnListThatContainsAllElementsFromTheArrayInCorrectOrder(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        //when
        List<Integer> resultList = array.toList();
        int element1 = resultList.get(0);
        int element2 = resultList.get(1);
        int element3 = resultList.get(2);

        //then
        assertThat(element1).isEqualTo(4);
        assertThat(element2).isEqualTo(5);
        assertThat(element3).isEqualTo(6);
    }


    @Test
    public void shouldContainsCorrectElementsAfterRemoveRow(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        //when
        array.removeRow(0);
        List<Integer> elementsAfterRemoveRow = array.toList();

        //then
        assertThat(elementsAfterRemoveRow).containsExactly(6);
    }

    @Test
    public void shouldChangeIndexesOfRowSmallerThanTheRowBeingDeleted(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        //when
        List<Integer> oldRowLocation =  array.getRow(1);
        array.removeRow(0);
        List<Integer> newRowLocation = array.getRow(0);

        //then
        assertThat(oldRowLocation).isSameAs(newRowLocation);
    }

    @Test
    public void shouldNotChangeIndexesOfRowBiggerThanTheRowBeingDeleted(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        //when
        List<Integer> oldRowLocation =  array.getRow(0);
        array.removeRow(1);
        List<Integer> newRowLocation = array.getRow(0);

        //then
        assertThat(oldRowLocation).isSameAs(newRowLocation);
    }

    @Test
    public void shouldRemoveCorrectElementAtSpecifyPosition(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        //when
        array.removeElement(0, 0);
        List<Integer> rowAfterRemoveElement = array.getRow(0);

        //then
        assertThat(rowAfterRemoveElement).containsExactly(5);
    }

    @Test
    public void shouldReturnTrueWhenSpecifyElementIsOnTheArray(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        int searchedElement = 6;

        //when
        boolean result = array.contains(searchedElement);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenSpecifyElementIsNotOnTheArray(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        int searchedElement = 7;

        //when
        boolean result = array.contains(searchedElement);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenSpecifyElementIsOnTheSpecifyRow(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        int searchedElement = 6;
        int specifyRow = 1;

        //when
        boolean result = array.containsAtRow(searchedElement, specifyRow);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenSpecifyElementIsNotOnTheSpecifyRow(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(4, 0);
        array.add(5, 0);
        array.add(6, 1);

        int searchedElement = 7;
        int specifyRow = 1;

        //when
        boolean result = array.containsAtRow(searchedElement, specifyRow);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnCorrectNumbersOfRows(){
        //given
        int numberOfRows = 3;
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(numberOfRows);

        //when
        int result = array.getNumberOfRows();

        //then
        assertThat(result).isEqualTo(numberOfRows);
    }

    @Test
    public void shouldReturnMultiDimensionalArrayIterator(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(3);

        int inputElement1 = 5;
        int inputElement2 = 1;
        int inputElement3 = 2;

        array.add(inputElement1, 0);
        array.add(inputElement2, 0);
        array.add(inputElement3, 0);

        //when
        Iterator<Integer> arrayIterator = array.iterator();
        int resultElement1 = arrayIterator.next();
        int resultElement2 = arrayIterator.next();
        int resultElement3 = arrayIterator.next();

        //then
        assertThat(resultElement1).isEqualTo(inputElement1);
        assertThat(resultElement2).isEqualTo(inputElement2);
        assertThat(resultElement3).isEqualTo(inputElement3);

        assertThat(arrayIterator.getClass()).isEqualTo(MultiDimensionalArrayIterator.class);
    }

    @Test
    public void arrayAfterTrimShouldHaveCorrectNumbersOfRow(){
        //given
        int numberOfRows = 3;
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(numberOfRows);
        array.add(5, 0);

        //when
        array.trimToSize();
        int newNumbersOfRow = array.getNumberOfRows();

        //then
        assertThat(newNumbersOfRow).isEqualTo(1);
    }

    @Test
    public void arrayAfterTrimShouldChangeTheStructure(){
        //given
        int numberOfRows = 3;
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(numberOfRows);
        array.add(5, 1);
        List<Integer> listWithOldLocation = array.getRow(1);

        //when
        array.trimToSize();
        List<Integer> listWithNewLocation = array.getRow(0);

        //then
        assertThat(listWithNewLocation).isSameAs(listWithOldLocation);
    }

    @Test
    public void theSameRowAfterTrimShouldKeepTheSameElements(){
        //given
        int numberOfRows = 3;
        int element1 = 5;
        int element2 = 3;

        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(numberOfRows);
        array.add(element1, 0);
        array.add(element2, 0);
        //when
        array.trimToSize();
        List<Integer> listWithNewLocation = array.getRow(0);

        //then
        assertThat(listWithNewLocation).containsExactly(5, 3);
    }
}