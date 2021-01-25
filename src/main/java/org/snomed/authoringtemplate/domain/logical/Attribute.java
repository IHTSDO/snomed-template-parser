package org.snomed.authoringtemplate.domain.logical;

public class Attribute implements HasCardinality {
	
	private String cardinalityMin;
	private String cardinalityMax;

	private String type;
	private String typeAllowableRangeECL;
	private String typeSlotName;
	private String typeSlotReference;
	
	private String value;
	private String valueAllowableRangeECL;
	private String valueSlotName;
	private String valueSlotReference;
	

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public void setCardinalityMin(String cardinalityMin) {
		this.cardinalityMin = cardinalityMin;
	}

	@Override
	public void setCardinalityMax(String cardinalityMax) {
		this.cardinalityMax = cardinalityMax;
	}

	public String getCardinalityMin() {
		return cardinalityMin;
	}

	public String getCardinalityMax() {
		return cardinalityMax;
	}

	public String getTypeAllowableRangeECL() {
		return typeAllowableRangeECL;
	}

	public void setTypeAllowableRangeECL(String typeAllowableRangeECL) {
		this.typeAllowableRangeECL = typeAllowableRangeECL;
	}

	public String getTypeSlotName() {
		return typeSlotName;
	}

	public void setTypeSlotName(String typeSlotName) {
		this.typeSlotName = typeSlotName;
	}

	public String getTypeSlotReference() {
		return typeSlotReference;
	}

	public void setTypeSlotReference(String typeSlotReference) {
		this.typeSlotReference = typeSlotReference;
	}

	public String getValueAllowableRangeECL() {
		return valueAllowableRangeECL;
	}

	public void setValueAllowableRangeECL(String valueAllowableRangeECL) {
		this.valueAllowableRangeECL = valueAllowableRangeECL;
	}

	public String getValueSlotName() {
		return valueSlotName;
	}

	public void setValueSlotName(String valueSlotName) {
		this.valueSlotName = valueSlotName;
	}

	public String getValueSlotReference() {
		return valueSlotReference;
	}

	public void setValueSlotReference(String valueSlotReference) {
		this.valueSlotReference = valueSlotReference;
	}

	@Override
	public String toString() {
		return (cardinalityMin == null ? "": "[[~" + cardinalityMin + ".." + cardinalityMax + "]] ")
				+ (getType() == null ? typeRangeToString() : getType() ) + " = "
				+ (getValue() == null ? valueRangeToString() : getValue() );
	}

	private String valueRangeToString() {
		return "[[+id(" + getValueAllowableRangeECL() + ") @" + getValueSlotName() + "]]";
	}
	
	private String typeRangeToString() {
		return "[[+id(" + getTypeAllowableRangeECL() + ") @" + getTypeSlotName() + "]]";
	}
}
