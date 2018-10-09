package com.nixsolutions.study.laba10;

import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class ArrayCollectionImplTest {
    private final ArrayCollection collection = new ArrayCollectionImpl();
    private static final Integer[] INTEGERS_ARRAY = { 0, 1, 2, 3, 4 };
    private final List<Integer> integers = Arrays.stream(INTEGERS_ARRAY)
            .collect(Collectors.toList());
    private final List<Double> doubles = Arrays.asList(0d, 1d, 2d, 3d, 4d);
    private Object first;
    private Object second;
    private Object third;

    @Before public void setUp() throws Exception {
        first = new Object();
        second = new Object();
        third = null;

    }

    @After public void tearDown() throws Exception {
        collection.setArray(new Object[0]);
    }

    private ArrayCollection<Double> arrayCollection = null;
    private Double[] doubleArray = {1d, 2d, 3d};
    private int size = doubleArray.length;

    @Before
    public void before() {
        arrayCollection = new ArrayCollectionImpl<>();
    }

    private void setArrayCollection() {
        arrayCollection.setArray(doubleArray);
    }

    @Test
    public void setArrayNull() {
        try {
            arrayCollection.setArray(null);
            fail(" should throw NullPointerException "
                    + "on setArray(null)");
        } catch (NullPointerException e) {
            //
        }
    }

    @Test
    public void setArray() {
        setArrayCollection();

        assertArrayEquals("should set an array to collection",
                doubleArray, arrayCollection.getArray());
    }

    @Test
    public void getArrayEmpty() {
        Double [] emptyDoubleArray = new Double[]{};

        assertArrayEquals("should return empty array in right type",
                emptyDoubleArray, arrayCollection.getArray());
    }

    @Test
    public void sizeZero_WhenCollectionIsEmpty() {
        assertEquals("should return zero if collection is empty",
                0, arrayCollection.size());
    }

    @Test
    public void sizeOne_WhenOneElementIn() {
        arrayCollection.setArray(new Double[]{1d});

        assertEquals("should return 1 if collection has 1 element",
                1, arrayCollection.size());
    }

    @Test
    public void sizeNotZero_WhenCollectionNotEmpty() {
        setArrayCollection();

        assertEquals("should return correct size of collection",
                size, arrayCollection.size());
    }

    @Test
    public void isEmpty_ReturnTrue() {
        assertTrue("should return true if collection is empty",
                arrayCollection.isEmpty());
    }

    @Test
    public void isEmpty_ReturnFalse() {
        setArrayCollection();

        assertFalse("should return false if collection isn't empty",
                arrayCollection.isEmpty());
    }

    @Test
    public void containsDefunct_ReturnFalse() {
        setArrayCollection();

        assertFalse("should return false if collection doesn't contains element",
                arrayCollection.contains(-3d));
    }

    @Test
    public void containsExisting_ReturnTrue() {
        setArrayCollection();

        assertTrue("should return true if collection contains element",
                arrayCollection.contains(doubleArray[0]));
    }

    @Test
    public void toArray_ReturnsCorrectArray() {
        setArrayCollection();

        assertArrayEquals("should return correct array of needed type",
                doubleArray, arrayCollection.getArray());
    }

    @Test
    public void add_ReturnsTrueIfAdded() {
        assertTrue("should return true if added an element",
                arrayCollection.add(1d));
    }

    @Test
    public void add_ChangesSize() {
        int previousSize = arrayCollection.getArray().length;

        arrayCollection.add(1d);
        int afterSize = arrayCollection.getArray().length;

        assertEquals("collection's size should grow up by 1 after add()",
                previousSize + 1, afterSize);

    }

    @Test
    public void add_LastElementIsAddedOne() {
        setArrayCollection();

        Double element = -100500d;
        int size = arrayCollection.getArray().length;

        arrayCollection.add(element);
        assertEquals("last element in collection should be the one," +
                "which was added last ", element, arrayCollection.getArray()[size]);
    }

    @Test
    public void add_ShouldAddNull() {
        setArrayCollection();

        arrayCollection.add(null);

        assertNull("last element in collection should be the null",
                arrayCollection.getArray()[size]);
    }

    @Test
    public void add_ShouldAddDuplicates() {
        arrayCollection.add(100500d);
        arrayCollection.add(100500d);

        assertEquals("collection size must be 2 after adding two duplicates",
                2, arrayCollection.getArray().length);
    }

    @Test
    public void remove_ReturnsTrueIfDeleted() {
        setArrayCollection();

        assertTrue("should return true if element has been deleted",
                arrayCollection.remove(doubleArray[0]));
    }

    @Test
    public void remove_RemovesElementFromCollection() {
        setArrayCollection();
        Double element = doubleArray[0];

        arrayCollection.remove(element);

        assertFalse(arrayCollection.contains(element));
    }

    @Test
    public void remove_RemovesOnlyOneDuplicate() {
        arrayCollection.add(doubleArray[0]);
        arrayCollection.add(doubleArray[0]);
        int previousSize = arrayCollection.getArray().length;

        arrayCollection.remove(doubleArray[0]);
        int afterSize = arrayCollection.getArray().length;

        assertEquals("if collection contains two duplicates," +
                " remove() should delete only one", previousSize - 1, afterSize);
    }

    @Test
    public void remove_ReturnsFalseIfNoSuchObjectIn() {
        setArrayCollection();

        assertFalse("should return false if no such element in collection",
                arrayCollection.remove(100500d));
    }

    @Test
    public void remove_NotChangeSizeWhenNoElementIn() {
        setArrayCollection();
        int previousSize = arrayCollection.getArray().length;

        arrayCollection.remove(100500d);
        int afterSize = arrayCollection.getArray().length;

        assertEquals("Size doesn't change when removing wasn't occured ",
                previousSize, afterSize);

    }

    @Test
    public void addAllNull_ShouldThrowNullPointerException() {
        setArrayCollection();
        List<Double> list = null;

        try {
            arrayCollection.addAll(list);
            fail("should throw NullPointerException if addAll(null)");
        } catch (Exception e) {
            /*NOP*/
        }
    }

    @Test
    public void addAll_AmountOfElementsShouldBeCorrect() {
        setArrayCollection();
        List<Double> list = new ArrayList<>();
        list.add(1d);
        list.add(5d);

        int previousSize = arrayCollection.getArray().length;
        arrayCollection.addAll(list);

        assertEquals("Size of collection after addAll() should be sum" +
                        " of 2 collections", list.size() + previousSize,
                arrayCollection.size());
    }

    @Test
    public void clear_SizeShouldBeZero() {
        setArrayCollection();

        arrayCollection.clear();

        assertEquals("After clear() size should be 0",
                0, arrayCollection.size());
    }

    @Test
    public void clear_ShouldNullifyArray() {
        setArrayCollection();

        arrayCollection.clear();

        assertEquals("After clear() array should be empty",
                0, arrayCollection.getArray().length);
    }

    @Test
    public void containsAllNull_ShouldThrowNullPointerException() {
        setArrayCollection();
        List<Double> list = null;

        try {
            arrayCollection.containsAll(list);
            fail("Should throw NullPointerException if containsAll(null)");
        } catch (Exception e) {
            /*NOP*/
        }
    }

    @Test
    public void containsAllFalse_ReturnsFalseIfContainsNotAllElements() {
        setArrayCollection();
        List<Double> list = new ArrayList<>();
        list.add(doubleArray[0]);
        list.add(100500d);

        assertFalse("Should return false if collection does not" +
                "contains at leas 1 element", arrayCollection.containsAll(list));
    }

    @Test
    public void containsAllTrue_ReturnsTrueIfContainsAllElements() {
        setArrayCollection();
        List<Double> list = new ArrayList<>();
        list.add(doubleArray[0]);
        list.add(doubleArray[1]);

        assertTrue("Should return true if collection all elements"
                , arrayCollection.containsAll(list));
    }


    @Test
    public void removeAllNull_ShouldThrowNullPointerException() {
        setArrayCollection();
        List<Double> list = null;

        try {
            arrayCollection.removeAll(list);
            fail("Should throw NullPointerException if removeAll(null)");
        } catch (Exception e) {
            /*NOP*/
        }
    }

    @Test
    public void retainAllNull_ShouldThrowNullPointerException() {
        setArrayCollection();
        List<Double> list = null;

        try {
            arrayCollection.retainAll(list);
            fail("Should throw NullPointerException if removeAll(null)");
        } catch (Exception e) {
            /*NOP*/
        }
    }

    @Test
    public void iterator_ReturnsRightClass(){
        assertTrue("if iterator() returns right class",
                arrayCollection.iterator() instanceof ArrayIterator);
    }

}