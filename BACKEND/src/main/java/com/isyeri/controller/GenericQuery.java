package com.isyeri.controller;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.JSONObject;

@Entity
@Table(name = "generic_queries")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenericQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "query_name")
    private String queryName;

    @Column(name = "query_string", length = 10485760)
    private String queryString;

    @Transient
    private Object parameters;

}
