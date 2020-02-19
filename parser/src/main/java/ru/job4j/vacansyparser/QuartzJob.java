package ru.job4j.vacansyparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author Ilya Devyatkov
 * @since 19.02.2020
 */
public class QuartzJob implements Job {
    private static final Logger LOG = LogManager.getLogger(QuartzJob.class.getName());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        LOG.info("Parser is run");
        DataBase dataBase = new DataBase();
        dataBase.init();
        HtmlParser parser = new HtmlParser();
        parser.updateParse();
        dataBase.addVacansys(parser.getVacansySet());
    }
}
