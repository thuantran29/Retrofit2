
package com.trannguyentanthuan2903.retrofit2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Large {

    @SerializedName("https")
    @Expose
    private String https;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Large() {
    }

    /**
     * 
     * @param https
     */
    public Large(String https) {
        super();
        this.https = https;
    }

    public String getHttps() {
        return https;
    }

    public void setHttps(String https) {
        this.https = https;
    }

}
