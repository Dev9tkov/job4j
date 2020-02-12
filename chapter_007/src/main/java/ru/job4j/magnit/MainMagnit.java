package ru.job4j.magnit;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

/**
 * @author Ilya Devyatkov
 * @since 10.02.2020
 */
public class MainMagnit {
    public static void main(String[] args) {
        String tempdir = System.getProperty("java.io.tmpdir");
        String fs = System.getProperty("file.separator");

        Config config = new Config();
        config.init();

        StoreSQL storeSQL = new StoreSQL(config);
        storeSQL.generate(100);
        List<Entry> values = storeSQL.load();

        File source = new File(tempdir + fs + "source.xml");
        StoreXML storeXML = new StoreXML(source);
        storeXML.save(values);

        File dest = new File(tempdir + fs + "dest.xml");
        File sheme = new File(tempdir + fs + "sheme.xslt");
        Path copied = sheme.toPath();
        try {
            Files.copy(Objects.requireNonNull(MainMagnit.class.getClassLoader().getResourceAsStream("scheme.xslt")), copied, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(source, dest, sheme);

        ParserSAX parserSAX = new ParserSAX();
        parserSAX.pars(dest);
        dest.delete();
        sheme.delete();
        source.delete();
    }
}
