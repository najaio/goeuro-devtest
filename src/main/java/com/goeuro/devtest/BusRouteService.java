package com.goeuro.devtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "singleton")
public class BusRouteService {

    private List<Set<Integer>> allRoutes = new ArrayList<>();

    public boolean findDirectRoute(int from, int to) {
        boolean direct = allRoutes.parallelStream()
                .anyMatch(r -> r.contains(from) && r.contains(to));
        
        return direct;
    }

    public void addRoutes(Set<Integer> routes) {
        this.allRoutes.add(routes);
    }
}