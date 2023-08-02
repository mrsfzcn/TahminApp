package org.mrsf.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TahminResponseDto {

    private Sehir sehir;
    private String blur;
    private String userId;
}
