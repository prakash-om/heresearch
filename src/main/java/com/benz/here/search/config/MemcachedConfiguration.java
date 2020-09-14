package com.benz.here.search.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.benz.here.search.cache.Memcached;
import com.benz.here.search.utils.ConfigUtility;

@Configuration
public class MemcachedConfiguration implements CachingConfigurer {

	@Autowired
	ConfigUtility configUtility;

	@Override
	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		try {
			cacheManager.setCaches(internalCaches());
			return cacheManager;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Collection<Memcached> internalCaches() throws IOException {
		final Collection<Memcached> caches = new ArrayList<>();
		caches.add(new Memcached(configUtility.getEvnProperty("cacheName"),
				configUtility.getEvnProperty("memCacheAddress"),
				Integer.parseInt(configUtility.getEvnProperty("memCacheexpiration"))));
		return caches;
	}
	
	 @Override
	    public KeyGenerator keyGenerator() {
	        return new SimpleKeyGenerator();
	    }

	    @Override
	    public CacheErrorHandler errorHandler() {
	        return new SimpleCacheErrorHandler();
	    }

	    @Override
	    public CacheResolver cacheResolver() {
	        return null;
	    }

}
