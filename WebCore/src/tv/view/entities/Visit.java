package tv.view.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/1/2015
 * Time: 8:20 AM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "visit")
public class Visit implements Serializable {
    private String visitId;

    @Id
    @javax.persistence.Column(name = "VISIT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    private String userLoginId;

    @Basic
    @javax.persistence.Column(name = "USER_LOGIN_ID", nullable = true, insertable = true, updatable = true, length = 250)
    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    private String userCreated;

    @Basic
    @javax.persistence.Column(name = "USER_CREATED", nullable = true, insertable = true, updatable = true, length = 1)
    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    private String sessionId;

    @Basic
    @javax.persistence.Column(name = "SESSION_ID", nullable = true, insertable = true, updatable = true, length = 250)
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    private String serverIpAddress;

    @Basic
    @javax.persistence.Column(name = "SERVER_IP_ADDRESS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getServerIpAddress() {
        return serverIpAddress;
    }

    public void setServerIpAddress(String serverIpAddress) {
        this.serverIpAddress = serverIpAddress;
    }

    private String serverHostName;

    @Basic
    @javax.persistence.Column(name = "SERVER_HOST_NAME", nullable = true, insertable = true, updatable = true, length = 255)
    public String getServerHostName() {
        return serverHostName;
    }

    public void setServerHostName(String serverHostName) {
        this.serverHostName = serverHostName;
    }

    private String webappName;

    @Basic
    @javax.persistence.Column(name = "WEBAPP_NAME", nullable = true, insertable = true, updatable = true, length = 60)
    public String getWebappName() {
        return webappName;
    }

    public void setWebappName(String webappName) {
        this.webappName = webappName;
    }

    private String initialLocale;

    @Basic
    @javax.persistence.Column(name = "INITIAL_LOCALE", nullable = true, insertable = true, updatable = true, length = 60)
    public String getInitialLocale() {
        return initialLocale;
    }

    public void setInitialLocale(String initialLocale) {
        this.initialLocale = initialLocale;
    }

    private String initialRequest;

    @Basic
    @javax.persistence.Column(name = "INITIAL_REQUEST", nullable = true, insertable = true, updatable = true, length = 255)
    public String getInitialRequest() {
        return initialRequest;
    }

    public void setInitialRequest(String initialRequest) {
        this.initialRequest = initialRequest;
    }

    private String initialReferrer;

    @Basic
    @javax.persistence.Column(name = "INITIAL_REFERRER", nullable = true, insertable = true, updatable = true, length = 255)
    public String getInitialReferrer() {
        return initialReferrer;
    }

    public void setInitialReferrer(String initialReferrer) {
        this.initialReferrer = initialReferrer;
    }

    private String initialUserAgent;

    @Basic
    @javax.persistence.Column(name = "INITIAL_USER_AGENT", nullable = true, insertable = true, updatable = true, length = 255)
    public String getInitialUserAgent() {
        return initialUserAgent;
    }

    public void setInitialUserAgent(String initialUserAgent) {
        this.initialUserAgent = initialUserAgent;
    }

    private String clientIpAddress;

    @Basic
    @javax.persistence.Column(name = "CLIENT_IP_ADDRESS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getClientIpAddress() {
        return clientIpAddress;
    }

    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    private String clientHostName;

    @Basic
    @javax.persistence.Column(name = "CLIENT_HOST_NAME", nullable = true, insertable = true, updatable = true, length = 255)
    public String getClientHostName() {
        return clientHostName;
    }

    public void setClientHostName(String clientHostName) {
        this.clientHostName = clientHostName;
    }

    private String clientUser;

    @Basic
    @javax.persistence.Column(name = "CLIENT_USER", nullable = true, insertable = true, updatable = true, length = 60)
    public String getClientUser() {
        return clientUser;
    }

    public void setClientUser(String clientUser) {
        this.clientUser = clientUser;
    }

    private String clientIpIspName;

    @Basic
    @javax.persistence.Column(name = "CLIENT_IP_ISP_NAME", nullable = true, insertable = true, updatable = true, length = 60)
    public String getClientIpIspName() {
        return clientIpIspName;
    }

    public void setClientIpIspName(String clientIpIspName) {
        this.clientIpIspName = clientIpIspName;
    }

    private String clientIpPostalCode;

    @Basic
    @javax.persistence.Column(name = "CLIENT_IP_POSTAL_CODE", nullable = true, insertable = true, updatable = true, length = 60)
    public String getClientIpPostalCode() {
        return clientIpPostalCode;
    }

    public void setClientIpPostalCode(String clientIpPostalCode) {
        this.clientIpPostalCode = clientIpPostalCode;
    }

    private String cookie;

    @Basic
    @javax.persistence.Column(name = "COOKIE", nullable = true, insertable = true, updatable = true, length = 60)
    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    private Timestamp fromDate;

    @Basic
    @javax.persistence.Column(name = "FROM_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    private Timestamp thruDate;

    @Basic
    @javax.persistence.Column(name = "THRU_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getThruDate() {
        return thruDate;
    }

    public void setThruDate(Timestamp thruDate) {
        this.thruDate = thruDate;
    }

    private Timestamp lastUpdatedStamp;

    @Basic
    @javax.persistence.Column(name = "LAST_UPDATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(Timestamp lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    private Timestamp lastUpdatedTxStamp;

    @Basic
    @javax.persistence.Column(name = "LAST_UPDATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastUpdatedTxStamp() {
        return lastUpdatedTxStamp;
    }

    public void setLastUpdatedTxStamp(Timestamp lastUpdatedTxStamp) {
        this.lastUpdatedTxStamp = lastUpdatedTxStamp;
    }

    private Timestamp createdStamp;

    @Basic
    @javax.persistence.Column(name = "CREATED_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedStamp() {
        return createdStamp;
    }

    public void setCreatedStamp(Timestamp createdStamp) {
        this.createdStamp = createdStamp;
    }

    private Timestamp createdTxStamp;

    @Basic
    @javax.persistence.Column(name = "CREATED_TX_STAMP", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedTxStamp() {
        return createdTxStamp;
    }

    public void setCreatedTxStamp(Timestamp createdTxStamp) {
        this.createdTxStamp = createdTxStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (clientHostName != null ? !clientHostName.equals(visit.clientHostName) : visit.clientHostName != null)
            return false;
        if (clientIpAddress != null ? !clientIpAddress.equals(visit.clientIpAddress) : visit.clientIpAddress != null)
            return false;
        if (clientIpIspName != null ? !clientIpIspName.equals(visit.clientIpIspName) : visit.clientIpIspName != null)
            return false;
        if (clientIpPostalCode != null ? !clientIpPostalCode.equals(visit.clientIpPostalCode) : visit.clientIpPostalCode != null)
            return false;
        if (clientUser != null ? !clientUser.equals(visit.clientUser) : visit.clientUser != null) return false;
        if (cookie != null ? !cookie.equals(visit.cookie) : visit.cookie != null) return false;
        if (createdStamp != null ? !createdStamp.equals(visit.createdStamp) : visit.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(visit.createdTxStamp) : visit.createdTxStamp != null)
            return false;
        if (fromDate != null ? !fromDate.equals(visit.fromDate) : visit.fromDate != null) return false;
        if (initialLocale != null ? !initialLocale.equals(visit.initialLocale) : visit.initialLocale != null)
            return false;
        if (initialReferrer != null ? !initialReferrer.equals(visit.initialReferrer) : visit.initialReferrer != null)
            return false;
        if (initialRequest != null ? !initialRequest.equals(visit.initialRequest) : visit.initialRequest != null)
            return false;
        if (initialUserAgent != null ? !initialUserAgent.equals(visit.initialUserAgent) : visit.initialUserAgent != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(visit.lastUpdatedStamp) : visit.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(visit.lastUpdatedTxStamp) : visit.lastUpdatedTxStamp != null)
            return false;
        if (serverHostName != null ? !serverHostName.equals(visit.serverHostName) : visit.serverHostName != null)
            return false;
        if (serverIpAddress != null ? !serverIpAddress.equals(visit.serverIpAddress) : visit.serverIpAddress != null)
            return false;
        if (sessionId != null ? !sessionId.equals(visit.sessionId) : visit.sessionId != null) return false;
        if (thruDate != null ? !thruDate.equals(visit.thruDate) : visit.thruDate != null) return false;
        if (userCreated != null ? !userCreated.equals(visit.userCreated) : visit.userCreated != null) return false;
        if (userLoginId != null ? !userLoginId.equals(visit.userLoginId) : visit.userLoginId != null) return false;
        if (visitId != null ? !visitId.equals(visit.visitId) : visit.visitId != null) return false;
        if (webappName != null ? !webappName.equals(visit.webappName) : visit.webappName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = visitId != null ? visitId.hashCode() : 0;
        result = 31 * result + (userLoginId != null ? userLoginId.hashCode() : 0);
        result = 31 * result + (userCreated != null ? userCreated.hashCode() : 0);
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (serverIpAddress != null ? serverIpAddress.hashCode() : 0);
        result = 31 * result + (serverHostName != null ? serverHostName.hashCode() : 0);
        result = 31 * result + (webappName != null ? webappName.hashCode() : 0);
        result = 31 * result + (initialLocale != null ? initialLocale.hashCode() : 0);
        result = 31 * result + (initialRequest != null ? initialRequest.hashCode() : 0);
        result = 31 * result + (initialReferrer != null ? initialReferrer.hashCode() : 0);
        result = 31 * result + (initialUserAgent != null ? initialUserAgent.hashCode() : 0);
        result = 31 * result + (clientIpAddress != null ? clientIpAddress.hashCode() : 0);
        result = 31 * result + (clientHostName != null ? clientHostName.hashCode() : 0);
        result = 31 * result + (clientUser != null ? clientUser.hashCode() : 0);
        result = 31 * result + (clientIpIspName != null ? clientIpIspName.hashCode() : 0);
        result = 31 * result + (clientIpPostalCode != null ? clientIpPostalCode.hashCode() : 0);
        result = 31 * result + (cookie != null ? cookie.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (thruDate != null ? thruDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
