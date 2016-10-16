package com.goeuro.devtest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {

    @JsonProperty("dep_sid")
    private int from;
    @JsonProperty("arr_sid")
    private int to;
    @JsonProperty("direct_bus_route")
    private boolean directRoute;
    
    public Route(int from, int to, boolean directRoute) {
        this.from = from;
        this.to = to;
        this.directRoute = directRoute;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public boolean isDirectRoute() {
        return directRoute;
    }
}