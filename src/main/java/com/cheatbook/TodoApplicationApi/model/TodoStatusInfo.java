package com.cheatbook.TodoApplicationApi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Immutable
public class TodoStatusInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statusId;

    @NotBlank
    @Size(max = 40)
    private String statusName;
}
