package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.objects.RacingCar;
import racingcar.utils.PrintUtil;

public class Application {
	
	// 공통 변수
	public static List<RacingCar> carList = new ArrayList<RacingCar>();
	public static int racingLoop = 0;
	public static final int movingGauge = 4;
	
	// main 메소드
    public static void main(String[] args) {
		PrintUtil.startGame();
    }
    
    // 예외 발생 시 throw
    public static void throwException(String logTxt) {
    	throw new IllegalArgumentException(logTxt);
    }
    
}
