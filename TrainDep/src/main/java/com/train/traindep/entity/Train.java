package com.train.traindep.entity;

import java.util.Map;

public class Train {
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public int getDelayedBy() {
        return delayedBy;
    }

    public void setDelayedBy(int delayedBy) {
        this.delayedBy = delayedBy;
    }

    private String trainName;
    private String trainNo;
    private int delayedBy;

    public Train(String trainName, String trainNo, Map<String, Integer> depatureTime, Map<String, Integer> seatsAvailable, Map<String, Integer> price, int delayedBy) {
        this.trainName = trainName;
        this.trainNo = trainNo;
        this.delayedBy = delayedBy;
    }
}

