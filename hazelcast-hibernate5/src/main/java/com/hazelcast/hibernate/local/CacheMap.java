package com.hazelcast.hibernate.local;

import java.util.Map;

public interface CacheMap<K, V> {

    V remove(K key);

    boolean remove(K key, V value);

    int size();

    V get(K key);

    void put(K key, V value);

    void clear();

    boolean replace(K key, V original, V revised);

    V putIfAbsent(K key, V marker);

    boolean containsKey(K key);

    Map<K, V> asMap();

    Iterable<Map.Entry<K, V>> entrySet();
}
