/*
 * Copyright (C) 2024 The STYLIST Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package stylist.value;

import static stylist.value.Unit.*;

import org.junit.jupiter.api.Test;

class NumericTest {

    @Test
    void degUnderflow() throws Exception {
        Numeric numeric = new Numeric(-100, deg);

        assert numeric.size == 260;
    }

    @Test
    void degOverflow() throws Exception {
        Numeric numeric = new Numeric(400, deg);

        assert numeric.size == 40;
    }

    @Test
    void plus() {
        Numeric numeric = Numeric.num(10, px).plus(1, em);

        assert numeric.toString().equals("calc(10px + 1em)");
    }

    @Test
    void subtract() {
        Numeric numeric = Numeric.num(10, px).subtract(1, em);

        assert numeric.toString().equals("calc(10px - 1em)");
    }

    @Test
    void multiply() {
        Numeric numeric = Numeric.num(10, px).multiply(1, em);

        assert numeric.toString().equals("calc(10px * 1em)");
    }

    @Test
    void divide() {
        Numeric numeric = Numeric.num(10, px).divide(1, em);

        assert numeric.toString().equals("calc(10px / 1em)");
    }

    @Test
    void max() {
        Numeric numeric = Numeric.max(Numeric.num(10, px), Numeric.num(1, em));

        assert numeric.toString().equals("max(10px, 1em)");
    }

    @Test
    void min() {
        Numeric numeric = Numeric.min(Numeric.num(10, px), Numeric.num(1, em));

        assert numeric.toString().equals("min(10px, 1em)");
    }
}