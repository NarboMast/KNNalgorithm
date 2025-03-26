package org.example.naimmp1.configurations;

import org.example.naimmp1.model.DataSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    List<Object> arrayList(){
        return new ArrayList<>();
    }

    @Bean
    HashMap<Double, DataSet> hashMap(){
        return new HashMap<>();
    }
}
