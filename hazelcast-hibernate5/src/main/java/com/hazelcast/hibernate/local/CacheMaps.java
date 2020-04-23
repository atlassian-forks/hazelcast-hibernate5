package com.hazelcast.hibernate.local;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

final class CacheMaps {
    static <K, V> CacheMap<K, V> cacheMapFor(final ConcurrentMap<K, V> map) {
        return new CacheMap<K, V>() {
            @Override
            public V remove(K key) {
                return map.remove(key);
            }

            @Override
            public boolean remove(K key, V value) {
                return map.remove(key, value);
            }

            @Override
            public int size() {
                return map.size();
            }

            @Override
            public V get(K key) {
                return map.get(key);
            }

            @Override
            public void put(K key, V value) {
                map.put(key, value);
            }

            @Override
            public void clear() {
                map.clear();
            }

            @Override
            public boolean replace(K key, V original, V revised) {
                return map.replace(key, original, revised);
            }

            @Override
            public V putIfAbsent(K key, V value) {
                return map.putIfAbsent(key, value);
            }

            @Override
            public boolean containsKey(K key) {
                return map.containsKey(key);
            }

            @Override
            public Map<K, V> asMap() {
                return map;
            }

            @Override
            public Iterable<Map.Entry<K, V>> entrySet() {
                return map.entrySet();
            }
        };
    }
}
