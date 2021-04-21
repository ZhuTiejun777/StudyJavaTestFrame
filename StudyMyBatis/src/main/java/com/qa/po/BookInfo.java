package com.qa.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "book_info")
public class BookInfo {

    @Id
    @Column(name = "book_id")
    private int bookId;


    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "publish")
    private String publish;

    @Column(name = "ISBN")
    private int ISBN;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "language")
    private String language;

    @Column(name = "price", scale = 2)
    private String price;

    @Column(name = "pub_date")
    private Date pubDate;

    @Column(name = "class_id")
    private int classId;

    @Column(name = "number")
    private int number;

}
