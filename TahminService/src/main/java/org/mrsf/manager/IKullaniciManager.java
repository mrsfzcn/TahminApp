package org.mrsf.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:9090/kullanici", decode404 = true, name = "tahmin-kullanici")
public interface IKullaniciManager {

    @GetMapping("/updatetahmin/{id}/{tahminId}")
    public ResponseEntity<Boolean> updateAktifTahminId(@PathVariable Long id, @PathVariable Long tahminId);
}
