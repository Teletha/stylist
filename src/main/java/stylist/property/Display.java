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

import stylist.PropertyDefinition;
import stylist.value.CSSValue;
import stylist.value.Numeric;
import stylist.value.Shadow;
import stylist.value.Unit;
import stylist.value.Vendor;

public final class Display extends PropertyDefinition<Display> {

    /**
     * <p>
     * The height CSS property specifies the height of an element. By default, the property defines
     * the height of the content area. If box-sizing is set to border-box, however, it instead
     * determines the height of the border area.
     * </p>
     */
    public final Height height = new Height();

    /**
     * <p>
     * The width CSS property sets an element's width. By default, it sets the width of the content
     * area, but if box-sizing is set to border-box, it sets the width of the border area.
     * </p>
     */
    public final Width width = new Width();

    /**
     * <p>
     * The box-sizing CSS property is used to alter the default CSS box model used to calculate
     * widths and heights of elements. It is possible to use this property to emulate the behavior
     * of browsers that do not correctly support the CSS box model specification.
     * </p>
     */
    public final Sizing sizing = new Sizing();

    /**
     * <p>
     * The visibility CSS property shows or hides an element without changing the layout of a
     * document. The property can also hide rows or columns in a table. To both hide an element and
     * remove it from the document layout, set the display property to none instead of using
     * visibility.
     * </p>
     */
    public final Visibility visibility = new Visibility();

    /**
     * The element generates a block element box.
     */
    public Display block() {
        return value("block");
    }

    /**
     * The element generates one or more inline element boxes.
     */
    public Display inline() {
        return value("inline");
    }

    /**
     * The element generates a block element box that will be flowed with surrounding content as if
     * it were a single inline box (behaving much like a replaced element would)
     */
    public Display inlineBlock() {
        return value("inline-block");
    }

    /**
     * The element generates a block box for the content and a separate list-item inline box.
     */
    public Display listItem() {
        return value("list-item");
    }

    // /**
    // * <p>
    // * If the run-in box contains a block box, same as block.
    // * </p>
    // * <p>
    // * If a block box follows the run-in box, the run-in box becomes the first inline box of the
    // * block box.
    // * </p>
    // * <p>
    // * If a inline box follows, the run-in box becomes a block box.
    // * </p>
    // */
    // public Display runIn() {
    // return value("run-in");
    // }

    /**
     * The element behaves like a block element and lay out its content according to the grid model.
     */
    public Grid grid() {
        value(CSSValue.of("grid"));

        return new Grid();
    }

    /**
     * The element behaves like an inline element and lay out its content according to the grid
     * model.
     */
    public Grid inlineGrid() {
        value(CSSValue.of("inline-grid"));

        return new Grid();
    }

    /**
     * The element behaves like a block element and lays out its content according to the flexbox
     * model.
     */
    public Flex flex() {
        value(CSSValue.of("flex", Vendor.Webkit));

        return new Flex();
    }

    /**
     * The element behaves like an inline element and lays out its content according to the flexbox
     * model.
     */
    public Flex inlineFlex() {
        value(CSSValue.of("inline-flex", Vendor.Webkit));

        return new Flex();
    }

    /**
     * Behaves like the table HTML element. It defines a block-level box.
     */
    public Display table() {
        return value("table");
    }

    /**
     * The inline-table value does not have a direct mapping in HTML. It behaves like a table HTML
     * element, but as an inline box, rather than a block-level box. Inside the table box is a
     * block-level context.
     */
    public Display inlineTable() {
        return value("inline-table");
    }

    /**
     * Behaves like the caption HTML element.
     */
    public Display tableCaption() {
        return value("table-caption");
    }

    /**
     * Behaves like the tr HTML element.
     */
    public Display tableRow() {
        return value("table-row");
    }

    /**
     * Behaves like the td HTML element.
     */
    public Display tableCell() {
        return value("table-cell");
    }

