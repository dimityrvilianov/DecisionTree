package temporary.example;

import java.util.Random;

public class Random5 implements IRandomNumber {

	@Override
	public boolean isHigherThan50() {
		Random d = new Random();
		int random = d.nextInt(100);
		return random > 50;
	}

}
