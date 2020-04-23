package com.hazelcast.hibernate.local;

/**
 * Defines the parameters used when evicting entries from the cache.
 */
public interface EvictionConfig {
    /**
     * @return the duration (in milliseconds) for which an item should live in the cache
     */
    long getTimeToLiveMillis();

    /**
     * @return the maximum number of entries that should live in the cache
     */
    int getMaxSize();
}
