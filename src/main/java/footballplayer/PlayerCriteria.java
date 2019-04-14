package footballplayer;

import lombok.Getter;

import java.util.Comparator;

@Getter
public enum PlayerCriteria {
    QUALITY_CRITERIA(TraitCriteria.QUALITY),
    SPEED_CRITERIA(TraitCriteria.SPEED);

    Comparator<FootballPlayer> playerCriteria;

    PlayerCriteria(TraitCriteria criteria) {
        switch (criteria) {
            case QUALITY:
                playerCriteria = Comparator
                        .comparing(FootballPlayer::getQuality)
                        .thenComparing(FootballPlayer::getSpeed);
                break;
            case SPEED:
                playerCriteria = Comparator
                        .comparing(FootballPlayer::getSpeed)
                        .thenComparing(FootballPlayer::getQuality);
                break;
        }
    }
}

enum TraitCriteria {
    QUALITY, SPEED
}