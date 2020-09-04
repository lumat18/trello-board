package com.spartez.trelloboard.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private List<Column> columns;

    public Board(final String name, final List<Column> columns) {
        this.name = name;
        this.columns = columns;
    }
}
