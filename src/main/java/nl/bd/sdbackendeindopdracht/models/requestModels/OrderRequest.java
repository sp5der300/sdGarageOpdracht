package nl.bd.sdbackendeindopdracht.models.requestModels;

import lombok.*;

import java.util.Date;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString

public class OrderRequest {

    private final String name;
    private final String carBrand;
    private final Date date;
    private final Double orderNr;
    private final Double totalPrice;

}