    /**
     * These elements behave like the corresponding col HTML elements.
     */
    public Display tableColumn() {
        return value("table-column");
    }

    /**
     * These elements behave like the corresponding colgroup HTML elements.
     */
    public Display tableColumnGroup() {
        return value("table-column-group");
    }

    /**
     * These elements behave like the corresponding thead HTML elements.
     */
    public Display tableHeaderGroup() {
        return value("table-header-group");
    }

    /**
     * These elements behave like the corresponding tfoot HTML elements.
     */
    public Display tableFooterGroup() {
        return value("table-footer-group");
    }

    /**
     * These elements behave like the corresponding tbody HTML elements.
     */
    public Display tableRowGroup() {
        return value("table-row-group");
    }

    /**
     * <p>
     * Turns off the display of an element (it has no effect on layout)); all child elements also
     * have their display turned off. The document is rendered as though the element did not exist.
     * </p>
     * <p>
     * To render an element box's dimensions, yet have its contents be invisible, see the visibility
     * property.
     * </p>
     */
    public Display none() {
        return value("none");
    }

    /**
     * <p>
     * Alias for <code>display.flex()</code>.
     * </p>
     * <p>
     * The element behaves like a block element and lays out its content according to the horizontal
     * flexbox model.
     * </p>
     */
    public Flex horizontalBox() {
        return flex();
    }

    /**
     * <p>
     * Alias for <code>display.flex().direction.column()</code>.
     * </p>
     * <p>
     * The element behaves like a block element and lays out its content according to the vertical
     * flexbox model.
     * </p>
     */
    public Flex verticalBox() {
        return flex().direction.column();
    }

    /**
     * <p>
     * Setting width and height properties.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Display size(double size, Unit unit) {
        return size(new Numeric(size, unit));
    }

    /**
     * <p>
     * Setting width and height properties.
     * </p>
     * 
     * @return
     */
    public Display size(Numeric value) {
        width(value);
        height(value);

        return this;
    }

    /**
     * <p>
     * The width CSS property specifies the width of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-width and max-width properties override width.
     * </p>
     * 
     * @param size A box width.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Display width(double size, Unit unit) {
        return width(new Numeric(size, unit));
    }

    /**
     * <p>
     * The width CSS property specifies the width of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-width and max-width properties override width.
     * </p>
     * 
     * @return Chainable API.
     */
    public Display width(Numeric value) {
        return value("width", value);
    }

    /**
     * <p>
     * The min-width CSS property is used to set the minimum width of a given element. It prevents
     * the used value of the width property from becoming smaller than the value specified for
     * min-width.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Display minWidth(double size, Unit unit) {
        return minWidth(new Numeric(size, unit));
    }

    /**
     * <p>
     * The min-width CSS property is used to set the minimum width of a given element. It prevents
     * the used value of the width property from becoming smaller than the value specified for
     * min-width.
     * </p>
     * 
     * @return
     */
    public Display minWidth(Numeric value) {
        return value("min-width", value);
    }

    /**
     * <p>
     * The max-width CSS property is used to set the maximum width of a given element. It prevents
     * the used value of the width property from becoming larger than the value specified for
     * max-width.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Display maxWidth(double size, Unit unit) {
        return maxWidth(new Numeric(size, unit));
    }

    /**
     * <p>
     * The max-width CSS property is used to set the maximum width of a given element. It prevents
     * the used value of the width property from becoming larger than the value specified for
     * max-width.
     * </p>
     * 
     * @return
     */
    public Display maxWidth(Numeric value) {
        return value("max-width", value);
    }

    /**
     * <p>
     * The height CSS property specifies the height of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-height and max-height properties override height.
     * </p>
     * 
     * @param size A box width.
     * @param unit A unit.
     * @return Chainable API.
     */
    public Display height(double size, Unit unit) {
        return height(new Numeric(size, unit));
    }

    /**
     * <p>
     * The height CSS property specifies the height of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-height and max-height properties override height.
     * </p>
     * 
     * @return Chainable API.
     */
    public Display height(Numeric value) {
        return value("height", value);
    }

