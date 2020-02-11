package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @author Ilya Devyatkov
 * @since 06.02.2020
 */
public class ConvertXSQT {

    private static final Logger LOG = LogManager.getLogger(ConvertXSQT.class.getName());

    public void convert (File source, File dest, File scheme) {
        try {
            //Create transformer factory
            TransformerFactory factory = TransformerFactory.newInstance();

            //Use the factory to create a template containing the xsl file
            Transformer transformer = factory.newTransformer(
                    new StreamSource(
                            new FileInputStream(scheme))
            );

            // Prepare the input and output files
            Source inFile = new StreamSource(new FileInputStream(source));
            Result outFile = new StreamResult(new FileOutputStream(dest));

            // Apply the xsl file to the source file and write the result
            // to the dest file
            transformer.transform(inFile, outFile);
        } catch (FileNotFoundException | TransformerException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
