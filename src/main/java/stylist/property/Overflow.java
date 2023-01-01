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

import stylist.PropertyDefinition;

/**
 * @version 2018/08/30 18:26:50
 */
public class Overflow<T extends Overflow> extends PropertyDefinition<T> {

    /**
     * <p>
     * Create property.
     * </p>
     * 
     * @param name A property name.
     */
    protected Overflow(String name) {
        super(name);
    }

    /**
     * <p>
     * Create property.
     * </p>
     * 
     * @param name A property name.
     * @param context A context object for chainable API.
     */
    protected Overflow(String name, T context) {
        super(name, context);
    }

    /**
     * <p>
     * Default value. Content is not clipped, it may be rendered outside the content box.
     * </p>
     * 
     * @return
     */
    public T visible() {
        return value("visible");
    }

    /**
     * <p>
     * The content is clipped and no scrollbars are provided.
     * </p>
     * 
     * @return
     */
    public T hidden() {
        return value("hidden");
    }

    /**
     * <p>
     * The content is clipped and desktop browsers use scrollbars, whether or not any content is
     * clipped. This avoids any problem with scrollbars appearing and disappearing in a dynamic
     * environment. Printers may print overflowing content.
     * </p>
     * 
     * @return
     */
    public T scroll() {
        return value("scroll");
    }

    /**
     * <p>
     * Depends on the user agent. Desktop browsers like Firefox provide scrollbars if content
     * overflows.
     * </p>
     * 
     * @return
     */
    public T auto() {
        return value("auto");
    }
}