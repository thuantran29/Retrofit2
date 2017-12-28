
package com.trannguyentanthuan2903.retrofit2.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filters {

    @SerializedName("category")
    @Expose
    private Boolean category;
    @SerializedName("exclude")
    @Expose
    private List<Integer> exclude = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Filters() {
    }

    /**
     * 
     * @param category
     * @param exclude
     */
    public Filters(Boolean category, List<Integer> exclude) {
        super();
        this.category = category;
        this.exclude = exclude;
    }

    public Boolean getCategory() {
        return category;
    }

    public void setCategory(Boolean category) {
        this.category = category;
    }

    public List<Integer> getExclude() {
        return exclude;
    }

    public void setExclude(List<Integer> exclude) {
        this.exclude = exclude;
    }

}
