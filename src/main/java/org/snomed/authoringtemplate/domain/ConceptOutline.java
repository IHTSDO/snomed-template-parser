package org.snomed.authoringtemplate.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ConceptOutline {

	private String moduleId;
	private DefinitionStatus definitionStatus;
	private Set<Axiom> classAxioms;
	private List<Description> descriptions;

	public ConceptOutline() {
		definitionStatus = DefinitionStatus.FULLY_DEFINED;
		classAxioms = new HashSet<Axiom>();
		descriptions = new ArrayList<>();
	}

	public ConceptOutline(DefinitionStatus definitionStatus) {
		this();
		this.definitionStatus = definitionStatus;
	}

	public ConceptOutline addDescription(Description description) {
		descriptions.add(description);
		return this;
	}

	public String getModuleId() {
		return moduleId;
	}

	public ConceptOutline setModuleId(String moduleId) {
		this.moduleId = moduleId;
		return this;
	}

	public DefinitionStatus getDefinitionStatus() {
		return definitionStatus;
	}

	public void setDefinitionStatus(DefinitionStatus definitionStatus) {
		this.definitionStatus = definitionStatus;
	}

	public List<Description> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

	public ConceptOutline addAxiom(Axiom axiom) {
		classAxioms.add(axiom);
		return this;
	}
	
	public Set<Axiom> getClassAxioms() {
		return classAxioms;
	}

	public void setClassAxioms(Set<Axiom> classAxioms) {
		this.classAxioms = classAxioms;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConceptOutline that = (ConceptOutline) o;
		return Objects.equals(moduleId, that.moduleId) &&
				definitionStatus == that.definitionStatus &&
				Objects.equals(classAxioms, that.classAxioms) &&
				Objects.equals(descriptions, that.descriptions);
	}

	@Override
	public int hashCode() {

		return Objects.hash(moduleId, definitionStatus, classAxioms, descriptions);
	}
}
