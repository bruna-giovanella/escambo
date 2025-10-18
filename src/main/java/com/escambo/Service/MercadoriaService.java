package com.escambo.Service;

import com.escambo.Dto.MercadoriaDto;
import com.escambo.Entity.Mercadoria;
import com.escambo.Repository.MercadoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoriaService {

    private final MercadoriaRepository mercadoriaRepository;

    public MercadoriaService(MercadoriaRepository mercadoriaRepository) {
        this.mercadoriaRepository = mercadoriaRepository;
    }

    public Mercadoria salvarMercadoria(MercadoriaDto mercadoriaDto) {
        Mercadoria mercadoria = new Mercadoria();
        BeanUtils.copyProperties(mercadoriaDto, mercadoria);
        return mercadoriaRepository.save(mercadoria);
    }

    public List<Mercadoria> listarTodasAsMercadorias() {
        return mercadoriaRepository.findAll();
    }

    public Mercadoria visualizarMercadoria(Long mercadoriaId) {
        return mercadoriaRepository.findById(mercadoriaId)
                .orElseThrow(()->new RuntimeException("Ocorreu um problema"));
    }

    public Mercadoria atualizarMercadoria(Long mercadoriaId, MercadoriaDto mercadoriaDto) {
        Mercadoria mercadoria = visualizarMercadoria(mercadoriaId);
        BeanUtils.copyProperties(mercadoriaDto, mercadoria);
        return mercadoriaRepository.save(mercadoria);
    }

    public void deletarMercadoria(Long mercadoriaId) {
        Mercadoria mercadoria = visualizarMercadoria(mercadoriaId);
        mercadoriaRepository.delete(mercadoria);
    }

}