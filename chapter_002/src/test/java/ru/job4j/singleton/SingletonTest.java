package ru.job4j.singleton;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SingletonTest {
    @Test
    public void trackerSingle() {
        TrackerSingle tracker1 = TrackerSingle.INSTANCE;
        TrackerSingle tracker2 = TrackerSingle.INSTANCE;
        assertThat(tracker1.toString(), is(tracker2.toString()));
    }

    @Test
    public void staticfieldLazy() {
        StaticfieldLazy tracker1 = StaticfieldLazy.getInstance();
        StaticfieldLazy tracker2 = StaticfieldLazy.getInstance();
        assertThat(tracker1.toString(), is(tracker2.toString()));
    }

    @Test
    public void staticFinalFieldEager() {
        StaticFinalFieldEager tracker1 = StaticFinalFieldEager.getInstance();
        StaticFinalFieldEager tracker2 = StaticFinalFieldEager.getInstance();
        assertThat(tracker1.toString(), is(tracker2.toString()));
    }

    @Test
    public void privateStaticFinalClassLazy() {
        PrivateStaticFinalClassLazy tracker1 = PrivateStaticFinalClassLazy.getInstance();
        PrivateStaticFinalClassLazy tracker2 = PrivateStaticFinalClassLazy.getInstance();
        assertThat(tracker1.toString(), is(tracker2.toString()));
    }

}
