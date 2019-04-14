package footballplayer;

import footballteam.TeamQuality;
import lombok.Setter;

public class PlayerPercentageFactory {
    private PlayerFactory playerFactory = new PlayerFactory();
    @Setter
    private TeamQuality teamQuality;

    public FootballPlayer createPlayerWithHighestPercentage(PlayerPosition playerPosition) {
        return footballPlayerQualitySelector(playerPosition);
    }

    public FootballPlayer createPlayerWithMediumPercentage(PlayerPosition playerPosition) {
        return footballPlayerQualitySelector(playerPosition);
    }

    public FootballPlayer createPlayerWithLowPercentage(PlayerPosition playerPosition) {
        return footballPlayerQualitySelector(playerPosition);
    }

    private FootballPlayer footballPlayerQualitySelector(PlayerPosition playerPosition) {
        switch(teamQuality) {
            case BAD_TEAM:
                return playerFactory.createBadPlayer(playerPosition);
            case AVERAGE_TEAM:
                return playerFactory.createAveragePlayer(playerPosition);
            case GOOD_TEAM:
                return playerFactory.createGoodPlayer(playerPosition);
            default:
                throw new RuntimeException("Invalid TeamQuality value");
        }
    }
}
