package footballplayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballPlayer {
    private PlayerPosition position;
    private Double quality;
    private Double speed;
}
