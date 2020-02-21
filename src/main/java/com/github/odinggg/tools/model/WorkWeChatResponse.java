package com.github.odinggg.tools.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkWeChatResponse {
    /**
     * errcode : 0
     * errmsg : ok
     * access_token : xR0-QyqVtopNZ008UZVklLdiA9sjnLA4mNoJxVz9oJRpd7uq5gZ9BIz0sv6a1iIdXTU1zMcD0TXWSkjQ-GorcdhIkRr5AChhUJAtFBvtg1ZtbAVsyD_mYw-0zYZlbKNNe8-iCuzHo4ijFgoKSV8PK6jBs0xfzZ1FcqSb5Br7D6i63ex-k3NsTnZn6u1g6ZDAScShLany904uRe92v81ihg
     * expires_in : 7200
     */

    @JsonProperty("errcode")
    private int errcode;
    @JsonProperty("errmsg")
    private String errmsg;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("invaliduser")
    private String invaliduser;
    @JsonProperty("expires_in")
    private int expiresIn;

    public String getInvaliduser() {
        return invaliduser;
    }

    public void setInvaliduser(String invaliduser) {
        this.invaliduser = invaliduser;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
