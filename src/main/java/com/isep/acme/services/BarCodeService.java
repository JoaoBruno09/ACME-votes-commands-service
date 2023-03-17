package com.isep.acme.services;


import net.sourceforge.barbecue.Barcode;

import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;


public class BarCodeService {

    private static final Font BARCODE_TEXT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

   // @Autowired
    //private static ProductRepository pRepo;

    public static BufferedImage getBarcode(String sku) throws Exception{
        //Optional<Product> product = pRepo.findBySKU(sku);
        //if (product == null){
        //    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not fOUND");
        //}
        Barcode barcode = BarcodeFactory.createCode128(sku);
        barcode.setFont(BARCODE_TEXT_FONT);
        barcode.setLabel(sku);
        BufferedImage image = BarcodeImageHandler.getImage(barcode);
        return image;


    }
}
