package nl.bd.sdbackendeindopdracht.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "orderTable")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column
    private String name;
    @Column
    private String carBrand;
    @Column
    private Date date;
    @Column
    private Double orderNr;
    @ManyToOne
    private AppUser workedOnBy;
    @ManyToMany
    public List<Parts> partsList;
    @Column
    public Double totalPrice;

}
