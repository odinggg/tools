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
@JacksonXmlRootElement(localName = "REFUND")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorldNetRefundRequestXML implements Serializable {

    @JacksonXmlProperty(localName = "UNIQUEREF")
    private String uniqueref;//	Y	Refers the UNIQUEREF generate for the original payment response. In case the unique ref configuration is enabled, it's mandatory, otherwise, the system is going to accept the original ORDERID used for the pre-authorization. Either UNIQUEREF or ORDERID should be used, but never both.
    @JacksonXmlProperty(localName = "TERMINALID")
    private String terminalid;//	Y	A Terminal ID provided by Worldnet.
    @JacksonXmlProperty(localName = "AMOUNT")
    private String amount;//	Y	The amount of the transaction. A 2 digit decimal or an integer value for JPY amounts.
    @JacksonXmlProperty(localName = "OPERATOR")
    private String operator;//	Y	An identifier for who executed this transaction.
    @JacksonXmlProperty(localName = "REASON")
    private String reason;//	Y	The reason for the refund.
    @JacksonXmlProperty(localName = "DATETIME")
    private String datetime;//	Y	Request date and time. Format: DD-MM-YYYY:HH:MM:SS:SSS.
    @JacksonXmlProperty(localName = "HASH")
    private String hash;//	Y	A HASH code formed by part of the request fields. The formation rule is given at the ND001 - Hash Formation, in the next section.

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
            WorldNetRefundRequestXML xml = new WorldNetRefundRequestXML();
            xml.setTerminalid("6003");
            xml.setDatetime(ZonedDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy:HH:mm:ss:SSS")));
            xml.setAmount("10");
            xml.setUniqueref("K5M7SQRLJY");
            xml.setReason("test");
            xml.setOperator("sys");
            instance = MessageDigest.getInstance("SHA-512");
            instance.update((xml.getTerminalid() + ":" + xml.getUniqueref() + ":" + xml.getAmount() + ":" + xml.getDatetime() + ":" + "sandboxUSD")
                    .getBytes(StandardCharsets.UTF_8));
            xml.setHash(HexUtils.toHexString(instance.digest()));
            System.out.println(JacksonConvertUtil.objectToXml(xml));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
