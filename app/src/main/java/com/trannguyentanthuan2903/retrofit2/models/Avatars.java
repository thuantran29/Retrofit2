
package com.trannguyentanthuan2903.retrofit2.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Avatars {

    @SerializedName("default")
    @Expose
    private Default _default;
    @SerializedName("large")
    @Expose
    private Large large;
    @SerializedName("small")
    @Expose
    private Small small;
    @SerializedName("tiny")
    @Expose
    private Tiny tiny;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Avatars() {
    }

    /**
     * 
     * @param tiny
     * @param _default
     * @param small
     * @param large
     */
    public Avatars(Default _default, Large large, Small small, Tiny tiny) {
        super();
        this._default = _default;
        this.large = large;
        this.small = small;
        this.tiny = tiny;
    }

    public Default getDefault() {
        return _default;
    }

    public void setDefault(Default _default) {
        this._default = _default;
    }

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Tiny getTiny() {
        return tiny;
    }

    public void setTiny(Tiny tiny) {
        this.tiny = tiny;
    }

}
