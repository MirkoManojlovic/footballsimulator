package footballteam;

import footballplayer.FootballPlayer;
import footballplayer.PlayerCriteria;
import footballplayer.PlayerPosition;
import formation.FootballFormation;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

public class FootballTeam {

    @Getter
    @Setter
    private String teamName;
    private final Integer GOALKEEPERS_NUMBER = 2;
    private final Integer DEFENDERS_NUMBER = 6;
    private final Integer MIDFIELDERS_NUMBER = 10;
    private final Integer STRIKERS_NUMBER = 4;

    @Getter
    private Map<PlayerPosition, List<FootballPlayer>> listOfFootballTeamPlayers;
    private List<FootballPlayer> goalkeepers = new ArrayList<>(Arrays.asList(new FootballPlayer[GOALKEEPERS_NUMBER]));
    private List<FootballPlayer> defenders =  new ArrayList<>(Arrays.asList(new FootballPlayer[DEFENDERS_NUMBER]));
    private List<FootballPlayer> midfielders =  new ArrayList<>(Arrays.asList(new FootballPlayer[MIDFIELDERS_NUMBER]));
    private List<FootballPlayer> strikers = new ArrayList<>(Arrays.asList(new FootballPlayer[STRIKERS_NUMBER]));

    @Getter
    private FootballFormation footballFormation;
    @Getter
    private StartingLineup startingLineup;

    public FootballTeam(String teamName) {
        this.teamName = teamName;
        this.initializeListOfFootballPlayers();
    }

    private void initializeListOfFootballPlayers() {
        listOfFootballTeamPlayers = new HashMap<>();
        listOfFootballTeamPlayers.put(PlayerPosition.GOALKEEPER, goalkeepers);
        listOfFootballTeamPlayers.put(PlayerPosition.DEFENDER, defenders);
        listOfFootballTeamPlayers.put(PlayerPosition.MIDFIELDER, midfielders);
        listOfFootballTeamPlayers.put(PlayerPosition.STRIKER, strikers);
    }

    private StartingLineup getStartingLineupBasedOnFormation() {
        Map<PlayerPosition, List<FootballPlayer>> listOfPlayersForStartingLineup = new HashMap<>();
        for (PlayerPosition playerPosition : listOfFootballTeamPlayers.keySet() ) {
            PlayerCriteria playerCriteria = footballFormation.getPlayerPositionCriteria(playerPosition);
            List<FootballPlayer> sortedPlayers = sortPlayers(playerPosition, playerCriteria);
            List<FootballPlayer> coachesPicks = pickPlayers(sortedPlayers, footballFormation.getNumberOfPlayersForPosition(playerPosition));
            listOfPlayersForStartingLineup.put(playerPosition, coachesPicks);
        }
        return new StartingLineup(listOfPlayersForStartingLineup);
    }

    private List<FootballPlayer> sortPlayers(PlayerPosition playerPosition, PlayerCriteria criteria) {
        List<FootballPlayer> footballPlayers = listOfFootballTeamPlayers.get(playerPosition);
        footballPlayers.sort(criteria.getPlayerCriteria().reversed());
        return footballPlayers;
    }

    private List<FootballPlayer> pickPlayers(List<FootballPlayer> listOfPlayersToPickFrom, Integer numberOfPlayersToPick) {
        return listOfPlayersToPickFrom
                .stream()
                .limit(numberOfPlayersToPick)
                .collect(Collectors.toList());
    }

    public void setFootballFormation(FootballFormation footballFormation){
        this.footballFormation = footballFormation;
        this.startingLineup = getStartingLineupBasedOnFormation();
    }

    public void printOutWholeTeam() {
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println(teamName + " roster");
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        for (PlayerPosition playerPosition : listOfFootballTeamPlayers.keySet()) {
            listOfFootballTeamPlayers.get(playerPosition).forEach(System.out::println);
        }
    }

    public void printOutStartingLineUp() {
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("Starting lineup for " + teamName);
        System.out.println("Formation " + footballFormation.getFormationNumbers());
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

        for (PlayerPosition playerPosition : startingLineup.getStartingLineup().keySet()) {
            startingLineup.getStartingLineup().get(playerPosition).forEach(System.out::println);
        }
    }
}
