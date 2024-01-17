package br.com.sergiowink.scale_generator.dtos;


import java.util.List;

import br.com.sergiowink.scale_generator.models.ScaleNames;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class scaleResponseDTO {
    private String title;
    private List<ScaleNames> scale;
    private String type;
}
