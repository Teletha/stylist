/*
 * Copyright (C) 2024 The STYLIST Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package stylist.property;

import org.junit.jupiter.api.Test;

import stylist.StyleTester;

/**
 * @version 2018/08/30 18:38:30
 */
public class OpacityTest extends StyleTester {

    @Test
    public void point() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.opacity(0.5);
        });

        assert style.property("opacity", "0.5");
    }

    @Test
    public void one() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.opacity(1);
        });

        assert style.property("opacity", "1");
    }

    @Test
    public void zero() throws Exception {
        ValidatableStyle style = writeStyle(() -> {
            display.opacity(0);
        });

        assert style.property("opacity", "0");
    }
}