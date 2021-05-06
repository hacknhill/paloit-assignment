package com.example.ecommerce.model;

import com.example.ecommerce.model.helper.NRICGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * This is the order entity for the ecommerce application.
 */
@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {

    @Id
    @JsonProperty("Order ID")
    private long orderId;
    @JsonProperty("NRIC")
    private String nric;
    @JsonProperty("Region")
    private String region;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Item Type")
    private String itemType;
    @JsonProperty("Sales Channel")
    private String salesChannel;
    @JsonProperty("Order Priority")
    private String orderPriority;
    @JsonProperty("Order Date")
    @JsonFormat(pattern = "M/d/yyyy")
    private LocalDate orderDate;
    @JsonProperty("Ship Date")
    @JsonFormat(pattern = "M/d/yyyy")
    private LocalDate shipDate;
    @JsonProperty("Units Sold")
    private int unitsSold;
    @JsonProperty("Unit Price")
    private double unitPrice;
    @JsonProperty("Unit Cost")
    private double unitCost;
    @JsonProperty("Total Revenue")
    private double totalRevenue;
    @JsonProperty("Total Cost")
    private double totalCost;
    @JsonProperty("Total Profit")
    private double totalProfit;

    @PrePersist
    void preInsert() {
        if (this.nric == null) {
            this.nric = NRICGenerator.getRandomNRIC();
        }
    }
}