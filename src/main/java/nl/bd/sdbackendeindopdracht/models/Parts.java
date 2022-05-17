package nl.bd.sdbackendeindopdracht.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private Long partsId;
    @Column
    private String name;
    @Column
    private double partPrice;



}
