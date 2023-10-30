package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Message;

public class RacingService {

    private List<Car> carList = new ArrayList<>();

    public void startRacing() {
        Message.printStartMessage();
        createRacingCar();

        int count = getCount();
        Message.printAskCountMessage(count);

        moveAllRacingCar(count);
    }

    private int getCount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void createRacingCar() {
        String cars = Console.readLine();

        Message.printCreateCarListMessage(cars);

        for (String car : cars.split(",")) {
            carList.add(new Car(car));
        }
    }

    private void moveAllRacingCar(int count) {
        while (count-- > 0) {
            carList.stream().forEach(x -> x.moveWithRandomNumber());
            Message.printMoveResultMessage(carList);
        }
    }


}
