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
import stylist.value.FontSet;
import stylist.value.Numeric;
import stylist.value.Unit;

public class Font extends PropertyDefinition<Font> implements ColorHelper<Font> {

    /**
     * The font-style CSS property allows italic or oblique faces to be selected within a
     * font-family.
     */
    public final Style style = new Style();

    /**
     * The font-variant CSS property selects a normal, or small-caps face from a font family.
     * Setting font-variant is also possible by using the font shorthand.
     */
    public final Variant variant = new Variant();

    /**
     * The font-weight CSS property specifies the weight or boldness of the font. However, some
     * fonts are not available in all weights; some are available only on normal and bold.
     */
    public final Weight weight = new Weight();

    /**
     * The font-size CSS property specifies the size of the font. Setting the font size may, in
     * turn, change the size of other items, since it is used to compute the value of em and ex
     * length units.
     */
    public final Size size = new Size();

    /**
     * {@inheritDoc}
     */
    @Override
    public Font color(CSSValue color) {
        value("color", color);

        return this;
    }

    /**
     * The font-size CSS property specifies the size of the font. Setting the font size may, in
     * turn, change the size of other items, since it is used to compute the value of em and ex
     * length units.
     * 
     * @param size
     * @param unit
     * @return
     */
    public Font size(double size, Unit unit) {
        return size(new Numeric(size, unit));
    }

    /**
     * The font-size CSS property specifies the size of the font. Setting the font size may, in
     * turn, change the size of other items, since it is used to compute the value of em and ex
     * length units.
     * 
     * @param value
     * @return
     */
    public Font size(Numeric value) {
        return this.size.set(value);
    }

    /**
     * <p>
     * The font-weight CSS property specifies the weight or boldness of the font. However, some
     * fonts are not available in all weights; some are available only on normal and bold.
     * </p>
     * <p>
     * Numeric font weights for fonts that provide more than just normal and bold. If the exact
     * weight given is unavailable, then 600-900 use the closest available darker weight (or, if
     * there is none, the closest available lighter weight), and 100-500 use the closest available
     * lighter weight (or, if there is none, the closest available darker weight). This means that
     * for fonts that provide only normal and bold, 100-500 are normal, and 600-900 are bold.
     * </p>
     * 
     * @param size
     * @return
     */
    public Font weight(int size) {
        return weight.number(size);
    }

    /**
     * <p>
     * The font-family CSS property allows for a prioritized list of font family names and/or
     * generic family names to be specified for the selected element. Unlike most other CSS
     * properties, values are separated by a comma to indicate that they are alternatives. The
     * browser will select the first font on the list that is installed on the computer, or that can
     * be downloaded using the information provided by a @font-face at-rule.
     * </p>
     * <p>
     * Web authors should always add at least one generic family in a font-family list, since
     * there's no guarantee that a specific font is intalled on the computer or can be downloaded
     * using a @font-face at-rule. The generic family lets the browser select an acceptable fallback
     * font when needed.
     * </p>
     * 
     * @param fonts
     * @return
     */
    public Font family(FontSet fonts) {
        return value("font-family", fonts);
    }

    /**
     * <p>
     * The font-family CSS property allows for a prioritized list of font family names and/or
     * generic family names to be specified for the selected element. Unlike most other CSS
     * properties, values are separated by a comma to indicate that they are alternatives. The
     * browser will select the first font on the list that is installed on the computer, or that can
     * be downloaded using the information provided by a @font-face at-rule.
     * </p>
     * <p>
     * Web authors should always add at least one generic family in a font-family list, since
     * there's no guarantee that a specific font is intalled on the computer or can be downloaded
     * using a @font-face at-rule. The generic family lets the browser select an acceptable fallback
     * font when needed.
     * </p>
     * 
     * @param fonts
     * @return
     */
    public Font family(CharSequence... fonts) {
        FontSet set = new FontSet();

        for (CharSequence font : fonts) {
            if (font instanceof stylist.value.Font) {
                set.local((stylist.value.Font) font);
            } else {
                set.local(font.toString());
            }
        }
        return family(set);
    }

    /**
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * 
     * @param size
     * @return
     */
    public Font lineHeight(double size) {
        return value("line-height", size);
    }

    /**
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * 
     * @param size
     * @return
     */
    public Font lineHeight(Numeric size) {
        return value("line-height", size);
    }

    /**
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * 
     * @param size
     * @return
     */
    public Font lineHeight(double size, Unit unit) {
        return lineHeight(new Numeric(size, unit));
    }

    /**
     * The letter-spacing CSS property sets the horizontal spacing behavior between text characters.
     * This value is added to the natural spacing between characters while rendering the text.
     * Positive values of letter-spacing causes characters to spread farther apart, while negative
     * values of letter-spacing bring characters closer together.
     * 
     * @param size
     * @return
     */
    public Font letterSpacing(Numeric size) {
        return value("letter-spacing", size);
    }

