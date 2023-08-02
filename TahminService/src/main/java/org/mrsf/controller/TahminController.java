package org.mrsf.controller;

import lombok.RequiredArgsConstructor;
import org.mrsf.dto.response.TahminResponseDto;
import org.mrsf.service.TahminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tahmin")
public class TahminController {

    private final TahminService tahminService;

    public ResponseEntity<TahminResponseDto> tahminOlustur(@RequestParam Long userId){
        return ResponseEntity.ok(tahminService.tahminOlustur(userId));
    }
}
