package org.sanketika.springbootdataset.Entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name="datasets1")
@Data
public class Dataset {
     @Id
     private String id;

     @JdbcTypeCode(SqlTypes.JSON)
     @Column(columnDefinition = "jsonb") // Store as text (PostgreSQL handles it as JSON if queried properly)
     private Map<String,Object> dataSchema;
     @JdbcTypeCode(SqlTypes.JSON)
     @Column(columnDefinition = "jsonb")
     private Map<String,Object> routeConfig;

     @Enumerated(EnumType.STRING)
     @Column(name="status")
     private Status status;

     @Column(name="createdBy" ,nullable = false)
     private String createdBy;

     @Column(name="updatedBy",nullable = false)
     private String updatedBy;

     @CreationTimestamp
     private LocalDateTime createdDate;

     @UpdateTimestamp
     private LocalDateTime updatedDate;

     public Dataset(String id, Map<String,Object> dataSchema, Map<String,Object> routeConfig, Status status, String createdBy, String updatedBy) {
          this.id = id;
          this.dataSchema = dataSchema;
          this.routeConfig = routeConfig;
          this.status = status;
          this.createdBy = createdBy;
          this.updatedBy = updatedBy;
     }

     public Dataset() {
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public Map<String,Object> getDataSchema() {
          return dataSchema;
     }

     public void setDataSchema(Map<String,Object> dataSchema) {
          this.dataSchema = dataSchema;
     }

     public Map<String,Object> getRouteConfig() {
          return routeConfig;
     }

     public void setRouteConfig(Map<String,Object> routeConfig) {
          this.routeConfig = routeConfig;
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
