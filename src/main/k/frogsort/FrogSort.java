package k.frogsort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FrogSort {
	private final List<FrogBox> boxes = new ArrayList<>();
	private final List<Integer> result = new ArrayList<>();

	public FrogSort(Collection<Integer> numbersToSort) {
		if (numbersToSort == null) {
			throw new IllegalArgumentException("No collection to sort");
		}
		for (Integer number: numbersToSort) {
			if (number == null) {
				throw new IllegalStateException("Frogs don't eat nulls!");
			}
			if (number < 0) {
				throw new IllegalStateException("Frogs don't eat negative flies!");
			}
			if (number == 0) {
				result.add(0);
			} else {
				boxes.add(new FrogBox(number));
			}
		}
	}

	public List<Integer> sort() {
		while (boxes.size() > 0) {
			List<FrogBox> boxesToRemove = new ArrayList<>();
			for (FrogBox box : boxes) {
				box.process();
				if (box.getFliesLeft() == 0) {
					result.add(box.getBoxNumber());
					boxesToRemove.add(box);
				}
			}
			boxes.removeAll(boxesToRemove);
		}
		return result;
	}
}
