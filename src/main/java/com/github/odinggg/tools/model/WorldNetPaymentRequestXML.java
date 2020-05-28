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
@JacksonXmlRootElement(localName = "PAYMENT", namespace = "https://testpayments.worldnettps.com/merchant/gateway.xsd")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorldNetPaymentRequestXML implements Serializable {


    @JacksonXmlProperty(localName = "ORDERID")
    private String orderid;//Y
    @JacksonXmlProperty(localName = "TERMINALID")
    private String terminalid;//Y
    @JacksonXmlProperty(localName = "AMOUNT")
    private String amount;//Y
    @JacksonXmlProperty(localName = "DATETIME")
    private String datetime;//Y
    @JacksonXmlProperty(localName = "TRACKDATA")
    private String trackdata;//N
    @JacksonXmlProperty(localName = "CARDNUMBER")
    private String cardnumber;//N
    @JacksonXmlProperty(localName = "APPLEPAYLOAD")
    private String applepayload;//N
    @JacksonXmlProperty(localName = "GOOGLEPAYLOAD")
    private String googlepayload;//N
    @JacksonXmlProperty(localName = "CARDTYPE")
    private String cardtype;//Y
    @JacksonXmlProperty(localName = "CARDEXPIRY")
    private String cardexpiry;//N
    @JacksonXmlProperty(localName = "CARDHOLDERNAME")
    private String cardholdername;//N
    @JacksonXmlProperty(localName = "HASH")
    private String hash;//Y
    @JacksonXmlProperty(localName = "CURRENCY")
    private String currency;//Y
    @JacksonXmlProperty(localName = "FOREIGNCURRENCYINFORMATION")
    private String foreigncurrencyinformation;//N
    @JacksonXmlProperty(localName = "TERMINALTYPE")
    private String terminaltype;//Y
    @JacksonXmlProperty(localName = "TRANSACTIONTYPE")
    private String transactiontype;//Y
    @JacksonXmlProperty(localName = "AUTOREADY")
    private String autoready;//N
    @JacksonXmlProperty(localName = "EMAIL")
    private String email;//N
    @JacksonXmlProperty(localName = "CVV")
    private String cvv;//N
    @JacksonXmlProperty(localName = "ISSUENO")
    private String issueno;//N
    @JacksonXmlProperty(localName = "ADDRESS1")
    private String address1;//N
    @JacksonXmlProperty(localName = "ADDRESS2")
    private String address2;//N
    @JacksonXmlProperty(localName = "POSTCODE")
    private String postcode;//N
    @JacksonXmlProperty(localName = "BILLTOLASTNAME")
    private String billtolastname;//N
    @JacksonXmlProperty(localName = "BILLTOFIRSTNAME")
    private String billtofirstname;//N
    @JacksonXmlProperty(localName = "DESCRIPTION")
    private String description;//N
    @JacksonXmlProperty(localName = "XID")
    private String xid;//N
    @JacksonXmlProperty(localName = "CAVV")
    private String cavv;//N
    @JacksonXmlProperty(localName = "MPIREF")
    private String mpiref;//N
    @JacksonXmlProperty(localName = "MOBILENUMBER")
    private String mobilenumber;//N

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getTrackdata() {
        return trackdata;
    }

    public void setTrackdata(String trackdata) {
        this.trackdata = trackdata;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getApplepayload() {
        return applepayload;
    }

    public void setApplepayload(String applepayload) {
        this.applepayload = applepayload;
    }

    public String getGooglepayload() {
        return googlepayload;
    }

    public void setGooglepayload(String googlepayload) {
        this.googlepayload = googlepayload;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getForeigncurrencyinformation() {
        return foreigncurrencyinformation;
    }

    public void setForeigncurrencyinformation(String foreigncurrencyinformation) {
        this.foreigncurrencyinformation = foreigncurrencyinformation;
    }

    public String getTerminaltype() {
        return terminaltype;
    }

    public void setTerminaltype(String terminaltype) {
        this.terminaltype = terminaltype;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public String getAutoready() {
        return autoready;
    }

    public void setAutoready(String autoready) {
        this.autoready = autoready;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getIssueno() {
        return issueno;
    }

    public void setIssueno(String issueno) {
        this.issueno = issueno;
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

    public String getBilltolastname() {
        return billtolastname;
    }

    public void setBilltolastname(String billtolastname) {
        this.billtolastname = billtolastname;
    }

    public String getBilltofirstname() {
        return billtofirstname;
    }

    public void setBilltofirstname(String billtofirstname) {
        this.billtofirstname = billtofirstname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getCavv() {
        return cavv;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public String getMpiref() {
        return mpiref;
    }

    public void setMpiref(String mpiref) {
        this.mpiref = mpiref;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public static void main(String[] args) {

        MessageDigest instance = null;
        try {
            WorldNetPaymentRequestXML xml = new WorldNetPaymentRequestXML();
            xml.setTerminalid("6003");
            xml.setDatetime(ZonedDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy:HH:mm:ss:SSS")));
            xml.setOrderid("123456522");
            xml.setAmount("12");
            xml.setCardnumber("4392260006122780");
            xml.setTransactiontype("7");
            xml.setTerminaltype("1");
            xml.setCurrency("USD");
            xml.setCardtype("SECURECARD");
            instance = MessageDigest.getInstance("SHA-512");
            instance.update((xml.getTerminalid() + ":" + xml.getOrderid() + ":" + xml.getAmount() + ":" + xml.getDatetime() + ":" + "sandboxUSD")
                    .getBytes(StandardCharsets.UTF_8));
            xml.setHash(HexUtils.toHexString(instance.digest()));
            System.out.println(JacksonConvertUtil.objectToXml(xml));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
