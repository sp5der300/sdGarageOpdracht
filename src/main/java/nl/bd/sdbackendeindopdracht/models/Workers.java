package nl.bd.sdbackendeindopdracht.models;

import lombok.*;
import nl.bd.sdbackendeindopdracht.security.enums.Roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "workersTable")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Workers {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String function;
    @Column
    private Roles roles;
    

}


