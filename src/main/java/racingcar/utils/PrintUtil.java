package racingcar.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Application;
import racingcar.objects.RacingCar;

public class PrintUtil {

	// 게임 시작
	public static void startGame() {
		makeCars();
		makeLoop();
		makeRacing();
		makeResultRanking();
	}
	
	// 경주할 자동차 이름 입력
	public static void makeCars() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"); 
		String inputNames = Console.readLine();
		Application.carList = RacingUtil.makingRacingCar(inputNames);		
	}
	
	// 시도할 횟수 입력
	public static void makeLoop() {
		System.out.println("시도할 회수는 몇회인가요?"); 
		String inputNumber = Console.readLine();
		Application.racingLoop = RacingUtil.makingRacingLoopCount(inputNumber);		
	}
	
	// 레이싱 시작
	public static void makeRacing() {
		System.out.println("실행 결과"); 
		RacingUtil.makingRacingLoop(Application.carList, Application.racingLoop);
	}

	// 레이싱 중간 결과
	public static void makeMidRanking(List<RacingCar> innerCarList) {
		for (RacingCar tmpCar : innerCarList) {
			System.out.println(tmpCar.printProgressString());
		}
		System.out.println();
	}

	// 레이싱 최종 결과
	public static void makeResultRanking() {
		System.out.println(String.format("최종 우승자 : %s", RacingUtil.makingRacingEnd()));
	}
	
}
