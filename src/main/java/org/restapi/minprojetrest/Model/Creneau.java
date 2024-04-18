package org.restapi.minprojetrest.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Creneau")
public class Creneau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String heureDebut;


    private int nb_rdv;



    private String heureFin;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "centre_id", referencedColumnName = "id")
    private Centre centre;



    @Override
    public String toString() {
        return "Creneau{" +
                "id=" + id +
                ", heureDebut='" + heureDebut + '\'' +
                ", heureFin='" + heureFin + '\'' +
                '}';
    }
}

