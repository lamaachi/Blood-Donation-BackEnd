package org.restapi.minprojetrest.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Setter@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "centre")
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    private String ville;
    private int reviews;
    @Column(name = "max_capacity")
    private int maxCapacity;

    @Column(name = "opening_hours")
    private String openingHours;
    @JsonIgnore
    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RendezVous> rdvs;

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Creneau> creneaux;
    @Override
    public String toString() {
        return "Centre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", ville='" + ville + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", openingHours='" + openingHours + '\'' +
                '}';
    }

}
