package org.snomed.authoringtemplate.domain.logical;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicalTemplate {

	private final List<String> focusConcepts;
	private final List<Attribute> ungroupedAttributes;
	private final List<AttributeGroup> attributeGroups;

	public LogicalTemplate() {
		focusConcepts = new ArrayList<>();
		ungroupedAttributes = new ArrayList<>();
		attributeGroups = new ArrayList<>();
	}

	public void addFocusConcept(String sctid) {
		focusConcepts.add(sctid);
	}

	public void addUngroupedAttribute(Attribute attribute) {
		ungroupedAttributes.add(attribute);
	}

	public void addAttributeGroup(AttributeGroup attributeGroup) {
		attributeGroups.add(attributeGroup);
	}

	public List<String> getFocusConcepts() {
		return focusConcepts;
	}

	public List<Attribute> getUngroupedAttributes() {
		return ungroupedAttributes;
	}

	public List<AttributeGroup> getAttributeGroups() {
		return attributeGroups;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.join(",", focusConcepts));
		sb.append(": ");
		
		sb.append(ungroupedAttributes.stream()
		.map(Attribute::toString)
		.collect(Collectors.joining(",")));
		
		boolean hasPrevious = !ungroupedAttributes.isEmpty();
		for (AttributeGroup g : attributeGroups) {
			if (hasPrevious) {
				sb.append(", \n");
			}
			sb.append(g.toString());
		}
		return sb.toString();
	}
}
