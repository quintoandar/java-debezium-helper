package br.com.quintoandar.dbz.dto;

import org.junit.Assert;
import org.junit.Test;

public class DebeziumOperationConverterTest {

    private DebeziumOperationConverter dbzConverter = new DebeziumOperationConverter();

    @Test
    public void testForCreated() {
        Assert.assertEquals(dbzConverter.convert("c"), DebeziumOperation.CREATED);
    }

    @Test
    public void testForUpdated() {
        Assert.assertEquals(dbzConverter.convert("u"), DebeziumOperation.UPDATED);
    }

    @Test
    public void testForDeleted() {
        Assert.assertEquals(dbzConverter.convert("d"), DebeziumOperation.DELETED);
    }

    @Test
    public void testForUnspecified() {
        Assert.assertEquals(dbzConverter.convert(null), DebeziumOperation.UNESPECIFIED);
    }

    @Test
    public void testForUnexpectedValue() {
        Assert.assertNull(dbzConverter.convert("j"));
    }

}
