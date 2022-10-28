package com.stijn.order.domain.user;

import com.google.common.collect.Lists;

import java.util.List;

public enum Role {
    USER(Lists.newArrayList(Feature.LOGIN));

    private final List<Feature> features;

    Role(List<Feature> features) {
        this.features = features;
    }

    public boolean containsFeature(Feature feature) {
        return features.contains(feature);
    }
}