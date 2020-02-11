package ru.job4j.magnit;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


/**
 * @author Ilya Devyatkov
 * @since 05.02.2020
 */
@XmlRootElement
public class Entries {
    private List<Entry> values;

    public Entries() {
    }

    public Entries(List<Entry> values) {
        this.values = values;
    }

    @XmlElement(name = "entry")
    public List<Entry> getValues() {
        return values;
    }

    public void setValues(List<Entry> values) {
        this.values = values;
    }
}
