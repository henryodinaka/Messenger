package com.leo.henry.messenger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class AuthenticationRequest {
    private String sessionId;
    private String requestorID;
    private String payerPhoneNumber;
    private String mandateReferenceNumber;
    private String productCode;
    private BigDecimal amount;
    private String additionalFIRequiredData;
    private String fIInstitution;
    private String accountNumber;
    private String accountName;
    private String passCode;
}