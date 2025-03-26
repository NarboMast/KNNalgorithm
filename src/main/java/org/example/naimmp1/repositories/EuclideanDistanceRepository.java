package org.example.naimmp1.repositories;

import org.example.naimmp1.model.DataSet;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class EuclideanDistanceRepository {
    private final HashMap<Double, DataSet> euclideanDistanceList;

    public EuclideanDistanceRepository(HashMap<Double, DataSet> euclideanDistanceList) {
        this.euclideanDistanceList = euclideanDistanceList;
    }

    public void addEuclideanDistance(double key, DataSet dataSet){
        euclideanDistanceList.put(key, dataSet);
    }

    public DataSet getValue(double key){
        return euclideanDistanceList.get(key);
    }
}
