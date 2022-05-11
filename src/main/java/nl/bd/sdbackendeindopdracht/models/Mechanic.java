package nl.bd.sdbackendeindopdracht.models;

import lombok.*;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;

import javax.persistence.*;

@Entity
@Table (name = "mechanicTable")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Mechanic {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String function;
    @ManyToOne
    private Mechanic workedOnBy;
    @Column
    private Roles mechanicRole;


}
