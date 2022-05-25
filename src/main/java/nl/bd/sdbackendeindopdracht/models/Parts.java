package nl.bd.sdbackendeindopdracht.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "partsTable")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partsId;
    @Column
    private String partName;
    @Column
    private double partPrice;



}
