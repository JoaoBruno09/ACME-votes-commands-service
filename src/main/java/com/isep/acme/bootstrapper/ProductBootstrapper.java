package com.isep.acme.bootstrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.isep.acme.model.Product;
import com.isep.acme.repositories.ProductRepository;

@Component
//@Profile("bootstrap")
public class ProductBootstrapper implements CommandLineRunner {

    @Autowired
    private ProductRepository pRepo;

    @Override
    public void run(String... args) throws Exception {
        
        if (pRepo.findBySku("asd578fgh267").isEmpty()) {
            Product p1 = new Product("asd578fgh267", "Pen", "very good nice product");
            pRepo.save(p1);
        }
        if (pRepo.findBySku("c1d4e7r8d5f2").isEmpty()) {
            Product p2 = new Product("c1d4e7r8d5f2", "Pencil", " writes ");
            pRepo.save(p2);
        }
        if (pRepo.findBySku("c4d4f1v2f5v3").isEmpty()) {
            Product p3 = new Product("c4d4f1v2f5v3", "Rubber", "erases");
            pRepo.save(p3);
        }
        if (pRepo.findBySku("v145dc2365sa").isEmpty()) {
            Product p4 = new Product("v145dc2365sa", "Wallet", "stores money");
            pRepo.save(p4);
        }
        if (pRepo.findBySku("fg54vc14tr78").isEmpty()) {
            Product p5 = new Product("fg54vc14tr78", "pencil case", " stores pencils");
            pRepo.save(p5);
        }
        if (pRepo.findBySku("12563dcfvg41").isEmpty()) {
            Product p6 = new Product("12563dcfvg41", "Glasses case", " stores glasses");
            pRepo.save(p6);
        }
        if (pRepo.findBySku("vcg46578vf32").isEmpty()) {
            Product p7 = new Product("vcg46578vf32", "tissues", " nose clearing material");
            pRepo.save(p7);
        }
        if (pRepo.findBySku("vgb576hgb675").isEmpty()) {
            Product p8 = new Product("vgb576hgb675", "mouse pad", " mouse adapted surface");
            pRepo.save(p8);
        }
        if (pRepo.findBySku("unbjh875ujg7").isEmpty()) {
            Product p9 = new Product("unbjh875ujg7", " mug ", " drink something from it");
            pRepo.save(p9);
        }
        if (pRepo.findBySku("u1f4f5e2d2xw").isEmpty()) {
            Product p10 = new Product("u1f4f5e2d2xw", " Lamp ", " it lights");
            pRepo.save(p10);
        }
        if (pRepo.findBySku("j85jg76jh845").isEmpty()) {
            Product p11 = new Product("j85jg76jh845", " Pillow ", " cold both sides");
            pRepo.save(p11);
        }
        if (pRepo.findBySku("g4f7e85f4g54").isEmpty()) {
            Product p12 = new Product("g4f7e85f4g54", " chair ", " comfortable ");
            pRepo.save(p12);
        }
    }
}
