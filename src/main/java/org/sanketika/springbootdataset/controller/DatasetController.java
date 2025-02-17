package org.sanketika.springbootdataset.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sanketika.springbootdataset.Entity.Dataset;
import org.sanketika.springbootdataset.Reposistory.DatasetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dataset")
public class DatasetController {

    @Autowired
    private DatasetRepo datasetRepo;
    @Autowired
    ObjectMapper objectMapper;
     @PostMapping("/create")
     public ResponseEntity createDataset(@RequestBody String dataset){
         try {
              Dataset datasets=objectMapper.readValue(dataset,Dataset.class);

             if (datasets.getId() == null || datasets.getId().isEmpty()) {
                 return ResponseEntity.badRequest().body("id is required");
             }
             if (datasets.getDataSchema() == null) {
                 return ResponseEntity.badRequest().body("dataschema is required");
             }
             if (datasets.getRouterConfig() == null) {
                 return ResponseEntity.badRequest().body("router config is required");
             }
             if (datasets.getStatus() == null  || datasets.getStatus().toString().isEmpty()) {
                 return ResponseEntity.badRequest().body("status is required");
             }
             datasets.setCreatedDate(LocalDateTime.now());
             datasets.setUpdatedDate(LocalDateTime.now());
             datasetRepo.save(datasets);
             Map res = new HashMap();
             res.put("message","created");
             return ResponseEntity.status(HttpStatus.CREATED).body(res);

         }
         catch (Exception e){
             System.out.print(toString());
             return ResponseEntity.internalServerError().body("An Error is occured");
         }
     }


     @GetMapping("/getall")
    public List<Dataset> getAllDataset(){
         List<Dataset> DatasetList=datasetRepo.findAll();
         return DatasetList;
     }
     @GetMapping("/get/{id}")
    public ResponseEntity<Dataset>getDataset(@PathVariable Integer id){
         try{
             Dataset dataset=datasetRepo.findById(id).orElse(null);
             return ResponseEntity.ok(dataset);
         }catch (Exception e){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }
     }
}
