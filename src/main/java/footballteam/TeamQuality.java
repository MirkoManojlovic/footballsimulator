package footballteam;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;

public enum  TeamQuality {
    BAD_TEAM(0.5, 0.3, 0.2),
    AVERAGE_TEAM(0.25, 0.5, 0.25),
    GOOD_TEAM(0.2, 0.3, 0.5);

    @Getter
    private Double percentOfBadPlayers;
    @Getter
    private Double percentOfAveragePlayers;
    @Getter
    private Double percentOfGoodPlayers;
    private Double[] percentages;

    TeamQuality(Double percentOfBadPlayers, Double percentOfAveragePlayers, Double percentOfGoodPlayers) {
        this.percentOfBadPlayers = percentOfBadPlayers;
        this.percentOfAveragePlayers = percentOfAveragePlayers;
        this.percentOfGoodPlayers = percentOfGoodPlayers;
        this.percentages = new Double[]{this.percentOfBadPlayers, this.percentOfAveragePlayers, this.percentOfGoodPlayers};
        Arrays.sort(this.percentages, Collections.reverseOrder());
    }

    public Double getHighestLevel() {
        return this.percentages[0];
    }

    public Double getMediumLevel() {
        return this.percentages[1];
    }

    public Double getLowestLevel() {
        return this.percentages[2];
    }
}