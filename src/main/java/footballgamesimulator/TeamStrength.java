package footballgamesimulator;

import footballplayer.PlayerPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamStrength {
    private Double goalkeeperQuality;
    private Double goalkeeperSpeed;

    private Double defendersQuality;
    private Double defendersSpeed;

    private Double midfieldersQuality;
    private Double midfieldersSpeed;

    private Double strikersQuality;
    private Double strikersSpeed;

    public void setTeamStrengthParameter(PlayerPosition playerPosition, Double quality, Double speed) {
        switch (playerPosition) {
            case GOALKEEPER:
                this.goalkeeperQuality = quality;
                this.goalkeeperSpeed = speed;
                break;
            case DEFENDER:
                this.defendersQuality = quality;
                this.defendersSpeed = speed;
                break;
            case MIDFIELDER:
                this.midfieldersQuality = quality;
                this.midfieldersSpeed = speed;
                break;
            case STRIKER:
                this.strikersQuality = quality;
                this.strikersSpeed = speed;
                break;
            default:
                throw new RuntimeException("Invalid Player position");
        }
    }


}
