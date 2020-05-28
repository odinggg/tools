package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import org.apache.tomcat.util.buf.HexUtils;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述:
 *
 * @author QinHaoChun
 * @version 2020-05-06 10:12
 */
@JacksonXmlRootElement(localName = "GET_TRANSACTION_DETAILS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorldNetPaymentSearchRequestXML implements Serializable {


    @JacksonXmlProperty(localName = "UNIQUEREF")
    private String uniqueref;//Y
    @JacksonXmlProperty(localName = "TERMINALID")
    private String terminalid;//Y
    @JacksonXmlProperty(localName = "DATETIME")
    private String datetime;//Y
    @JacksonXmlProperty(localName = "HASH")
    private String hash;//Y

    public String getUniqueref() {
        return uniqueref;
    }

    public void setUniqueref(String uniqueref) {
        this.uniqueref = uniqueref;
    }

    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public static void main(String[] args) {

        MessageDigest instance = null;
        try {
//            WorldNetPaymentSearchRequestXML xml = new WorldNetPaymentSearchRequestXML();
//            xml.setTerminalid("6003");
//            xml.setDatetime(ZonedDateTime.now()
//                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy:HH:mm:ss:SSS")));
//            xml.setUniqueref("EKWCU0XKVQ");
//            instance = MessageDigest.getInstance("SHA-512");
//            instance.update((xml.getTerminalid() + ":" + xml.getUniqueref() + ":" + xml.getDatetime() + ":" + "sandboxUSD")
//                    .getBytes(StandardCharsets.UTF_8));
//            xml.setHash(HexUtils.toHexString(instance.digest()));
//            JacksonConvertUtil.xmlToObject()
//            System.out.println(JacksonConvertUtil.objectToXml(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