    /**
     * The letter-spacing CSS property sets the horizontal spacing behavior between text characters.
     * This value is added to the natural spacing between characters while rendering the text.
     * Positive values of letter-spacing causes characters to spread farther apart, while negative
     * values of letter-spacing bring characters closer together.
     * 
     * @param size
     * @return
     */
    public Font letterSpacing(double size, Unit unit) {
        return letterSpacing(new Numeric(size, unit));
    }

    public class Size extends PropertyDefinition<Font> {

        /**
         * 
         */
        private Size() {
            super("font-size", Font.this);
        }

        /**
         * Set numerical value.
         * 
         * @param value
         * @return
         */
        private Font set(Numeric value) {
            return value(value.toString());
        }

        /**
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * 
         * @return
         */
        public Font xxsmall() {
            return value("xx-small");
        }

        /**
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * 
         * @return
         */
        public Font xsmall() {
            return value("x-small");
        }

        /**
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * 
         * @return
         */
        public Font small() {
            return value("small");
        }

        /**
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * 
         * @return
         */
        public Font medium() {
            return value("medium");
        }

        /**
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * 
         * @return
         */
        public Font large() {
            return value("large");
        }

        /**
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * 
         * @return
         */
        public Font xlarge() {
            return value("x-large");
        }

        /**
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * 
         * @return
         */
        public Font xxlarge() {
            return value("xx-large");
        }

        /**
         * Larger or smaller than the parent element's font size, by roughly the ratio used to
         * separate the absolute size keywords above.
         * 
         * @return
         */
        public Font larger() {
            return value("larger");
        }

        /**
         * Larger or smaller than the parent element's font size, by roughly the ratio used to
         * separate the absolute size keywords above.
         * 
         * @return
         */
        public Font smaller() {
            return value("smaller");
        }
    }

    /**
     * @version 2014/10/28 22:39:08
     */
    public class Style extends PropertyDefinition<Font> {

        /**
         * 
         */
        private Style() {
            super("font-style", Font.this);
        }

        /**
         * <p>
         * selects a font that is classified as normal within a font-family
         * </p>
         * 
         * @return
         */
        public Font normal() {
            return value("normal");
        }

        /**
         * <p>
         * selects a font that is labeled italic, if that is not available, one labeled oblique
         * </p>
         * 
         * @return
         */
        public Font italic() {
            return value("italic");
        }

        /**
         * <p>
         * selects a font that is labeled oblique
         * </p>
         * 
         * @return
         */
        public Font oblique() {
            return value("oblique");
        }
    }

    /**
     * @version 2014/10/28 22:39:12
     */
    public class Weight extends PropertyDefinition<Font> {

        /**
         * 
         */
        private Weight() {
            super("font-weight", Font.this);
        }

        /**
         * <p>
         * Normal font weight. Same as 400.
         * </p>
         * 
         * @return
         */
        public Font normal() {
            return value("normal");
        }

        /**
         * <p>
         * Bold font weight. Same as 700.
         * </p>
         * 
         * @return
         */
        public Font bold() {
            return value("bold");
        }

        /**
         * <p>
         * One font weight lighter than the parent element (among the available weights of the
         * font).
         * </p>
         * 
         * @return
         */
        public Font lighter() {
            return value("lighter");
        }

        /**
         * <p>
         * One font weight darker than the parent element (among the available weights of the font).
         * </p>
         * 
         * @return
         */
        public Font bolder() {
            return value("bolder");
        }

        /**
         * <p>
         * The font-weight CSS property specifies the weight or boldness of the font. However, some
         * fonts are not available in all weights; some are available only on normal and bold.
         * </p>
         * <p>
         * Numeric font weights for fonts that provide more than just normal and bold. If the exact
         * weight given is unavailable, then 600-900 use the closest available darker weight (or, if
         * there is none, the closest available lighter weight), and 100-500 use the closest
         * available lighter weight (or, if there is none, the closest available darker weight).
         * This means that for fonts that provide only normal and bold, 100-500 are normal, and
         * 600-900 are bold.
         * </p>
         * 
         * @param size
         * @return
         */
        private Font number(int size) {
            return value(String.valueOf(size));
        }
    }

    /**
     * @version 2014/10/28 22:39:17
     */
    public class Variant extends PropertyDefinition<Font> {

        /**
         * 
         */
        private Variant() {
            super("font-variant", Font.this);
        }

        /**
         * <p>
         * Specifies a font that is labeled as a small-caps font. If a small-caps font is not
         * available, Mozilla (Firefox) and other browsers will simulate a small-caps font, i.e. by
         * taking a normal font and replacing the lowercase letters by scaled uppercase characters.
         * </p>
         * 
         * @return
         */
        public Font smallCaps() {
            return value("small-caps");
        }

        /**
         * <p>
         * Specifies a normal font face.
         * </p>
         * 
         * @return
         */
        public Font normal() {
            return value("normal");
        }
    }
}