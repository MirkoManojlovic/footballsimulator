package footballmain;

import footballgamesimulator.GameResult;
import footballgamesimulator.GameSimulator;
import footballteam.*;
import formation.FootballFormation343;
import formation.FootballFormation442;
import formation.FootballFormation541;
import injurysimulator.InjurySimulator;

public class FootballMain {

    private FootballTeamFactory footballTeamFactory = new FootballTeamFactory();
    private InjurySimulator injurySimulator = new InjurySimulator();

    public void run() throws InterruptedException {
        FootballTeam badTeam = footballTeamFactory.createTeam("Bad team", TeamQuality.BAD_TEAM, new FootballFormation541());
        FootballTeam averageTeam = footballTeamFactory.createTeam("Average team", TeamQuality.AVERAGE_TEAM, new FootballFormation442());
        FootballTeam goodTeam = footballTeamFactory.createTeam("Good team", TeamQuality.GOOD_TEAM, new FootballFormation343());
        FootballTeam playerTeam = footballTeamFactory.createTeam("Player Team", TeamQuality.AVERAGE_TEAM, new FootballFormation541());

        System.out.println("GAME 1 of UEFA league group stage");
        playerTeam.printOutStartingLineUp();
        simulateAGame(playerTeam, goodTeam);
        injurySimulator.simulateAnInjury(playerTeam);
        Thread.sleep(2000);

        System.out.println();
        System.out.println("GAME 2 of UEFA league group stage");
        playerTeam.setFootballFormation(new FootballFormation442());
        playerTeam.printOutStartingLineUp();
        simulateAGame(playerTeam, averageTeam);
        injurySimulator.simulateAnInjury(playerTeam);
        Thread.sleep(2000);


        System.out.println();
        System.out.println("GAME 3 of UEFA league group stage");
        playerTeam.setFootballFormation(new FootballFormation343());
        playerTeam.printOutStartingLineUp();
        simulateAGame(playerTeam, badTeam);
        injurySimulator.simulateAnInjury(playerTeam);
    }

    private void simulateAGame(FootballTeam teamA, FootballTeam teamB) {
        GameSimulator gameSimulator = new GameSimulator();
        GameResult gameResult = gameSimulator.simulateGame(teamA, teamB);
        gameResult.displayGameResults();
    }
}
