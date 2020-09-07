package com.spartez.trelloboard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class BoardColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JsonIgnore
    private Board board;

    public BoardColumn(final String name, final Board board) {
        this.name = name;
    }

    public BoardColumn(final String name){
        this.name = name;
    }
}
