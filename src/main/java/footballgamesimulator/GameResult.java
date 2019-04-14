package footballgamesimulator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameResult {
    private String teamAName;
    private String teamBName;
    private Integer numberOfGoalsTeamA;
    private Integer numberOfGoalsTeamB;

    public void displayGameResults() {
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("Football game:");
        System.out.println(teamAName + " vs " + teamBName);
        System.out.println(numberOfGoalsTeamA + ":" + numberOfGoalsTeamB);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }
}