    /**
     * <p>
     * The min-height CSS property is used to set the minimum height of a given element. It prevents
     * the used value of the height property from becoming smaller than the value specified for
     * min-height.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Display minHeight(double size, Unit unit) {
        return minHeight(new Numeric(size, unit));
    }

    /**
     * <p>
     * The min-height CSS property is used to set the minimum height of a given element. It prevents
     * the used value of the height property from becoming smaller than the value specified for
     * min-height.
     * </p>
     * 
     * @return
     */
    public Display minHeight(Numeric value) {
        return value("min-height", value);
    }

    /**
     * <p>
     * The max-height CSS property is used to set the maximum height of a given element. It prevents
     * the used value of the height property from becoming larger than the value specified for
     * max-height.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Display maxHeight(double size, Unit unit) {
        return maxHeight(new Numeric(size, unit));
    }

    /**
     * <p>
     * The max-height CSS property is used to set the maximum height of a given element. It prevents
     * the used value of the height property from becoming larger than the value specified for
     * max-height.
     * </p>
     * 
     * @return
     */
    public Display maxHeight(Numeric value) {
        return value("max-height", value);
    }

    /**
     * <p>
     * The z-index CSS property specifies the z-order of an element and its descendants. When
     * elements overlap, z-order determines which one covers the other. An element with a larger
     * z-index generally covers an element with a lower one.
     * </p>
     * 
     * @param value
     */
    public Display zIndex(int value) {
        return value("z-index", value);
    }

    /**
     * <p>
     * The float CSS property places an element on the left or right side of its container, allowing
     * text and inline elements to wrap around it. The element is removed from the normal flow of
     * the page, though still remaining a part of the flow (in contrast to absolute positioning).
     * </p>
     * 
     * @return
     */
    public Display floatRight() {
        return value("float", "right");
    }

    /**
     * <p>
     * The float CSS property places an element on the left or right side of its container, allowing
     * text and inline elements to wrap around it. The element is removed from the normal flow of
     * the page, though still remaining a part of the flow (in contrast to absolute positioning).
     * </p>
     * 
     * @return
     */
    public Display floatLeft() {
        return value("float", "left");
    }

    /**
     * <p>
     * The opacity CSS property specifies the transparency of an element, that is, the degree to
     * which the background behind the element is overlaid. Using this property with a value
     * different than 1 places the element in a new stacking context.
     * </p>
     */
    public Display opacity(double alpha) {
        return value("opacity", alpha);
    }

    /**
     * <p>
     * The box-shadow CSS property describes one or more shadow effects as a comma-separated list.
     * It allows casting a drop shadow from the frame of almost any element. If a border-radius is
     * specified on the element with a box shadow, the box shadow takes on the same rounded corners.
     * The z-ordering of multiple box shadows is the same as multiple text shadows (the first
     * specified shadow is on top).
     * </p>
     * 
     * @return
     */
    public Display shadow(Shadow... shadows) {
        return value("box-shadow", join(shadows, v -> v.toString()));
    }

    /**
     * 
     */
    public class Height extends PropertyDefinition<Display> {

        /**
         * Hide.
         */
        private Height() {
            super("height", Display.this);
        }

        /**
         * <p>
         * The browser will calculate and select a height for the specified element.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display auto() {
            return value("auto");
        }

        /**
         * <p>
         * The intrinsic preferred height.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display maxContent() {
            return value("max-content");
        }

        /**
         * <p>
         * The intrinsic minimum height.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display minContent() {
            return value("min-content");
        }

        /**
         * <p>
         * The larger of: the intrinsic minimum height the smaller of the intrinsic preferred height
         * and the available height
         * </p>
         * 
         * @return Chainable API.
         */
        public Display fitContent() {
            return value("fit-content");
        }

