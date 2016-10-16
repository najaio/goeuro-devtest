
package com.goeuro.devtest;

import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BusRouteServiceTest {
    
    private static BusRouteService service;
    
    @BeforeClass
    public static void setup(){
        service = new BusRouteService();
        
        Set<Integer> routes = new HashSet<>(asList(1, 2, 3));
        service.addRoutes(routes);
        
        routes = new HashSet<>(asList(1, 3, 5));
        service.addRoutes(routes);
        
        routes = new HashSet<>(asList(4, 3, 2));
        service.addRoutes(routes);
        
    }
    
    @Test
    public void findDirectRouteTest(){
        
        boolean directTrue = service.findDirectRoute(1, 2);
        assertTrue("Should exist a direct connection between station 1 and 2", 
                    directTrue);
        
        boolean directFalse = service.findDirectRoute(1, 4);
        assertFalse("Should not exist a direct connection between station 1 and 2",
                    directFalse);
    }
}
