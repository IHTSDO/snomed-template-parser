package org.snomed.authoringtemplate.domain;

import java.util.ArrayList;
import java.util.List;


public class LexicalTemplate {

	private String name;
	private String displayName;
	private String takeFSNFromSlot;
	private Integer order;
	private List<String> removeParts;
	private List<ReplacementRule> termReplacements;

	public LexicalTemplate() {
	}

	public LexicalTemplate(String name, String displayName, String takeFSNFromSlot, List<String> removeParts) {
		this.name = name;
		this.displayName = displayName;
		this.takeFSNFromSlot = takeFSNFromSlot;
		this.removeParts = removeParts;
		this.termReplacements = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getTakeFSNFromSlot() {
		return takeFSNFromSlot;
	}

	public void setTakeFSNFromSlot(String takeFSNFromSlot) {
		this.takeFSNFromSlot = takeFSNFromSlot;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getOrder() {
		return order;
	}

	public List<String> getRemoveParts() {
		return removeParts;
	}

	public void setRemoveParts(List<String> removeParts) {
		this.removeParts = removeParts;
	}
	
	public List<ReplacementRule> getTermReplacements() {
		return termReplacements;
	}

	public void setTermReplacements(List<ReplacementRule> termReplacements) {
		this.termReplacements = termReplacements;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LexicalTemplate [");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (displayName != null)
			builder.append("displayName=").append(displayName).append(", ");
		if (takeFSNFromSlot != null)
			builder.append("takeFSNFromSlot=").append(takeFSNFromSlot).append(", ");
		if (removeParts != null)
			builder.append("removeParts=").append(removeParts).append(", ");
		if (termReplacements != null)
			builder.append("termReplacements=").append(termReplacements);
		builder.append("]");
		return builder.toString();
	}
	
	public static class ReplacementRule {
		
		private String existingTerm;
		
  		private String replacement;
  		
  		private boolean slotAbsent;

  		private String slotTermStartsWith;

  		private List<String> slotValues;

  		public ReplacementRule() {
			
		}
		
		public ReplacementRule(String existingTerm, String replacement) {
			this.existingTerm = existingTerm;
			this.replacement = replacement;
		}

		public String getExistingTerm() {
			return existingTerm;
		}

		public void setExistingTerm(String existingTerm) {
			this.existingTerm = existingTerm;
		}

		public String getReplacement() {
			return replacement;
		}

		public void setReplacement(String replacement) {
			this.replacement = replacement;
		}

		public boolean isSlotAbsent() {
			return slotAbsent;
		}

		public void setSlotAbsent(boolean isSlotAbsent) {
			this.slotAbsent = isSlotAbsent;
		}

		public List<String> getSlotValues() {
			return slotValues;
		}

		public void setSlotValues(List<String> slotValues) {
			this.slotValues = slotValues;
		}

		public void setSlotTermStartsWith(String slotTermStartsWith) {
			this.slotTermStartsWith = slotTermStartsWith;
		}

		public String getSlotTermStartsWith() {
			return slotTermStartsWith;
		}
	}
	
}
