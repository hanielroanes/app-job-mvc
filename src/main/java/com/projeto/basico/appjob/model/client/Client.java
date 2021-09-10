package com.projeto.basico.appjob.model.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.br.CPF;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Size(max = 50, min = 3)
    @NotBlank
    private String name;

    @Size(max = 16, min = 9)
    @NotBlank
    @ElementCollection
    @CollectionTable(name = "user_phone",
            joinColumns = @JoinColumn(name = "id_client"))
    @Column(name = "phone")
    private Set<String> phones = new HashSet<>();

    @CPF
    private String cpf;

}
