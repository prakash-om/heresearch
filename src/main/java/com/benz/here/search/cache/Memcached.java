package com.benz.here.search.cache;

import java.io.IOException;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.transcoders.SerializingTranscoder;

public class Memcached implements Cache {

	private static final Logger LOGGER = LoggerFactory.getLogger(Memcached.class);

	private String name;

	private MemcachedClient cache;

	private int expiration;

	public Memcached(String name, String memcachedAddresses, int expiration) throws IOException {
		this.name = name;
		this.expiration = expiration;
		cache = new MemcachedClient(
				new ConnectionFactoryBuilder().setTranscoder(new SerializingTranscoder())
						.setProtocol(ConnectionFactoryBuilder.Protocol.BINARY).build(),
				AddrUtil.getAddresses(memcachedAddresses));
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Object getNativeCache() {
		return cache;
	}

	@Override
	public ValueWrapper get(Object key) {
		Object value = null;
		try {
			value = cache.get(key.toString());
		} catch (final Exception e) {
			LOGGER.warn(e.getMessage());
		}
		if (value == null) {
			LOGGER.info("cache miss for key: " + key.toString());
			return null;
		}
		LOGGER.info("cache hit for key: " + key.toString());
		return new SimpleValueWrapper(value);
	}

	@Override
	public void put(Object key, Object value) {
		if (value != null) {
			cache.set(key.toString(), expiration, value);
			LOGGER.info("cache put for key: " + key.toString());
		}
	}

	@Override
	public void evict(Object key) {
		this.cache.delete(key.toString());
		LOGGER.info("cache delete for key: " + key.toString());

	}

	@Override
	public void clear() {
		cache.flush();
		LOGGER.info("cache clear completed");

	}
	
	@Override
	public <T> T get(Object key, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T get(Object key, Callable<T> valueLoader) {
		// TODO Auto-generated method stub
		return null;
	}

}
