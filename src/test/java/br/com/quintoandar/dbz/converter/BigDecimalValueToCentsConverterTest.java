package br.com.quintoandar.dbz.converter;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BigDecimalValueToCentsConverterTest {

    private BigDecimalValueToCentsConverter subject;

    @Before
    public void setUp() {
        this.subject = new BigDecimalValueToCentsConverter();
    }

    @Test
    public void testForGreaterThanOneWholeNumber() {
        BigDecimal input = new BigDecimal("4815.00");

        Long result = subject.convert(input);

        Assert.assertEquals(Long.valueOf(481500), result);
    }

    @Test
    public void testGreaterThenOneNonWholeNumber() {
        BigDecimal input = new BigDecimal("1623.42");

        Long result = subject.convert(input);

        Assert.assertEquals(Long.valueOf(162342), result);
    }

    @Test
    public void testForGreaterThanZeroAndLessThanOneNonWholeNumber() {
        BigDecimal input = new BigDecimal("0.06");

        Long result = subject.convert(input);

        Assert.assertEquals(Long.valueOf(6), result);
    }

    @Test
    public void testForPositiveNumberWithMoreThanTwoDecimalPlacesAndThatRoundsDown() {
        BigDecimal input = new BigDecimal("2004.201");

        Long result = subject.convert(input);

        Assert.assertEquals(Long.valueOf(200420), result);
    }

    @Test
    public void testForPositiveNumberWithMoreThanTwoDecimalPlacesAndThatRoundsUp() {
        BigDecimal input = new BigDecimal("2004.209");

        Long result = subject.convert(input);

        Assert.assertEquals(Long.valueOf(200420), result);
    }

    @Test
    public void testForZero() {
        BigDecimal input = BigDecimal.ZERO;

        Long result = subject.convert(input);

        Assert.assertEquals(Long.valueOf(0), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWhenInputIsNegative() {
        subject.convert(new BigDecimal("-1"));
    }

    @Test(expected = NullPointerException.class)
    public void testExceptionThrownWhenInputIsNull() {
        subject.convert(null);
    }

}
