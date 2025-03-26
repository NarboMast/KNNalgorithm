package org.example.naimmp1.controller;

import org.example.naimmp1.model.dataSetType;
import org.example.naimmp1.services.EuclideanDistanceService;
import org.example.naimmp1.services.FileService;
import org.example.naimmp1.services.SortingAlgorithm;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class KNearestNeighbours {
    private static final int K = 5;
    private final FileService fileService;
    private final EuclideanDistanceService euclideanDistanceService;
    private final SortingAlgorithm sortingAlgorithm;

    public KNearestNeighbours(FileService fileService,
                              EuclideanDistanceService euclideanDistanceService,
                              SortingAlgorithm sortingAlgorithm) {
        this.fileService = fileService;
        this.euclideanDistanceService = euclideanDistanceService;
        this.sortingAlgorithm = sortingAlgorithm;
        start();
    }

    public dataSetType findPredictedClass(double[] key){
        double[] comparison = euclideanDistanceService
                .calculateAllEuclideanDistances(
                        fileService.getAllDataSets()
                        ,key);
        sortingAlgorithm.quickSort(comparison,0,comparison.length-1);
        Map<dataSetType, Integer> countMap = new HashMap<>();
        for(int i = 0; i < K; i++){
            dataSetType target = euclideanDistanceService
                    .getEuclideanDistanceRepository()
                    .getValue(comparison[i]).getDataSetType();
            countMap.put(target,countMap.getOrDefault(target, 0) + 1);
        }
        return Collections.max(
                countMap.entrySet(),
                Map.Entry.comparingByValue()).getKey();
    }



    public void start(){
        fileService.readFile();
    }
}
