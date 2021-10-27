package com.attila.varga.BredexInterviewProject.position;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "positions")
public class PositionEntity {

    public PositionEntity() {}

    public PositionEntity(String name, String location, String url) {
        this.name = name;
        this.location = location;
        this.url = url;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String url;
}
