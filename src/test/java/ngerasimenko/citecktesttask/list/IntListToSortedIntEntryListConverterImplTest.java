package ngerasimenko.citecktesttask.list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class IntListToSortedIntEntryListConverterImplTest {

    private IntListToIntEntryListConverter converter;

    @Autowired
    public IntListToSortedIntEntryListConverterImplTest(IntListToIntEntryListConverter converter) {
        this.converter = converter;
    }

    @Test
    public void emptyListTest() {
        List<Integer> emptyList = Collections.emptyList();

        assertTrue(converter.convert(emptyList).isEmpty());
    }

    @Test
    public void singleEntityListTest() {
        List<Integer> singleEntityList = Collections.singletonList(1);

        List<IntEntry> result = converter.convert(singleEntityList);
        assertEquals(1, result.size());
        assertEquals(IntEntry.of(1, 1), result.get(0));
    }

    @Test
    public void simpleListTest() {
        List<Integer> intList = Arrays.asList(1, 3, 3, 3, 2, 2, 4, 4, 4, 4);

        List<IntEntry> result = converter.convert(intList);
        assertEquals(4, result.size());
        assertEquals(IntEntry.of(4, 4), result.get(0));
        assertEquals(IntEntry.of(3, 3), result.get(1));
        assertEquals(IntEntry.of(2, 2), result.get(2));
        assertEquals(IntEntry.of(1, 1), result.get(3));
    }

    @Test
    public void repeatableCountsTest() {
        List<Integer> intList = Arrays.asList(1, 3, 3, 2, 2, 4);

        List<IntEntry> result = converter.convert(intList);
        assertEquals(4, result.size());
        assertEquals(IntEntry.of(2, 2), result.get(0));
        assertEquals(IntEntry.of(3, 2), result.get(1));
        assertEquals(IntEntry.of(1, 1), result.get(2));
        assertEquals(IntEntry.of(4, 1), result.get(3));
    }
}