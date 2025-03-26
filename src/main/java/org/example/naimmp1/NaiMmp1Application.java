package org.example.naimmp1;

import org.example.naimmp1.controller.KNearestNeighbours;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NaiMmp1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(NaiMmp1Application.class, args);
        KNearestNeighbours kNearestNeighbours = context.getBean(KNearestNeighbours.class);
        System.out.println(kNearestNeighbours.findPredictedClass(new double[]{5.6,2.5,3.9,1.1}));
    }

}
