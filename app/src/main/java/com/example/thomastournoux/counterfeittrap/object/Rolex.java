package com.example.thomastournoux.counterfeittrap.object;

import com.google.gson.annotations.Expose;

public class Rolex {

    @Expose private String $class;
    @Expose private String rolexId;
    @Expose private String brand;
    @Expose private String serialNumber;
    @Expose private String visual;
    @Expose private String weight;
    @Expose private String weightUnity;
    @Expose private String secondHandSpecifications;
    @Expose private String materialsSpecifications;
    @Expose private String cyclopeanObjective;
    @Expose private String remontoireChangeDateAtSixHour;
    @Expose private String backTransparent;
    @Expose private String braceletMaterial;
    @Expose private String sealing;
    @Expose private String productDate;

    public Rolex() {

    }

    public Rolex(String $class, String rolexId, String brand, String serialNumber, String visual, String weight, String weightUnity, String secondHandSpecifications, String materialsSpecifications, String cyclopeanObjective, String remontoireChangeDateAtSixHour, String backTransparent, String braceletMaterial, String sealing, String productDate) {
        this.$class = $class;
        this.rolexId = rolexId;
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.visual = visual;
        this.weight = weight;
        this.weightUnity = weightUnity;
        this.secondHandSpecifications = secondHandSpecifications;
        this.materialsSpecifications = materialsSpecifications;
        this.cyclopeanObjective = cyclopeanObjective;
        this.remontoireChangeDateAtSixHour = remontoireChangeDateAtSixHour;
        this.backTransparent = backTransparent;
        this.braceletMaterial = braceletMaterial;
        this.sealing = sealing;
        this.productDate = productDate;
    }

    public String get$class() {
        return $class;
    }

    public void set$class(String $class) {
        this.$class = $class;
    }

    public String getRolexId() {
        return rolexId;
    }

    public void setRolexId(String rolexId) {
        this.rolexId = rolexId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getVisual() {
        return visual;
    }

    public void setVisual(String visual) {
        this.visual = visual;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightUnity() {
        return weightUnity;
    }

    public void setWeightUnity(String weightUnity) {
        this.weightUnity = weightUnity;
    }

    public String getSecondHandSpecifications() {
        return secondHandSpecifications;
    }

    public void setSecondHandSpecifications(String secondHandSpecifications) {
        this.secondHandSpecifications = secondHandSpecifications;
    }

    public String getMaterialsSpecifications() {
        return materialsSpecifications;
    }

    public void setMaterialsSpecifications(String materialsSpecifications) {
        this.materialsSpecifications = materialsSpecifications;
    }

    public String getCyclopeanObjective() {
        return cyclopeanObjective;
    }

    public void setCyclopeanObjective(String cyclopeanObjective) {
        this.cyclopeanObjective = cyclopeanObjective;
    }

    public String getRemontoireChangeDateAtSixHour() {
        return remontoireChangeDateAtSixHour;
    }

    public void setRemontoireChangeDateAtSixHour(String remontoireChangeDateAtSixHour) {
        this.remontoireChangeDateAtSixHour = remontoireChangeDateAtSixHour;
    }

    public String getBackTransparent() {
        return backTransparent;
    }

    public void setBackTransparent(String backTransparent) {
        this.backTransparent = backTransparent;
    }

    public String getBraceletMaterial() {
        return braceletMaterial;
    }

    public void setBraceletMaterial(String braceletMaterial) {
        this.braceletMaterial = braceletMaterial;
    }

    public String getSealing() {
        return sealing;
    }

    public void setSealing(String sealing) {
        this.sealing = sealing;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }
}
