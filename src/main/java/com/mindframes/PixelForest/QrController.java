package com.mindframes.PixelForest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/generate-qr")
public class QrController {

    private final QrService qrService;

    public QrController(QrService qrService) {
        this.qrService = qrService;
    }

    @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@RequestParam(defaultValue = "Hello from Spring Boot!") String text) {
        byte[] image = qrService.generateQRCodeImage(text);
        return ResponseEntity.ok(image);
    }
}