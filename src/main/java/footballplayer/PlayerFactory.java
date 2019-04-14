package footballplayer;

import footballutils.FootballUtils;

public class PlayerFactory {

    private Double generateTraitValue(PlayerTrait playerTrait) {
        return FootballUtils.generateRandomNumberDouble(playerTrait.getMin(), playerTrait.getMax());
    }

    public FootballPlayer createBadPlayer(PlayerPosition playerPosition) {
        Double quality = generateTraitValue(PlayerTrait.BAD);
        Double speed = generateTraitValue(PlayerTrait.UNBIASED);
        return new FootballPlayer(playerPosition, quality, speed);
    }

    public FootballPlayer createAveragePlayer(PlayerPosition playerPosition) {
        Double quality = generateTraitValue(PlayerTrait.AVERAGE);
        Double speed = generateTraitValue(PlayerTrait.UNBIASED);
        return new FootballPlayer(playerPosition, quality, speed);
    }

    public FootballPlayer createGoodPlayer(PlayerPosition playerPosition) {
        Double quality = generateTraitValue(PlayerTrait.GOOD);
        Double speed = generateTraitValue(PlayerTrait.UNBIASED);
        return new FootballPlayer(playerPosition, quality, speed);
    }
}
