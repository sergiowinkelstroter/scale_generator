package br.com.sergiowink.scale_generator.controllers;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sergiowink.scale_generator.dtos.scaleRequestDTO;
import br.com.sergiowink.scale_generator.models.Scale;
import br.com.sergiowink.scale_generator.services.CreateScaleService;
import br.com.sergiowink.scale_generator.services.DeleteScaleService;
import br.com.sergiowink.scale_generator.services.GetScaleService;


@RestController
@RequestMapping(value = "/scale")
public class ScaleController {
    
    @Autowired
    private CreateScaleService createScaleService;

    @Autowired
    private GetScaleService getScaleService;

    @Autowired
    private DeleteScaleService deleteScaleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getScale(@PathVariable UUID id){
        try {
            var scale = this.getScaleService.execute(id);
            return ResponseEntity.ok().body(scale);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createScale(@RequestBody scaleRequestDTO scaleRequestDTO){
       Scale scale =  createScaleService.execute(scaleRequestDTO);

       return new ResponseEntity<Object>(scale, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteScale(@PathVariable UUID id){
        try {
            this.deleteScaleService.execute(id);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
