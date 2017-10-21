package com.relay42.tomatobackend.domain;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Sale {
    private final String id;
    private final int tomatoes;
    private final String provider;
    private final long timestamp;

    public Sale(String id, int tomatoes, String provider, long timestamp) {
        this.id = id;
        this.tomatoes = tomatoes;
        this.provider = provider;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public int getTomatoes() {
        return tomatoes;
    }

    public String getProvider() {
        return provider;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", id)
                .add("tomatoes", tomatoes)
                .add("provider", provider)
                .add("timestamp", timestamp)
                .toString();
    }
}
