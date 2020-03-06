package ru.job4j.lsp;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Ilya Devyatkov
 * @since 04.03.2020
 */
public class Food {

    private String name;

    private Date createDate;

    private Date expaireDate;

    private double price;

    private double discount;

    public Food(String name, Date createDate, Date expaireDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expaireDate = expaireDate;
        this.price = price;
        this.discount = discount;
    }

    public double getExpirePersent() throws ParseException {
        double exp;
        Date current = new SimpleDateFormat("yyyy.MM.dd").parse("2020.03.05");
        double passed = duration(getCreateDate(), current);
        double leftover = duration(getCreateDate(), getExpaireDate());
        exp = 1 - (passed / leftover);
        return exp;
    }

    private long duration(Date first, Date second) {
        Instant one = first.toInstant();
        Instant two = second.toInstant();
        long diff = ChronoUnit.DAYS.between(one, two);
        return diff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Date expaireDate) {
        this.expaireDate = expaireDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expaireDate=" + expaireDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
