package com.github.odinggg.tools.service;

import com.github.odinggg.tools.model.Text;

import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * 描述:
 *
 * @author Hansen
 * @version 2019-12-27 16:42
 */
public interface ToolService {
    Text yml2properties(String content) throws Exception;

    Text properties2yml(String content) throws Exception;

    ByteBuffer wechatArticle2PDF(String url);
}
