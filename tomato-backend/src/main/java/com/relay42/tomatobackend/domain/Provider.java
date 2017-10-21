package com.relay42.tomatobackend.domain;

import static com.google.common.base.MoreObjects.toStringHelper;

public enum Provider {
    HEINZ("Heinz"),
    HUNTS("Hunt's"),
    DEL_MONTE("Del Monte"),
    LE_OL_GRANMA("Le Ol' Granma");

    private final String strValue;

    Provider(String strValue) {
        this.strValue = strValue;
    }

    public String getStrValue() {
        return strValue;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("strValue", strValue)
                .toString();
    }
}
