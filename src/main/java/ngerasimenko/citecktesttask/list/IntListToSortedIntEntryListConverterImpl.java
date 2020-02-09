package ngerasimenko.citecktesttask.list;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class IntListToSortedIntEntryListConverterImpl implements IntListToIntEntryListConverter {
    public static final Comparator<IntEntry> COMPARATOR =
            Comparator.comparing(IntEntry::getValue).reversed()
                    .thenComparing(IntEntry::getKey);

    public List<IntEntry> convert(List<Integer> intList) {
        Map<Integer, Long> intMap = intList.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        return intMap.entrySet().stream()
                .map(e -> new IntEntry(e.getKey(), e.getValue()))
                .sorted(COMPARATOR)
                .collect(Collectors.toList());
    }
}