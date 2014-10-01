package com.expedia.tesla.schema;

public class Map extends Type {
	private Type keyType;
	private Type valueType;
	private String extraTypeId;

	public Map() {
	}

	public Map(Type keyType, Type valueType, String extraTypeId) {
		setKeyType(keyType);
		setValueType(valueType);
		setExtraTypeId(extraTypeId);
	}

	public Type getKeyType() {
		return this.keyType;
	}

	public void setKeyType(Type value) {
		this.keyType = value;
	}

	public Type getValueType() {
		return this.valueType;
	}

	public void setValueType(Type value) {
		this.valueType = value;
	}

	public String getExtraTypeId() {
		return this.extraTypeId;
	}

	public void setExtraTypeId(String value) {
		this.extraTypeId = value;
	}

	@Override
	public String getTypeId() {
		String ex = this.getExtraTypeId();
		if (ex != null && !ex.isEmpty()) {
			ex = "[" + ex + "]";
		} else {
			ex = "";
		}
		return String.format("map%s<%s,%s>", ex, this.getKeyType().getTypeId(),
				this.getValueType().getTypeId());
	}

}
