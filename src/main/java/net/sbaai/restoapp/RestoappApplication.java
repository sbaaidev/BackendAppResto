package net.sbaai.restoapp;

import net.sbaai.restoapp.dao.IOperation;
import net.sbaai.restoapp.model.*;
import net.sbaai.restoapp.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class RestoappApplication implements CommandLineRunner {
    @Autowired
    IOperation io;
    @Resource
    FilesStorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(RestoappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Initialize Storage
        storageService.deleteAll();
        storageService.init();
        io.addCategory(new Category("cat1"));
        io.addCategory(new Category("cat2"));
        io.addCategory(new Category("cat3"));
        Category cat = io.addCategory(new Category("cat5"));


        Food f1 = io.addFood(new Food("Pizza", 20.00, cat, 10));
        Food f2 = io.addFood(new Food("Pizza2", 10.00, cat, 12));

        Customer c1 = io.addCustomer(new Customer("custome1r", "maroc", "062625253"));
        io.addCustomer(new Customer("customer2", "Paris", "062345253"));
        Tables t1 = io.addTables(new Tables(12));
        io.addTables(new Tables(6));
        io.addSector(new Sector("Famille"));
        io.addSector(new Sector("Amis"));
        io.addWaiter(new Waiter("code123", "khalid", "065536334"));
        io.addWaiter(new Waiter("code124", "Mohamed", "065536334"));
        Basket b = new Basket();
        Food f3 = io.getFoodById(2L);
        b.addLineFood(f3, 22);
        //Thread.sleep(1000);
        io.saveCommand(b, c1, t1);

        for (Cashier c : io.getCmdlignes()) {
            System.out.println(c.toString());

        }


    }
}
