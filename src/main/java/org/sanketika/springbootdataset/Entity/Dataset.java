package org.sanketika.springbootdataset.Entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="datasets")
public class Dataset {
     @Id
     private String id;

     @Column(columnDefinition = "json")
     private String dataSchema;

     @Column(columnDefinition = "json")
     private String routerConfig;

     @Enumerated(EnumType.STRING)
     @Column(name="status")
     private Status status;

     @Column(name="createdBy" ,nullable = false)
     private String createdBy;

     @Column(name="updatedBy",nullable = false)
     private String updatedBy;

     @CreationTimestamp //automatically sets when the row is created
     private LocalDateTime createdDate;

     @UpdateTimestamp // updates automatically when the row is modified
     private LocalDateTime updatedDate;

     public Dataset() {}
     public Dataset(String id ,String dataSchema,String routerConfig,Status status,String createdBy,String updatedBy){
          this.id = id;
          this.dataSchema=dataSchema;
          this.routerConfig=routerConfig;
          this.status=status;
          this.createdBy=createdBy;
          this.updatedBy=updatedBy;

     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getDataSchema() {
          return dataSchema;
     }

     public void setDataSchema(String dataSchema) {
          this.dataSchema = dataSchema;
     }

     public String getRouterConfig() {
          return routerConfig;
     }

     public void setRouterConfig(String routerConfig) {
          this.routerConfig = routerConfig;
     }

     public Status getStatus() {
          return status;
     }

     public void setStatus(Status status) {
          this.status = status;
     }

     public String getCreatedBy() {
          return createdBy;
     }

     public void setCreatedBy(String createdBy) {
          this.createdBy = createdBy;
     }

     public String getUpdatedBy() {
          return updatedBy;
     }

     public void setUpdatedBy(String updatedBy) {
          this.updatedBy = updatedBy;
     }

     public LocalDateTime getCreatedDate() {
          return createdDate;
     }

     public void setCreatedDate(LocalDateTime createdDate) {
          this.createdDate = createdDate;
     }

     public LocalDateTime getUpdatedDate() {
          return updatedDate;
     }

     public void setUpdatedDate(LocalDateTime updatedDate) {
          this.updatedDate = updatedDate;
     }
}



