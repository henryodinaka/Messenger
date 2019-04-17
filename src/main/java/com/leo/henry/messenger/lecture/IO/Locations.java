package com.leo.henry.messenger.lecture.IO;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Locations implements Map<Integer,Location> {
    private static  Map<Integer,Location> locations = new HashMap<>();

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return locations.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return locations.containsValue(o);
    }

    @Override
    public Location get(Object o) {
        return locations.get(o);
    }

    @Override
    public Location put(Integer integer, Location location) {
        return locations.put(integer,location);
    }

    @Override
    public Location remove(Object o) {
        return locations.remove(o);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> map) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}

class Location  implements Serializable{
    private long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String distance;

    public Location(Integer id, String name, String distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }
}
