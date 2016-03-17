package tv.news.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:50 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "product_review")
public class ProductReview {
    private String productReviewId;

    @Id
    @javax.persistence.Column(name = "PRODUCT_REVIEW_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductReviewId() {
        return productReviewId;
    }

    public void setProductReviewId(String productReviewId) {
        this.productReviewId = productReviewId;
    }

    private String productStoreId;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_STORE_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getProductStoreId() {
        return productStoreId;
    }

    public void setProductStoreId(String productStoreId) {
        this.productStoreId = productStoreId;
    }

    private String productId;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    private String statusId;

    @Basic
    @javax.persistence.Column(name = "STATUS_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    private String postedAnonymous;

    @Basic
    @javax.persistence.Column(name = "POSTED_ANONYMOUS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getPostedAnonymous() {
        return postedAnonymous;
    }

    public void setPostedAnonymous(String postedAnonymous) {
        this.postedAnonymous = postedAnonymous;
    }

    private Timestamp postedDateTime;

    @Basic
    @javax.persistence.Column(name = "POSTED_DATE_TIME", nullable = true, insertable = true, updatable = true)
    public Timestamp getPostedDateTime() {
        return postedDateTime;
    }

    public void setPostedDateTime(Timestamp postedDateTime) {
        this.postedDateTime = postedDateTime;
    }

    private BigDecimal productRating;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_RATING", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getProductRating() {
        return productRating;
    }

    public void setProductRating(BigDecimal productRating) {
        this.productRating = productRating;
    }

    private String productReview;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_REVIEW", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getProductReview() {
        return productReview;
    }

    public void setProductReview(String productReview) {
        this.productReview = productReview;
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

        ProductReview that = (ProductReview) o;

        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (postedAnonymous != null ? !postedAnonymous.equals(that.postedAnonymous) : that.postedAnonymous != null)
            return false;
        if (postedDateTime != null ? !postedDateTime.equals(that.postedDateTime) : that.postedDateTime != null)
            return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productRating != null ? !productRating.equals(that.productRating) : that.productRating != null)
            return false;
        if (productReview != null ? !productReview.equals(that.productReview) : that.productReview != null)
            return false;
        if (productReviewId != null ? !productReviewId.equals(that.productReviewId) : that.productReviewId != null)
            return false;
        if (productStoreId != null ? !productStoreId.equals(that.productStoreId) : that.productStoreId != null)
            return false;
        if (statusId != null ? !statusId.equals(that.statusId) : that.statusId != null) return false;
        if (userLoginId != null ? !userLoginId.equals(that.userLoginId) : that.userLoginId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productReviewId != null ? productReviewId.hashCode() : 0;
        result = 31 * result + (productStoreId != null ? productStoreId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (userLoginId != null ? userLoginId.hashCode() : 0);
        result = 31 * result + (statusId != null ? statusId.hashCode() : 0);
        result = 31 * result + (postedAnonymous != null ? postedAnonymous.hashCode() : 0);
        result = 31 * result + (postedDateTime != null ? postedDateTime.hashCode() : 0);
        result = 31 * result + (productRating != null ? productRating.hashCode() : 0);
        result = 31 * result + (productReview != null ? productReview.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        return result;
    }
}
