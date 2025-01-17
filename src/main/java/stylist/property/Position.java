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

import static stylist.StyleDSL.*;
import static stylist.value.Unit.*;

import stylist.PropertyDefinition;
import stylist.value.Numeric;
import stylist.value.Unit;

public final class Position extends PropertyDefinition<Position> {

    /**
     * The inset CSS property is a shorthand that corresponds to the top, right, bottom, and/or left
     * properties. It has the same multi-value syntax of the margin shorthand.
     */
    public final BoxLength inset = new BoxLength("inset", "");

    /**
     * <p>
     * Helper method to test position property.
     * </p>
     * 
     * @return A result.
     */
    public boolean isRelative() {
        return is("relative");
    }

    /**
     * <p>
     * Lay out all elements as though the element were not positioned, and then adjust the element's
     * position, without changing layout (and thus leaving a gap for the element where it would have
     * been had it not been positioned). The effect of position:relative on table-*-group,
     * table-row, table-column, table-cell, and table-caption elements is undefined.
     * </p>
     * 
     * @return
     */
    public Position relative() {
        return value("relative");
    }

    /**
     * <p>
     * Helper method to test position property.
     * </p>
     * 
     * @return A result.
     */
    public boolean isAbsolute() {
        return is("absolute");
    }

    /**
     * <p>
     * Do not leave space for the element. Instead, position it at a specified position relative to
     * its closest positioned ancestor or to the containing block. Absolutely positioned boxes can
     * have margins, they do not collapse with any other margins.
     * </p>
     * 
     * @return
     */
    public Position absolute() {
        return value("absolute");
    }

    /**
     * <p>
     * Do not leave space for the element. Instead, position it at a specified position relative to
     * the screen's viewport and doesn't move when scrolled. When printing, position it at that
     * fixed position on every page.
     * </p>
     * 
     * @return
     */
    public Position fixed() {
        return value("fixed");
    }

    /**
     * <p>
     * The element is positioned according to the normal flow of the document, and then offset
     * relative to its nearest scrolling ancestor and containing block (nearest block-level
     * ancestor), including table-related elements, based on the values of top, right, bottom, and
     * left. The offset does not affect the position of any other elements.
     * </p>
     * 
     * @return
     */
    public Position sticky() {
        return value("sticky");
    }

    /**
     * <p>
     * The left CSS property specifies part of the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the left margin edge of the element and the left edge of its
     * containing block.
     * </p>
     * 
     * @param size A position value.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Position left(double size, Unit unit) {
        return left(new Numeric(size, unit));
    }

    /**
     * <p>
     * The left CSS property specifies part of the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the left margin edge of the element and the left edge of its
     * containing block.
     * </p>
     * 
     * @param value A position value.
     * @return Chainable API.
     */
    public Position left(Numeric value) {
        return value("left", value);
    }

    /**
     * <p>
     * The right CSS property specifies part of the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the right margin edge of the element and the right edge of its
     * containing block.
     * </p>
     * <p>
     * The right property has no effect on non-positioned elements.
     * </p>
     * <p>
     * When both the right CSS property and the left CSS property are defined, the position of the
     * element is overspecified. In that case, the left value has precedence when the container is
     * left-to-right (that is that the right computed value is set to -left), and the right value
     * has precedence when the container is right-to-left (that is that the left computed value is
     * set to -right).
     * </p>
     * 
     * @param size A position value.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Position right(double size, Unit unit) {
        return right(new Numeric(size, unit));
    }

    /**
     * <p>
     * The right CSS property specifies part of the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the right margin edge of the element and the right edge of its
     * containing block.
     * </p>
     * <p>
     * The right property has no effect on non-positioned elements.
     * </p>
     * <p>
     * When both the right CSS property and the left CSS property are defined, the position of the
     * element is overspecified. In that case, the left value has precedence when the container is
     * left-to-right (that is that the right computed value is set to -left), and the right value
     * has precedence when the container is right-to-left (that is that the left computed value is
     * set to -right).
     * </p>
     * 
     * @param value A position value.
     * @return Chainable API.
     */
    public Position right(Numeric value) {
        return value("right", value);
    }

    /**
     * <p>
     * The top CSS property specifies part of the position of positioned elements. It has no effect
     * on non-positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the top margin edge of the element and the top edge of its
     * containing block.
     * </p>
     * <p>
     * For relatively positioned elements (those with position: relative), it specifies the amount
     * the element is moved below its normal position.
     * </p>
     * <p>
     * When both top and bottom are specified, the element position is over-constrained and the top
     * property has precedence: the computed value of bottom is set to -top, while its specified
     * value is ignored.
     * </p>
     * 
     * @param size A position value.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Position top(double size, Unit unit) {
        return top(new Numeric(size, unit));
    }

    /**
     * <p>
     * The top CSS property specifies part of the position of positioned elements. It has no effect
     * on non-positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the top margin edge of the element and the top edge of its
     * containing block.
     * </p>
     * <p>
     * For relatively positioned elements (those with position: relative), it specifies the amount
     * the element is moved below its normal position.
     * </p>
     * <p>
     * When both top and bottom are specified, the element position is over-constrained and the top
     * property has precedence: the computed value of bottom is set to -top, while its specified
     * value is ignored.
     * </p>
     * 
     * @param value A position value.
     * @return Chainable API.
     */
    public Position top(Numeric value) {
        return value("top", value);
    }

    /**
     * <p>
     * The bottom CSS property participates in specifying the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements, that is those with position: absolute or position: fixed,
     * it specifies the distance between the bottom margin edge of the element and the bottom edge
     * of its containing block.
     * </p>
     * <p>
     * For relatively positioned elements, that is those with position: relative, it specifies the
     * distance the element is moved above its normal position.
     * </p>
     * <p>
     * However, the top property overrides the bottom property, so if top is not auto, the computed
     * value of bottom is the negative of the computed value of top.
     * </p>
     * 
     * @param size A position value.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Position bottom(double size, Unit unit) {
        return bottom(new Numeric(size, unit));
    }

    /**
     * <p>
     * The bottom CSS property participates in specifying the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements, that is those with position: absolute or position: fixed,
     * it specifies the distance between the bottom margin edge of the element and the bottom edge
     * of its containing block.
     * </p>
     * <p>
     * For relatively positioned elements, that is those with position: relative, it specifies the
     * distance the element is moved above its normal position.
     * </p>
     * <p>
     * However, the top property overrides the bottom property, so if top is not auto, the computed
     * value of bottom is the negative of the computed value of top.
     * </p>
     * 
     * @return Chainable API.
     */
    public Position bottom(Numeric value) {
        return value("bottom", value);
    }

    /**
     * <p>
     * Extended property for centering the box against the parent box.
     * </p>
     * 
     * @return Chainable API.
     */
    public Position center() {
        position.absolute().bottom(50, percent).right(50, percent);
        transform.translate(50, percent);
        return this;
    }

    /**
     * <p>
     * Extended property for centering the box vertically against the parent box.
     * </p>
     * 
     * @return Chainable API.
     */
    public Position centerVertically() {
        position.absolute().bottom(50, percent);
        transform.translateY(50, percent);

        return this;
    }

    /**
     * <p>
     * Extended property for centering the box horizontally against the parent box.
     * </p>
     * 
     * @return Chainable API.
     */
    public Position centerHorizontally() {
        position.absolute().right(50, percent);
        transform.translateX(50, percent);

        return this;
    }
}