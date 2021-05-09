package k.frogsort;

class FrogBox {
	private final int boxNumber;
	private int fliesLeft;

	public FrogBox(int boxNumber) {
		this.boxNumber = boxNumber;
		this.fliesLeft = boxNumber;
	}

	public void process() {
		this.fliesLeft--;
		if (fliesLeft < 0) {
			throw new IllegalStateException("Frog ate negative flies");
		}
	}

	public int getFliesLeft() {
		return fliesLeft;
	}

	public int getBoxNumber() {
		return boxNumber;
	}
}
