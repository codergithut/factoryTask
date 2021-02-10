package com.tianjian.factory.core.model.constant;

/**
 * Created by tianjian on 2021/2/8.
 */
public enum Constraints {
    REQUIRED("REQUIRED"), DISPENSABLE("DISPENSABLE");

    private String constraintsName;

    Constraints(String constraintsName) {
        this.constraintsName = constraintsName;
    }
}
