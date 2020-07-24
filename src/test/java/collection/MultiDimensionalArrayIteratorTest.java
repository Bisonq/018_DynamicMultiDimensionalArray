package collection;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


public class MultiDimensionalArrayIteratorTest {

    @Test
    public void shouldReturnTrueIfThereAreStillElementsInTheArray(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(5, 0);
        array.add(4,1);

        MultiDimensionalArrayIterator<Integer> iterator = new MultiDimensionalArrayIterator<>(array.toList());

        //when
        boolean result = iterator.hasNext();

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseIfThereAreNotElementsInTheArray(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(5, 0);

        MultiDimensionalArrayIterator<Integer> iterator = new MultiDimensionalArrayIterator<>(array.toList());

        //when
        iterator.next();
        boolean result = iterator.hasNext();

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnCorrectElement(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);
        array.add(5, 0);

        MultiDimensionalArrayIterator<Integer> iterator = new MultiDimensionalArrayIterator<>(array.toList());

        //when

        int result = iterator.next();

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void shouldReturnElementsInCorrectOrder(){
        //given
        MultiDimensionalArray<Integer> array = new MultiDimensionalArray<>(2);

        int element1 = 5;
        int element2 = 10;

        array.add(element1, 0);
        array.add(element2, 0);

        MultiDimensionalArrayIterator<Integer> iterator = new MultiDimensionalArrayIterator<>(array.toList());

        //then
        assertThat(iterator.next()).isEqualTo(element1);
        assertThat(iterator.next()).isEqualTo(element2);
    }
}