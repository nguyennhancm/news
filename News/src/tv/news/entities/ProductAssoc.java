package tv.news.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:36 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "product_assoc")
public class ProductAssoc implements Serializable {
    private String productId;

    @Id
    @javax.persistence.Column(name = "PRODUCT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String productIdTo;

    @Id
    @javax.persistence.Column(name = "PRODUCT_ID_TO", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductIdTo() {
        return productIdTo;
    }

    public void setProductIdTo(String productIdTo) {
        this.productIdTo = productIdTo;
    }

    private String productAssocTypeId;

    @Id
    @javax.persistence.Column(name = "PRODUCT_ASSOC_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductAssocTypeId() {
        return productAssocTypeId;
    }

    public void setProductAssocTypeId(String productAssocTypeId) {
        this.productAssocTypeId = productAssocTypeId;
    }

    private Timestamp fromDate;

    @Id
    @javax.persistence.Column(name = "FROM_DATE", nullable = false, insertable = true, updatable = true)
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

    private Integer sequenceNum;

    @Basic
    @javax.persistence.Column(name = "SEQUENCE_NUM", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(Integer sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    private String reason;

    @Basic
    @javax.persistence.Column(name = "REASON", nullable = true, insertable = true, updatable = true, length = 255)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    private BigDecimal quantity;

    @Basic
    @javax.persistence.Column(name = "QUANTITY", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    private BigDecimal scrapFactor;

    @Basic
    @javax.persistence.Column(name = "SCRAP_FACTOR", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getScrapFactor() {
        return scrapFactor;
    }

    public void setScrapFactor(BigDecimal scrapFactor) {
        this.scrapFactor = scrapFactor;
    }

    private String instruction;

    @Basic
    @javax.persistence.Column(name = "INSTRUCTION", nullable = true, insertable = true, updatable = true, length = 255)
    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    private String routingWorkEffortId;

    @Basic
    @javax.persistence.Column(name = "ROUTING_WORK_EFFORT_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRoutingWorkEffortId() {
        return routingWorkEffortId;
    }

    public void setRoutingWorkEffortId(String routingWorkEffortId) {
        this.routingWorkEffortId = routingWorkEffortId;
    }

    private String estimateCalcMethod;

    @Basic
    @javax.persistence.Column(name = "ESTIMATE_CALC_METHOD", nullable = true, insertable = true, updatable = true, length = 20)
    public String getEstimateCalcMethod() {
        return estimateCalcMethod;
    }

    public void setEstimateCalcMethod(String estimateCalcMethod) {
        this.estimateCalcMethod = estimateCalcMethod;
    }

    private String recurrenceInfoId;

    @Basic
    @javax.persistence.Column(name = "RECURRENCE_INFO_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRecurrenceInfoId() {
        return recurrenceInfoId;
    }

    public void setRecurrenceInfoId(String recurrenceInfoId) {
        this.recurrenceInfoId = recurrenceInfoId;
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

    private String specRouWeffId;

    @Basic
    @javax.persistence.Column(name = "SPEC_ROU_WEFF_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getSpecRouWeffId() {
        return specRouWeffId;
    }

    public void setSpecRouWeffId(String specRouWeffId) {
        this.specRouWeffId = specRouWeffId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductAssoc that = (ProductAssoc) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (estimateCalcMethod != null ? !estimateCalcMethod.equals(that.estimateCalcMethod) : that.estimateCalcMethod != null)
            return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (instruction != null ? !instruction.equals(that.instruction) : that.instruction != null) return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (productAssocTypeId != null ? !productAssocTypeId.equals(that.productAssocTypeId) : that.productAssocTypeId != null)
            return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productIdTo != null ? !productIdTo.equals(that.productIdTo) : that.productIdTo != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (recurrenceInfoId != null ? !recurrenceInfoId.equals(that.recurrenceInfoId) : that.recurrenceInfoId != null)
            return false;
        if (routingWorkEffortId != null ? !routingWorkEffortId.equals(that.routingWorkEffortId) : that.routingWorkEffortId != null)
            return false;
        if (scrapFactor != null ? !scrapFactor.equals(that.scrapFactor) : that.scrapFactor != null) return false;
        if (sequenceNum != null ? !sequenceNum.equals(that.sequenceNum) : that.sequenceNum != null) return false;
        if (specRouWeffId != null ? !specRouWeffId.equals(that.specRouWeffId) : that.specRouWeffId != null)
            return false;
        if (thruDate != null ? !thruDate.equals(that.thruDate) : that.thruDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productIdTo != null ? productIdTo.hashCode() : 0);
        result = 31 * result + (productAssocTypeId != null ? productAssocTypeId.hashCode() : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (thruDate != null ? thruDate.hashCode() : 0);
        result = 31 * result + (sequenceNum != null ? sequenceNum.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (scrapFactor != null ? scrapFactor.hashCode() : 0);
        result = 31 * result + (instruction != null ? instruction.hashCode() : 0);
        result = 31 * result + (routingWorkEffortId != null ? routingWorkEffortId.hashCode() : 0);
        result = 31 * result + (estimateCalcMethod != null ? estimateCalcMethod.hashCode() : 0);
        result = 31 * result + (recurrenceInfoId != null ? recurrenceInfoId.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        result = 31 * result + (specRouWeffId != null ? specRouWeffId.hashCode() : 0);
        return result;
    }
}
