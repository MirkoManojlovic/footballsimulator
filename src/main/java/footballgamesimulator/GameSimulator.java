package footballgamesimulator;

import footballplayer.FootballPlayer;
import footballplayer.PlayerPosition;
import footballteam.FootballTeam;
import footballteam.StartingLineup;
import footballutils.FootballUtils;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {

   public GameResult simulateGame(FootballTeam teamA, FootballTeam teamB) {
       TeamStrength teamAStrength = calculateTeamStrength(teamA.getStartingLineup());
       TeamStrength teamBStrength = calculateTeamStrength(teamB.getStartingLineup());

       ArrayList<Double> teamAGoalProbability = calculateGoalProbability(teamAStrength, teamBStrength);
       ArrayList<Double> teamBGoalProbability = calculateGoalProbability(teamBStrength, teamAStrength);

       Integer numberOfGoalsTeamA = countNumberOfGoals(teamAGoalProbability);
       Integer numberOfGoalsTeamB = countNumberOfGoals(teamBGoalProbability);

       return new GameResult(teamA.getTeamName(), teamB.getTeamName(), numberOfGoalsTeamA, numberOfGoalsTeamB);
   }

    private TeamStrength calculateTeamStrength(StartingLineup startingLineup) {
        TeamStrength teamStrength = new TeamStrength();
        for (PlayerPosition playerPosition : startingLineup.getStartingLineup().keySet()) {
            Double averageQuality = this.calculateTeamQuality(startingLineup, playerPosition);
            Double averageSpeed = this.calculateTeamSpeed(startingLineup, playerPosition);
            teamStrength.setTeamStrengthParameter(playerPosition, averageQuality, averageSpeed);
        }
        return teamStrength;
    }

    private Double calculateTeamQuality(StartingLineup startingLineup, PlayerPosition playerPosition) {
        List<FootballPlayer> footballPlayers = startingLineup.getStartingLineup().get(playerPosition);
        Double sumOfQuality = footballPlayers
                .stream()
                .mapToDouble(FootballPlayer::getQuality)
                .sum();
        return sumOfQuality/footballPlayers.size();
    }

    private Double calculateTeamSpeed(StartingLineup startingLineup, PlayerPosition playerPosition) {
        List<FootballPlayer> footballPlayers = startingLineup.getStartingLineup().get(playerPosition);
        double sumOfSpeed = footballPlayers
                .stream()
                .mapToDouble(FootballPlayer::getSpeed)
                .sum();
        return sumOfSpeed/footballPlayers.size();
    }

    private ArrayList<Double> calculateGoalProbability(TeamStrength attackingTeam, TeamStrength defendingTeam) {

        Double strikersQuality = attackingTeam.getStrikersQuality();
        Double strikersSpeed = attackingTeam.getStrikersSpeed();

        Double defendersQuality = defendingTeam.getDefendersQuality();
        Double defendersSpeed = defendingTeam.getDefendersSpeed();

        Double midfieldersAttackingQuality = attackingTeam.getMidfieldersQuality();
        Double midfieldersAttackingSpeed = attackingTeam.getMidfieldersSpeed();

        Double midfieldersDefendingQuality = defendingTeam.getMidfieldersQuality();
        Double midfieldersDefendingSpeed = defendingTeam.getMidfieldersSpeed();

        Double goalkeeperQuality = defendingTeam.getGoalkeeperQuality();
        Double goalkeeperSpeed = defendingTeam.getGoalkeeperSpeed();

        Double luck = FootballUtils.generateRandomNumberDouble(0.0, 1.0);

        ArrayList<Double> results = new ArrayList<>();
        for (int i = 0; i < 90; i++) {
            Double formula = (strikersQuality*randomFunc() - defendersQuality*randomFunc())
                    + (strikersSpeed*randomFunc() - defendersSpeed*randomFunc())
                    + (midfieldersAttackingQuality*randomFunc() - midfieldersDefendingQuality*randomFunc())
                    + (midfieldersAttackingSpeed*randomFunc() - midfieldersDefendingSpeed*randomFunc())
                    - (goalkeeperQuality*randomFunc() + goalkeeperSpeed*randomFunc())
                    + luck*randomFunc();
            results.add(formula);
        }
        return results;
    }

    private Double randomFunc() {
        return FootballUtils.generateRandomNumberDouble(0.0, 1.0);
    }

    private Integer countNumberOfGoals(ArrayList<Double> goalProbability) {
        Double average = this.calculateAverage(goalProbability);
        Double standardDeviation = this.calculateStandardDeviation(average, goalProbability);
        Double goalThreshold = calculateGoalThreshold(average, standardDeviation);
        return calculateNumberOfGoals(goalProbability, goalThreshold);
    }

    private Double calculateAverage(ArrayList<Double> results) {
        return results
                .stream()
                .mapToDouble(element -> element)
                .average()
                .getAsDouble();
    }

    private Double calculateStandardDeviation(Double average, ArrayList<Double> results) {
        Double standardDeviationSum = results
                .stream()
                .mapToDouble(element -> element)
                .map(element -> Math.pow(element - average, 2))
                .sum();

        return Math.sqrt(standardDeviationSum / results.size());
    }

    private Double calculateGoalThreshold(Double average, Double standardDeviation) {
        return average + 2.25*standardDeviation;
    }

    private Integer calculateNumberOfGoals(ArrayList<Double> results, Double goalThreshold) {
        return results
                .stream()
                .filter(element -> element > goalThreshold)
                .mapToInt(Double::intValue)
                .sum();
    }
}
