package ru.job4j.vacansyparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Ilya Devyatkov
 * @since 14.02.2020
 */
public class HtmlParser {
    private static final Logger LOG = LogManager.getLogger(HtmlParser.class.getName());
    private Integer page = 1;
    private boolean lastPage = false;
    private Set<Vacansy> vacansies = new LinkedHashSet<>();
    private final String url = "https://www.sql.ru/forum/job-offers";

    /**
     * Метод для первого парсинга с начала года
     * @return set вакансий
     */
    public Set<Vacansy> parse() {
            try {
                Document doc = Jsoup.connect(url + "/" + page).get();
                Elements forumTable = doc.getElementsByClass("forumTable");
                Elements rows = forumTable.first().getElementsByTag("tbody").first().getElementsByTag("tr");
                for (int j = 1; j < rows.size(); j++) {
                    Element row = rows.get(j);
                    String link, name, dateCreated;
                    link = row.getElementsByTag("a").attr("href");
                    name = row.child(1).getElementsByTag("a").first().text();
                    dateCreated = row.child(5).text();
                    String text = null;
                    try {
                        Document document = Jsoup.connect(link).get();
                        Elements msgTable = document.getElementsByClass("msgTable");
                        Elements lines = msgTable.first().getElementsByTag("tbody").first().getElementsByTag("tr");
                        text = lines.get(1).child(1).text();
                    } catch (IOException e) {
                        LOG.error(e.getMessage(), e);
                    }
                    if (checkName(link) && checkYear(dateCreated)) {
                        lastPage = true;
                        Vacansy vacansy = new Vacansy(name, text, link);
                        vacansies.add(vacansy);
                    }
                }
                page++;
                if (lastPage) {
                    lastPage = false;
                    parse();
                }
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        return vacansies;
    }

    /**
     * Метод для апдейта парсинга. Сохраняет в set только сегодняшние вакансии
     * @return set вакансий
     */
    public Set<Vacansy> updateParse() {
        try {
            Document doc = Jsoup.connect(url + "/" + 1).get();
            Elements forumTable = doc.getElementsByClass("forumTable");
            Elements rows = forumTable.first().getElementsByTag("tbody").first().getElementsByTag("tr");
            for (int j = 1; j < rows.size(); j++) {
                Element row = rows.get(j);
                String link, name, dateCreated;
                link = row.getElementsByTag("a").attr("href");
                name = row.child(1).getElementsByTag("a").first().text();
                dateCreated = row.child(5).text();
                String text = null;
                try {
                    Document document = Jsoup.connect(link).get();
                    Elements msgTable = document.getElementsByClass("msgTable");
                    Elements lines = msgTable.first().getElementsByTag("tbody").first().getElementsByTag("tr");
                    text = lines.get(1).child(1).text();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
                if (checkName(link) && checkToday(dateCreated)) {
                    Vacansy vacansy = new Vacansy(name, text, link);
                    vacansies.add(vacansy);
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return vacansies;
    }

    public Set<Vacansy> getVacansySet() {
        return this.vacansies;
    }

    private boolean checkName(String name) {
        boolean result = false;
        if (name.contains("java")
                && !name.contains("javascript")
                && !name.contains("java script")) {
            result = true;
        }
        return result;
    }

    private boolean checkYear(String date) {
        boolean result = false;
        String[] spl = date.split("\\s");
        if (spl[0].contains("сегодня") || spl[0].contains("вчера")) {
            result = true;
        } else if (spl.length == 4 && spl[2].contains("20")) {
            result = true;
        }
        return result;
    }

    private boolean checkToday(String date) {
        boolean result = false;
        String[] spl = date.split("\\s");
        if (spl[0].contains("сегодня")) {
            result = true;
        }
        return result;
    }
}
