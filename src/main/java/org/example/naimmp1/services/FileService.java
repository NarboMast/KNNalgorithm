package org.example.naimmp1.services;

import org.example.naimmp1.model.DataSet;
import org.example.naimmp1.model.dataSetType;
import org.example.naimmp1.repositories.DataSetRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {
    @Value("${iris}")
    private String filename;
    private static final String COMMA_DELIMITER = ",";
    private final DataSetRepository repository;

    public FileService(DataSetRepository repository) {
        this.repository = repository;
    }

    public void readFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line = br.readLine();
            String[] values;
            while ((line = br.readLine()) != null) {
                values = line.split(COMMA_DELIMITER);
                repository.addDataSet(new DataSet(
                        makeNumericSet(values)
                        , dataSetType.valueOf(values[values.length-1])));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public double castString(String str){
        return Double.parseDouble(str);
    }

    public double[] makeNumericSet(String[] arr){
        double[] res = new double[arr.length-1];
        for(int i = 0; i < arr.length-1; i++)
            res[i] = castString(arr[i]);
        return res;
    }

    public List<DataSet> getAllDataSets(){
        return repository.getDataSetList();
    }
}
