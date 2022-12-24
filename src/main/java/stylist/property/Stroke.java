/*
 * Copyright (C) 2021 stylist Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package stylist.property;

import stylist.CSSValue;
import stylist.PropertyDefinition;
import stylist.property.helper.ColorHelper;
import stylist.value.Numeric;
import stylist.value.Unit;

/**
 * @version 2018/08/30 18:28:15
 */
public class Stroke extends PropertyDefinition<Stroke> implements ColorHelper<Stroke> {

    /**
     * <p>
     * ‘stroke-linecap’ specifies the shape to be used at the end of open subpaths when they are
     * stroked. For further details see the path implementation notes.
     * </p>
     */
    public final LineCap linecap = new LineCap();

    /**
     * <p>
     * ‘stroke-linejoin’ specifies the shape to be used at the corners of paths or basic shapes when
     * they are stroked. For further details see the path implementation notes.
     * </p>
     */
    public final LineJoin linejoin = new LineJoin();

    public final Width width = new Width();

    /**
     * {@inheritDoc}
     */
    @Override
    public Stroke color(CSSValue color) {
        value("stroke", color);

        return this;
    }

    /**
     * @param width
     * @param unit
     * @return
     */
    public Stroke width(double width, Unit unit) {
        return width(new Numeric(width, unit));
    }

    /**
     * @param value
     * @return
     */
    public Stroke width(Numeric value) {
        return this.width.set(value);
    }

    /**
     * <p>
     * ‘stroke-dasharray’ controls the pattern of dashes and gaps used to stroke paths. <dasharray>
     * contains a list of comma and/or white space separated <length>s and <percentage>s that
     * specify the lengths of alternating dashes and gaps. If an odd number of values is provided,
     * then the list of values is repeated to yield an even number of values. Thus,
     * stroke-dasharray: 5,3,2 is equivalent to stroke-dasharray: 5,3,2,5,3,2.
     * </p>
     * 
     * @param sizes A list of comma and/or white space separated <length>s (which can have a unit
     *            identifier) and <percentage>s. A percentage represents a distance as a percentage
     *            of the current viewport (see Units). A negative value is an error (see Error
     *            processing). If the sum of the values is zero, then the stroke is rendered as if a
     *            value of none were specified. For further details see the path implementation
     *            notes.
     * @return Chainable API.
     */
    public Stroke dashArray(float... sizes) {
        return value("stroke-dasharray", " ", sizes);
    }

    /**
     * <p>
     * ‘stroke-dashoffset’ specifies the distance into the dash pattern to start the dash.
     * </p>
     * 
     * @param offset
     * @return
     */
    public Stroke dashOffset(double offset) {
        return value("stroke-dashoffset", offset);
    }

    public Stroke miterLimit(int size) {
        return value("stroke-miterlimit", size);
    }

    /**
     * <p>
     * The stroke-opacity attribute specifies the opacity of the outline on the current object. Its
     * default value is 1.
     * </p>
     * 
     * @param opacity The opacity of the painting operation used to outline the current object, as a
     *            number. Any values outside the range 0.0 (fully transparent) to 1.0 (fully opaque)
     *            will be clamped to this range.
     */
    public Stroke opacity(double opacity) {
        return value("stroke-opacity", opacity);
    }

    /**
     * @version 2015/03/23 17:03:00
     */
    public class Width extends PropertyDefinition<Stroke> {

        /**
         * 
         */
        private Width() {
            super("stroke-width", Stroke.this);
        }

        /**
         * <p>
         * Set numerical value.
         * </p>
         * 
         * @param value
         * @return
         */
        private Stroke set(Numeric value) {
            return value(value.toString());
        }
    }

    /**
     * <p>
     * ‘stroke-linecap’ specifies the shape to be used at the end of open subpaths when they are
     * stroked. For further details see the path implementation notes.
     * </p>
     * 
     * @version 2015/03/23 17:08:30
     */
    public class LineCap extends PropertyDefinition<Stroke> {

        /**
         * 
         */
        private LineCap() {
            super("stroke-linecap", Stroke.this);
        }

        /**
         * <p>
         * Normal.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke butt() {
            return value("butt");
        }

        /**
         * <p>
         * Rounded corner.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke round() {
            return value("round");
        }

        /**
         * <p>
         * Append square area.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke square() {
            return value("square ");
        }
    }

    /**
     * <p>
     * ‘stroke-linejoin’ specifies the shape to be used at the corners of paths or basic shapes when
     * they are stroked. For further details see the path implementation notes.
     * </p>
     * 
     * @version 2015/03/23 17:08:30
     */
    public class LineJoin extends PropertyDefinition<Stroke> {

        /**
         * 
         */
        private LineJoin() {
            super("stroke-linejoin", Stroke.this);
        }

        /**
         * <p>
         * Normal.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke miter() {
            return value("miter");
        }

        /**
         * <p>
         * Rounded corner.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke round() {
            return value("round");
        }

        /**
         * <p>
         * Bevel.
         * </p>
         * 
         * @return Chainable API.
         */
        public Stroke bevel() {
            return value("bevel  ");
        }
    }
}