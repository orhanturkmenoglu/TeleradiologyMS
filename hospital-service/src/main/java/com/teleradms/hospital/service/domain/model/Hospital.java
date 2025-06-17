package com.teleradms.hospital.service.domain.model;

import com.teleradms.common.lib.base.BaseDomain;

public class Hospital extends BaseDomain {
    private String shortName;
    private String fullTitle;
    private String authorizedPerson;
    private String city;
    private String district;
    private String phone;
    private String email;
    private String address;
    private String taxNumber;
    private String taxOffice;
    private String website;
    private boolean isDeleted;
    private boolean isActive;

    public Hospital() {
        super();
    }

    public Hospital(String shortName, String fullTitle, String authorizedPerson, String city, String district,
                    String phone, String email, String address, String taxNumber, String taxOffice,
                    String website, boolean isDeleted, boolean isActive) {
        super();
        this.shortName = shortName;
        this.fullTitle = fullTitle;
        this.authorizedPerson = authorizedPerson;
        this.city = city;
        this.district = district;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.taxNumber = taxNumber;
        this.taxOffice = taxOffice;
        this.website = website;
        this.isDeleted = isDeleted;
        this.isActive = isActive;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void setAuthorizedPerson(String authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getTaxOffice() {
        return taxOffice;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
