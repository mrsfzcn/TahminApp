package org.mrsf.controller;

import lombok.RequiredArgsConstructor;
import org.mrsf.dto.request.GirisRequestDto;
import org.mrsf.dto.request.KayitRequestDto;
import org.mrsf.dto.response.KayitResponseDto;
import org.mrsf.repository.entity.Kullanici;
import org.mrsf.service.KullaniciService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kullanici")
public class KullaniciController {

    private final KullaniciService kullaniciService;

    @PostMapping("/kayit")
    public ResponseEntity<KayitResponseDto> kayit(@RequestBody KayitRequestDto dto){
        return ResponseEntity.ok(kullaniciService.kayit(dto));
    }
    @PostMapping("/giris")
    public ResponseEntity<Boolean> giris(@RequestBody GirisRequestDto dto){
        return ResponseEntity.ok(kullaniciService.giris(dto));
    }
    @GetMapping("/findall")
    public ResponseEntity<List<Kullanici>> findAll(){
        return ResponseEntity.ok(kullaniciService.findAll());
    }
}
