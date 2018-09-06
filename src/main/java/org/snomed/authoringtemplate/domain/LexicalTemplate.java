package org.snomed.authoringtemplate.domain;

import java.util.ArrayList;
import java.util.List;

public class LexicalTemplate {

	private String name;
	private String displayName;
	private String takeFSNFromSlot;
	private List<String> removeParts;
	private List<String> removeFromTermTemplateWhenSlotAbsent;

	public LexicalTemplate() {
	}

	public LexicalTemplate(String name, String displayName, String takeFSNFromSlot, List<String> removeParts) {
		this.name = name;
		this.displayName = displayName;
		this.takeFSNFromSlot = takeFSNFromSlot;
		this.removeParts = removeParts;
		this.removeFromTermTemplateWhenSlotAbsent = new ArrayList<>();
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

	public List<String> getRemoveParts() {
		return removeParts;
	}

	public void setRemoveParts(List<String> removeParts) {
		this.removeParts = removeParts;
	}
	
	public List<String> getRemoveFromTermTemplateWhenSlotAbsent() {
		return removeFromTermTemplateWhenSlotAbsent;
	}

	public void setRemoveFromTermTemplateWhenSlotAbsent(List<String> removeFromTermTemplateWhenSlotAbsent) {
		this.removeFromTermTemplateWhenSlotAbsent = removeFromTermTemplateWhenSlotAbsent;
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
		if (removeFromTermTemplateWhenSlotAbsent != null)
			builder.append("removeFromTermTemplateWhenSlotAbsent=").append(removeFromTermTemplateWhenSlotAbsent);
		builder.append("]");
		return builder.toString();
	}
}
