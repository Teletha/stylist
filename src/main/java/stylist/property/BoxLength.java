/*
 * Copyright (C) 2023 The STYLIST Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package stylist.property;

import java.util.EnumSet;

import stylist.PropertyDefinition;
import stylist.value.Numeric;
import stylist.value.Unit;
import stylist.value.Vendor;

/**
 * @version 2018/08/30 18:24:37
 */
public class BoxLength extends PropertyDefinition<BoxLength> {

    /** The property name. */
    private final String name;

    /**
     * @param name The property name.
     */
    public BoxLength(String name) {
        this.name = name;
    }

    /**
     * <p>
     * The margin CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength size(double size, Unit unit) {
        horizontal(size, unit);
        vertical(size, unit);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @return
     */
    public BoxLength size(Numeric value) {
        horizontal(value);
        vertical(value);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * </p>
     * 
     * @return
     */
    public BoxLength auto() {
        right(new Auto());
        left(new Auto());

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin-top CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength top(double size, Unit unit) {
        return top(new Numeric(size, unit));
    }

    /**
     * <p>
     * The margin-top CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @return
     */
    public BoxLength top(Numeric value) {
        return value(name + "-top", value);
    }

    /**
     * <p>
     * The margin-bottom CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength bottom(double size, Unit unit) {
        return bottom(new Numeric(size, unit));
    }

    /**
     * <p>
     * The margin-bottom CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @return
     */
    public BoxLength bottom(Numeric value) {
        return value(name + "-bottom", value);
    }

    /**
     * <p>
     * The margin-left CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength left(double size, Unit unit) {
        return left(new Numeric(size, unit));
    }

    /**
     * <p>
     * The margin-left CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @return
     */
    public BoxLength left(Numeric value) {
        return value(name + "-left", value);
    }

    /**
     * <p>
     * The margin-right CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength right(double size, Unit unit) {
        return right(new Numeric(size, unit));
    }

    /**
     * <p>
     * The margin-right CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @return
     */
    public BoxLength right(Numeric value) {
        return value(name + "-right", value);
    }

    /**
     * <p>
     * The margin-left and margin-right CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength horizontal(double size, Unit unit) {
        left(size, unit);
        right(size, unit);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin-left and margin-right CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @return
     */
    public BoxLength horizontal(Numeric value) {
        left(value);
        right(value);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin-top and margin-bottom CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public BoxLength vertical(double size, Unit unit) {
        top(size, unit);
        bottom(size, unit);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin-top and margin-bottom CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @return
     */
    public BoxLength vertical(Numeric value) {
        top(value);
        bottom(value);

        // Chainable API
        return this;
    }

    /**
     * @version 2018/09/02 7:06:43
     */
    private static class Auto extends Numeric {

        /**
         * Hide
         */
        private Auto() {
            super("auto");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public EnumSet<Vendor> vendors() {
            return NoVendors;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String valueFor(Vendor vendor) {
            return expression;
        }
    }
}