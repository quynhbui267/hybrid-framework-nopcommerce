package FactoryPattern;

public class Toyota implements Car {

	@Override
	public void viewCar() {
	System.out.println("View Toyota car");
		
	}

	@Override
	public void driveCar() {
		System.out.println("Drive Toyota car");
		
	}

}
