package com.tianjian.factory.data.test;

/**
 * Created by tianjian on 2020/8/15.
 */
public class TestMainModel {

    private String id;

    private TestDetailModel testDetailModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TestDetailModel getTestDetailModel() {
        return testDetailModel;
    }

    public void setTestDetailModel(TestDetailModel testDetailModel) {
        this.testDetailModel = testDetailModel;
    }
}
