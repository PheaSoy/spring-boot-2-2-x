package com.ascendmoney.td.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter

public class Book {
    @Id
    @GeneratedValue
    int id;

    public Book(String title, String author, String snb) {
        this.title = title;
        this.author = author;
        this.snb = snb;
    }

    String title;
    String author;
    String snb;
}
