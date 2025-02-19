package org.sanketika.springbootdataset.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sanketika.springbootdataset.Entity.Dataset;
import org.sanketika.springbootdataset.Entity.Status;
import org.sanketika.springbootdataset.Reposistory.DatasetRepo;
import org.sanketika.springbootdataset.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/dataset")
public class DatasetController {

    @Autowired
    private DatasetRepo datasetRepo;


    @GetMapping("/getall")
    public List<Dataset> getAllDataset() {
        List<Dataset> DatasetList = datasetRepo.findAll();
        return DatasetList;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getDataset(@PathVariable String id) {
        try {
            if (datasetRepo.findById(id).isPresent()) {
                return ResponseEntity.ok(datasetRepo.findById(id).get());
            } else {
                return ResponseEntity.badRequest().body("Requested data does not exist");
            }
        } catch (Exception e) {
            return status(HttpStatus.INTERNAL_SERVER_ERROR).body("An erroroccured" + e.getMessage());
        }

    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createDataset(@RequestBody Dataset dataset) {
        if (dataset.getId() == null || dataset.getId().isEmpty()) {
            return ResponseEntity.badRequest().body(new ApiResponse("Error: primary key is required",HttpStatus.BAD_REQUEST.value()));
        }

        try {
            Dataset savedDataset = datasetRepo.save(dataset);
            return ResponseEntity.ok(new ApiResponse("Dataset saved successfully with ID: " + savedDataset.getId(),HttpStatus.OK.value()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Error while saving dataset: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }
}





