package com.bodhixu.retrofitdemo.bean;

/**
 * Created by bodhixu on 2016/12/12.
 */

public class LoginBean {


    /**
     * result : {"resultCode":1,"resultMsg":"success"}
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * resultCode : 1
         * resultMsg : success
         */

        private int resultCode;
        private String resultMsg;

        public int getResultCode() {
            return resultCode;
        }

        public void setResultCode(int resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }
    }
}
