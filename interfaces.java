//Bicycle

package com.dnapss.java.training.interfaces;

public abstract class Bicycle implements Cycle,Cloneable{
	int vehicleNo;
	int cadence;
	int gear;
	int speed;

	private static int Number = 1;

	static {
		System.out.println("WELCOME");
	}

	{
		// System.out.println("Vehicle Details:");

	}
	
	public void applyBrake(int decrement)
	{
		speed-=decrement;
	}
	public void speedUp(int increment)
	{
		speed+=increment;
	}
	public Bicycle(int startCadence, int startGear, int startSpeed) {
		this.vehicleNo = Number;
		Number++;
		this.cadence = startCadence;
		this.gear = startGear;
		this.speed = startSpeed;
	}

	
	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int Number) {
		this.vehicleNo = Number;
	}

	public int getCadence() {
		return cadence;
	}

	public void setCadence(int cadence) {
		this.cadence = cadence;
	}

	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public void printDrescription() {
		System.out.println(this.getVehicleNo() + ")  Bicycle Vehicle number :" + this.getVehicleNo() + "  Cadence :"
				+ this.getCadence() + "  Gear :" + this.getGear() + "  Speed :" + this.getSpeed());
	}
	
	abstract public void specific(int decrement);
}

//cycle
package com.dnapss.java.training.interfaces;

       public interface Cycle {

		double kmh=3.6;
		double mph=2.356479587;
		double fts=3.568475398;
		void applyBrake(int decrement);
		void speedUp(int increment);
		void printDescription();
		default void turnAlarmOn()
		{
			System.out.println("turning the cycle bell on");
		}
		default void turnAlarmOff()
		{
			System.out.println("turning the cycle bell off");
		}
		
		static void parkCycle() {
			System.out.println("Cycle parked.");
		}
		static double speedupInKmh(double distanceInMeter,int timeInSeconds)
		{
			return kmh*distanceInMeter/timeInSeconds;
		}
		static double speedupInMph(double distanceInMeter,int timeInSeconds)
		{
			return kmh*distanceInMeter/timeInSeconds;
		}
		static double speedupInFts(double distanceInMeter,int timeInSeconds)
		{
			return kmh*distanceInMeter/timeInSeconds;
		}
	}


//horn
package com.dnapss.java.training.interfaces;

public interface Horn {
	default void turnAlarmOn()
	{
		System.out.println("turning the cycle bell on");
	}
	default void turnAlarmOff()
	{
		System.out.println("turning the cycle bell on");
	}
}
//mountain bike
package com.dnapss.java.training.interfaces;

public class MountainBike extends Bicycle {

	private static final int MOUNTAINBIKESPEEDADJUSTMENT = 5;
	private String suspension;

	public MountainBike(int startCadence, int startGear, int startSpeed, String newSuspenion) 
	{
		super(startCadence, startGear, startSpeed);
		this.setSuspension(newSuspenion);
	}

	public String getSuspension() {
		return suspension;
	}

	public void setSuspension(String suspension) {
		this.suspension = suspension;
	}

	public void adjustSpeed()
	{
		super.speedUp(super.getSpeed()-MOUNTAINBIKESPEEDADJUSTMENT);
	}

	@Override
	public void printDescription() {
		super.printDrescription();
		System.out.println("MountainBike Suspension :"+this.getSuspension());
		
	}

	@Override
	public void specific(int decrement) {
		// TODO Auto-generated method stub
		
	}

}

//Roadbike
package com.dnapss.java.training.interfaces;

public class RoadBike extends Bicycle {
	
	private static final int RoadBikeSpeedAdjustment = 2;
	private int tireWidth;
	

	public RoadBike(int startCadence, int startGear, int startSpeed, int newTireWidth) 
	{
		super(startCadence, startGear, startSpeed);
		this.setTireWidth(newTireWidth);
	}

	public int getTireWidth() {
		return tireWidth;
	}

	public void setTireWidth(int tireWidth) {
		this.tireWidth = tireWidth;
	}

	@Override
	public void printDescription() {
		super.printDrescription();
		System.out.println("RoadBike TireWidth :"+this.getTireWidth());	
		
	}

	public void adjustSpeed()
	{
		super.speedUp(super.getSpeed()-RoadBikeSpeedAdjustment);
	}
	@Override
	public void specific(int decrement) {
		// TODO Auto-generated method stub
		
	}
}

//testbike
package com.dnapss.java.training.interfaces;



public class TestBike  {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Bicycle b1= new RoadBike(20,6,10,2);
		Bicycle clone=(Bicycle) b1.clone();
		Bicycle b2= new RoadBike(30,4,500,5);
		Bicycle b3= new MountainBike(40,3,30,"Suspension_model1");
		RoadBike b4= new RoadBike(50,10,700,7) ;
		MountainBike b5= new MountainBike(60,5,80,"Suspension_model2");
		
		b1.printDrescription();
		b2.printDrescription();
		b3.printDrescription();
		b4.printDrescription();
		b5.printDrescription();
		
		demo1();
	}
	private static void demo1() {
		Cycle bike1 =new MountainBike(20,6,10,"Suspension_model3");
		Cycle bike2 =new RoadBike(20,6,10,9);
		
		bike1.printDescription();
		bike1.applyBrake(3);
		bike1.printDescription();
		bike1.speedUp(10);
		bike1.printDescription();
		bike1.turnAlarmOff();
		bike1.turnAlarmOn();
		Cycle.speedupInKmh(100,50);
		
		bike2.printDescription();
		bike2.speedUp(3);
		bike2.printDescription();
		bike1.speedUp(7);
		bike2.printDescription();
		bike1.turnAlarmOff();
		bike1.turnAlarmOn();
	}

}

