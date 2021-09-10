package com.projeto.basico.appjob.model.worker;

import com.projeto.basico.appjob.model.client.Client;
import com.projeto.basico.appjob.model.service.Service;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Worker extends Client {

    @Builder.Default
    @OneToMany(mappedBy = "worker")
    private List<Service> services = new ArrayList<>();



}
