public class RoadBike extends Bicycle {
	private int tirewidth;
	public RoadBike(int startCadence,
			int startSpeed,
			int startGear,
			int newTireWidth) {
		super(startCadence,
				startSpeed,
				startGear);
		this.setTirewidth(newTireWidth);
	}
	public int getTirewidth() {
		return tirewidth;
	}
	public void setTirewidth(int newTireWidth) {
		this.tirewidth = newTireWidth;
	}
	public void printDescription() {
		super.printDescription();
		System.out.println("The RoadBike" + "has"  + getTirewidth() + "MM tires");
	}
}
