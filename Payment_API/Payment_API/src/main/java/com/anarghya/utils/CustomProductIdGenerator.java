package com.anarghya.utils;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomProductIdGenerator implements IdentifierGenerator {

	
	private static final long serialVersionUID = 1L;

	/*
	 * @Override public Serializable generate(SharedSessionContractImplementor
	 * session, Object object) { return "PROD_" +
	 * UUID.randomUUID().toString().replace("-", "").substring(0, 2); }
	 */

	 private static int counter = 1;

	    @Override
	    public Serializable generate(SharedSessionContractImplementor session, Object object) {
	        String productId = "PROD_" + String.format("%02d", counter);
	        counter++;
	        return productId;
	    }
}
