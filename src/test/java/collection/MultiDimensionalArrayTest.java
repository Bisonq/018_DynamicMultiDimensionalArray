package collection;

import org.junit.Test;

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
    public void shouldReturnTrueWhenElementHasBeenAddedInSpecifyRowCorrectly(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);

        //when
        boolean result = array.add(5, 0);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void elementsInTheArrayShouldBeInTheCorrectOrder(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(5, 0);
        array.add(4, 0);
        array.add(3, 0);

        //when
        int element1 = array.get(0,0);
        int element2 = array.get(0,1);
        int element3 = array.get(0,2);

        //then
        assertThat(element1).isEqualTo(5);
        assertThat(element2).isEqualTo(4);
        assertThat(element3).isEqualTo(3);
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
    public void shouldReturnTrueWhenElementHasBeenChangedInSpecifyRowInSpecifyColumnCorrectly(){
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
    public void shouldReturnCorrectSizeInSpecifiedRow(){
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
    public void shouldReturnCorrectElementInSpecifiedRowInSpecifiedColumn(){
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(1);
        array.add(4, 0);

        //when
        int element1 = array.get(0, 0);

        //then
        assertThat(element1).isEqualTo(4);
    }
}