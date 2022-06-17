package FactoryPattern;

public class CarFactory {
	public static Car getCarType(CarType carType) {
		switch (carType) {
		case TOYOTA:
			return new Toyota();	
		case HUYNDAI:
			return new Huyndai();
		default:
			throw new IllegalArgumentException("This Car Type is unsupported");
		}
	}
}
