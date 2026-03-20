package com.nathan.petshop.service;


import com.nathan.petshop.model.Servico;
import com.nathan.petshop.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor // Cria um construtor para injetar o Repository automaticamente.
public class ServicoService {

    private final ServicoRepository servicoRepository; // dependecia do banco de dados

    public Servico getServico(Long id) {
        //tenta buscar no banco de dados, caso não encontre lança um 404
        return servicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));
    }

    public Servico inserirServico(Servico servico) {
        servico.setId(null); // id nulo, pois é uma inserção e não atualização
        return servicoRepository.save(servico);
    }

}
