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
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), IntEntry.of(1, 1));
    }

    @Test
    public void simpleListTest() {
        List<Integer> intList = Arrays.asList(1, 3, 3, 3, 2, 2, 4, 4, 4, 4);

        List<IntEntry> result = converter.convert(intList);
        assertEquals(result.size(), 4);
        assertEquals(result.get(0), IntEntry.of(4, 4));
        assertEquals(result.get(1), IntEntry.of(3, 3));
        assertEquals(result.get(2), IntEntry.of(2, 2));
        assertEquals(result.get(3), IntEntry.of(1, 1));
    }

    @Test
    public void repeatableCountsTest() {
        List<Integer> intList = Arrays.asList(1, 3, 3, 2, 2, 4);

        List<IntEntry> result = converter.convert(intList);
        assertEquals(result.size(), 4);
        assertEquals(result.get(0), IntEntry.of(2, 2));
        assertEquals(result.get(1), IntEntry.of(3, 2));
        assertEquals(result.get(2), IntEntry.of(1, 1));
        assertEquals(result.get(3), IntEntry.of(4, 1));
    }
}