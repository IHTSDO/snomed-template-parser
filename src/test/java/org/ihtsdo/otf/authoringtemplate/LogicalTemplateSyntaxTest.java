package org.ihtsdo.otf.authoringtemplate;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snomed.authoringtemplate.domain.logical.LogicalTemplate;
import org.snomed.authoringtemplate.service.LogicalTemplateParserService;

import java.io.InputStream;

public class LogicalTemplateSyntaxTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogicalTemplateSyntaxTest.class);
	private static final LogicalTemplateParserService target = new LogicalTemplateParserService();

	/*
	 * This utility test is used for testing and confirming the
	 * syntax of a LogicalTemplate without involving Git.
	 *
	 * To use the test:
	 * - Create the '/templates/.wip.txt' file,
	 * - Add LogicalTemplate to file
	 *
	 * To ignore the test:
	 * - Delete the file OR
	 * - Remove content from file
	 * */
	@Test
	public void parseTemplate_ShouldReturnLogicalTemplate() throws Exception {
		// given
		InputStream templateStream = getClass().getResourceAsStream("/templates/.wip.txt");
		boolean ignoredFileIsPresent = templateStream != null;

		if (ignoredFileIsPresent) {
			boolean ignoredFileIsNotEmpty = templateStream.read() != -1;
			if (ignoredFileIsNotEmpty) {
				// when
				LogicalTemplate result = target.parseTemplate(templateStream);

				// then
				Assert.assertNotNull(result);
			} else {
				LOGGER.info("Expected test file is empty; test is ignored.");
			}
		} else {
			LOGGER.info("Expected test file not found; test is ignored.");
		}
	}
}
