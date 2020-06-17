package org.sid.lightecomv1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString

public class Caddy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "caddy")
    private Collection<Articl>articls;
    @OneToOne
    private Beneficiaire beneficiaire;

}
