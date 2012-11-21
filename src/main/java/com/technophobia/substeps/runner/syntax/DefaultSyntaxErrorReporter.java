package com.technophobia.substeps.runner.syntax;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.technophobia.substeps.model.exception.StepImplementationException;
import com.technophobia.substeps.model.exception.SubstepsParsingException;

public class DefaultSyntaxErrorReporter implements SyntaxErrorReporter {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultSyntaxErrorReporter.class);

    public void reportFeatureError(final File file, final String line, final int lineNumber, final String description)
            throws RuntimeException {
        LOG.error("Error on line " + lineNumber + " of feature file " + file.getAbsolutePath() + ": " + line
                + " - reason: " + description);
    }

    public void reportFeatureError(final File file, final String line, final int lineNumber, final String description,
            final RuntimeException ex) throws RuntimeException {
        LOG.error("Error on line " + lineNumber + " of feature file " + file.getAbsolutePath() + ": " + line
                + " - reason: " + description);
        throw ex;
    }

    public void reportSubstepsError(final SubstepsParsingException ex) {
        LOG.error(ex.getMessage());
    }

    public void reportStepImplError(final StepImplementationException ex) {
        LOG.error(ex.getMessage());
    }

}
