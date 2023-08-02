package org.mrsf.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Sehir{

    private Long id;
    private String isim;
    private String bolge;
    private String blur;

}
