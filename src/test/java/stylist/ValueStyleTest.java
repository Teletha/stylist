/*
 * Copyright (C) 2018 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package stylist;

import static stylist.ValueStyleTest.Number.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * @version 2018/09/08 16:54:22
 */
class ValueStyleTest extends StyleTester {

    static enum Number {
        Zero, One, Two;
    }

    static ValueStyle<Number> enumed = value -> {
        display.width(value.ordinal(), px);
    };

    @Test
    void enumeration() {
        Set<String> selectors = new HashSet();
        ValidatableStyle style = writeStyle(enumed.of(Zero));
        assert style.property("width", "0");
        selectors.add(style.selector());
        assert selectors.size() == 1;

        style = writeStyle(enumed.of(One));
        assert style.property("width", "1px");
        selectors.add(style.selector());
        assert selectors.size() == 2;

        style = writeStyle(enumed.of(Two));
        assert style.property("width", "2px");
        selectors.add(style.selector());
        assert selectors.size() == 3;
    }

    @Test
    void equality() {
        Style a = enumed.of(Zero);
        Style b = enumed.of(Zero);
        assert a == b;
    }

    @Test
    void menber() {
        Style a = enumed.of(Zero);
        Style b = enumed.of(One);
        Style c = enumed.of(Two);

        Collection<Style> member = enumed.member();
        assert member.size() == 3;
        assert member.contains(a);
        assert member.contains(b);
        assert member.contains(c);
    }
}
