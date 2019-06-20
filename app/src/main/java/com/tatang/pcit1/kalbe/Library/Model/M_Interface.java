package com.tatang.pcit1.kalbe.Library.Model;

public class M_Interface {

    String intBrandID;
    String txtBrandName;
    String dtInserted;
    String intProductID;
    String txtProductCode;
    String txtProductName;
    String intCustomerID;
    String txtCustomerName;
    String txtCustomerAddress;
    String bitGender;
    String intSalesOrderID;
    String dtSalesOrder;
    String intQty;

    public M_Interface(){}

    public M_Interface(String intBrandID, String txtBrandName, String dtInserted, String intProductID, String txtProductCode, String txtProductName, String intCustomerID, String txtCustomerName, String txtCustomerAddress, String bitGender, String intSalesOrderID, String dtSalesOrder, String intQty) {
        this.intBrandID = intBrandID;
        this.txtBrandName = txtBrandName;
        this.dtInserted = dtInserted;
        this.intProductID = intProductID;
        this.txtProductCode = txtProductCode;
        this.txtProductName = txtProductName;
        this.intCustomerID = intCustomerID;
        this.txtCustomerName = txtCustomerName;
        this.txtCustomerAddress = txtCustomerAddress;
        this.bitGender = bitGender;
        this.intSalesOrderID = intSalesOrderID;
        this.dtSalesOrder = dtSalesOrder;
        this.intQty = intQty;
    }

    public String getIntBrandID() {
        return intBrandID;
    }

    public void setIntBrandID(String intBrandID) {
        this.intBrandID = intBrandID;
    }

    public String getTxtBrandName() {
        return txtBrandName;
    }

    public void setTxtBrandName(String txtBrandName) {
        this.txtBrandName = txtBrandName;
    }

    public String getDtInserted() {
        return dtInserted;
    }

    public void setDtInserted(String dtInserted) {
        this.dtInserted = dtInserted;
    }

    public String getIntProductID() {
        return intProductID;
    }

    public void setIntProductID(String intProductID) {
        this.intProductID = intProductID;
    }

    public String getTxtProductCode() {
        return txtProductCode;
    }

    public void setTxtProductCode(String txtProductCode) {
        this.txtProductCode = txtProductCode;
    }

    public String getTxtProductName() {
        return txtProductName;
    }

    public void setTxtProductName(String txtProductName) {
        this.txtProductName = txtProductName;
    }

    public String getIntCustomerID() {
        return intCustomerID;
    }

    public void setIntCustomerID(String intCustomerID) {
        this.intCustomerID = intCustomerID;
    }

    public String getTxtCustomerName() {
        return txtCustomerName;
    }

    public void setTxtCustomerName(String txtCustomerName) {
        this.txtCustomerName = txtCustomerName;
    }

    public String getTxtCustomerAddress() {
        return txtCustomerAddress;
    }

    public void setTxtCustomerAddress(String txtCustomerAddress) {
        this.txtCustomerAddress = txtCustomerAddress;
    }

    public String getBitGender() {
        return bitGender;
    }

    public void setBitGender(String bitGender) {
        this.bitGender = bitGender;
    }

    public String getIntSalesOrderID() {
        return intSalesOrderID;
    }

    public void setIntSalesOrderID(String intSalesOrderID) {
        this.intSalesOrderID = intSalesOrderID;
    }

    public String getDtSalesOrder() {
        return dtSalesOrder;
    }

    public void setDtSalesOrder(String dtSalesOrder) {
        this.dtSalesOrder = dtSalesOrder;
    }

    public String getIntQty() {
        return intQty;
    }

    public void setIntQty(String intQty) {
        this.intQty = intQty;
    }



}
