package org.mrsf.controller;

import lombok.RequiredArgsConstructor;
import org.mrsf.dto.request.TahminRequestDto;
import org.mrsf.dto.response.TahminResponseDto;
import org.mrsf.service.TahminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tahmin")
public class TahminController {

    private final TahminService tahminService;

    @GetMapping("/tahminolustur")
    public ResponseEntity<TahminResponseDto> tahminOlustur(@RequestParam Long userId){
        return ResponseEntity.ok(tahminService.tahminOlustur(userId));
    }
    @GetMapping("/tahminyap")
    public ResponseEntity<String> tahminYap(@RequestBody TahminRequestDto dto){
        return ResponseEntity.ok(tahminService.tahminYap(dto));
    }


}
