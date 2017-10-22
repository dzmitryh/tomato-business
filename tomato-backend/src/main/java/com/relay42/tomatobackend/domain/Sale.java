package com.relay42.tomatobackend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nonnull;

@AutoValue
public abstract class Sale {
    @JsonProperty
    public abstract String id();
    @JsonProperty
    public abstract int tomatoes();
    @JsonProperty
    public abstract String provider();
    @JsonProperty
    public abstract long timestamp();

    @JsonCreator
    public static Sale create(@Nonnull String id, int tomatoes,
                              @Nonnull String provider, long timestamp) {
        return new AutoValue_Sale(id, tomatoes, provider, timestamp);
    }
}
