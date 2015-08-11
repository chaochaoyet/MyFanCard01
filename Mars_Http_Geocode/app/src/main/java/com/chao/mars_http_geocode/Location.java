package com.chao.mars_http_geocode;

import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Result;

/**
 * Created by chao on 2015/5/14.
 */
public class Location {
  private String status;
    private List<Inresult> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Inresult> getResults() {
        return results;
    }

    public void setResults(List<Inresult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Location{" +
                "status='" + status + '\'' +
                ", results=" + results +
                '}';
    }
}
