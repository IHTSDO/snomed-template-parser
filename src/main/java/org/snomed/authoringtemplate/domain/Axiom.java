package org.snomed.authoringtemplate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Axiom {
	
	private String axiomId;
	
	private String moduleId;
	
	private boolean active;
	
	private String definitionStatusId;
	
	private List<Relationship> relationships;
	
	public Axiom() {
		this.axiomId = UUID.randomUUID().toString();
		this.active = true;
		this.relationships = new ArrayList<>();
	}

	public String getAxiomId() {
		return axiomId;
	}

	public void setAxiomId(String axiomId) {
		this.axiomId = axiomId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDefinitionStatusId() {
		return definitionStatusId;
	}

	public void setDefinitionStatusId(String definitionStatusId) {
		this.definitionStatusId = definitionStatusId;
	}

	public List<Relationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
	}

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		Axiom axiom = (Axiom) object;
		return active == axiom.active &&
				java.util.Objects.equals(axiomId, axiom.axiomId) &&
				java.util.Objects.equals(moduleId, axiom.moduleId) &&
				java.util.Objects.equals(definitionStatusId, axiom.definitionStatusId) &&
				java.util.Objects.equals(relationships, axiom.relationships);
	}

	public int hashCode() {

		return java.util.Objects.hash(super.hashCode(), axiomId, moduleId, active, definitionStatusId, relationships);
	}
}
