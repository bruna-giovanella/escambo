package com.escambo.Service;

import com.escambo.Dto.MercadoriaDto;
import com.escambo.Entity.Mercadoria;
import com.escambo.Repository.MercadoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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

}