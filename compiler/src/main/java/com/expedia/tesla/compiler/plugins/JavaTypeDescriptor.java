package com.expedia.tesla.compiler.plugins;

import com.expedia.tesla.schema.Type;

public class JavaTypeDescriptor {
	public JavaTypeDescriptor(Type t, String symbol, String interfaceName,
			String actualTypeName) {
		this.setType(t);
		this.symbol = symbol;
		this.interfaceName = interfaceName;
		this.actualTypeName = actualTypeName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getActualTypeName() {
		return actualTypeName;
	}

	public void setActualTypeName(String actualTypeName) {
		this.actualTypeName = actualTypeName;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	private Type type;
	private String symbol;
	private String interfaceName;
	private String actualTypeName;
}
