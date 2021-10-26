package com.attila.varga.BredexInterviewProject.client;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "clients")
public class ClientEntity {

    public ClientEntity() {}

    public ClientEntity(String name, String email, String uuid) {
        this.name = name;
        this.email = email;
        this.uuid = uuid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String uuid;
}
