package footballteam;

import footballplayer.FootballPlayer;
import footballplayer.PlayerPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StartingLineup {
    private Map<PlayerPosition, List<FootballPlayer>> startingLineup;
}
