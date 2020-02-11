package ru.job4j.magnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * @author Ilya Devyatkov
 * @since 07.02.2020
 */
public class ParserSAX extends DefaultHandler {
    private static final Logger LOG = LogManager.getLogger(ParserSAX.class.getName());

    public void pars(File source) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ParserSAX parserSAX = new ParserSAX();
            saxParser.parse(source, parserSAX);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    int count = 0;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("entry")) {
            String value = attributes.getValue("field");
            count += Integer.parseInt(value);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Sum of fields = " + count);
    }
}
