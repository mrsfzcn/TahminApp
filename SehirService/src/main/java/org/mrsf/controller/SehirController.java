package org.mrsf.controller;

import lombok.RequiredArgsConstructor;
import org.mrsf.dto.request.SehirRequestDto;
import org.mrsf.repository.entity.Sehir;
import org.mrsf.service.SehirService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sehir")
public class SehirController {
    private final SehirService sehirService;

    @PostMapping("/ekle")
    public ResponseEntity<Sehir> ekle(@RequestBody SehirRequestDto dto){
        return ResponseEntity.ok(sehirService.ekle(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Sehir> sehirGetir(@PathVariable Long id){
        return ResponseEntity.ok(sehirService.sehirGetir(id));
    }
    @GetMapping("/randomsehir")
    public ResponseEntity<Sehir> randomSehirGetir(){
        return ResponseEntity.ok(sehirService.randomSehirGetir());
    }
}
