package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Application;
import racingcar.objects.RacingCar;

public class RacingUtil {

	public static List<RacingCar> makingRacingCar(String inputNames) {
		List<RacingCar> carList = new ArrayList<RacingCar>();

		// 이름 입력값 유효성 체크 및 자동차 인스턴스 생성
		int carIndex = 0;
		String[] inNames = inputNames.split(",");

		for (String tmpName : inNames) {

			if (tmpName.length() > 5) {
				Application.throwException(String.format("자동차 이름은 5자 이하로 입력해주세요. (%s)", tmpName));
			}

			RacingCar tmpObj = new RacingCar(carIndex, tmpName);
			carIndex++;
			carList.add(tmpObj);
		}

		return carList;
	}

	public static int makingRacingLoopCount(String inputNumber) {
		int racingLoop = 0;

		// 횟수 입력 값 유효성 검사
		if (!inputNumber.matches("\\d+")) {
			Application.throwException(String.format("게임 횟수는 숫자만 입력해주세요. (%s)", inputNumber));
		}

		racingLoop = Integer.parseInt(inputNumber);

		return racingLoop;
	}

	public static void makingRacingLoop(List<RacingCar> carList, int racingLoop) {
		List<RacingCar> innerCarList = carList;

		for (int i = 0; i < racingLoop; i++) {
			innerCarList = makingRacingLoopInner(innerCarList);
			PrintUtil.makeMidRanking(innerCarList);
		}
		
		Application.carList = innerCarList;
	}

	public static List<RacingCar> makingRacingLoopInner(List<RacingCar> carList) {
		List<RacingCar> carListAfter = carList;

		for (RacingCar tmpCar : carListAfter) {
			if(Randoms.pickNumberInRange(0,9) >= Application.movingGauge) {
				tmpCar.setMovingForward();
			}
		}

		return carListAfter;
	}

	public static String makingRacingEnd() {
		return makingWinnerCarListName(Application.carList);
	}
	
	public static String makingWinnerCarListName(List<RacingCar> innerCarList) {
		List<RacingCar> winnerCarList = innerCarList;
		
        int maxProgress = winnerCarList.stream()
                .mapToInt(RacingCar::getCarProgress)
                .max()
                .orElse(0);

        winnerCarList = winnerCarList.stream()
                .filter(car -> car.getCarProgress() == maxProgress)
                .collect(Collectors.toList());
        
        return winnerCarList.stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));
	}
	
}
