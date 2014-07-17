package com.expedia.tesla.compiler.plugins;

import com.expedia.tesla.schema.Type;

public class CppTypeDescriptor {
	public CppTypeDescriptor(Type t, String symbol, String cppTypeName) {
		this.setType(t);
		this.symbol = symbol;
		this.cppTypeName = cppTypeName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCppTypeName() {
		return cppTypeName;
	}

	public void setCppTypeName(String cppTypeName) {
		this.cppTypeName = cppTypeName;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	private Type type;
	private String symbol;
	private String cppTypeName;
}
