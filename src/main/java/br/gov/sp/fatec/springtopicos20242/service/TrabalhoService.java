package br.gov.sp.fatec.springtopicos20242.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springtopicos20242.entity.Trabalho;
import br.gov.sp.fatec.springtopicos20242.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public Trabalho cadastrar(Trabalho trabalho) {
        if (trabalho.getTitulo() == null || trabalho.getGrupo() == null) {
            throw new IllegalArgumentException("Título e grupo devem estar preenchidos.");
        }
        if (trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }
        return trabalhoRepository.save(trabalho);
    }

    public List<Trabalho> listarTodos() {
        return trabalhoRepository.findAll();
    }

    public List<Trabalho> buscarPorTituloENota(String palavra, int nota) {
        return trabalhoRepository.findByTituloContainingAndNotaGreaterThan(palavra, nota);
    }
}
