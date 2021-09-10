package com.projeto.basico.appjob.model.service;

import com.projeto.basico.appjob.model.keyWord.KeyWord;
import com.projeto.basico.appjob.model.worker.Worker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Size(max = 50, min = 3)
    @NotBlank
    private String description;

    @Builder.Default
    @ManyToMany(mappedBy = "services")
    private Set<KeyWord> keyWords = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_worker")
    @NotNull
    private Worker worker;
}
