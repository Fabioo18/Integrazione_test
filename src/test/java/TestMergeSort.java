
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;
import org.example.MergeSort;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class TestMergeSort
{
    //T1 e T2
    @Test
    @DisplayName("arrIsNullorEmpty")
    void arrIsNullorEmpty()
    {
        assertNull(MergeSort.mergeSort(null, new int[]{1}, new int[]{2,3}));
        assertArrayEquals(new int[]{},MergeSort.mergeSort(new int[]{}, new int[]{1}, new int[]{2, 3}));
    }

    //T3 e T4
    @Test
    @DisplayName("lIsNullorEmpty")
    void lIsNullorEmpty()
    {
        assertNull(MergeSort.mergeSort(new int[]{3,5,7}, null, new int[]{5,7}));
        assertArrayEquals(new int[]{3,5,7},MergeSort.mergeSort(new int[]{3,5,7}, new int[]{}, new int[]{5,7}));
    }

    //T5 e T6
    @Test
    @DisplayName("rIsNullorEmpty")
    void rIsNullorEmpty()
    {
        assertNull(MergeSort.mergeSort(new int[]{3,5,7}, new int[]{3}, null));
        assertArrayEquals(new int[]{3,5,7},MergeSort.mergeSort(new int[]{3,5,7}, new int[]{3}, new int[]{}));
    }

    //Boundary tests T7,T8,79,10
    @ParameterizedTest
    @MethodSource("intArrayProvider")
    @DisplayName("arrOfLength1")
    void arrOfLength1(int[] arr, int[] l , int [] r)
    {
        assertArrayEquals(arr,MergeSort.mergeSort(arr, l, r));
    }

    static Stream<Arguments> intArrayProvider()
    {
        return Stream.of(
                arguments(new int[]{2}, new int[]{}, new int[]{2}), //T7
                arguments(new int[]{2}, new int[]{0}, new int[]{2}), //T8
                arguments(new int[]{1000}, new int[]{}, new int[]{1001}), // il test T9 ci ha permesso di cambiare la condizione nel codice a riga 26 e i due test T7 e T9
                arguments(new int[]{1000}, new int[]{0}, new int[]{1001})); // T10
    }

    //T11,T12,T13,T14
    @ParameterizedTest
    @MethodSource("intArrayProvider2")
    @DisplayName("arrOfLengthMajorThan1")
    void arrOfLengthMajorThan1(int[] arr, int[] l , int [] r)
    {
        assertArrayEquals(arr,MergeSort.mergeSort(arr, l, r));
    }

    static Stream<Arguments> intArrayProvider2()
    {
        return Stream.of(
                arguments(new int[]{4,5,10,7,1,2}, new int[]{4,5,10}, new int[]{7,1,2}),//T11
                arguments(new int[]{4,5,10,7,1,2}, new int[]{}, new int[]{7,1,2}), //T12
                arguments(new int[]{4,5,10,7,1,2}, new int[]{4,5,10}, new int[]{}), // T13
                arguments(new int[]{4,5,10,7,1,2}, new int[]{}, new int[]{})); // T14
    }

    //Boundary tests T15,T16
    @ParameterizedTest
    @MethodSource("intArrayProvider3")
    @DisplayName("BoundaryTests")
    void BoundaryTests(int[] arr, int[] l , int [] r)
    {
        assertArrayEquals(arr,MergeSort.mergeSort(arr, l, r));
    }

    static Stream<Arguments> intArrayProvider3()
    {
        return Stream.of(
                arguments(new int[]{1,5,10,27,30,35}, new int[]{1,5,10}, new int[]{27,30,35}),//T15
                arguments(new int[]{35,5,10,27,30}, new int[]{35,5}, new int[]{10,27,30}));//T16
    }

    //T17,T18,T19,T20,T21,T22,T23,T24
    @ParameterizedTest
    @MethodSource("intArrayProvider4")
    @DisplayName("AugmentedTests")
    void AugmentedTests(int[] arr, int[] l , int [] r)
    {
        assertArrayEquals(arr,MergeSort.mergeSort(arr, l, r));
    }

    static Stream<Arguments> intArrayProvider4()
    {
        return Stream.of(
                arguments(new int[]{-1,25,-100,-270,3000,15}, new int[]{-1,25,-100}, new int[]{-270,3000,15}),//T17
                arguments(new int[]{-1000,-10,-2034,-1,-30}, new int[]{-1000,-10}, new int[]{-2034,-1,-30}),//T18
                arguments(new int[]{1,5,10,5,30,40}, new int[]{1,5,10}, new int[]{5,30,40}),//T19
                arguments(new int[]{40,35,20,4,0}, new int[]{40,35}, new int[]{20,4,0}),//T20
                arguments(new int[]{Integer.MAX_VALUE,5,10}, new int[]{Integer.MAX_VALUE}, new int[]{5,10}),//T21
                arguments(new int[]{Integer.MIN_VALUE,5,10}, new int[]{Integer.MIN_VALUE}, new int[]{5,10}),//T22
                arguments(new int[]{Integer.MIN_VALUE,5,Integer.MAX_VALUE}, new int[]{Integer.MIN_VALUE}, new int[]{5,Integer.MAX_VALUE}),//T23
                arguments(new int[]{35,5,10,27,30}, new int[]{35,5}, new int[]{10,27,30}));//T24
    }

}
