package ru.job4j.departure;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 29.11.2019
 */
public class DeparturelistTest {

    @Test
    public void whenListDepartureThenFillGaps() {
        Departurelist departurelist = new Departurelist();
        List<String> list = List.of(
                "K1//SK1",
                "K1//SK2",
                "K1//SK1//SSK1",
                "K1//SK1//SSK2",
                "K2",
                "K2//SK1//SSK1",
                "K2//SK1//SSK2"
        );
        List<String> result = departurelist.fillGaps(list);
        List<String> expected = List.of(
                "K1",
                "K1//SK1",
                "K1//SK1//SSK1",
                "K1//SK1//SSK2",
                "K1//SK2",
                "K2",
                "K2//SK1",
                "K2//SK1//SSK1",
                "K2//SK1//SSK2"
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenListDepartureThenSortNaturalOrder() {
        Departurelist departurelist = new Departurelist();
        List<String> list = List.of(
                "K1//SK1",
                "K1//SK2",
                "K1//SK1//SSK1",
                "K1//SK1//SSK2",
                "K2",
                "K2//SK1//SSK1",
                "K2//SK1//SSK2"
        );
        List<String> result = departurelist.abs(list);
        List<String> expected = List.of(
                "K1",
                "K1//SK1",
                "K1//SK1//SSK1",
                "K1//SK1//SSK2",
                "K1//SK2",
                "K2",
                "K2//SK1",
                "K2//SK1//SSK1",
                "K2//SK1//SSK2"
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenListDepartureThenSortDesceding() {
        Departurelist departurelist = new Departurelist();
        List<String> list = List.of(
                "K1//SK1",
                "K1//SK2",
                "K1//SK1//SSK1",
                "K1//SK1//SSK2",
                "K2",
                "K2//SK1//SSK1",
                "K2//SK1//SSK2"
        );
        List<String> result = departurelist.desc(list);
        List<String> expected = List.of(
                "K2",
                "K2//SK1",
                "K2//SK1//SSK2",
                "K2//SK1//SSK1",
                "K1",
                "K1//SK2",
                "K1//SK1",
                "K1//SK1//SSK2",
                "K1//SK1//SSK1"
        );
        assertThat(result, is(expected));
    }
}
