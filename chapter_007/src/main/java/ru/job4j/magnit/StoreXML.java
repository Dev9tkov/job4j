package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Ilya Devyatkov
 * @since 06.02.2020
 */
public class StoreXML {
    private File target;
    private static final Logger LOG = LogManager.getLogger(StoreXML.class.getName());

    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * Сохраняет данные из list в файл target
     * @param list
     */
    public void save(List<Entry> list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Entries entries = new Entries();
            entries.setValues(list);
            jaxbMarshaller.marshal(entries, target);
        } catch (JAXBException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
