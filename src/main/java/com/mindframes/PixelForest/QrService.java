package com.mindframes.PixelForest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class QrService {

    public byte[] generateQRCodeImage(String text) {
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, 300, 300);
            MatrixToImageWriter.writeToStream(matrix, "PNG", stream);
            return stream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate QR Code", e);
        }
    }
}
