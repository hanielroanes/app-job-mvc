package com.projeto.basico.appjob.model.keyWord;

import com.projeto.basico.appjob.model.service.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class KeyWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotBlank
    @Size(max = 50, min = 3)
    private String description;

    @ManyToMany
    @JoinTable(name = "service_keyWord",
            joinColumns = @JoinColumn(name = "id_keyword"),
            inverseJoinColumns = @JoinColumn(name = "id_service"))
    private List<Service> services = new ArrayList<>();
}
