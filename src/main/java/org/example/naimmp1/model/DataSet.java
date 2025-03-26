package org.example.naimmp1.model;

import java.util.Arrays;

public class DataSet {
    private final double[] set;
    private final dataSetType dataSetType;

    public DataSet(double[] set, dataSetType dataSetType){
        this.set = set;
        this.dataSetType = dataSetType;
    }

    public double[] getSet(){
        return set;
    }

    public dataSetType getDataSetType(){
        return dataSetType;
    }

    @Override
    public String toString(){
        return String.format("Set: %s, Type: %s", Arrays.toString(set), dataSetType);
    }
}
