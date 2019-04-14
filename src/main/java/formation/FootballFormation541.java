package formation;

import footballplayer.PlayerCriteria;

public class FootballFormation541 extends FootballFormation {
    public FootballFormation541() {
        this.goalkeeperCriteria = PlayerCriteria.QUALITY_CRITERIA;
        this.defendersCriteria = PlayerCriteria.QUALITY_CRITERIA;
        this.midfieldersCriteria = PlayerCriteria.QUALITY_CRITERIA;
        this.strikersCriteria = PlayerCriteria.SPEED_CRITERIA;
        this.formationNumbers = FormationNumbers.Formation541;
    }
}
