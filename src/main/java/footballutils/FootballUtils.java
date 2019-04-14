package footballutils;

import java.util.Random;

public class FootballUtils {
    public static Double generateRandomNumberDouble(Double min, Double max) {
        Random random = new Random();
        Double returnNumber = random.doubles(min, max).findFirst().getAsDouble();
        return  Math.round(returnNumber*10)/10.0;
    }
    public static Integer generateRandomNumberInteger(Integer min, Integer max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }
}
