package footballplayer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlayerTrait {
    BAD(0.0, 0.4),
    AVERAGE(0.4, 0.7),
    GOOD(0.7, 1.0),
    UNBIASED(0.0, 1.0);

    private Double min;
    private Double max;
}
