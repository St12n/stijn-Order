package com.stijn.order.domain.user.fields;

import com.google.common.collect.Lists;

import java.util.List;

public enum Role {
    USER(Lists.newArrayList(Feature.LOGIN)),
    TEST(Lists.newArrayList(Feature.TEST)),
    ADMIN(Lists.newArrayList(Feature.LOGIN,Feature.CREATE_ITEM));

    private final List<Feature> features;

    Role(List<Feature> features) {
        this.features = features;
    }

    public boolean containsFeature(Feature feature) {
        return features.contains(feature);
    }
}
