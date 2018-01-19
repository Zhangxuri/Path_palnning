package com.heitian.ssm.model;


public class ProductList {

  private Long id;
  private String address;
  private Long product;
  private String sendname;
  private Long sendtel;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public Long getProduct() {
    return product;
  }

  public void setProduct(Long product) {
    this.product = product;
  }


  public String getSendname() {
    return sendname;
  }

  public void setSendname(String sendname) {
    this.sendname = sendname;
  }


  public Long getSendtel() {
    return sendtel;
  }

  public void setSendtel(Long sendtel) {
    this.sendtel = sendtel;
  }

}
