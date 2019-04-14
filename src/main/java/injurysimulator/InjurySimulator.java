package injurysimulator;

import footballplayer.FootballPlayer;
import footballplayer.PlayerPosition;
import footballteam.FootballTeam;
import footballutils.FootballUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InjurySimulator {
    private List<PlayerPosition> playerPositionList;

    public InjurySimulator() {
        this.playerPositionList = Arrays.asList(PlayerPosition.values());
    }

    private PlayerPosition pickARandomPosition() {
        Integer playerPositionIndex = FootballUtils.generateRandomNumberInteger(0, 4);
        return this.playerPositionList.get(playerPositionIndex);
    }

    private FootballPlayer pickARandomFootballPlayer(FootballTeam footballTeam, PlayerPosition playerPosition) {
        Map<PlayerPosition, List<FootballPlayer>> startingLineup = footballTeam.getStartingLineup().getStartingLineup();
        List<FootballPlayer> footballPlayers = startingLineup.get(playerPosition);
        int numberOfPlayers = footballPlayers.size();
        Integer footballPlayerIndex = FootballUtils.generateRandomNumberInteger(0, numberOfPlayers);
        return footballPlayers.get(footballPlayerIndex);
    }

    private void removeFootballPlayerFromFootballTeam(FootballTeam footballTeam, PlayerPosition playerPosition, FootballPlayer footballPlayer) {
        Map<PlayerPosition, List<FootballPlayer>> listOfFootballTeamPlayers = footballTeam.getListOfFootballTeamPlayers();
        List<FootballPlayer> footballPlayers = listOfFootballTeamPlayers.get(playerPosition);
        footballPlayers.remove(footballPlayer);
    }

    public void simulateAnInjury(FootballTeam footballTeam) {
        PlayerPosition playerPosition = pickARandomPosition();
        FootballPlayer footballPlayer = pickARandomFootballPlayer(footballTeam, playerPosition);
        removeFootballPlayerFromFootballTeam(footballTeam, playerPosition, footballPlayer);
        printOutInjuredPlayer(footballPlayer);
    }

    private void printOutInjuredPlayer(FootballPlayer footballPlayer) {
        System.out.println();
        System.out.print("Player injured    ----------->   ");
        System.out.println(footballPlayer);
    }
}
