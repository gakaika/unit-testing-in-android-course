package com.techyourchance.unittestingfundamentals.exercise1;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;

public class NegativeNumberValidatorTest {
    public NegativeNumberValidator SUT;

    @Before
    public void setup() {
        SUT = new NegativeNumberValidator();
    }

    @Test
    public void test1() {
        MatcherAssert.assertThat(SUT.isNegative(-1), is(true));
    }

    @Test
    public void test2() {
        MatcherAssert.assertThat(SUT.isNegative(0), is(false));
    }

    @Test
    public void test3() {
        MatcherAssert.assertThat(SUT.isNegative(1), is(false));
    }
}