        /**
         * <p>
         * Use the fill-available inline size or fill-available block size, as appropriate to the
         * writing mode.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display fill() {
            return value("fill");
        }
    }

    /**
     * 
     */
    public class Width extends PropertyDefinition<Display> {

        /**
         * Hide.
         */
        private Width() {
            super("width", Display.this);
        }

        /**
         * <p>
         * The browser will calculate and select a height for the specified element.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display auto() {
            return value("auto");
        }

        /**
         * <p>
         * The intrinsic preferred height.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display maxContent() {
            return value("max-content");
        }

        /**
         * <p>
         * The intrinsic minimum height.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display minContent() {
            return value("min-content");
        }

        /**
         * <p>
         * The larger of: the intrinsic minimum height the smaller of the intrinsic preferred height
         * and the available height
         * </p>
         * 
         * @return Chainable API.
         */
        public Display fitContent() {
            return value("fit-content");
        }

        /**
         * <p>
         * Use the fill-available inline size or fill-available block size, as appropriate to the
         * writing mode.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display fill() {
            return value("fill");
        }
    }

    public class Sizing extends PropertyDefinition<Display> {

        /**
         * Hide.
         */
        private Sizing() {
            super("box-sizing", Display.this);
        }

        /**
         * <p>
         * This is the default style as specified by the CSS standard. The width and height
         * properties are measured including only the content, but not the border, margin, or
         * padding.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display contentBox() {
            return value("content-box");
        }

        /**
         * <p>
         * The width and height properties include the padding and border, but not the margin. This
         * is the box model used by Internet Explorer when the document is in Quirks mode.
         * </p>
         * 
         * @return Chainable API.
         */
        public Display borderBox() {
            return value("border-box");
        }
    }

    /**
     * Property for visibility.
     */
    public class Visibility extends PropertyDefinition<Display> {

        private Visibility() {
            super("visibility", Display.this);
        }

        /**
         * <p>
         * Default value, the box is visible.
         * </p>
         * 
         * @return
         */
        public Display visible() {
            return value("visible");
        }

        /**
         * <p>
         * The box is invisible (fully transparent, nothing is drawn), but still affects layout.
         * Descendants of the element will be visible if they have visibility:visible (this doesn't
         * work in IE up to version 7).
         * </p>
         * 
         * @return
         */
        public Display hidden() {
            return value("hidden");
        }

        /**
         * <p>
         * For table rows, columns, column groups, and row groups the row(s) or column(s) are hidden
         * and the space they would have occupied is (as if display: none were applied to the
         * column/row of the table). However, the size of other rows and columns is still calculated
         * as though the cells in the collapsed row(s) or column(s) are present. This was designed
         * for fast removal of a row/column from a table without having to recalculate widths and
         * heights for every portion of the table. For XUL elements, the computed size of the
         * element is always zero, regardless of other styles that would normally affect the size,
         * although margins still take effect. For other elements, collapse is treated the same as
         * hidden.
         * </p>
         * 
         * @return
         */
        public Display collapse() {
            return value("collapse");
        }
    }

    // Float is the root of EVIL.
    // /**
    // * @version 2014/10/28 22:03:37
    // */
    // public class Float extends PropertyDefinition<Box> {
    //
    // /**
    // * Hide.
    // */
    // private Float() {
    // super("float", Box.this);
    // }
    //
    // /**
    // * <p>
    // * Is a keyword indicating that the element must float on the left side of its containing
    // * block.
    // * </p>
    // *
    // * @return Chainable API.
    // */
    // public Box left() {
    // return value("left");
    //
    // }
    //
    // /**
    // * <p>
    // * Is a keyword indicating that the element must float on the right side of its containing
    // * block.
    // * </p>
    // *
    // * @return Chainable API.
    // */
    // public Box right() {
    // return value("right");
    // }
    //
    // /**
    // * <p>
    // * Is a keyword indicating that the element must not float.
    // * </p>
    // *
    // * @return Chainable API.
    // */
    // public Box none() {
    // return value("none");
    // }
    // }
}