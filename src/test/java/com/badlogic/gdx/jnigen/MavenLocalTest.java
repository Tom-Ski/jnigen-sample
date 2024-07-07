package com.badlogic.gdx.jnigen;

import com.badlogic.gdx.utils.SharedLibraryLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.*;

public class MavenLocalTest {


    @BeforeAll
    public static void setUp() throws Exception {
        new SharedLibraryLoader().load("test");
    }

    @Test
    public void testBoolean () {
        assertTrue(JniGenTestClass.testBoolean(true));
        assertFalse(JniGenTestClass.testBoolean(false));
    }

    @Test
    public void testByte () {
        assertEquals((byte) 0, JniGenTestClass.testByte((byte) 0));
        assertEquals((byte) 1, JniGenTestClass.testByte((byte) 1));
    }

    @Test
    public void testChar () {
        assertEquals('A', JniGenTestClass.testChar('A'));
        assertEquals('B', JniGenTestClass.testChar('B'));
    }

    @Test
    public void testShort () {
        assertEquals((short) 0, JniGenTestClass.testShort((short) 0));
        assertEquals((short) 1, JniGenTestClass.testShort((short) 1));
    }

    @Test
    public void testInt () {
        assertEquals(0, JniGenTestClass.testInt(0));
        assertEquals(1, JniGenTestClass.testInt(1));
    }

    @Test
    public void testLong () {
        assertEquals(0L, JniGenTestClass.testLong(0L));
        assertEquals(1L, JniGenTestClass.testLong(1L));
    }

    @Test
    public void testFloat () {
        assertEquals(0.0f, JniGenTestClass.testFloat(0.0f), 0.001);
        assertEquals(1.0f, JniGenTestClass.testFloat(1.0f), 0.001);
    }

    @Test
    public void testDouble () {
        assertEquals(0.0, JniGenTestClass.testDouble(0.0), 0.001);
        assertEquals(1.0, JniGenTestClass.testDouble(1.0), 0.001);
    }

    @Test
    public void testInner () {
        assertEquals(1, JniGenTestClass.TestInner.testInner(0));
        assertEquals(2, JniGenTestClass.TestInner.testInner(1));
    }

    @Test
    public void testAll () {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1);
        buffer.put(0, (byte) 8);

        assertTrue(JniGenTestClass.test(
                true, (byte) 1, (char) 2, (short) 3, 4, 5, 6, 7,
                buffer, new boolean[]{false}, new char[]{'9'},
                new short[]{10}, new int[]{11}, new long[]{12},
                new float[]{13}, new double[]{14},
                null, "Hurray", JniGenTestClass.class, new RuntimeException(), new JniGenTestClass()));
    }
}
