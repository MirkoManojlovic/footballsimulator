package footballteam;

import footballplayer.FootballPlayer;
import footballplayer.PlayerPercentageFactory;
import footballplayer.PlayerPosition;
import footballutils.FootballUtils;
import formation.FootballFormation;

import java.util.*;

public class FootballTeamFactory {

    private PlayerPercentageFactory playerPercentageFactory = new PlayerPercentageFactory();

    public FootballTeam createTeam(String name, TeamQuality teamQuality, FootballFormation footballFormation) {
        FootballTeam footballTeam = new FootballTeam(name);
        playerPercentageFactory.setTeamQuality(teamQuality);

        Map<PlayerPosition, List<FootballPlayer>> listOfFootballTeamPlayers = footballTeam.getListOfFootballTeamPlayers();

        for (PlayerPosition playerPosition: listOfFootballTeamPlayers.keySet()) {
            List<FootballPlayer> footballPlayers = listOfFootballTeamPlayers.get(playerPosition);

            for (int i = 0; i < footballPlayers.size(); i++) {
                footballPlayers.set(i, createPlayer(playerPosition, teamQuality));
            }
            listOfFootballTeamPlayers.put(playerPosition, footballPlayers);
        }
        footballTeam.setFootballFormation(footballFormation);
        return footballTeam;
    }

    private FootballPlayer createPlayer(PlayerPosition playerPosition, TeamQuality teamQuality) {
        Double threshold = FootballUtils.generateRandomNumberDouble(0.0, 1.0);
        if (threshold > teamQuality.getHighestLevel()) {
            return playerPercentageFactory.createPlayerWithHighestPercentage(playerPosition);
        } else if (threshold > teamQuality.getMediumLevel()) {
            return playerPercentageFactory.createPlayerWithMediumPercentage(playerPosition);
        } else {
            return playerPercentageFactory.createPlayerWithLowPercentage(playerPosition);
        }
    }
}
