package formation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FormationNumbers {
    Formation541(1, 5,4,1),
    Formation442(1, 4,4,2),
    Formation343(1, 3,4,3);

    private Integer goalkeepers;
    private Integer defenders;
    private Integer midfielders;
    private Integer strikers;
}