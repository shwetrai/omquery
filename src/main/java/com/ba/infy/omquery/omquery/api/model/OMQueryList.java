package com.ba.infy.omquery.omquery.api.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OMQueryList {

   private List<OMQuery> instances;

    public List<OMQuery> getInstances() {
        return instances;
    }

    public void setInstances(List<OMQuery> instances) {
        this.instances = instances;
    }
}
