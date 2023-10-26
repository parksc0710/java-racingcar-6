package racingcar.objects;

public class RacingCar {

	private int carNo = 0;
	private String carName = "";
	private int carProgress = 0;
	private String carProgressString = "";
	
	public RacingCar(int carNo, String carName) {
		this.carNo = carNo;
		this.carName = carName;
	}
	
	public String printProgressString() {
		return String.format("%s : %s", this.carName, this.carProgressString);
	}
	
	public void setMovingForward() {
		this.carProgress++;
		this.carProgressString += "-";
	}

	public int getCarNo() {
		return this.carNo;
	}

	public String getCarName() {
		return this.carName;
	}

	public int getCarProgress() {
		return this.carProgress;
	}

}
