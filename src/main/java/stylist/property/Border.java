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

import java.util.List;

import stylist.PropertyDefinition;
import stylist.property.helper.ColorHelper;
import stylist.value.Numeric;
import stylist.value.Unit;

public abstract class Border extends PropertyDefinition<Border> implements ColorHelper<Border> {

    /**
     * 
     */
    protected Border() {
    }

    /**
     * <p>
     * Set the radius of this border.
     * </p>
     * <p>
     * The border-radius CSS property allows Web authors to define how rounded border corners are.
     * The curve of each corner is defined using one or two radii, defining its shape: circle or
     * ellipse.
     * </p>
     * 
     * @param size A radius to set.
     * @return Chainable API.
     */
    public abstract Border radius(Numeric size);

    /**
     * <p>
     * Set the radius of this border.
     * </p>
     * <p>
     * The border-radius CSS property allows Web authors to define how rounded border corners are.
     * The curve of each corner is defined using one or two radii, defining its shape: circle or
     * ellipse.
     * </p>
     * 
     * @param size A radius to set.
     * @param unit A width unit to set.
     * @return Chainable API.
     */
    public final Border radius(double size, Unit unit) {
        return radius(new Numeric(size, unit));
    }

    /**
     * <p>
     * Set the width of this border.
     * </p>
     * 
     * @param size A width to set.
     * @return Chainable API.
     */
    public abstract Border width(Numeric size);

    /**
     * <p>
     * Set the width of this border.
     * </p>
     * 
     * @param size A width to set.
     * @param unit A width unit to set.
     * @return Chainable API.
     */
    public final Border width(double size, Unit unit) {
        return width(new Numeric(size, unit));
    }

    /**
     * <p>
     * Set the style of this border.
     * </p>
     * 
     * @param style A style to set.
     * @return Chainable API.
     */
    protected abstract Border style(String style);

    /**
     * <p>
     * Like for the hidden keyword, displays no border. In that case, except if a background image
     * is set, the calculated values of border-width will be 0, even if specified otherwise through
     * the property. In case of table cell and border collapsing, the none value has the lowest
     * priority: it means that if any other conflicting border is set, it will be displayed.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border none() {
        return style("none");
    }

    /**
     * <p>
     * Like for the none keyword, displays no border. In that case, except if a background image is
     * set, the calculated values of border-width will be 0, even if specified otherwise through the
     * property. In case of table cell and border collapsing, the hidden value has the highest
     * priority: it means that if any other conflicting border is set, it won't be displayed.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border hidden() {
        return style("hidden");
    }

    /**
     * <p>
     * Displays a series of rounded dots. The spacing of the dots are not defined by the
     * specification and are implementation-specific. The radius of the dots is half the calculated
     * border-width.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border dotted() {
        return style("dotted");
    }

    /**
     * <p>
     * Displays a series of short square-ended dashes or line segments. The exact size and length of
     * the segments are not defined by the specification and are implementation-specific.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border dashed() {
        return style("dashed");
    }

    /**
     * <p>
     * Displays a single, straight, solid line.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border solid() {
        return style("solid");
    }

    /**
     * <p>
     * Displays two straight lines that add up to the pixel amount defined as border-width .
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border doubles() {
        return style("double");
    }

    /**
     * <p>
     * Displays a border leading to a carved effect. It is the opposite of ridge.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border groove() {
        return style("groove");
    }

    /**
     * <p>
     * Displays a border with a 3D effect, like if it is coming out of the page. It is the opposite
     * of groove.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border ridge() {
        return style("ridge");
    }

    /**
     * <p>
     * Displays a border that makes the box appear embedded. It is the opposite of outset. When
     * applied to a table cell with border-collapse set to collapsed, this value behaves like
     * groove.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border inset() {
        return style("inset");
    }

    /**
     * <p>
     * Displays a border that makes the box appear in 3D, embossed. It is the opposite of inset.
     * When applied to a table cell with border-collapse set to collapsed, this value behaves like
     * ridge.
     * </p>
     * 
     * @return Chainable API.
     */
    public final Border outset() {
        return style("outset");
    }

    /**
     * <p>
     * The border-spacing CSS property sets the distance between the borders of adjacent
     * <table>
     * cells. This property applies only when border-collapse is separate.
     * </p>
     */
    public final Border spacing(double length, Unit unit) {
        return spacing(Numeric.of(length, unit));
    }

    /**
     * <p>
     * The border-spacing CSS property sets the distance between the borders of adjacent
     * <table>
     * cells. This property applies only when border-collapse is separate.
     * </p>
     */
    public final Border spacing(Numeric length) {
        return value("border-spacing", length);
    }

    /**
     * <p>
     * The border-spacing CSS property sets the distance between the borders of adjacent
     * <table>
     * cells. This property applies only when border-collapse is separate.
     * </p>
     */
    public final Border spacing(double horizontalLength, Unit horizontalUnit, double verticalLength, Unit vertivalUnit) {
        return spacing(Numeric.of(horizontalLength, horizontalUnit), Numeric.of(verticalLength, vertivalUnit));
    }

    /**
     * <p>
     * The border-spacing CSS property sets the distance between the borders of adjacent
     * <table>
     * cells. This property applies only when border-collapse is separate.
     * </p>
     */
    public final Border spacing(Numeric horizontal, Numeric vertical) {
        return value("border-spacing", List.of(horizontal, vertical), " ");
    }
}