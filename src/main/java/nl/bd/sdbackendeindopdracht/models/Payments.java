package nl.bd.sdbackendeindopdracht.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "paymentsTable")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payments {
    @Id
    private Long paymentsId;
    @Column
    private String customerName;
    @Column
    private int orderNr;
    @Column
    private double price;


}
