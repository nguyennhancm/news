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
 * Time: 10:35 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "product")
public class Product {
    private String productId;

    @Id
    @javax.persistence.Column(name = "PRODUCT_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String productTypeId;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_TYPE_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    private String primaryProductCategoryId;

    @Basic
    @javax.persistence.Column(name = "PRIMARY_PRODUCT_CATEGORY_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPrimaryProductCategoryId() {
        return primaryProductCategoryId;
    }

    public void setPrimaryProductCategoryId(String primaryProductCategoryId) {
        this.primaryProductCategoryId = primaryProductCategoryId;
    }

    private String manufacturerPartyId;

    @Basic
    @javax.persistence.Column(name = "MANUFACTURER_PARTY_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getManufacturerPartyId() {
        return manufacturerPartyId;
    }

    public void setManufacturerPartyId(String manufacturerPartyId) {
        this.manufacturerPartyId = manufacturerPartyId;
    }

    private String facilityId;

    @Basic
    @javax.persistence.Column(name = "FACILITY_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    private Timestamp introductionDate;

    @Basic
    @javax.persistence.Column(name = "INTRODUCTION_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getIntroductionDate() {
        return introductionDate;
    }

    public void setIntroductionDate(Timestamp introductionDate) {
        this.introductionDate = introductionDate;
    }

    private Timestamp releaseDate;

    @Basic
    @javax.persistence.Column(name = "RELEASE_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    private Timestamp supportDiscontinuationDate;

    @Basic
    @javax.persistence.Column(name = "SUPPORT_DISCONTINUATION_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getSupportDiscontinuationDate() {
        return supportDiscontinuationDate;
    }

    public void setSupportDiscontinuationDate(Timestamp supportDiscontinuationDate) {
        this.supportDiscontinuationDate = supportDiscontinuationDate;
    }

    private Timestamp salesDiscontinuationDate;

    @Basic
    @javax.persistence.Column(name = "SALES_DISCONTINUATION_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getSalesDiscontinuationDate() {
        return salesDiscontinuationDate;
    }

    public void setSalesDiscontinuationDate(Timestamp salesDiscontinuationDate) {
        this.salesDiscontinuationDate = salesDiscontinuationDate;
    }

    private String salesDiscWhenNotAvail;

    @Basic
    @javax.persistence.Column(name = "SALES_DISC_WHEN_NOT_AVAIL", nullable = true, insertable = true, updatable = true, length = 1)
    public String getSalesDiscWhenNotAvail() {
        return salesDiscWhenNotAvail;
    }

    public void setSalesDiscWhenNotAvail(String salesDiscWhenNotAvail) {
        this.salesDiscWhenNotAvail = salesDiscWhenNotAvail;
    }

    private String internalName;

    @Basic
    @javax.persistence.Column(name = "INTERNAL_NAME", nullable = true, insertable = true, updatable = true, length = 255)
    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    private String brandName;

    @Basic
    @javax.persistence.Column(name = "BRAND_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    private String productName;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String description;

    @Basic
    @javax.persistence.Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String longDescription;

    @Basic
    @javax.persistence.Column(name = "LONG_DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    private String priceDetailText;

    @Basic
    @javax.persistence.Column(name = "PRICE_DETAIL_TEXT", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPriceDetailText() {
        return priceDetailText;
    }

    public void setPriceDetailText(String priceDetailText) {
        this.priceDetailText = priceDetailText;
    }

    private String smallImageUrl;

    @Basic
    @javax.persistence.Column(name = "SMALL_IMAGE_URL", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    private String mediumImageUrl;

    @Basic
    @javax.persistence.Column(name = "MEDIUM_IMAGE_URL", nullable = true, insertable = true, updatable = true, length = 255)
    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    public void setMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
    }

    private String largeImageUrl;

    @Basic
    @javax.persistence.Column(name = "LARGE_IMAGE_URL", nullable = true, insertable = true, updatable = true, length = 255)
    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    private String detailImageUrl;

    @Basic
    @javax.persistence.Column(name = "DETAIL_IMAGE_URL", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDetailImageUrl() {
        return detailImageUrl;
    }

    public void setDetailImageUrl(String detailImageUrl) {
        this.detailImageUrl = detailImageUrl;
    }

    private String originalImageUrl;

    @Basic
    @javax.persistence.Column(name = "ORIGINAL_IMAGE_URL", nullable = true, insertable = true, updatable = true, length = 255)
    public String getOriginalImageUrl() {
        return originalImageUrl;
    }

    public void setOriginalImageUrl(String originalImageUrl) {
        this.originalImageUrl = originalImageUrl;
    }

    private String detailScreen;

    @Basic
    @javax.persistence.Column(name = "DETAIL_SCREEN", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDetailScreen() {
        return detailScreen;
    }

    public void setDetailScreen(String detailScreen) {
        this.detailScreen = detailScreen;
    }

    private String inventoryMessage;

    @Basic
    @javax.persistence.Column(name = "INVENTORY_MESSAGE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getInventoryMessage() {
        return inventoryMessage;
    }

    public void setInventoryMessage(String inventoryMessage) {
        this.inventoryMessage = inventoryMessage;
    }

    private String requireInventory;

    @Basic
    @javax.persistence.Column(name = "REQUIRE_INVENTORY", nullable = true, insertable = true, updatable = true, length = 1)
    public String getRequireInventory() {
        return requireInventory;
    }

    public void setRequireInventory(String requireInventory) {
        this.requireInventory = requireInventory;
    }

    private String quantityUomId;

    @Basic
    @javax.persistence.Column(name = "QUANTITY_UOM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getQuantityUomId() {
        return quantityUomId;
    }

    public void setQuantityUomId(String quantityUomId) {
        this.quantityUomId = quantityUomId;
    }

    private BigDecimal quantityIncluded;

    @Basic
    @javax.persistence.Column(name = "QUANTITY_INCLUDED", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getQuantityIncluded() {
        return quantityIncluded;
    }

    public void setQuantityIncluded(BigDecimal quantityIncluded) {
        this.quantityIncluded = quantityIncluded;
    }

    private Integer piecesIncluded;

    @Basic
    @javax.persistence.Column(name = "PIECES_INCLUDED", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getPiecesIncluded() {
        return piecesIncluded;
    }

    public void setPiecesIncluded(Integer piecesIncluded) {
        this.piecesIncluded = piecesIncluded;
    }

    private String requireAmount;

    @Basic
    @javax.persistence.Column(name = "REQUIRE_AMOUNT", nullable = true, insertable = true, updatable = true, length = 1)
    public String getRequireAmount() {
        return requireAmount;
    }

    public void setRequireAmount(String requireAmount) {
        this.requireAmount = requireAmount;
    }

    private BigDecimal fixedAmount;

    @Basic
    @javax.persistence.Column(name = "FIXED_AMOUNT", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(BigDecimal fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    private String amountUomTypeId;

    @Basic
    @javax.persistence.Column(name = "AMOUNT_UOM_TYPE_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getAmountUomTypeId() {
        return amountUomTypeId;
    }

    public void setAmountUomTypeId(String amountUomTypeId) {
        this.amountUomTypeId = amountUomTypeId;
    }

    private String weightUomId;

    @Basic
    @javax.persistence.Column(name = "WEIGHT_UOM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getWeightUomId() {
        return weightUomId;
    }

    public void setWeightUomId(String weightUomId) {
        this.weightUomId = weightUomId;
    }

    private BigDecimal weight;

    @Basic
    @javax.persistence.Column(name = "WEIGHT", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    private BigDecimal productWeight;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_WEIGHT", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(BigDecimal productWeight) {
        this.productWeight = productWeight;
    }

    private String heightUomId;

    @Basic
    @javax.persistence.Column(name = "HEIGHT_UOM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getHeightUomId() {
        return heightUomId;
    }

    public void setHeightUomId(String heightUomId) {
        this.heightUomId = heightUomId;
    }

    private BigDecimal productHeight;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_HEIGHT", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(BigDecimal productHeight) {
        this.productHeight = productHeight;
    }

    private BigDecimal shippingHeight;

    @Basic
    @javax.persistence.Column(name = "SHIPPING_HEIGHT", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getShippingHeight() {
        return shippingHeight;
    }

    public void setShippingHeight(BigDecimal shippingHeight) {
        this.shippingHeight = shippingHeight;
    }

    private String widthUomId;

    @Basic
    @javax.persistence.Column(name = "WIDTH_UOM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getWidthUomId() {
        return widthUomId;
    }

    public void setWidthUomId(String widthUomId) {
        this.widthUomId = widthUomId;
    }

    private BigDecimal productWidth;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_WIDTH", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(BigDecimal productWidth) {
        this.productWidth = productWidth;
    }

    private BigDecimal shippingWidth;

    @Basic
    @javax.persistence.Column(name = "SHIPPING_WIDTH", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getShippingWidth() {
        return shippingWidth;
    }

    public void setShippingWidth(BigDecimal shippingWidth) {
        this.shippingWidth = shippingWidth;
    }

    private String depthUomId;

    @Basic
    @javax.persistence.Column(name = "DEPTH_UOM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDepthUomId() {
        return depthUomId;
    }

    public void setDepthUomId(String depthUomId) {
        this.depthUomId = depthUomId;
    }

    private BigDecimal productDepth;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_DEPTH", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getProductDepth() {
        return productDepth;
    }

    public void setProductDepth(BigDecimal productDepth) {
        this.productDepth = productDepth;
    }

    private BigDecimal shippingDepth;

    @Basic
    @javax.persistence.Column(name = "SHIPPING_DEPTH", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getShippingDepth() {
        return shippingDepth;
    }

    public void setShippingDepth(BigDecimal shippingDepth) {
        this.shippingDepth = shippingDepth;
    }

    private String diameterUomId;

    @Basic
    @javax.persistence.Column(name = "DIAMETER_UOM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDiameterUomId() {
        return diameterUomId;
    }

    public void setDiameterUomId(String diameterUomId) {
        this.diameterUomId = diameterUomId;
    }

    private BigDecimal productDiameter;

    @Basic
    @javax.persistence.Column(name = "PRODUCT_DIAMETER", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getProductDiameter() {
        return productDiameter;
    }

    public void setProductDiameter(BigDecimal productDiameter) {
        this.productDiameter = productDiameter;
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

    private String ratingTypeEnum;

    @Basic
    @javax.persistence.Column(name = "RATING_TYPE_ENUM", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRatingTypeEnum() {
        return ratingTypeEnum;
    }

    public void setRatingTypeEnum(String ratingTypeEnum) {
        this.ratingTypeEnum = ratingTypeEnum;
    }

    private String returnable;

    @Basic
    @javax.persistence.Column(name = "RETURNABLE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getReturnable() {
        return returnable;
    }

    public void setReturnable(String returnable) {
        this.returnable = returnable;
    }

    private String taxable;

    @Basic
    @javax.persistence.Column(name = "TAXABLE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getTaxable() {
        return taxable;
    }

    public void setTaxable(String taxable) {
        this.taxable = taxable;
    }

    private String chargeShipping;

    @Basic
    @javax.persistence.Column(name = "CHARGE_SHIPPING", nullable = true, insertable = true, updatable = true, length = 1)
    public String getChargeShipping() {
        return chargeShipping;
    }

    public void setChargeShipping(String chargeShipping) {
        this.chargeShipping = chargeShipping;
    }

    private String autoCreateKeywords;

    @Basic
    @javax.persistence.Column(name = "AUTO_CREATE_KEYWORDS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAutoCreateKeywords() {
        return autoCreateKeywords;
    }

    public void setAutoCreateKeywords(String autoCreateKeywords) {
        this.autoCreateKeywords = autoCreateKeywords;
    }

    private String includeInPromotions;

    @Basic
    @javax.persistence.Column(name = "INCLUDE_IN_PROMOTIONS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIncludeInPromotions() {
        return includeInPromotions;
    }

    public void setIncludeInPromotions(String includeInPromotions) {
        this.includeInPromotions = includeInPromotions;
    }

    private String isVirtual;

    @Basic
    @javax.persistence.Column(name = "IS_VIRTUAL", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(String isVirtual) {
        this.isVirtual = isVirtual;
    }

    private String isVariant;

    @Basic
    @javax.persistence.Column(name = "IS_VARIANT", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsVariant() {
        return isVariant;
    }

    public void setIsVariant(String isVariant) {
        this.isVariant = isVariant;
    }

    private String virtualVariantMethodEnum;

    @Basic
    @javax.persistence.Column(name = "VIRTUAL_VARIANT_METHOD_ENUM", nullable = true, insertable = true, updatable = true, length = 20)
    public String getVirtualVariantMethodEnum() {
        return virtualVariantMethodEnum;
    }

    public void setVirtualVariantMethodEnum(String virtualVariantMethodEnum) {
        this.virtualVariantMethodEnum = virtualVariantMethodEnum;
    }

    private String originGeoId;

    @Basic
    @javax.persistence.Column(name = "ORIGIN_GEO_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getOriginGeoId() {
        return originGeoId;
    }

    public void setOriginGeoId(String originGeoId) {
        this.originGeoId = originGeoId;
    }

    private String requirementMethodEnumId;

    @Basic
    @javax.persistence.Column(name = "REQUIREMENT_METHOD_ENUM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRequirementMethodEnumId() {
        return requirementMethodEnumId;
    }

    public void setRequirementMethodEnumId(String requirementMethodEnumId) {
        this.requirementMethodEnumId = requirementMethodEnumId;
    }

    private Integer billOfMaterialLevel;

    @Basic
    @javax.persistence.Column(name = "BILL_OF_MATERIAL_LEVEL", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getBillOfMaterialLevel() {
        return billOfMaterialLevel;
    }

    public void setBillOfMaterialLevel(Integer billOfMaterialLevel) {
        this.billOfMaterialLevel = billOfMaterialLevel;
    }

    private BigDecimal reservMaxPersons;

    @Basic
    @javax.persistence.Column(name = "RESERV_MAX_PERSONS", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getReservMaxPersons() {
        return reservMaxPersons;
    }

    public void setReservMaxPersons(BigDecimal reservMaxPersons) {
        this.reservMaxPersons = reservMaxPersons;
    }

    private BigDecimal reserv2NdPPPerc;

    @Basic
    @javax.persistence.Column(name = "RESERV2ND_P_P_PERC", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getReserv2NdPPPerc() {
        return reserv2NdPPPerc;
    }

    public void setReserv2NdPPPerc(BigDecimal reserv2NdPPPerc) {
        this.reserv2NdPPPerc = reserv2NdPPPerc;
    }

    private BigDecimal reservNthPPPerc;

    @Basic
    @javax.persistence.Column(name = "RESERV_NTH_P_P_PERC", nullable = true, insertable = true, updatable = true, precision = 6)
    public BigDecimal getReservNthPPPerc() {
        return reservNthPPPerc;
    }

    public void setReservNthPPPerc(BigDecimal reservNthPPPerc) {
        this.reservNthPPPerc = reservNthPPPerc;
    }

    private String configId;

    @Basic
    @javax.persistence.Column(name = "CONFIG_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    private Timestamp createdDate;

    @Basic
    @javax.persistence.Column(name = "CREATED_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    private String createdByUserLogin;

    @Basic
    @javax.persistence.Column(name = "CREATED_BY_USER_LOGIN", nullable = true, insertable = true, updatable = true, length = 250)
    public String getCreatedByUserLogin() {
        return createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin) {
        this.createdByUserLogin = createdByUserLogin;
    }

    private Timestamp lastModifiedDate;

    @Basic
    @javax.persistence.Column(name = "LAST_MODIFIED_DATE", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    private String lastModifiedByUserLogin;

    @Basic
    @javax.persistence.Column(name = "LAST_MODIFIED_BY_USER_LOGIN", nullable = true, insertable = true, updatable = true, length = 250)
    public String getLastModifiedByUserLogin() {
        return lastModifiedByUserLogin;
    }

    public void setLastModifiedByUserLogin(String lastModifiedByUserLogin) {
        this.lastModifiedByUserLogin = lastModifiedByUserLogin;
    }

    private String inShippingBox;

    @Basic
    @javax.persistence.Column(name = "IN_SHIPPING_BOX", nullable = true, insertable = true, updatable = true, length = 1)
    public String getInShippingBox() {
        return inShippingBox;
    }

    public void setInShippingBox(String inShippingBox) {
        this.inShippingBox = inShippingBox;
    }

    private String defaultShipmentBoxTypeId;

    @Basic
    @javax.persistence.Column(name = "DEFAULT_SHIPMENT_BOX_TYPE_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDefaultShipmentBoxTypeId() {
        return defaultShipmentBoxTypeId;
    }

    public void setDefaultShipmentBoxTypeId(String defaultShipmentBoxTypeId) {
        this.defaultShipmentBoxTypeId = defaultShipmentBoxTypeId;
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

    private String isActive;

    @Basic
    @javax.persistence.Column(name = "IS_ACTIVE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (amountUomTypeId != null ? !amountUomTypeId.equals(product.amountUomTypeId) : product.amountUomTypeId != null)
            return false;
        if (autoCreateKeywords != null ? !autoCreateKeywords.equals(product.autoCreateKeywords) : product.autoCreateKeywords != null)
            return false;
        if (billOfMaterialLevel != null ? !billOfMaterialLevel.equals(product.billOfMaterialLevel) : product.billOfMaterialLevel != null)
            return false;
        if (brandName != null ? !brandName.equals(product.brandName) : product.brandName != null) return false;
        if (chargeShipping != null ? !chargeShipping.equals(product.chargeShipping) : product.chargeShipping != null)
            return false;
        if (comments != null ? !comments.equals(product.comments) : product.comments != null) return false;
        if (configId != null ? !configId.equals(product.configId) : product.configId != null) return false;
        if (createdByUserLogin != null ? !createdByUserLogin.equals(product.createdByUserLogin) : product.createdByUserLogin != null)
            return false;
        if (createdDate != null ? !createdDate.equals(product.createdDate) : product.createdDate != null) return false;
        if (createdStamp != null ? !createdStamp.equals(product.createdStamp) : product.createdStamp != null)
            return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(product.createdTxStamp) : product.createdTxStamp != null)
            return false;
        if (defaultShipmentBoxTypeId != null ? !defaultShipmentBoxTypeId.equals(product.defaultShipmentBoxTypeId) : product.defaultShipmentBoxTypeId != null)
            return false;
        if (depthUomId != null ? !depthUomId.equals(product.depthUomId) : product.depthUomId != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (detailImageUrl != null ? !detailImageUrl.equals(product.detailImageUrl) : product.detailImageUrl != null)
            return false;
        if (detailScreen != null ? !detailScreen.equals(product.detailScreen) : product.detailScreen != null)
            return false;
        if (diameterUomId != null ? !diameterUomId.equals(product.diameterUomId) : product.diameterUomId != null)
            return false;
        if (facilityId != null ? !facilityId.equals(product.facilityId) : product.facilityId != null) return false;
        if (fixedAmount != null ? !fixedAmount.equals(product.fixedAmount) : product.fixedAmount != null) return false;
        if (heightUomId != null ? !heightUomId.equals(product.heightUomId) : product.heightUomId != null) return false;
        if (inShippingBox != null ? !inShippingBox.equals(product.inShippingBox) : product.inShippingBox != null)
            return false;
        if (includeInPromotions != null ? !includeInPromotions.equals(product.includeInPromotions) : product.includeInPromotions != null)
            return false;
        if (internalName != null ? !internalName.equals(product.internalName) : product.internalName != null)
            return false;
        if (introductionDate != null ? !introductionDate.equals(product.introductionDate) : product.introductionDate != null)
            return false;
        if (inventoryMessage != null ? !inventoryMessage.equals(product.inventoryMessage) : product.inventoryMessage != null)
            return false;
        if (isActive != null ? !isActive.equals(product.isActive) : product.isActive != null) return false;
        if (isVariant != null ? !isVariant.equals(product.isVariant) : product.isVariant != null) return false;
        if (isVirtual != null ? !isVirtual.equals(product.isVirtual) : product.isVirtual != null) return false;
        if (largeImageUrl != null ? !largeImageUrl.equals(product.largeImageUrl) : product.largeImageUrl != null)
            return false;
        if (lastModifiedByUserLogin != null ? !lastModifiedByUserLogin.equals(product.lastModifiedByUserLogin) : product.lastModifiedByUserLogin != null)
            return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(product.lastModifiedDate) : product.lastModifiedDate != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(product.lastUpdatedStamp) : product.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(product.lastUpdatedTxStamp) : product.lastUpdatedTxStamp != null)
            return false;
        if (longDescription != null ? !longDescription.equals(product.longDescription) : product.longDescription != null)
            return false;
        if (manufacturerPartyId != null ? !manufacturerPartyId.equals(product.manufacturerPartyId) : product.manufacturerPartyId != null)
            return false;
        if (mediumImageUrl != null ? !mediumImageUrl.equals(product.mediumImageUrl) : product.mediumImageUrl != null)
            return false;
        if (originGeoId != null ? !originGeoId.equals(product.originGeoId) : product.originGeoId != null) return false;
        if (originalImageUrl != null ? !originalImageUrl.equals(product.originalImageUrl) : product.originalImageUrl != null)
            return false;
        if (piecesIncluded != null ? !piecesIncluded.equals(product.piecesIncluded) : product.piecesIncluded != null)
            return false;
        if (priceDetailText != null ? !priceDetailText.equals(product.priceDetailText) : product.priceDetailText != null)
            return false;
        if (primaryProductCategoryId != null ? !primaryProductCategoryId.equals(product.primaryProductCategoryId) : product.primaryProductCategoryId != null)
            return false;
        if (productDepth != null ? !productDepth.equals(product.productDepth) : product.productDepth != null)
            return false;
        if (productDiameter != null ? !productDiameter.equals(product.productDiameter) : product.productDiameter != null)
            return false;
        if (productHeight != null ? !productHeight.equals(product.productHeight) : product.productHeight != null)
            return false;
        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productRating != null ? !productRating.equals(product.productRating) : product.productRating != null)
            return false;
        if (productTypeId != null ? !productTypeId.equals(product.productTypeId) : product.productTypeId != null)
            return false;
        if (productWeight != null ? !productWeight.equals(product.productWeight) : product.productWeight != null)
            return false;
        if (productWidth != null ? !productWidth.equals(product.productWidth) : product.productWidth != null)
            return false;
        if (quantityIncluded != null ? !quantityIncluded.equals(product.quantityIncluded) : product.quantityIncluded != null)
            return false;
        if (quantityUomId != null ? !quantityUomId.equals(product.quantityUomId) : product.quantityUomId != null)
            return false;
        if (ratingTypeEnum != null ? !ratingTypeEnum.equals(product.ratingTypeEnum) : product.ratingTypeEnum != null)
            return false;
        if (releaseDate != null ? !releaseDate.equals(product.releaseDate) : product.releaseDate != null) return false;
        if (requireAmount != null ? !requireAmount.equals(product.requireAmount) : product.requireAmount != null)
            return false;
        if (requireInventory != null ? !requireInventory.equals(product.requireInventory) : product.requireInventory != null)
            return false;
        if (requirementMethodEnumId != null ? !requirementMethodEnumId.equals(product.requirementMethodEnumId) : product.requirementMethodEnumId != null)
            return false;
        if (reserv2NdPPPerc != null ? !reserv2NdPPPerc.equals(product.reserv2NdPPPerc) : product.reserv2NdPPPerc != null)
            return false;
        if (reservMaxPersons != null ? !reservMaxPersons.equals(product.reservMaxPersons) : product.reservMaxPersons != null)
            return false;
        if (reservNthPPPerc != null ? !reservNthPPPerc.equals(product.reservNthPPPerc) : product.reservNthPPPerc != null)
            return false;
        if (returnable != null ? !returnable.equals(product.returnable) : product.returnable != null) return false;
        if (salesDiscWhenNotAvail != null ? !salesDiscWhenNotAvail.equals(product.salesDiscWhenNotAvail) : product.salesDiscWhenNotAvail != null)
            return false;
        if (salesDiscontinuationDate != null ? !salesDiscontinuationDate.equals(product.salesDiscontinuationDate) : product.salesDiscontinuationDate != null)
            return false;
        if (shippingDepth != null ? !shippingDepth.equals(product.shippingDepth) : product.shippingDepth != null)
            return false;
        if (shippingHeight != null ? !shippingHeight.equals(product.shippingHeight) : product.shippingHeight != null)
            return false;
        if (shippingWidth != null ? !shippingWidth.equals(product.shippingWidth) : product.shippingWidth != null)
            return false;
        if (smallImageUrl != null ? !smallImageUrl.equals(product.smallImageUrl) : product.smallImageUrl != null)
            return false;
        if (supportDiscontinuationDate != null ? !supportDiscontinuationDate.equals(product.supportDiscontinuationDate) : product.supportDiscontinuationDate != null)
            return false;
        if (taxable != null ? !taxable.equals(product.taxable) : product.taxable != null) return false;
        if (virtualVariantMethodEnum != null ? !virtualVariantMethodEnum.equals(product.virtualVariantMethodEnum) : product.virtualVariantMethodEnum != null)
            return false;
        if (weight != null ? !weight.equals(product.weight) : product.weight != null) return false;
        if (weightUomId != null ? !weightUomId.equals(product.weightUomId) : product.weightUomId != null) return false;
        if (widthUomId != null ? !widthUomId.equals(product.widthUomId) : product.widthUomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productTypeId != null ? productTypeId.hashCode() : 0);
        result = 31 * result + (primaryProductCategoryId != null ? primaryProductCategoryId.hashCode() : 0);
        result = 31 * result + (manufacturerPartyId != null ? manufacturerPartyId.hashCode() : 0);
        result = 31 * result + (facilityId != null ? facilityId.hashCode() : 0);
        result = 31 * result + (introductionDate != null ? introductionDate.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (supportDiscontinuationDate != null ? supportDiscontinuationDate.hashCode() : 0);
        result = 31 * result + (salesDiscontinuationDate != null ? salesDiscontinuationDate.hashCode() : 0);
        result = 31 * result + (salesDiscWhenNotAvail != null ? salesDiscWhenNotAvail.hashCode() : 0);
        result = 31 * result + (internalName != null ? internalName.hashCode() : 0);
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (longDescription != null ? longDescription.hashCode() : 0);
        result = 31 * result + (priceDetailText != null ? priceDetailText.hashCode() : 0);
        result = 31 * result + (smallImageUrl != null ? smallImageUrl.hashCode() : 0);
        result = 31 * result + (mediumImageUrl != null ? mediumImageUrl.hashCode() : 0);
        result = 31 * result + (largeImageUrl != null ? largeImageUrl.hashCode() : 0);
        result = 31 * result + (detailImageUrl != null ? detailImageUrl.hashCode() : 0);
        result = 31 * result + (originalImageUrl != null ? originalImageUrl.hashCode() : 0);
        result = 31 * result + (detailScreen != null ? detailScreen.hashCode() : 0);
        result = 31 * result + (inventoryMessage != null ? inventoryMessage.hashCode() : 0);
        result = 31 * result + (requireInventory != null ? requireInventory.hashCode() : 0);
        result = 31 * result + (quantityUomId != null ? quantityUomId.hashCode() : 0);
        result = 31 * result + (quantityIncluded != null ? quantityIncluded.hashCode() : 0);
        result = 31 * result + (piecesIncluded != null ? piecesIncluded.hashCode() : 0);
        result = 31 * result + (requireAmount != null ? requireAmount.hashCode() : 0);
        result = 31 * result + (fixedAmount != null ? fixedAmount.hashCode() : 0);
        result = 31 * result + (amountUomTypeId != null ? amountUomTypeId.hashCode() : 0);
        result = 31 * result + (weightUomId != null ? weightUomId.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (productWeight != null ? productWeight.hashCode() : 0);
        result = 31 * result + (heightUomId != null ? heightUomId.hashCode() : 0);
        result = 31 * result + (productHeight != null ? productHeight.hashCode() : 0);
        result = 31 * result + (shippingHeight != null ? shippingHeight.hashCode() : 0);
        result = 31 * result + (widthUomId != null ? widthUomId.hashCode() : 0);
        result = 31 * result + (productWidth != null ? productWidth.hashCode() : 0);
        result = 31 * result + (shippingWidth != null ? shippingWidth.hashCode() : 0);
        result = 31 * result + (depthUomId != null ? depthUomId.hashCode() : 0);
        result = 31 * result + (productDepth != null ? productDepth.hashCode() : 0);
        result = 31 * result + (shippingDepth != null ? shippingDepth.hashCode() : 0);
        result = 31 * result + (diameterUomId != null ? diameterUomId.hashCode() : 0);
        result = 31 * result + (productDiameter != null ? productDiameter.hashCode() : 0);
        result = 31 * result + (productRating != null ? productRating.hashCode() : 0);
        result = 31 * result + (ratingTypeEnum != null ? ratingTypeEnum.hashCode() : 0);
        result = 31 * result + (returnable != null ? returnable.hashCode() : 0);
        result = 31 * result + (taxable != null ? taxable.hashCode() : 0);
        result = 31 * result + (chargeShipping != null ? chargeShipping.hashCode() : 0);
        result = 31 * result + (autoCreateKeywords != null ? autoCreateKeywords.hashCode() : 0);
        result = 31 * result + (includeInPromotions != null ? includeInPromotions.hashCode() : 0);
        result = 31 * result + (isVirtual != null ? isVirtual.hashCode() : 0);
        result = 31 * result + (isVariant != null ? isVariant.hashCode() : 0);
        result = 31 * result + (virtualVariantMethodEnum != null ? virtualVariantMethodEnum.hashCode() : 0);
        result = 31 * result + (originGeoId != null ? originGeoId.hashCode() : 0);
        result = 31 * result + (requirementMethodEnumId != null ? requirementMethodEnumId.hashCode() : 0);
        result = 31 * result + (billOfMaterialLevel != null ? billOfMaterialLevel.hashCode() : 0);
        result = 31 * result + (reservMaxPersons != null ? reservMaxPersons.hashCode() : 0);
        result = 31 * result + (reserv2NdPPPerc != null ? reserv2NdPPPerc.hashCode() : 0);
        result = 31 * result + (reservNthPPPerc != null ? reservNthPPPerc.hashCode() : 0);
        result = 31 * result + (configId != null ? configId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdByUserLogin != null ? createdByUserLogin.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        result = 31 * result + (lastModifiedByUserLogin != null ? lastModifiedByUserLogin.hashCode() : 0);
        result = 31 * result + (inShippingBox != null ? inShippingBox.hashCode() : 0);
        result = 31 * result + (defaultShipmentBoxTypeId != null ? defaultShipmentBoxTypeId.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }
}
