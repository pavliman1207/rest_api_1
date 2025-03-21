package com.example.api1.Student;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Table(name="Студент")
@Schema(description = "сущность студента")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id студента",example = "1")
    private Integer id;
    @Schema(description = "имя студента",example = "артур")
    private String name;
    @Schema(description = "фамилия студента",example = "чапарян")
    private String fam;
    @Schema(description = "факультет студента",example = "МП")
    private String fak;
    @Schema(description = "группа студента",example = "апр32")
    private String studgroup;

    public Student() {
    }

    public Student(int id, String name, String fam, String fak, String studgroup) {
        this.id = id;
        this.name = name;
        this.fam = fam;
        this.fak = fak;
        this.studgroup = studgroup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getFak() {
        return fak;
    }

    public void setFak(String fak) {
        this.fak = fak;
    }

    public String getStudgroup() {
        return studgroup;
    }

    public void setStudgroup(String studgroup) {
        this.studgroup = studgroup;
    }
}

