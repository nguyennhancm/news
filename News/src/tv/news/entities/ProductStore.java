package tv.news.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 5/31/2015
 * Time: 10:53 PM
 * Media Group
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name = "product_store")
public class ProductStore {
    private String productStoreId;

    @Id
    @javax.persistence.Column(name = "PRODUCT_STORE_ID", nullable = false, insertable = true, updatable = true, length = 20)
    public String getProductStoreId() {
        return productStoreId;
    }

    public void setProductStoreId(String productStoreId) {
        this.productStoreId = productStoreId;
    }

    private String primaryStoreGroupId;

    @Basic
    @javax.persistence.Column(name = "PRIMARY_STORE_GROUP_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPrimaryStoreGroupId() {
        return primaryStoreGroupId;
    }

    public void setPrimaryStoreGroupId(String primaryStoreGroupId) {
        this.primaryStoreGroupId = primaryStoreGroupId;
    }

    private String storeName;

    @Basic
    @javax.persistence.Column(name = "STORE_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    private String companyName;

    @Basic
    @javax.persistence.Column(name = "COMPANY_NAME", nullable = true, insertable = true, updatable = true, length = 100)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private String title;

    @Basic
    @javax.persistence.Column(name = "TITLE", nullable = true, insertable = true, updatable = true, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String subtitle;

    @Basic
    @javax.persistence.Column(name = "SUBTITLE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    private String payToPartyId;

    @Basic
    @javax.persistence.Column(name = "PAY_TO_PARTY_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPayToPartyId() {
        return payToPartyId;
    }

    public void setPayToPartyId(String payToPartyId) {
        this.payToPartyId = payToPartyId;
    }

    private Integer daysToCancelNonPay;

    @Basic
    @javax.persistence.Column(name = "DAYS_TO_CANCEL_NON_PAY", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getDaysToCancelNonPay() {
        return daysToCancelNonPay;
    }

    public void setDaysToCancelNonPay(Integer daysToCancelNonPay) {
        this.daysToCancelNonPay = daysToCancelNonPay;
    }

    private String manualAuthIsCapture;

    @Basic
    @javax.persistence.Column(name = "MANUAL_AUTH_IS_CAPTURE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getManualAuthIsCapture() {
        return manualAuthIsCapture;
    }

    public void setManualAuthIsCapture(String manualAuthIsCapture) {
        this.manualAuthIsCapture = manualAuthIsCapture;
    }

    private String prorateShipping;

    @Basic
    @javax.persistence.Column(name = "PRORATE_SHIPPING", nullable = true, insertable = true, updatable = true, length = 1)
    public String getProrateShipping() {
        return prorateShipping;
    }

    public void setProrateShipping(String prorateShipping) {
        this.prorateShipping = prorateShipping;
    }

    private String prorateTaxes;

    @Basic
    @javax.persistence.Column(name = "PRORATE_TAXES", nullable = true, insertable = true, updatable = true, length = 1)
    public String getProrateTaxes() {
        return prorateTaxes;
    }

    public void setProrateTaxes(String prorateTaxes) {
        this.prorateTaxes = prorateTaxes;
    }

    private String viewCartOnAdd;

    @Basic
    @javax.persistence.Column(name = "VIEW_CART_ON_ADD", nullable = true, insertable = true, updatable = true, length = 1)
    public String getViewCartOnAdd() {
        return viewCartOnAdd;
    }

    public void setViewCartOnAdd(String viewCartOnAdd) {
        this.viewCartOnAdd = viewCartOnAdd;
    }

    private String autoSaveCart;

    @Basic
    @javax.persistence.Column(name = "AUTO_SAVE_CART", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAutoSaveCart() {
        return autoSaveCart;
    }

    public void setAutoSaveCart(String autoSaveCart) {
        this.autoSaveCart = autoSaveCart;
    }

    private String autoApproveReviews;

    @Basic
    @javax.persistence.Column(name = "AUTO_APPROVE_REVIEWS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAutoApproveReviews() {
        return autoApproveReviews;
    }

    public void setAutoApproveReviews(String autoApproveReviews) {
        this.autoApproveReviews = autoApproveReviews;
    }

    private String isDemoStore;

    @Basic
    @javax.persistence.Column(name = "IS_DEMO_STORE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsDemoStore() {
        return isDemoStore;
    }

    public void setIsDemoStore(String isDemoStore) {
        this.isDemoStore = isDemoStore;
    }

    private String isImmediatelyFulfilled;

    @Basic
    @javax.persistence.Column(name = "IS_IMMEDIATELY_FULFILLED", nullable = true, insertable = true, updatable = true, length = 1)
    public String getIsImmediatelyFulfilled() {
        return isImmediatelyFulfilled;
    }

    public void setIsImmediatelyFulfilled(String isImmediatelyFulfilled) {
        this.isImmediatelyFulfilled = isImmediatelyFulfilled;
    }

    private String inventoryFacilityId;

    @Basic
    @javax.persistence.Column(name = "INVENTORY_FACILITY_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getInventoryFacilityId() {
        return inventoryFacilityId;
    }

    public void setInventoryFacilityId(String inventoryFacilityId) {
        this.inventoryFacilityId = inventoryFacilityId;
    }

    private String oneInventoryFacility;

    @Basic
    @javax.persistence.Column(name = "ONE_INVENTORY_FACILITY", nullable = true, insertable = true, updatable = true, length = 1)
    public String getOneInventoryFacility() {
        return oneInventoryFacility;
    }

    public void setOneInventoryFacility(String oneInventoryFacility) {
        this.oneInventoryFacility = oneInventoryFacility;
    }

    private String checkInventory;

    @Basic
    @javax.persistence.Column(name = "CHECK_INVENTORY", nullable = true, insertable = true, updatable = true, length = 1)
    public String getCheckInventory() {
        return checkInventory;
    }

    public void setCheckInventory(String checkInventory) {
        this.checkInventory = checkInventory;
    }

    private String reserveInventory;

    @Basic
    @javax.persistence.Column(name = "RESERVE_INVENTORY", nullable = true, insertable = true, updatable = true, length = 1)
    public String getReserveInventory() {
        return reserveInventory;
    }

    public void setReserveInventory(String reserveInventory) {
        this.reserveInventory = reserveInventory;
    }

    private String reserveOrderEnumId;

    @Basic
    @javax.persistence.Column(name = "RESERVE_ORDER_ENUM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getReserveOrderEnumId() {
        return reserveOrderEnumId;
    }

    public void setReserveOrderEnumId(String reserveOrderEnumId) {
        this.reserveOrderEnumId = reserveOrderEnumId;
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

    private String balanceResOnOrderCreation;

    @Basic
    @javax.persistence.Column(name = "BALANCE_RES_ON_ORDER_CREATION", nullable = true, insertable = true, updatable = true, length = 1)
    public String getBalanceResOnOrderCreation() {
        return balanceResOnOrderCreation;
    }

    public void setBalanceResOnOrderCreation(String balanceResOnOrderCreation) {
        this.balanceResOnOrderCreation = balanceResOnOrderCreation;
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

    private String orderNumberPrefix;

    @Basic
    @javax.persistence.Column(name = "ORDER_NUMBER_PREFIX", nullable = true, insertable = true, updatable = true, length = 60)
    public String getOrderNumberPrefix() {
        return orderNumberPrefix;
    }

    public void setOrderNumberPrefix(String orderNumberPrefix) {
        this.orderNumberPrefix = orderNumberPrefix;
    }

    private String defaultLocaleString;

    @Basic
    @javax.persistence.Column(name = "DEFAULT_LOCALE_STRING", nullable = true, insertable = true, updatable = true, length = 10)
    public String getDefaultLocaleString() {
        return defaultLocaleString;
    }

    public void setDefaultLocaleString(String defaultLocaleString) {
        this.defaultLocaleString = defaultLocaleString;
    }

    private String defaultCurrencyUomId;

    @Basic
    @javax.persistence.Column(name = "DEFAULT_CURRENCY_UOM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDefaultCurrencyUomId() {
        return defaultCurrencyUomId;
    }

    public void setDefaultCurrencyUomId(String defaultCurrencyUomId) {
        this.defaultCurrencyUomId = defaultCurrencyUomId;
    }

    private String defaultSalesChannelEnumId;

    @Basic
    @javax.persistence.Column(name = "DEFAULT_SALES_CHANNEL_ENUM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDefaultSalesChannelEnumId() {
        return defaultSalesChannelEnumId;
    }

    public void setDefaultSalesChannelEnumId(String defaultSalesChannelEnumId) {
        this.defaultSalesChannelEnumId = defaultSalesChannelEnumId;
    }

    private String allowPassword;

    @Basic
    @javax.persistence.Column(name = "ALLOW_PASSWORD", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAllowPassword() {
        return allowPassword;
    }

    public void setAllowPassword(String allowPassword) {
        this.allowPassword = allowPassword;
    }

    private String defaultPassword;

    @Basic
    @javax.persistence.Column(name = "DEFAULT_PASSWORD", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

    private String explodeOrderItems;

    @Basic
    @javax.persistence.Column(name = "EXPLODE_ORDER_ITEMS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getExplodeOrderItems() {
        return explodeOrderItems;
    }

    public void setExplodeOrderItems(String explodeOrderItems) {
        this.explodeOrderItems = explodeOrderItems;
    }

    private String checkGcBalance;

    @Basic
    @javax.persistence.Column(name = "CHECK_GC_BALANCE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getCheckGcBalance() {
        return checkGcBalance;
    }

    public void setCheckGcBalance(String checkGcBalance) {
        this.checkGcBalance = checkGcBalance;
    }

    private String retryFailedAuths;

    @Basic
    @javax.persistence.Column(name = "RETRY_FAILED_AUTHS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getRetryFailedAuths() {
        return retryFailedAuths;
    }

    public void setRetryFailedAuths(String retryFailedAuths) {
        this.retryFailedAuths = retryFailedAuths;
    }

    private String headerApprovedStatus;

    @Basic
    @javax.persistence.Column(name = "HEADER_APPROVED_STATUS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getHeaderApprovedStatus() {
        return headerApprovedStatus;
    }

    public void setHeaderApprovedStatus(String headerApprovedStatus) {
        this.headerApprovedStatus = headerApprovedStatus;
    }

    private String itemApprovedStatus;

    @Basic
    @javax.persistence.Column(name = "ITEM_APPROVED_STATUS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getItemApprovedStatus() {
        return itemApprovedStatus;
    }

    public void setItemApprovedStatus(String itemApprovedStatus) {
        this.itemApprovedStatus = itemApprovedStatus;
    }

    private String digitalItemApprovedStatus;

    @Basic
    @javax.persistence.Column(name = "DIGITAL_ITEM_APPROVED_STATUS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDigitalItemApprovedStatus() {
        return digitalItemApprovedStatus;
    }

    public void setDigitalItemApprovedStatus(String digitalItemApprovedStatus) {
        this.digitalItemApprovedStatus = digitalItemApprovedStatus;
    }

    private String headerDeclinedStatus;

    @Basic
    @javax.persistence.Column(name = "HEADER_DECLINED_STATUS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getHeaderDeclinedStatus() {
        return headerDeclinedStatus;
    }

    public void setHeaderDeclinedStatus(String headerDeclinedStatus) {
        this.headerDeclinedStatus = headerDeclinedStatus;
    }

    private String itemDeclinedStatus;

    @Basic
    @javax.persistence.Column(name = "ITEM_DECLINED_STATUS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getItemDeclinedStatus() {
        return itemDeclinedStatus;
    }

    public void setItemDeclinedStatus(String itemDeclinedStatus) {
        this.itemDeclinedStatus = itemDeclinedStatus;
    }

    private String headerCancelStatus;

    @Basic
    @javax.persistence.Column(name = "HEADER_CANCEL_STATUS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getHeaderCancelStatus() {
        return headerCancelStatus;
    }

    public void setHeaderCancelStatus(String headerCancelStatus) {
        this.headerCancelStatus = headerCancelStatus;
    }

    private String itemCancelStatus;

    @Basic
    @javax.persistence.Column(name = "ITEM_CANCEL_STATUS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getItemCancelStatus() {
        return itemCancelStatus;
    }

    public void setItemCancelStatus(String itemCancelStatus) {
        this.itemCancelStatus = itemCancelStatus;
    }

    private String authDeclinedMessage;

    @Basic
    @javax.persistence.Column(name = "AUTH_DECLINED_MESSAGE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getAuthDeclinedMessage() {
        return authDeclinedMessage;
    }

    public void setAuthDeclinedMessage(String authDeclinedMessage) {
        this.authDeclinedMessage = authDeclinedMessage;
    }

    private String authFraudMessage;

    @Basic
    @javax.persistence.Column(name = "AUTH_FRAUD_MESSAGE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getAuthFraudMessage() {
        return authFraudMessage;
    }

    public void setAuthFraudMessage(String authFraudMessage) {
        this.authFraudMessage = authFraudMessage;
    }

    private String authErrorMessage;

    @Basic
    @javax.persistence.Column(name = "AUTH_ERROR_MESSAGE", nullable = true, insertable = true, updatable = true, length = 255)
    public String getAuthErrorMessage() {
        return authErrorMessage;
    }

    public void setAuthErrorMessage(String authErrorMessage) {
        this.authErrorMessage = authErrorMessage;
    }

    private String visualThemeId;

    @Basic
    @javax.persistence.Column(name = "VISUAL_THEME_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getVisualThemeId() {
        return visualThemeId;
    }

    public void setVisualThemeId(String visualThemeId) {
        this.visualThemeId = visualThemeId;
    }

    private String storeCreditAccountEnumId;

    @Basic
    @javax.persistence.Column(name = "STORE_CREDIT_ACCOUNT_ENUM_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getStoreCreditAccountEnumId() {
        return storeCreditAccountEnumId;
    }

    public void setStoreCreditAccountEnumId(String storeCreditAccountEnumId) {
        this.storeCreditAccountEnumId = storeCreditAccountEnumId;
    }

    private String usePrimaryEmailUsername;

    @Basic
    @javax.persistence.Column(name = "USE_PRIMARY_EMAIL_USERNAME", nullable = true, insertable = true, updatable = true, length = 1)
    public String getUsePrimaryEmailUsername() {
        return usePrimaryEmailUsername;
    }

    public void setUsePrimaryEmailUsername(String usePrimaryEmailUsername) {
        this.usePrimaryEmailUsername = usePrimaryEmailUsername;
    }

    private String requireCustomerRole;

    @Basic
    @javax.persistence.Column(name = "REQUIRE_CUSTOMER_ROLE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getRequireCustomerRole() {
        return requireCustomerRole;
    }

    public void setRequireCustomerRole(String requireCustomerRole) {
        this.requireCustomerRole = requireCustomerRole;
    }

    private String autoInvoiceDigitalItems;

    @Basic
    @javax.persistence.Column(name = "AUTO_INVOICE_DIGITAL_ITEMS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAutoInvoiceDigitalItems() {
        return autoInvoiceDigitalItems;
    }

    public void setAutoInvoiceDigitalItems(String autoInvoiceDigitalItems) {
        this.autoInvoiceDigitalItems = autoInvoiceDigitalItems;
    }

    private String reqShipAddrForDigItems;

    @Basic
    @javax.persistence.Column(name = "REQ_SHIP_ADDR_FOR_DIG_ITEMS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getReqShipAddrForDigItems() {
        return reqShipAddrForDigItems;
    }

    public void setReqShipAddrForDigItems(String reqShipAddrForDigItems) {
        this.reqShipAddrForDigItems = reqShipAddrForDigItems;
    }

    private String showCheckoutGiftOptions;

    @Basic
    @javax.persistence.Column(name = "SHOW_CHECKOUT_GIFT_OPTIONS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getShowCheckoutGiftOptions() {
        return showCheckoutGiftOptions;
    }

    public void setShowCheckoutGiftOptions(String showCheckoutGiftOptions) {
        this.showCheckoutGiftOptions = showCheckoutGiftOptions;
    }

    private String selectPaymentTypePerItem;

    @Basic
    @javax.persistence.Column(name = "SELECT_PAYMENT_TYPE_PER_ITEM", nullable = true, insertable = true, updatable = true, length = 1)
    public String getSelectPaymentTypePerItem() {
        return selectPaymentTypePerItem;
    }

    public void setSelectPaymentTypePerItem(String selectPaymentTypePerItem) {
        this.selectPaymentTypePerItem = selectPaymentTypePerItem;
    }

    private String showPricesWithVatTax;

    @Basic
    @javax.persistence.Column(name = "SHOW_PRICES_WITH_VAT_TAX", nullable = true, insertable = true, updatable = true, length = 1)
    public String getShowPricesWithVatTax() {
        return showPricesWithVatTax;
    }

    public void setShowPricesWithVatTax(String showPricesWithVatTax) {
        this.showPricesWithVatTax = showPricesWithVatTax;
    }

    private String showTaxIsExempt;

    @Basic
    @javax.persistence.Column(name = "SHOW_TAX_IS_EXEMPT", nullable = true, insertable = true, updatable = true, length = 1)
    public String getShowTaxIsExempt() {
        return showTaxIsExempt;
    }

    public void setShowTaxIsExempt(String showTaxIsExempt) {
        this.showTaxIsExempt = showTaxIsExempt;
    }

    private String vatTaxAuthGeoId;

    @Basic
    @javax.persistence.Column(name = "VAT_TAX_AUTH_GEO_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getVatTaxAuthGeoId() {
        return vatTaxAuthGeoId;
    }

    public void setVatTaxAuthGeoId(String vatTaxAuthGeoId) {
        this.vatTaxAuthGeoId = vatTaxAuthGeoId;
    }

    private String vatTaxAuthPartyId;

    @Basic
    @javax.persistence.Column(name = "VAT_TAX_AUTH_PARTY_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getVatTaxAuthPartyId() {
        return vatTaxAuthPartyId;
    }

    public void setVatTaxAuthPartyId(String vatTaxAuthPartyId) {
        this.vatTaxAuthPartyId = vatTaxAuthPartyId;
    }

    private String enableAutoSuggestionList;

    @Basic
    @javax.persistence.Column(name = "ENABLE_AUTO_SUGGESTION_LIST", nullable = true, insertable = true, updatable = true, length = 1)
    public String getEnableAutoSuggestionList() {
        return enableAutoSuggestionList;
    }

    public void setEnableAutoSuggestionList(String enableAutoSuggestionList) {
        this.enableAutoSuggestionList = enableAutoSuggestionList;
    }

    private String enableDigProdUpload;

    @Basic
    @javax.persistence.Column(name = "ENABLE_DIG_PROD_UPLOAD", nullable = true, insertable = true, updatable = true, length = 1)
    public String getEnableDigProdUpload() {
        return enableDigProdUpload;
    }

    public void setEnableDigProdUpload(String enableDigProdUpload) {
        this.enableDigProdUpload = enableDigProdUpload;
    }

    private String prodSearchExcludeVariants;

    @Basic
    @javax.persistence.Column(name = "PROD_SEARCH_EXCLUDE_VARIANTS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getProdSearchExcludeVariants() {
        return prodSearchExcludeVariants;
    }

    public void setProdSearchExcludeVariants(String prodSearchExcludeVariants) {
        this.prodSearchExcludeVariants = prodSearchExcludeVariants;
    }

    private String digProdUploadCategoryId;

    @Basic
    @javax.persistence.Column(name = "DIG_PROD_UPLOAD_CATEGORY_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDigProdUploadCategoryId() {
        return digProdUploadCategoryId;
    }

    public void setDigProdUploadCategoryId(String digProdUploadCategoryId) {
        this.digProdUploadCategoryId = digProdUploadCategoryId;
    }

    private String autoOrderCcTryExp;

    @Basic
    @javax.persistence.Column(name = "AUTO_ORDER_CC_TRY_EXP", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAutoOrderCcTryExp() {
        return autoOrderCcTryExp;
    }

    public void setAutoOrderCcTryExp(String autoOrderCcTryExp) {
        this.autoOrderCcTryExp = autoOrderCcTryExp;
    }

    private String autoOrderCcTryOtherCards;

    @Basic
    @javax.persistence.Column(name = "AUTO_ORDER_CC_TRY_OTHER_CARDS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAutoOrderCcTryOtherCards() {
        return autoOrderCcTryOtherCards;
    }

    public void setAutoOrderCcTryOtherCards(String autoOrderCcTryOtherCards) {
        this.autoOrderCcTryOtherCards = autoOrderCcTryOtherCards;
    }

    private String autoOrderCcTryLaterNsf;

    @Basic
    @javax.persistence.Column(name = "AUTO_ORDER_CC_TRY_LATER_NSF", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAutoOrderCcTryLaterNsf() {
        return autoOrderCcTryLaterNsf;
    }

    public void setAutoOrderCcTryLaterNsf(String autoOrderCcTryLaterNsf) {
        this.autoOrderCcTryLaterNsf = autoOrderCcTryLaterNsf;
    }

    private Integer autoOrderCcTryLaterMax;

    @Basic
    @javax.persistence.Column(name = "AUTO_ORDER_CC_TRY_LATER_MAX", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getAutoOrderCcTryLaterMax() {
        return autoOrderCcTryLaterMax;
    }

    public void setAutoOrderCcTryLaterMax(Integer autoOrderCcTryLaterMax) {
        this.autoOrderCcTryLaterMax = autoOrderCcTryLaterMax;
    }

    private Integer storeCreditValidDays;

    @Basic
    @javax.persistence.Column(name = "STORE_CREDIT_VALID_DAYS", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getStoreCreditValidDays() {
        return storeCreditValidDays;
    }

    public void setStoreCreditValidDays(Integer storeCreditValidDays) {
        this.storeCreditValidDays = storeCreditValidDays;
    }

    private String autoApproveInvoice;

    @Basic
    @javax.persistence.Column(name = "AUTO_APPROVE_INVOICE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAutoApproveInvoice() {
        return autoApproveInvoice;
    }

    public void setAutoApproveInvoice(String autoApproveInvoice) {
        this.autoApproveInvoice = autoApproveInvoice;
    }

    private String autoApproveOrder;

    @Basic
    @javax.persistence.Column(name = "AUTO_APPROVE_ORDER", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAutoApproveOrder() {
        return autoApproveOrder;
    }

    public void setAutoApproveOrder(String autoApproveOrder) {
        this.autoApproveOrder = autoApproveOrder;
    }

    private String shipIfCaptureFails;

    @Basic
    @javax.persistence.Column(name = "SHIP_IF_CAPTURE_FAILS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getShipIfCaptureFails() {
        return shipIfCaptureFails;
    }

    public void setShipIfCaptureFails(String shipIfCaptureFails) {
        this.shipIfCaptureFails = shipIfCaptureFails;
    }

    private String setOwnerUponIssuance;

    @Basic
    @javax.persistence.Column(name = "SET_OWNER_UPON_ISSUANCE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getSetOwnerUponIssuance() {
        return setOwnerUponIssuance;
    }

    public void setSetOwnerUponIssuance(String setOwnerUponIssuance) {
        this.setOwnerUponIssuance = setOwnerUponIssuance;
    }

    private String reqReturnInventoryReceive;

    @Basic
    @javax.persistence.Column(name = "REQ_RETURN_INVENTORY_RECEIVE", nullable = true, insertable = true, updatable = true, length = 1)
    public String getReqReturnInventoryReceive() {
        return reqReturnInventoryReceive;
    }

    public void setReqReturnInventoryReceive(String reqReturnInventoryReceive) {
        this.reqReturnInventoryReceive = reqReturnInventoryReceive;
    }

    private String addToCartRemoveIncompat;

    @Basic
    @javax.persistence.Column(name = "ADD_TO_CART_REMOVE_INCOMPAT", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAddToCartRemoveIncompat() {
        return addToCartRemoveIncompat;
    }

    public void setAddToCartRemoveIncompat(String addToCartRemoveIncompat) {
        this.addToCartRemoveIncompat = addToCartRemoveIncompat;
    }

    private String addToCartReplaceUpsell;

    @Basic
    @javax.persistence.Column(name = "ADD_TO_CART_REPLACE_UPSELL", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAddToCartReplaceUpsell() {
        return addToCartReplaceUpsell;
    }

    public void setAddToCartReplaceUpsell(String addToCartReplaceUpsell) {
        this.addToCartReplaceUpsell = addToCartReplaceUpsell;
    }

    private String splitPayPrefPerShpGrp;

    @Basic
    @javax.persistence.Column(name = "SPLIT_PAY_PREF_PER_SHP_GRP", nullable = true, insertable = true, updatable = true, length = 1)
    public String getSplitPayPrefPerShpGrp() {
        return splitPayPrefPerShpGrp;
    }

    public void setSplitPayPrefPerShpGrp(String splitPayPrefPerShpGrp) {
        this.splitPayPrefPerShpGrp = splitPayPrefPerShpGrp;
    }

    private String showOutOfStockProducts;

    @Basic
    @javax.persistence.Column(name = "SHOW_OUT_OF_STOCK_PRODUCTS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getShowOutOfStockProducts() {
        return showOutOfStockProducts;
    }

    public void setShowOutOfStockProducts(String showOutOfStockProducts) {
        this.showOutOfStockProducts = showOutOfStockProducts;
    }

    private String styleSheet;

    @Basic
    @javax.persistence.Column(name = "STYLE_SHEET", nullable = true, insertable = true, updatable = true, length = 255)
    public String getStyleSheet() {
        return styleSheet;
    }

    public void setStyleSheet(String styleSheet) {
        this.styleSheet = styleSheet;
    }

    private String headerLogo;

    @Basic
    @javax.persistence.Column(name = "HEADER_LOGO", nullable = true, insertable = true, updatable = true, length = 255)
    public String getHeaderLogo() {
        return headerLogo;
    }

    public void setHeaderLogo(String headerLogo) {
        this.headerLogo = headerLogo;
    }

    private String headerMiddleBackground;

    @Basic
    @javax.persistence.Column(name = "HEADER_MIDDLE_BACKGROUND", nullable = true, insertable = true, updatable = true, length = 255)
    public String getHeaderMiddleBackground() {
        return headerMiddleBackground;
    }

    public void setHeaderMiddleBackground(String headerMiddleBackground) {
        this.headerMiddleBackground = headerMiddleBackground;
    }

    private String headerRightBackground;

    @Basic
    @javax.persistence.Column(name = "HEADER_RIGHT_BACKGROUND", nullable = true, insertable = true, updatable = true, length = 255)
    public String getHeaderRightBackground() {
        return headerRightBackground;
    }

    public void setHeaderRightBackground(String headerRightBackground) {
        this.headerRightBackground = headerRightBackground;
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

    private String noShipOnDropShipGroups;

    @Basic
    @javax.persistence.Column(name = "NO_SHIP_ON_DROP_SHIP_GROUPS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getNoShipOnDropShipGroups() {
        return noShipOnDropShipGroups;
    }

    public void setNoShipOnDropShipGroups(String noShipOnDropShipGroups) {
        this.noShipOnDropShipGroups = noShipOnDropShipGroups;
    }

    private String allowDoNotShipOrders;

    @Basic
    @javax.persistence.Column(name = "ALLOW_DO_NOT_SHIP_ORDERS", nullable = true, insertable = true, updatable = true, length = 1)
    public String getAllowDoNotShipOrders() {
        return allowDoNotShipOrders;
    }

    public void setAllowDoNotShipOrders(String allowDoNotShipOrders) {
        this.allowDoNotShipOrders = allowDoNotShipOrders;
    }

    private String defaultShipMethodId;

    @Basic
    @javax.persistence.Column(name = "DEFAULT_SHIP_METHOD_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDefaultShipMethodId() {
        return defaultShipMethodId;
    }

    public void setDefaultShipMethodId(String defaultShipMethodId) {
        this.defaultShipMethodId = defaultShipMethodId;
    }

    private String defaultShipCarrierPartyId;

    @Basic
    @javax.persistence.Column(name = "DEFAULT_SHIP_CARRIER_PARTY_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDefaultShipCarrierPartyId() {
        return defaultShipCarrierPartyId;
    }

    public void setDefaultShipCarrierPartyId(String defaultShipCarrierPartyId) {
        this.defaultShipCarrierPartyId = defaultShipCarrierPartyId;
    }

    private String billToThirdPartyId;

    @Basic
    @javax.persistence.Column(name = "BILL_TO_THIRD_PARTY_ID", nullable = true, insertable = true, updatable = true, length = 20)
    public String getBillToThirdPartyId() {
        return billToThirdPartyId;
    }

    public void setBillToThirdPartyId(String billToThirdPartyId) {
        this.billToThirdPartyId = billToThirdPartyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductStore that = (ProductStore) o;

        if (addToCartRemoveIncompat != null ? !addToCartRemoveIncompat.equals(that.addToCartRemoveIncompat) : that.addToCartRemoveIncompat != null)
            return false;
        if (addToCartReplaceUpsell != null ? !addToCartReplaceUpsell.equals(that.addToCartReplaceUpsell) : that.addToCartReplaceUpsell != null)
            return false;
        if (allowDoNotShipOrders != null ? !allowDoNotShipOrders.equals(that.allowDoNotShipOrders) : that.allowDoNotShipOrders != null)
            return false;
        if (allowPassword != null ? !allowPassword.equals(that.allowPassword) : that.allowPassword != null)
            return false;
        if (authDeclinedMessage != null ? !authDeclinedMessage.equals(that.authDeclinedMessage) : that.authDeclinedMessage != null)
            return false;
        if (authErrorMessage != null ? !authErrorMessage.equals(that.authErrorMessage) : that.authErrorMessage != null)
            return false;
        if (authFraudMessage != null ? !authFraudMessage.equals(that.authFraudMessage) : that.authFraudMessage != null)
            return false;
        if (autoApproveInvoice != null ? !autoApproveInvoice.equals(that.autoApproveInvoice) : that.autoApproveInvoice != null)
            return false;
        if (autoApproveOrder != null ? !autoApproveOrder.equals(that.autoApproveOrder) : that.autoApproveOrder != null)
            return false;
        if (autoApproveReviews != null ? !autoApproveReviews.equals(that.autoApproveReviews) : that.autoApproveReviews != null)
            return false;
        if (autoInvoiceDigitalItems != null ? !autoInvoiceDigitalItems.equals(that.autoInvoiceDigitalItems) : that.autoInvoiceDigitalItems != null)
            return false;
        if (autoOrderCcTryExp != null ? !autoOrderCcTryExp.equals(that.autoOrderCcTryExp) : that.autoOrderCcTryExp != null)
            return false;
        if (autoOrderCcTryLaterMax != null ? !autoOrderCcTryLaterMax.equals(that.autoOrderCcTryLaterMax) : that.autoOrderCcTryLaterMax != null)
            return false;
        if (autoOrderCcTryLaterNsf != null ? !autoOrderCcTryLaterNsf.equals(that.autoOrderCcTryLaterNsf) : that.autoOrderCcTryLaterNsf != null)
            return false;
        if (autoOrderCcTryOtherCards != null ? !autoOrderCcTryOtherCards.equals(that.autoOrderCcTryOtherCards) : that.autoOrderCcTryOtherCards != null)
            return false;
        if (autoSaveCart != null ? !autoSaveCart.equals(that.autoSaveCart) : that.autoSaveCart != null) return false;
        if (balanceResOnOrderCreation != null ? !balanceResOnOrderCreation.equals(that.balanceResOnOrderCreation) : that.balanceResOnOrderCreation != null)
            return false;
        if (billToThirdPartyId != null ? !billToThirdPartyId.equals(that.billToThirdPartyId) : that.billToThirdPartyId != null)
            return false;
        if (checkGcBalance != null ? !checkGcBalance.equals(that.checkGcBalance) : that.checkGcBalance != null)
            return false;
        if (checkInventory != null ? !checkInventory.equals(that.checkInventory) : that.checkInventory != null)
            return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (createdStamp != null ? !createdStamp.equals(that.createdStamp) : that.createdStamp != null) return false;
        if (createdTxStamp != null ? !createdTxStamp.equals(that.createdTxStamp) : that.createdTxStamp != null)
            return false;
        if (daysToCancelNonPay != null ? !daysToCancelNonPay.equals(that.daysToCancelNonPay) : that.daysToCancelNonPay != null)
            return false;
        if (defaultCurrencyUomId != null ? !defaultCurrencyUomId.equals(that.defaultCurrencyUomId) : that.defaultCurrencyUomId != null)
            return false;
        if (defaultLocaleString != null ? !defaultLocaleString.equals(that.defaultLocaleString) : that.defaultLocaleString != null)
            return false;
        if (defaultPassword != null ? !defaultPassword.equals(that.defaultPassword) : that.defaultPassword != null)
            return false;
        if (defaultSalesChannelEnumId != null ? !defaultSalesChannelEnumId.equals(that.defaultSalesChannelEnumId) : that.defaultSalesChannelEnumId != null)
            return false;
        if (defaultShipCarrierPartyId != null ? !defaultShipCarrierPartyId.equals(that.defaultShipCarrierPartyId) : that.defaultShipCarrierPartyId != null)
            return false;
        if (defaultShipMethodId != null ? !defaultShipMethodId.equals(that.defaultShipMethodId) : that.defaultShipMethodId != null)
            return false;
        if (digProdUploadCategoryId != null ? !digProdUploadCategoryId.equals(that.digProdUploadCategoryId) : that.digProdUploadCategoryId != null)
            return false;
        if (digitalItemApprovedStatus != null ? !digitalItemApprovedStatus.equals(that.digitalItemApprovedStatus) : that.digitalItemApprovedStatus != null)
            return false;
        if (enableAutoSuggestionList != null ? !enableAutoSuggestionList.equals(that.enableAutoSuggestionList) : that.enableAutoSuggestionList != null)
            return false;
        if (enableDigProdUpload != null ? !enableDigProdUpload.equals(that.enableDigProdUpload) : that.enableDigProdUpload != null)
            return false;
        if (explodeOrderItems != null ? !explodeOrderItems.equals(that.explodeOrderItems) : that.explodeOrderItems != null)
            return false;
        if (headerApprovedStatus != null ? !headerApprovedStatus.equals(that.headerApprovedStatus) : that.headerApprovedStatus != null)
            return false;
        if (headerCancelStatus != null ? !headerCancelStatus.equals(that.headerCancelStatus) : that.headerCancelStatus != null)
            return false;
        if (headerDeclinedStatus != null ? !headerDeclinedStatus.equals(that.headerDeclinedStatus) : that.headerDeclinedStatus != null)
            return false;
        if (headerLogo != null ? !headerLogo.equals(that.headerLogo) : that.headerLogo != null) return false;
        if (headerMiddleBackground != null ? !headerMiddleBackground.equals(that.headerMiddleBackground) : that.headerMiddleBackground != null)
            return false;
        if (headerRightBackground != null ? !headerRightBackground.equals(that.headerRightBackground) : that.headerRightBackground != null)
            return false;
        if (inventoryFacilityId != null ? !inventoryFacilityId.equals(that.inventoryFacilityId) : that.inventoryFacilityId != null)
            return false;
        if (isDemoStore != null ? !isDemoStore.equals(that.isDemoStore) : that.isDemoStore != null) return false;
        if (isImmediatelyFulfilled != null ? !isImmediatelyFulfilled.equals(that.isImmediatelyFulfilled) : that.isImmediatelyFulfilled != null)
            return false;
        if (itemApprovedStatus != null ? !itemApprovedStatus.equals(that.itemApprovedStatus) : that.itemApprovedStatus != null)
            return false;
        if (itemCancelStatus != null ? !itemCancelStatus.equals(that.itemCancelStatus) : that.itemCancelStatus != null)
            return false;
        if (itemDeclinedStatus != null ? !itemDeclinedStatus.equals(that.itemDeclinedStatus) : that.itemDeclinedStatus != null)
            return false;
        if (lastUpdatedStamp != null ? !lastUpdatedStamp.equals(that.lastUpdatedStamp) : that.lastUpdatedStamp != null)
            return false;
        if (lastUpdatedTxStamp != null ? !lastUpdatedTxStamp.equals(that.lastUpdatedTxStamp) : that.lastUpdatedTxStamp != null)
            return false;
        if (manualAuthIsCapture != null ? !manualAuthIsCapture.equals(that.manualAuthIsCapture) : that.manualAuthIsCapture != null)
            return false;
        if (noShipOnDropShipGroups != null ? !noShipOnDropShipGroups.equals(that.noShipOnDropShipGroups) : that.noShipOnDropShipGroups != null)
            return false;
        if (oneInventoryFacility != null ? !oneInventoryFacility.equals(that.oneInventoryFacility) : that.oneInventoryFacility != null)
            return false;
        if (orderNumberPrefix != null ? !orderNumberPrefix.equals(that.orderNumberPrefix) : that.orderNumberPrefix != null)
            return false;
        if (payToPartyId != null ? !payToPartyId.equals(that.payToPartyId) : that.payToPartyId != null) return false;
        if (primaryStoreGroupId != null ? !primaryStoreGroupId.equals(that.primaryStoreGroupId) : that.primaryStoreGroupId != null)
            return false;
        if (prodSearchExcludeVariants != null ? !prodSearchExcludeVariants.equals(that.prodSearchExcludeVariants) : that.prodSearchExcludeVariants != null)
            return false;
        if (productStoreId != null ? !productStoreId.equals(that.productStoreId) : that.productStoreId != null)
            return false;
        if (prorateShipping != null ? !prorateShipping.equals(that.prorateShipping) : that.prorateShipping != null)
            return false;
        if (prorateTaxes != null ? !prorateTaxes.equals(that.prorateTaxes) : that.prorateTaxes != null) return false;
        if (reqReturnInventoryReceive != null ? !reqReturnInventoryReceive.equals(that.reqReturnInventoryReceive) : that.reqReturnInventoryReceive != null)
            return false;
        if (reqShipAddrForDigItems != null ? !reqShipAddrForDigItems.equals(that.reqShipAddrForDigItems) : that.reqShipAddrForDigItems != null)
            return false;
        if (requireCustomerRole != null ? !requireCustomerRole.equals(that.requireCustomerRole) : that.requireCustomerRole != null)
            return false;
        if (requireInventory != null ? !requireInventory.equals(that.requireInventory) : that.requireInventory != null)
            return false;
        if (requirementMethodEnumId != null ? !requirementMethodEnumId.equals(that.requirementMethodEnumId) : that.requirementMethodEnumId != null)
            return false;
        if (reserveInventory != null ? !reserveInventory.equals(that.reserveInventory) : that.reserveInventory != null)
            return false;
        if (reserveOrderEnumId != null ? !reserveOrderEnumId.equals(that.reserveOrderEnumId) : that.reserveOrderEnumId != null)
            return false;
        if (retryFailedAuths != null ? !retryFailedAuths.equals(that.retryFailedAuths) : that.retryFailedAuths != null)
            return false;
        if (selectPaymentTypePerItem != null ? !selectPaymentTypePerItem.equals(that.selectPaymentTypePerItem) : that.selectPaymentTypePerItem != null)
            return false;
        if (setOwnerUponIssuance != null ? !setOwnerUponIssuance.equals(that.setOwnerUponIssuance) : that.setOwnerUponIssuance != null)
            return false;
        if (shipIfCaptureFails != null ? !shipIfCaptureFails.equals(that.shipIfCaptureFails) : that.shipIfCaptureFails != null)
            return false;
        if (showCheckoutGiftOptions != null ? !showCheckoutGiftOptions.equals(that.showCheckoutGiftOptions) : that.showCheckoutGiftOptions != null)
            return false;
        if (showOutOfStockProducts != null ? !showOutOfStockProducts.equals(that.showOutOfStockProducts) : that.showOutOfStockProducts != null)
            return false;
        if (showPricesWithVatTax != null ? !showPricesWithVatTax.equals(that.showPricesWithVatTax) : that.showPricesWithVatTax != null)
            return false;
        if (showTaxIsExempt != null ? !showTaxIsExempt.equals(that.showTaxIsExempt) : that.showTaxIsExempt != null)
            return false;
        if (splitPayPrefPerShpGrp != null ? !splitPayPrefPerShpGrp.equals(that.splitPayPrefPerShpGrp) : that.splitPayPrefPerShpGrp != null)
            return false;
        if (storeCreditAccountEnumId != null ? !storeCreditAccountEnumId.equals(that.storeCreditAccountEnumId) : that.storeCreditAccountEnumId != null)
            return false;
        if (storeCreditValidDays != null ? !storeCreditValidDays.equals(that.storeCreditValidDays) : that.storeCreditValidDays != null)
            return false;
        if (storeName != null ? !storeName.equals(that.storeName) : that.storeName != null) return false;
        if (styleSheet != null ? !styleSheet.equals(that.styleSheet) : that.styleSheet != null) return false;
        if (subtitle != null ? !subtitle.equals(that.subtitle) : that.subtitle != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (usePrimaryEmailUsername != null ? !usePrimaryEmailUsername.equals(that.usePrimaryEmailUsername) : that.usePrimaryEmailUsername != null)
            return false;
        if (vatTaxAuthGeoId != null ? !vatTaxAuthGeoId.equals(that.vatTaxAuthGeoId) : that.vatTaxAuthGeoId != null)
            return false;
        if (vatTaxAuthPartyId != null ? !vatTaxAuthPartyId.equals(that.vatTaxAuthPartyId) : that.vatTaxAuthPartyId != null)
            return false;
        if (viewCartOnAdd != null ? !viewCartOnAdd.equals(that.viewCartOnAdd) : that.viewCartOnAdd != null)
            return false;
        if (visualThemeId != null ? !visualThemeId.equals(that.visualThemeId) : that.visualThemeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productStoreId != null ? productStoreId.hashCode() : 0;
        result = 31 * result + (primaryStoreGroupId != null ? primaryStoreGroupId.hashCode() : 0);
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
        result = 31 * result + (payToPartyId != null ? payToPartyId.hashCode() : 0);
        result = 31 * result + (daysToCancelNonPay != null ? daysToCancelNonPay.hashCode() : 0);
        result = 31 * result + (manualAuthIsCapture != null ? manualAuthIsCapture.hashCode() : 0);
        result = 31 * result + (prorateShipping != null ? prorateShipping.hashCode() : 0);
        result = 31 * result + (prorateTaxes != null ? prorateTaxes.hashCode() : 0);
        result = 31 * result + (viewCartOnAdd != null ? viewCartOnAdd.hashCode() : 0);
        result = 31 * result + (autoSaveCart != null ? autoSaveCart.hashCode() : 0);
        result = 31 * result + (autoApproveReviews != null ? autoApproveReviews.hashCode() : 0);
        result = 31 * result + (isDemoStore != null ? isDemoStore.hashCode() : 0);
        result = 31 * result + (isImmediatelyFulfilled != null ? isImmediatelyFulfilled.hashCode() : 0);
        result = 31 * result + (inventoryFacilityId != null ? inventoryFacilityId.hashCode() : 0);
        result = 31 * result + (oneInventoryFacility != null ? oneInventoryFacility.hashCode() : 0);
        result = 31 * result + (checkInventory != null ? checkInventory.hashCode() : 0);
        result = 31 * result + (reserveInventory != null ? reserveInventory.hashCode() : 0);
        result = 31 * result + (reserveOrderEnumId != null ? reserveOrderEnumId.hashCode() : 0);
        result = 31 * result + (requireInventory != null ? requireInventory.hashCode() : 0);
        result = 31 * result + (balanceResOnOrderCreation != null ? balanceResOnOrderCreation.hashCode() : 0);
        result = 31 * result + (requirementMethodEnumId != null ? requirementMethodEnumId.hashCode() : 0);
        result = 31 * result + (orderNumberPrefix != null ? orderNumberPrefix.hashCode() : 0);
        result = 31 * result + (defaultLocaleString != null ? defaultLocaleString.hashCode() : 0);
        result = 31 * result + (defaultCurrencyUomId != null ? defaultCurrencyUomId.hashCode() : 0);
        result = 31 * result + (defaultSalesChannelEnumId != null ? defaultSalesChannelEnumId.hashCode() : 0);
        result = 31 * result + (allowPassword != null ? allowPassword.hashCode() : 0);
        result = 31 * result + (defaultPassword != null ? defaultPassword.hashCode() : 0);
        result = 31 * result + (explodeOrderItems != null ? explodeOrderItems.hashCode() : 0);
        result = 31 * result + (checkGcBalance != null ? checkGcBalance.hashCode() : 0);
        result = 31 * result + (retryFailedAuths != null ? retryFailedAuths.hashCode() : 0);
        result = 31 * result + (headerApprovedStatus != null ? headerApprovedStatus.hashCode() : 0);
        result = 31 * result + (itemApprovedStatus != null ? itemApprovedStatus.hashCode() : 0);
        result = 31 * result + (digitalItemApprovedStatus != null ? digitalItemApprovedStatus.hashCode() : 0);
        result = 31 * result + (headerDeclinedStatus != null ? headerDeclinedStatus.hashCode() : 0);
        result = 31 * result + (itemDeclinedStatus != null ? itemDeclinedStatus.hashCode() : 0);
        result = 31 * result + (headerCancelStatus != null ? headerCancelStatus.hashCode() : 0);
        result = 31 * result + (itemCancelStatus != null ? itemCancelStatus.hashCode() : 0);
        result = 31 * result + (authDeclinedMessage != null ? authDeclinedMessage.hashCode() : 0);
        result = 31 * result + (authFraudMessage != null ? authFraudMessage.hashCode() : 0);
        result = 31 * result + (authErrorMessage != null ? authErrorMessage.hashCode() : 0);
        result = 31 * result + (visualThemeId != null ? visualThemeId.hashCode() : 0);
        result = 31 * result + (storeCreditAccountEnumId != null ? storeCreditAccountEnumId.hashCode() : 0);
        result = 31 * result + (usePrimaryEmailUsername != null ? usePrimaryEmailUsername.hashCode() : 0);
        result = 31 * result + (requireCustomerRole != null ? requireCustomerRole.hashCode() : 0);
        result = 31 * result + (autoInvoiceDigitalItems != null ? autoInvoiceDigitalItems.hashCode() : 0);
        result = 31 * result + (reqShipAddrForDigItems != null ? reqShipAddrForDigItems.hashCode() : 0);
        result = 31 * result + (showCheckoutGiftOptions != null ? showCheckoutGiftOptions.hashCode() : 0);
        result = 31 * result + (selectPaymentTypePerItem != null ? selectPaymentTypePerItem.hashCode() : 0);
        result = 31 * result + (showPricesWithVatTax != null ? showPricesWithVatTax.hashCode() : 0);
        result = 31 * result + (showTaxIsExempt != null ? showTaxIsExempt.hashCode() : 0);
        result = 31 * result + (vatTaxAuthGeoId != null ? vatTaxAuthGeoId.hashCode() : 0);
        result = 31 * result + (vatTaxAuthPartyId != null ? vatTaxAuthPartyId.hashCode() : 0);
        result = 31 * result + (enableAutoSuggestionList != null ? enableAutoSuggestionList.hashCode() : 0);
        result = 31 * result + (enableDigProdUpload != null ? enableDigProdUpload.hashCode() : 0);
        result = 31 * result + (prodSearchExcludeVariants != null ? prodSearchExcludeVariants.hashCode() : 0);
        result = 31 * result + (digProdUploadCategoryId != null ? digProdUploadCategoryId.hashCode() : 0);
        result = 31 * result + (autoOrderCcTryExp != null ? autoOrderCcTryExp.hashCode() : 0);
        result = 31 * result + (autoOrderCcTryOtherCards != null ? autoOrderCcTryOtherCards.hashCode() : 0);
        result = 31 * result + (autoOrderCcTryLaterNsf != null ? autoOrderCcTryLaterNsf.hashCode() : 0);
        result = 31 * result + (autoOrderCcTryLaterMax != null ? autoOrderCcTryLaterMax.hashCode() : 0);
        result = 31 * result + (storeCreditValidDays != null ? storeCreditValidDays.hashCode() : 0);
        result = 31 * result + (autoApproveInvoice != null ? autoApproveInvoice.hashCode() : 0);
        result = 31 * result + (autoApproveOrder != null ? autoApproveOrder.hashCode() : 0);
        result = 31 * result + (shipIfCaptureFails != null ? shipIfCaptureFails.hashCode() : 0);
        result = 31 * result + (setOwnerUponIssuance != null ? setOwnerUponIssuance.hashCode() : 0);
        result = 31 * result + (reqReturnInventoryReceive != null ? reqReturnInventoryReceive.hashCode() : 0);
        result = 31 * result + (addToCartRemoveIncompat != null ? addToCartRemoveIncompat.hashCode() : 0);
        result = 31 * result + (addToCartReplaceUpsell != null ? addToCartReplaceUpsell.hashCode() : 0);
        result = 31 * result + (splitPayPrefPerShpGrp != null ? splitPayPrefPerShpGrp.hashCode() : 0);
        result = 31 * result + (showOutOfStockProducts != null ? showOutOfStockProducts.hashCode() : 0);
        result = 31 * result + (styleSheet != null ? styleSheet.hashCode() : 0);
        result = 31 * result + (headerLogo != null ? headerLogo.hashCode() : 0);
        result = 31 * result + (headerMiddleBackground != null ? headerMiddleBackground.hashCode() : 0);
        result = 31 * result + (headerRightBackground != null ? headerRightBackground.hashCode() : 0);
        result = 31 * result + (lastUpdatedStamp != null ? lastUpdatedStamp.hashCode() : 0);
        result = 31 * result + (lastUpdatedTxStamp != null ? lastUpdatedTxStamp.hashCode() : 0);
        result = 31 * result + (createdStamp != null ? createdStamp.hashCode() : 0);
        result = 31 * result + (createdTxStamp != null ? createdTxStamp.hashCode() : 0);
        result = 31 * result + (noShipOnDropShipGroups != null ? noShipOnDropShipGroups.hashCode() : 0);
        result = 31 * result + (allowDoNotShipOrders != null ? allowDoNotShipOrders.hashCode() : 0);
        result = 31 * result + (defaultShipMethodId != null ? defaultShipMethodId.hashCode() : 0);
        result = 31 * result + (defaultShipCarrierPartyId != null ? defaultShipCarrierPartyId.hashCode() : 0);
        result = 31 * result + (billToThirdPartyId != null ? billToThirdPartyId.hashCode() : 0);
        return result;
    }
}
