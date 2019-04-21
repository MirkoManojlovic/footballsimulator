package footballplayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerFactoryTest {

    PlayerFactory playerFactory;

    @BeforeEach
    void setup() {
        playerFactory = new PlayerFactory();
    }

    @Test
    void shouldReturnBadPlayerWhenCreateBadPlayerIsCalled() {
        FootballPlayer badPlayer = playerFactory.createBadPlayer(PlayerPosition.DEFENDER);
        assertThat(badPlayer.getQuality()).isLessThan(0.4d);
        assertThat(badPlayer.getSpeed()).isBetween(0.0d, 1d);
    }

    @Test
    void shouldReturnAveragePlayerWhenCreateAveragePlayerIsCalled() {
        FootballPlayer averagePlayer = playerFactory.createAveragePlayer(PlayerPosition.DEFENDER);
        assertThat(averagePlayer.getQuality()).isBetween(0.4d, 0.7d);
        assertThat(averagePlayer.getSpeed()).isBetween(0.0d, 1d);
    }

    @Test
    void shouldReturnGoodPlayerWhenCreateGoodPlayerIsCalled() {
        FootballPlayer goodPlayer = playerFactory.createGoodPlayer(PlayerPosition.DEFENDER);
        assertThat(goodPlayer.getQuality()).isGreaterThan(0.7d);
        assertThat(goodPlayer.getSpeed()).isBetween(0.0d, 1d);
    }
}