package org.sanketika.springbootdataset.Reposistory;

import org.sanketika.springbootdataset.Entity.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasetRepo extends JpaRepository <Dataset ,String> {

}
