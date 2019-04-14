package formation;

import footballplayer.PlayerCriteria;

public class FootballFormation442 extends FootballFormation {
    public FootballFormation442() {
        this.goalkeeperCriteria = PlayerCriteria.QUALITY_CRITERIA;
        this.defendersCriteria = PlayerCriteria.QUALITY_CRITERIA;
        this.midfieldersCriteria = PlayerCriteria.QUALITY_CRITERIA;
        this.strikersCriteria = PlayerCriteria.QUALITY_CRITERIA;
        this.formationNumbers = FormationNumbers.Formation442;
    }
}
