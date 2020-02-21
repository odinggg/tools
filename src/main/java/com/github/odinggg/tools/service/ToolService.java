package com.github.odinggg.tools.service;

import com.github.odinggg.tools.model.Text;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-12-27 16:42
 */
public interface ToolService {
    Text yml2properties(String content) throws Exception;

    Text properties2yml(String content) throws Exception;
}
