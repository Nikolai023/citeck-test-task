package ngerasimenko.citecktesttask.list;

import java.util.Objects;

public class IntEntry {
    private final int key;
    private final long value;

    public IntEntry(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public static IntEntry of(int key, int value) {
        return new IntEntry(key, value);
    }

    public int getKey() {
        return key;
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntEntry intEntry = (IntEntry) o;
        return key == intEntry.key &&
                value == intEntry.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
