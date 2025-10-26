package com.E_Commerce.RuhKart.entity;


import jakarta.persistence.*;

@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String publicId;
    private String url;

    public ProductImage(Long id, String url, String publicId) {
        this.id = id;
        this.url = url;
        this.publicId = publicId;
    }
    public ProductImage()
    {
        super();
    }
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImage(String url, Product product) {
        this.url = "/uploads"+url;
        this.publicId = url;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
