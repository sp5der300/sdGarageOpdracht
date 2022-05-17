package nl.bd.sdbackendeindopdracht.models.requestModels;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString

public class PartsRequest {
    private final String partName;
    private final double partPrice;
}
