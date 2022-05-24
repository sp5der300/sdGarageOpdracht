package nl.bd.sdbackendeindopdracht.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "carTable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Car {
    @Id
    private Long carId;
    @ManyToOne
    @JoinColumn(name = "customer_userId", referencedColumnName = "userId")
    private AppUser customer;
    @Column(name = "order_nr_column")
    private int orderNr;
    @Column(name = "construction_year_column")
    private int constructionYear;
    @ManyToOne
    @JoinColumn(name = "mechanic_userId", referencedColumnName = "userId")
    private AppUser workedOnBy;

    public Car(AppUser customer, int orderNr, int constructionYear, AppUser workedOnBy){
        this.customer = customer;
        this.orderNr = orderNr;
        this.constructionYear = constructionYear;
        this.workedOnBy = workedOnBy;
    }

}
