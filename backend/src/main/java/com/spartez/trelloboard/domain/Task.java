package com.spartez.trelloboard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String userAssigned;
    private Long boardColumnId;

    @ManyToOne
    @JsonIgnore
    private Column column;

    public Task(final String name, final String description, final String userAssigned, final Column column) {
        this.name = name;
        this.description = description;
        this.userAssigned = userAssigned;
        this.column = column;
    }
}
