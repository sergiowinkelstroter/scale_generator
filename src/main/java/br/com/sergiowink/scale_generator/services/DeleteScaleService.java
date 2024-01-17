package br.com.sergiowink.scale_generator.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sergiowink.scale_generator.exceptions.ScaleNotFoundException;
import br.com.sergiowink.scale_generator.models.Scale;
import br.com.sergiowink.scale_generator.repositories.ScaleRepository;


@Service
public class DeleteScaleService {
    
    @Autowired 
    private ScaleRepository scaleRepository;

    public void execute(UUID id){
         Scale scale = this.scaleRepository.findById(id).orElseThrow(() -> {
            throw new ScaleNotFoundException();
        });

        this.scaleRepository.delete(scale);

    }
}
