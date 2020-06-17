package org.sid.lightecomv1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Articl implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean selected;
    private boolean available;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePublication;
    private String photoName;
    @ManyToOne
    private  Category category;
    @ManyToOne
    private Caddy caddy;
}
