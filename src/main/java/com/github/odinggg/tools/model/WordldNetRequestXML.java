package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.github.odinggg.tools.util.HttpClientUtil;
import com.github.odinggg.tools.util.JacksonConvertUtil;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@JacksonXmlRootElement(localName = "ACCOUNT_VERIFICATION")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WordldNetRequestXML implements Serializable {

    @JacksonXmlProperty(localName = "TERMINALID")
    private String terminalid;
    @JacksonXmlProperty(localName = "CARDNUMBER")
    private String cardnumber;
    @JacksonXmlProperty(localName = "CARDEXPIRY")
    private String cardexpiry;
    @JacksonXmlProperty(localName = "CARDHOLDERNAME")
    private String cardholdername;
    @JacksonXmlProperty(localName = "CVV")
    private String cvv;
    @JacksonXmlProperty(localName = "ADDRESS1")
    private String address1;
    @JacksonXmlProperty(localName = "ADDRESS2")
    private String address2;
    @JacksonXmlProperty(localName = "POSTCODE")
    private String postcode;
    @JacksonXmlProperty(localName = "DATETIME")
    private String datetime;
    @JacksonXmlProperty(localName = "HASH")
    private String hash;

    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCardexpiry() {
        return cardexpiry;
    }

    public void setCardexpiry(String cardexpiry) {
        this.cardexpiry = cardexpiry;
    }

    public String getCardholdername() {
        return cardholdername;
    }

    public void setCardholdername(String cardholdername) {
        this.cardholdername = cardholdername;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("Content-Type", "application/xml");
//        WordldNetRequestXML wordldNetRequestXML = new WordldNetRequestXML();
//        wordldNetRequestXML.setTerminalid("3673001");
//        wordldNetRequestXML.setCardnumber("4392260006122780");
//        wordldNetRequestXML.setCardexpiry("0320");
//        wordldNetRequestXML.setCardholdername("LOU XIAOLIANG");
//        wordldNetRequestXML.setCvv("151");
//        wordldNetRequestXML.setAddress1("Beijing");
//        wordldNetRequestXML.setAddress2("Beijing");
//        wordldNetRequestXML.setPostcode("100000");
//        wordldNetRequestXML.setDatetime(ZonedDateTime.now()
//                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy:HH:mm:ss:SSS")));
//        MessageDigest instance = MessageDigest.getInstance("SHA-512");
//        instance.update((wordldNetRequestXML.getTerminalid() + ":123212:" + "223" + ":15-4-2020:10:43:01:673:3673001S").getBytes(StandardCharsets.UTF_8));
//        wordldNetRequestXML.setHash(HexUtils.toHexString(instance.digest()));
//        System.out.println(JacksonConvertUtil.objectToXml(wordldNetRequestXML));
//        HttpEntity send = HttpClientUtil.send("https://testpayments.worldnettps.com/merchant/xmlpayment", RequestMethod.POST, JacksonConvertUtil
//                .objectToXml(wordldNetRequestXML), null, map, false, null);
//        String s = EntityUtils.toString(send);
//        System.out.println(s);
//        System.out.println(JacksonConvertUtil.objectToXml(wordldNetRequestXML));
    }
}
