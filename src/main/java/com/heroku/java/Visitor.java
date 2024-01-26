package com.heroku.java;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visitors")
@Data
@Entity
public class Visitor {
    @Id
    private UUID id;
    private String visitorName;
    private String visitorEmail;

}
