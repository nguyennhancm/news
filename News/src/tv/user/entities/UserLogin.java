package tv.user.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@javax.persistence.Table(name = "user_login")
public class UserLogin {
    private String userLoginId;

    @Id
    @javax.persistence.Column(name = "USER_LOGIN_ID", nullable = false, insertable = true, updatable = true, length = 250)
    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    private String currentPassword;

    @Basic
    @javax.persistence.Column(name = "CURRENT_PASSWORD", nullable = true, insertable = true, updatable = true, length = 60)
    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    private String passwordHint;

    @Basic
    @javax.persistence.Column(name = "PASSWORD_HINT", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    private String isSystem;

    @Basic
    @javax.persistence.Column(name = "IS_SYSTEM", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem;
    }

    private String enabled;

    @Basic
    @javax.persistence.Column(name = "ENABLED", nullable = true, insertable = true, updatable = true, length = 1)
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    private String hasLoggedOut;

    @Basic
    @javax.persistence.Column(name = "HAS_LOGGED_OUT", nullable = true, insertable = true, updatable = true, length = 1)
    public String getHasLoggedOut() {
        return hasLoggedOut;
    }

    public void setHasLoggedOut(String hasLoggedOut) {
        this.hasLoggedOut = hasLoggedOut;
    }

    private String requirePasswordChange;

    @Basic
    @javax.persistence.Column(name = "REQUIRE_PASSWORD_CHANGE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getRequirePasswordChange() {
        return requirePasswordChange;
    }

    public void setRequirePasswordChange(String requirePasswordChange) {
        this.requirePasswordChange = requirePasswordChange;
    }

    private String lastCurrencyUom;

    @Basic
    @javax.persistence.Column(name = "LAST_CURRENCY_UOM", nullable = true, insertable = true, updatable = true, length = 20)
    public String getLastCurrencyUom() {
        return lastCurrencyUom;
    }

    public void setLastCurrencyUom(String lastCurrencyUom) {
        this.lastCurrencyUom = lastCurrencyUom;
    }

    private String lastLocale;

    @Basic
    @javax.persistence.Column(name = "LAST_LOCALE", nullable = true, insertable = true, updatable = true, length = 10)
    public String getLastLocale() {
        return lastLocale;
    }

    public void setLastLocale(String lastLocale) {
        this.lastLocale = lastLocale;
    }

    private String lastTimeZone;

    @Basic
    @javax.persistence.Column(name = "LAST_TIME_ZONE", nullable = true, insertable = true, updatable = true, length = 60)
    public String getLastTimeZone() {
        return lastTimeZone;
    }

    public void setLastTimeZone(String lastTimeZone) {
        this.lastTimeZone = lastTimeZone;
    }

    private Timestamp disabledDateTime;

    @Basic
    @javax.persistence.Column(name = "DISABLED_DATE_TIME", nullable = true, insertable = true, updatable = true)
    public Timestamp getDisabledDateTime() {
        return disabledDateTime;
    }

    public void setDisabledDateTime(Timestamp disabledDateTime) {
        this.disabledDateTime = disabledDateTime;
    }

    private Integer successiveFailedLogins;

    @Basic
    @javax.persistence.Column(name = "SUCCESSIVE_FAILED_LOGINS", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getSuccessiveFailedLogins() {
        return successiveFailedLogins;
    }

    public void setSuccessiveFailedLogins(Integer successiveFailedLogins) {
        this.successiveFailedLogins = successiveFailedLogins;
    }

    private String externalAuthId;

    @Basic
    @javax.persistence.Column(name = "EXTERNAL_AUTH_ID", nullable = true, insertable = true, updatable = true, length = 250)
    public String getExternalAuthId() {
        return externalAuthId;
    }

    public void setExternalAuthId(String externalAuthId) {
        this.externalAuthId = externalAuthId;
    }

    private String userLdapDn;

    @Basic
    @javax.persistence.Column(name = "USER_LDAP_DN", nullable = true, insertable = true, updatable = true, length = 250)
    public String getUserLdapDn() {
        return userLdapDn;
    }

    public void setUserLdapDn(String userLdapDn) {
        this.userLdapDn = userLdapDn;
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

    private String partyId;

    @Basic
    @javax.persistence.Column(name = "PARTY_ID", nullable = true, insertable = true, updatable = true, length = 20, precision = 0)
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
    this.partyId = partyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLogin userLogin = (UserLogin) o;

        if (createdStamp != null ? !createdStamp.equals(userLogin.createdStamp) : userLogin.createdStamp != null)
            return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(userLogin.createdTxStamp) : userLogin.createdTxStamp != null)
            return false;
        if (currentPassword != null ? !currentPassword.equals(userLogin.currentPassword) : userLogin.currentPassword != null)
            return false;
        if (disabledDateTime != null ? !disabledDateTime.equals(userLogin.disabledDateTime) : userLogin.disabledDateTime != null)
            return false;
        if (enabled != null ? !enabled.equals(userLogin.enabled) : userLogin.enabled != null) return false;
        if (externalAuthId != null ? !externalAuthId.equals(userLogin.externalAuthId) : userLogin.externalAuthId != null)
            return false;
        if (hasLoggedOut != null ? !hasLoggedOut.equals(userLogin.hasLoggedOut) : userLogin.hasLoggedOut != null)
            return false;
        if (isSystem != null ? !isSystem.equals(userLogin.isSystem) : userLogin.isSystem != null) return false;
        if (lastCurrencyUom != null ? !lastCurrencyUom.equals(userLogin.lastCurrencyUom) : userLogin.lastCurrencyUom != null)
            return false;
        if (lastLocale != null ? !lastLocale.equals(userLogin.lastLocale) : userLogin.lastLocale != null) return false;
        if (lastTimeZone != null ? !lastTimeZone.equals(userLogin.lastTimeZone) : userLogin.lastTimeZone != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(userLogin.lastUpdatedStamp) : userLogin.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(userLogin.lastUpdatedTxStamp) : userLogin.lastUpdatedTxStamp != null)
            return false;
        if (passwordHint != null ? !passwordHint.equals(userLogin.passwordHint) : userLogin.passwordHint != null)
            return false;
        if (requirePasswordChange != null ? !requirePasswordChange.equals(userLogin.requirePasswordChange) : userLogin.requirePasswordChange != null)
            return false;
        if (successiveFailedLogins != null ? !successiveFailedLogins.equals(userLogin.successiveFailedLogins) : userLogin.successiveFailedLogins != null)
            return false;
        if (userLdapDn != null ? !userLdapDn.equals(userLogin.userLdapDn) : userLogin.userLdapDn != null) return false;
        if (userLoginId != null ? !userLoginId.equals(userLogin.userLoginId) : userLogin.userLoginId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userLoginId != null ? userLoginId.hashCode() : 0;
        result = 31 * result + (currentPassword != null ? currentPassword.hashCode() : 0);
        result = 31 * result + (passwordHint != null ? passwordHint.hashCode() : 0);
        result = 31 * result + (isSystem != null ? isSystem.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (hasLoggedOut != null ? hasLoggedOut.hashCode() : 0);
        result = 31 * result + (requirePasswordChange != null ? requirePasswordChange.hashCode() : 0);
        result = 31 * result + (lastCurrencyUom != null ? lastCurrencyUom.hashCode() : 0);
        result = 31 * result + (lastLocale != null ? lastLocale.hashCode() : 0);
        result = 31 * result + (lastTimeZone != null ? lastTimeZone.hashCode() : 0);
        result = 31 * result + (disabledDateTime != null ? disabledDateTime.hashCode() : 0);
        result = 31 * result + (successiveFailedLogins != null ? successiveFailedLogins.hashCode() : 0);
        result = 31 * result + (externalAuthId != null ? externalAuthId.hashCode() : 0);
        result = 31 * result + (userLdapDn != null ? userLdapDn.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
