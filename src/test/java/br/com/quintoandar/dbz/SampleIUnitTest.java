package br.com.quintoandar.dbz;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class SampleIUnitTest {

    @Test
    public void fakeUnitTest() {
        assertThat(true, is(equalTo(true)));
    }
}
