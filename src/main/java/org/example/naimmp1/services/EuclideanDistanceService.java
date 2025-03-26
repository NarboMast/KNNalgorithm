package org.example.naimmp1.services;

import org.example.naimmp1.model.DataSet;
import org.example.naimmp1.repositories.EuclideanDistanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EuclideanDistanceService {
    private final EuclideanDistanceRepository euclideanDistanceRepository;

    public EuclideanDistanceService(EuclideanDistanceRepository euclideanDistanceRepository) {
        this.euclideanDistanceRepository = euclideanDistanceRepository;
    }

    public double calculateEuclideanDistance(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays must have the same length.");
        }
        double innerSum = 0;
        double temp;
        for (int i = 0; i < a.length; i++){
            temp = b[i] - a[i];
            innerSum += temp * temp;
        }
        return Math.sqrt(innerSum);
    }

    public double[] calculateAllEuclideanDistances(List<DataSet> sets, double[] key){
        double[] res = new double[sets.size()];
        for(int i = 0; i < sets.size(); i++){
            res[i] = calculateEuclideanDistance(sets.get(i).getSet(), key);
            euclideanDistanceRepository.addEuclideanDistance(res[i], sets.get(i));
        }
        return res;
    }

    public EuclideanDistanceRepository getEuclideanDistanceRepository(){
        return euclideanDistanceRepository;
    }
}
