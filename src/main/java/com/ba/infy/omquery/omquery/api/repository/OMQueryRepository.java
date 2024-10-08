package com.ba.infy.omquery.omquery.api.repository;

import com.ba.infy.omquery.omquery.api.model.OMQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OMQueryRepository extends MongoRepository<OMQuery, String> {

    @Override
    Optional<OMQuery> findById(String id);

    @Query("{'customerName':?0}")
    List<OMQuery> findQueryByCustomerName(String customerName);

    @Query("{'status':?0}")
    List<OMQuery> findQueryByStatus(String status);

//    @Query("{'customerName':?0,'status':?1}")
//    List<PurchaseOrderTemp> findPOByCustomerNameAndStatus(String customerName, String status);

//    @Query("{'todayDate':?0,'status':?1}")
//    List<OMQuery> findPOByDate(Date todayDate, String status);

    @Override
    List<OMQuery> findAll();


    @Override
    void delete(OMQuery deleted);


}
