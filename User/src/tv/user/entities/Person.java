package tv.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:32 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "person")
public class Person {
    private String partyId;

    @Id
    @javax.persistence.Column(name = "PARTY_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    private String salutation;

    @Basic
    @javax.persistence.Column(name = "SALUTATION", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    private String firstName;

    @Basic
    @javax.persistence.Column(name = "FIRST_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String middleName;

    @Basic
    @javax.persistence.Column(name = "MIDDLE_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    private String lastName;

    @Basic
    @javax.persistence.Column(name = "LAST_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String personalTitle;

    @Basic
    @javax.persistence.Column(name = "PERSONAL_TITLE", nullable = true, insertable = true, updatable = true, length = 100)
    public String getPersonalTitle() {
        return personalTitle;
    }

    public void setPersonalTitle(String personalTitle) {
        this.personalTitle = personalTitle;
    }

    private String suffix;

    @Basic
    @javax.persistence.Column(name = "SUFFIX", nullable = true, insertable = true, updatable = true, length = 100)
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private String nickname;

    @Basic
    @javax.persistence.Column(name = "NICKNAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private String firstNameLocal;

    @Basic
    @javax.persistence.Column(name = "FIRST_NAME_LOCAL", nullable = true, insertable = true, updatable = true, length = 100)
    public String getFirstNameLocal() {
        return firstNameLocal;
    }

    public void setFirstNameLocal(String firstNameLocal) {
        this.firstNameLocal = firstNameLocal;
    }

    private String middleNameLocal;

    @Basic
    @javax.persistence.Column(name = "MIDDLE_NAME_LOCAL", nullable = true, insertable = true, updatable = true, length = 100)
    public String getMiddleNameLocal() {
        return middleNameLocal;
    }

    public void setMiddleNameLocal(String middleNameLocal) {
        this.middleNameLocal = middleNameLocal;
    }

    private String lastNameLocal;

    @Basic
    @javax.persistence.Column(name = "LAST_NAME_LOCAL", nullable = true, insertable = true, updatable = true, length = 100)
    public String getLastNameLocal() {
        return lastNameLocal;
    }

    public void setLastNameLocal(String lastNameLocal) {
        this.lastNameLocal = lastNameLocal;
    }

    private String otherLocal;

    @Basic
    @javax.persistence.Column(name = "OTHER_LOCAL", nullable = true, insertable = true, updatable = true, length = 100)
    public String getOtherLocal() {
        return otherLocal;
    }

    public void setOtherLocal(String otherLocal) {
        this.otherLocal = otherLocal;
    }

    private String memberId;

    @Basic
    @javax.persistence.Column(name = "MEMBER_ID", nullable = true, insertable = true, updatable = true, length = 250)
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    private String gender;

    @Basic
    @javax.persistence.Column(name = "GENDER", nullable = true, insertable = true, updatable = true, length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private Date birthDate;

    @Basic
    @javax.persistence.Column(name = "BIRTH_DATE", nullable = true, insertable = true, updatable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private Date deceasedDate;

    @Basic
    @javax.persistence.Column(name = "DECEASED_DATE", nullable = true, insertable = true, updatable = true)
    public Date getDeceasedDate() {
        return deceasedDate;
    }

    public void setDeceasedDate(Date deceasedDate) {
        this.deceasedDate = deceasedDate;
    }

    private BigDecimal height;

    @Basic
    @javax.persistence.Column(name = "HEIGHT", nullable = true, insertable = true, updatable = true, precision = 10)
    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    private BigDecimal weight;

    @Basic
    @javax.persistence.Column(name = "WEIGHT", nullable = true, insertable = true, updatable = true, precision = 10)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    private String mothersMaidenName;

    @Basic
    @javax.persistence.Column(name = "MOTHERS_MAIDEN_NAME", nullable = true, insertable = true, updatable = true, length = 255)
    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }

    private String maritalStatus;

    @Basic
    @javax.persistence.Column(name = "MARITAL_STATUS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    private String socialSecurityNumber;

    @Basic
    @javax.persistence.Column(name = "SOCIAL_SECURITY_NUMBER", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    private String passportNumber;

    @Basic
    @javax.persistence.Column(name = "PASSPORT_NUMBER", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    private Date passportExpireDate;

    @Basic
    @javax.persistence.Column(name = "PASSPORT_EXPIRE_DATE", nullable = true, insertable = true, updatable = true)
    public Date getPassportExpireDate() {
        return passportExpireDate;
    }

    public void setPassportExpireDate(Date passportExpireDate) {
        this.passportExpireDate = passportExpireDate;
    }

    private BigDecimal totalYearsWorkExperience;

    @Basic
    @javax.persistence.Column(name = "TOTAL_YEARS_WORK_EXPERIENCE", nullable = true, insertable = true, updatable = true, precision = 10)
    public BigDecimal getTotalYearsWorkExperience() {
        return totalYearsWorkExperience;
    }

    public void setTotalYearsWorkExperience(BigDecimal totalYearsWorkExperience) {
        this.totalYearsWorkExperience = totalYearsWorkExperience;
    }

    private String comments;

    @Basic
    @javax.persistence.Column(name = "COMMENTS", nullable = true, insertable = true, updatable = true, length = 255)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private String employmentStatusEnumId;

    @Basic
    @javax.persistence.Column(name = "EMPLOYMENT_STATUS_ENUM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getEmploymentStatusEnumId() {
        return employmentStatusEnumId;
    }

    public void setEmploymentStatusEnumId(String employmentStatusEnumId) {
        this.employmentStatusEnumId = employmentStatusEnumId;
    }

    private String residenceStatusEnumId;

    @Basic
    @javax.persistence.Column(name = "RESIDENCE_STATUS_ENUM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getResidenceStatusEnumId() {
        return residenceStatusEnumId;
    }

    public void setResidenceStatusEnumId(String residenceStatusEnumId) {
        this.residenceStatusEnumId = residenceStatusEnumId;
    }

    private String occupation;

    @Basic
    @javax.persistence.Column(name = "OCCUPATION", nullable = true, insertable = true, updatable = true, length = 100)
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    private Integer yearsWithEmployer;

    @Basic
    @javax.persistence.Column(name = "YEARS_WITH_EMPLOYER", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getYearsWithEmployer() {
        return yearsWithEmployer;
    }

    public void setYearsWithEmployer(Integer yearsWithEmployer) {
        this.yearsWithEmployer = yearsWithEmployer;
    }

    private Integer monthsWithEmployer;

    @Basic
    @javax.persistence.Column(name = "MONTHS_WITH_EMPLOYER", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getMonthsWithEmployer() {
        return monthsWithEmployer;
    }

    public void setMonthsWithEmployer(Integer monthsWithEmployer) {
        this.monthsWithEmployer = monthsWithEmployer;
    }

    private String existingCustomer;

    @Basic
    @javax.persistence.Column(name = "EXISTING_CUSTOMER", nullable = true, insertable = true, updatable = true, length = 1)
    public String getExistingCustomer() {
        return existingCustomer;
    }

    public void setExistingCustomer(String existingCustomer) {
        this.existingCustomer = existingCustomer;
    }

    private String cardId;

    @Basic
    @javax.persistence.Column(name = "CARD_ID", nullable = true, insertable = true, updatable = true, length = 60)
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

        Person person = (Person) o;

        if (birthDate != null ? !birthDate.equals(person.birthDate) : person.birthDate != null) return false;
        if (cardId != null ? !cardId.equals(person.cardId) : person.cardId != null) return false;
        if (comments != null ? !comments.equals(person.comments) : person.comments != null) return false;
        if (createdStamp != null ? !createdStamp.equals(person.createdStamp) : person.createdStamp != null)
            return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(person.createdTxStamp) : person.createdTxStamp != null)
            return false;
        if (deceasedDate != null ? !deceasedDate.equals(person.deceasedDate) : person.deceasedDate != null)
            return false;
        if (employmentStatusEnumId != null ? !employmentStatusEnumId.equals(person.employmentStatusEnumId) : person.employmentStatusEnumId != null)
            return false;
        if (existingCustomer != null ? !existingCustomer.equals(person.existingCustomer) : person.existingCustomer != null)
            return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (firstNameLocal != null ? !firstNameLocal.equals(person.firstNameLocal) : person.firstNameLocal != null)
            return false;
        if (gender != null ? !gender.equals(person.gender) : person.gender != null) return false;
        if (height != null ? !height.equals(person.height) : person.height != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (lastNameLocal != null ? !lastNameLocal.equals(person.lastNameLocal) : person.lastNameLocal != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(person.lastUpdatedStamp) : person.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(person.lastUpdatedTxStamp) : person.lastUpdatedTxStamp != null)
            return false;
        if (maritalStatus != null ? !maritalStatus.equals(person.maritalStatus) : person.maritalStatus != null)
            return false;
        if (memberId != null ? !memberId.equals(person.memberId) : person.memberId != null) return false;
        if (middleName != null ? !middleName.equals(person.middleName) : person.middleName != null) return false;
        if (middleNameLocal != null ? !middleNameLocal.equals(person.middleNameLocal) : person.middleNameLocal != null)
            return false;
        if (monthsWithEmployer != null ? !monthsWithEmployer.equals(person.monthsWithEmployer) : person.monthsWithEmployer != null)
            return false;
        if (mothersMaidenName != null ? !mothersMaidenName.equals(person.mothersMaidenName) : person.mothersMaidenName != null)
            return false;
        if (nickname != null ? !nickname.equals(person.nickname) : person.nickname != null) return false;
        if (occupation != null ? !occupation.equals(person.occupation) : person.occupation != null) return false;
        if (otherLocal != null ? !otherLocal.equals(person.otherLocal) : person.otherLocal != null) return false;
        if (partyId != null ? !partyId.equals(person.partyId) : person.partyId != null) return false;
        if (passportExpireDate != null ? !passportExpireDate.equals(person.passportExpireDate) : person.passportExpireDate != null)
            return false;
        if (passportNumber != null ? !passportNumber.equals(person.passportNumber) : person.passportNumber != null)
            return false;
        if (personalTitle != null ? !personalTitle.equals(person.personalTitle) : person.personalTitle != null)
            return false;
        if (residenceStatusEnumId != null ? !residenceStatusEnumId.equals(person.residenceStatusEnumId) : person.residenceStatusEnumId != null)
            return false;
        if (salutation != null ? !salutation.equals(person.salutation) : person.salutation != null) return false;
        if (socialSecurityNumber != null ? !socialSecurityNumber.equals(person.socialSecurityNumber) : person.socialSecurityNumber != null)
            return false;
        if (suffix != null ? !suffix.equals(person.suffix) : person.suffix != null) return false;
        if (totalYearsWorkExperience != null ? !totalYearsWorkExperience.equals(person.totalYearsWorkExperience) : person.totalYearsWorkExperience != null)
            return false;
        if (weight != null ? !weight.equals(person.weight) : person.weight != null) return false;
        if (yearsWithEmployer != null ? !yearsWithEmployer.equals(person.yearsWithEmployer) : person.yearsWithEmployer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partyId != null ? partyId.hashCode() : 0;
        result = 31 * result + (salutation != null ? salutation.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (personalTitle != null ? personalTitle.hashCode() : 0);
        result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (firstNameLocal != null ? firstNameLocal.hashCode() : 0);
        result = 31 * result + (middleNameLocal != null ? middleNameLocal.hashCode() : 0);
        result = 31 * result + (lastNameLocal != null ? lastNameLocal.hashCode() : 0);
        result = 31 * result + (otherLocal != null ? otherLocal.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (deceasedDate != null ? deceasedDate.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (mothersMaidenName != null ? mothersMaidenName.hashCode() : 0);
        result = 31 * result + (maritalStatus != null ? maritalStatus.hashCode() : 0);
        result = 31 * result + (socialSecurityNumber != null ? socialSecurityNumber.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (passportExpireDate != null ? passportExpireDate.hashCode() : 0);
        result = 31 * result + (totalYearsWorkExperience != null ? totalYearsWorkExperience.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (employmentStatusEnumId != null ? employmentStatusEnumId.hashCode() : 0);
        result = 31 * result + (residenceStatusEnumId != null ? residenceStatusEnumId.hashCode() : 0);
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        result = 31 * result + (yearsWithEmployer != null ? yearsWithEmployer.hashCode() : 0);
        result = 31 * result + (monthsWithEmployer != null ? monthsWithEmployer.hashCode() : 0);
        result = 31 * result + (existingCustomer != null ? existingCustomer.hashCode() : 0);
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
