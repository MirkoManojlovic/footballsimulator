package formation;

import footballplayer.PlayerCriteria;
import footballplayer.PlayerPosition;
import lombok.Getter;

public abstract class FootballFormation {
    @Getter
    protected FormationNumbers formationNumbers;
    protected PlayerCriteria goalkeeperCriteria;
    protected PlayerCriteria defendersCriteria;
    protected PlayerCriteria midfieldersCriteria;
    protected PlayerCriteria strikersCriteria;

    public PlayerCriteria getPlayerPositionCriteria(PlayerPosition playerPosition) {
        switch (playerPosition) {
            case GOALKEEPER:
                return goalkeeperCriteria;
            case DEFENDER:
                return defendersCriteria;
            case MIDFIELDER:
                return midfieldersCriteria;
            case STRIKER:
                return strikersCriteria;
            default:
                throw new RuntimeException("Illegal player position");
        }
    }

    public Integer getNumberOfPlayersForPosition(PlayerPosition playerPosition) {
        switch (playerPosition) {
            case GOALKEEPER:
                return formationNumbers.getGoalkeepers();
            case DEFENDER:
                return formationNumbers.getDefenders();
            case MIDFIELDER:
                return formationNumbers.getMidfielders();
            case STRIKER:
                return formationNumbers.getStrikers();
            default:
                throw new RuntimeException("Illegal player position");
        }
    }

}
