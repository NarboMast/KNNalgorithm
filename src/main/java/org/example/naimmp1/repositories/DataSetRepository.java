package org.example.naimmp1.repositories;

import org.example.naimmp1.model.DataSet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataSetRepository {
    private final List<DataSet> dataSetList;

    public DataSetRepository(List<DataSet> dataSetList){
        this.dataSetList = dataSetList;
    }

    public void addDataSet(DataSet dataSet){
        dataSetList.add(dataSet);
    }

    public List<DataSet> getDataSetList(){
        return dataSetList;
    }
}
