import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import k.frogsort.FrogSort;

public class FrogSortTest {

	@Test
	public void shouldSortList() {
		List<Integer> toSort = List.of(3,2,1);
		FrogSort frogSort = new FrogSort(toSort);
		Assertions.assertIterableEquals(List.of(1,2,3), frogSort.sort(), "sorted list");
	}

	@Test
	public void shouldNotSortListWithNulls() {
		List<Integer> toSort = new ArrayList<>(List.of(3, 2));
		toSort.add(null);
		Assertions.assertThrows(IllegalStateException.class, () -> new FrogSort(toSort));
	}

	@Test
	public void shouldNotSortListWithNegativeNumbers() {
		List<Integer> toSort = List.of(-3, 2);
		Assertions.assertThrows(IllegalStateException.class, () -> new FrogSort(toSort));
	}

	@Test
	public void shouldNotSortNullList() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new FrogSort(null));
	}

	@Test
	public void shouldSortEmptyList() {
		List<Integer> toSort = List.of();
		FrogSort frogSort = new FrogSort(toSort);
		Assertions.assertIterableEquals(List.of(), frogSort.sort(), "sorted list");
	}

	@Test
	public void shouldSortBigNumbersEventually() {
		List<Integer> toSort = List.of(3_000_000, 2_000_000_000);
		FrogSort frogSort = new FrogSort(toSort);
		Assertions.assertIterableEquals(List.of(3_000_000,2_000_000_000), frogSort.sort(), "sorted list");
	}

	@Test
	public void shouldSortLongList() {
		List<Integer> toSort = new ArrayList<>();
		for (int i = 0; i < 10_000; i++) {
			toSort.add(i);
		}
		FrogSort frogSort = new FrogSort(toSort);
		Assertions.assertIterableEquals(toSort, frogSort.sort(), "sorted list");
	}
}
