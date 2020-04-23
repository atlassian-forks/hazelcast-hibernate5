package com.hazelcast.hibernate.local;

import com.hazelcast.config.MapConfig;
import com.hazelcast.hibernate.CacheEnvironment;

final class EvictionConfigs {
    private static final long SEC_TO_MS = 1000L;
    private static final int MAX_SIZE = 100000;

    /**
     * Creates an {@link EvictionConfig} for a given Hazelcast {@link MapConfig}.
     *
     * @param mapConfig the MapConfig to use. If null, defaults will be used.
     */
    static EvictionConfig evictionConfigFor(final MapConfig mapConfig) {
        return new EvictionConfig() {
            @Override
            public long getTimeToLiveMillis() {
                return mapConfig == null ?
                        CacheEnvironment.getDefaultCacheTimeoutInMillis() :
                        mapConfig.getTimeToLiveSeconds() * SEC_TO_MS;
            }

            @Override
            public int getMaxSize() {
                return mapConfig == null ?
                        MAX_SIZE :
                        mapConfig.getMaxSizeConfig().getSize();
            }
        };
    }}
