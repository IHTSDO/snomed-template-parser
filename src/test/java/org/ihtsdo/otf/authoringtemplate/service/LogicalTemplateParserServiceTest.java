package org.ihtsdo.otf.authoringtemplate.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.snomed.authoringtemplate.domain.logical.Attribute;
import org.snomed.authoringtemplate.domain.logical.AttributeGroup;
import org.snomed.authoringtemplate.domain.logical.LogicalTemplate;
import org.snomed.authoringtemplate.service.LogicalTemplateParserService;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class LogicalTemplateParserServiceTest {

	private LogicalTemplateParserService service;

	@Before
	public void setUp() throws Exception {
		service = new LogicalTemplateParserService();
	}

	@Test
	public void testParseTemplateCtOfX() throws Exception {
		final InputStream templateStream = getClass().getResourceAsStream("/templates/ct-of-x_template.txt");
		assertNotNull("Found template stream resource", templateStream);
		final LogicalTemplate template = service.parseTemplate(templateStream);
		assertNotNull(template);

		assertEquals(1, template.getFocusConcepts().size());
		assertEquals("71388002", template.getFocusConcepts().get(0));

		assertEquals(1, template.getAttributeGroups().size());
		final AttributeGroup attributeGroup = template.getAttributeGroups().get(0);
		assertEquals("1", attributeGroup.getCardinalityMin());
		assertEquals("1", attributeGroup.getCardinalityMax());

		final List<Attribute> attributes = attributeGroup.getAttributes();
		assertEquals(2, attributes.size());

		assertEquals("260686004", attributes.get(0).getType());
		assertEquals("312251004", attributes.get(0).getValue());
        assertNull(attributes.get(0).getCardinalityMin());
        assertNull(attributes.get(0).getCardinalityMax());

		assertEquals("405813007", attributes.get(1).getType());
		assertEquals("<< 442083009 |Anatomical or acquired body structure|", attributes.get(1).getValueAllowableRangeECL());
		assertEquals("slotX", attributes.get(1).getValueSlotName());
		assertEquals("1", attributes.get(1).getCardinalityMin());
		assertEquals("1", attributes.get(1).getCardinalityMax());
	}

	@Test
	public void testParseTemplateGuidedCtOfX() throws Exception {
		final InputStream templateStream = getClass().getResourceAsStream("/templates/guided-ct-of-x_template.txt");
		assertNotNull("Found template stream resource", templateStream);
		final LogicalTemplate template = service.parseTemplate(templateStream);
		assertNotNull(template);

		assertEquals(1, template.getFocusConcepts().size());
		assertEquals("71388002", template.getFocusConcepts().get(0));

		assertEquals(2, template.getAttributeGroups().size());

		AttributeGroup attributeGroup = template.getAttributeGroups().get(0);
		assertEquals("1", attributeGroup.getCardinalityMin());
		assertEquals("1", attributeGroup.getCardinalityMax());

		List<Attribute> attributes = attributeGroup.getAttributes();
		assertEquals(3, attributes.size());

		assertEquals("260686004", attributes.get(0).getType());
		assertEquals("312251004", attributes.get(0).getValue());
        assertNull(attributes.get(0).getCardinalityMin());
        assertNull(attributes.get(0).getCardinalityMax());

		assertEquals("405813007", attributes.get(1).getType());
		assertEquals("<< 442083009 |Anatomical or acquired body structure|", attributes.get(1).getValueAllowableRangeECL());
		assertEquals("procSite", attributes.get(1).getValueSlotName());
		assertEquals("1", attributes.get(1).getCardinalityMin());
		assertEquals("1", attributes.get(1).getCardinalityMax());

		assertEquals("363703001", attributes.get(2).getType());
		assertEquals("429892002", attributes.get(2).getValue());
        assertNull(attributes.get(2).getCardinalityMin());
        assertNull(attributes.get(2).getCardinalityMax());

		attributeGroup = template.getAttributeGroups().get(1);
        assertNull(attributeGroup.getCardinalityMin());
        assertNull(attributeGroup.getCardinalityMax());

		attributes = attributeGroup.getAttributes();
		assertEquals(2, attributes.size());

		assertEquals("260686004", attributes.get(0).getType());
		assertEquals("312251004", attributes.get(0).getValue());
        assertNull(attributes.get(0).getCardinalityMin());
        assertNull(attributes.get(0).getCardinalityMax());

		assertEquals("405813007", attributes.get(1).getType());
        assertNull(attributes.get(1).getValueAllowableRangeECL());
        assertNull(attributes.get(1).getValueSlotName());
		assertEquals("procSite", attributes.get(1).getValueSlotReference());
		assertEquals("1", attributes.get(1).getCardinalityMin());
		assertEquals("1", attributes.get(1).getCardinalityMax());

	}
	
	@Test
	public void testParseTemplateWithMultipleFocusConcepts() throws Exception {
		final InputStream templateStream = getClass().getResourceAsStream("/templates/multiple-focus-concepts-template.txt");
		assertNotNull("Failed to find template stream resource", templateStream);
		final LogicalTemplate template = service.parseTemplate(templateStream);
		assertNotNull(template);

		assertEquals(2, template.getFocusConcepts().size());
		assertEquals("420134006", template.getFocusConcepts().get(0));
		assertEquals("473011001", template.getFocusConcepts().get(1));
	}
	
	@Test
	public void testParseTemplateDoubleSlotAttribute() throws Exception {
		final InputStream templateStream = getClass().getResourceAsStream("/templates/double_slot_attribute.txt");
		assertNotNull("Found template stream resource", templateStream);
		final LogicalTemplate template = service.parseTemplate(templateStream);
		assertNotNull(template);

		assertEquals(1, template.getFocusConcepts().size());
		assertEquals("64572001", template.getFocusConcepts().get(0));

		assertEquals(1, template.getAttributeGroups().size());
		final AttributeGroup attributeGroup = template.getAttributeGroups().get(0);
		assertEquals("0", attributeGroup.getCardinalityMin());
		assertEquals("1", attributeGroup.getCardinalityMax());

		final List<Attribute> attributes = attributeGroup.getAttributes();
		assertEquals(1, attributes.size());

		assertEquals("0", attributes.get(0).getCardinalityMin());
		assertEquals("1", attributes.get(0).getCardinalityMax());

		assertNull(attributes.get(0).getType());
		assertEquals("<< 726633004 |Temporally related to (attribute)|", attributes.get(0).getTypeAllowableRangeECL());
		assertEquals("timeType", attributes.get(0).getTypeSlotName());
		
		assertNull(attributes.get(0).getValue());
		assertEquals("< 404684003 |Clinical finding (finding)|", attributes.get(0).getValueAllowableRangeECL());
		assertEquals("temporallyRelatedTo", attributes.get(0).getValueSlotName());
	}

	@Test
	public void testParseTemplateWithMultipleFocusConceptsAndMinusQuery() throws Exception {
		final InputStream templateStream = getClass().getResourceAsStream("/templates/multiple-focus-concepts-and-minus-query-template.txt");
		assertNotNull("Failed to find template stream resource", templateStream);

		final LogicalTemplate template = service.parseTemplate(templateStream);
		assertNotNull(template);

		assertEquals(2, template.getFocusConcepts().size());
		assertEquals(3, template.getAttributeGroups().size());
		assertEquals("64572001", template.getFocusConcepts().get(0));
		assertEquals("298325004", template.getFocusConcepts().get(1));
	}
}
