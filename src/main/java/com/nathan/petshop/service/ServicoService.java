package com.nathan.petshop.service;

import java.util.List;
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

    public List<Servico> getServicoList(){
        return servicoRepository.findAll();
    }

    public Servico getServico(Long id) {
        //tenta buscar no banco de dados, caso não encontre lança um 404
        return servicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));
    }

    public Servico insertServico(Servico servico) {
        servico.setId(null); // id nulo, pois é uma inserção e não atualização
        return servicoRepository.save(servico);
    }

    public Servico updateServico(Servico servico) {
        if (servico.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "É obrigatório o ID para atualizar");
        }
        return servicoRepository.save(servico);
    }

    public void deleteServico(Long id) {
        Servico servico = this.getServico(id);
        servicoRepository.delete(servico);
    }

}
