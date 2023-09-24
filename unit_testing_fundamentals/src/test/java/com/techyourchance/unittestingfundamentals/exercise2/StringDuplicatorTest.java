package com.techyourchance.unittestingfundamentals.exercise2;

import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

public class StringDuplicatorTest {
    public StringDuplicator SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new StringDuplicator();
    }

    @Test
    public void stringDuplicator_emptyString_emptyStringReturned() {
        MatcherAssert.assertThat(SUT.duplicate(""), is(""));
    }

    @Test
    public void stringDuplicator_singleChar_charDuplicated() {
        MatcherAssert.assertThat(SUT.duplicate("a"), is("aa"));
    }

    @Test
    public void stringDuplicator_multipleChar_multipleCharDuplicated() {
        MatcherAssert.assertThat(SUT.duplicate("abc"), is("abcabc"));
    }
}