package com.tornado.mawalltracker.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;

public class QRCodeGenerator {



//    public static void main(String[] args) {
//        String url = "https://vorlesungsplan.dhbw-mannheim.de/index.php?action=list&gid=3067001";
//        String routeid = "01";
//
//        try {
//            generateQRCode(url, routeid);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    private static void generateQRCode(String text, String routeid) throws WriterException, IOException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 300, 300);

        // generate image from bitMatrix
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", new File(System.getProperty("user.home") + "/Desktop/" + routeid + ".png").toPath());
    }

}
