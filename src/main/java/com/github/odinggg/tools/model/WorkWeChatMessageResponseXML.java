package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "xml")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkWeChatMessageResponseXML {
    @JacksonXmlProperty(localName = "Encrypt")
    @JacksonXmlCData
    private String encrypt;

    @JacksonXmlProperty(localName = "MsgSignature")
    @JacksonXmlCData
    private String msgSignature;

    @JacksonXmlProperty(localName = "TimeStamp")
    private String timeStamp;

    @JacksonXmlProperty(localName = "Nonce")
    @JacksonXmlCData
    private String nonce;

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getMsgSignature() {
        return msgSignature;
    }

    public void setMsgSignature(String msgSignature) {
        this.msgSignature = msgSignature;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}
