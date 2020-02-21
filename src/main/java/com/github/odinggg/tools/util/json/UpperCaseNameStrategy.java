package com.github.odinggg.tools.util.json;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * 描述:
 *
 * @outhor Hansen
 * @create 2018-08-29 15:48
 */
public class UpperCaseNameStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {
    private static final long serialVersionUID = -4861097778216000142L;

    public UpperCaseNameStrategy() {
    }

    public String translate(String propertyName) {
        return propertyName.toUpperCase();
    }
}
