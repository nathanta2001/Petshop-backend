package com.nathan.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nathan.petshop.model.Servico;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
