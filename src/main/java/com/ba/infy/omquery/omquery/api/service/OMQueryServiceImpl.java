package com.ba.infy.omquery.omquery.api.service;

import com.ba.infy.omquery.omquery.api.model.OMQuery;
import com.ba.infy.omquery.omquery.api.repository.OMQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OMQueryServiceImpl implements OMQueryService {


    @Autowired
    MongoTemplate mongoTemplate;

   @Autowired
   private OMQueryRepository omQueryRepository;

    @Override
    public String createQuery(OMQuery omQuery) {

        try {
            omQueryRepository.insert(omQuery);

        } catch (Exception ex) {
            throw ex;
        }

        return "OM Query created";
    }

    /**
     * @param customerName
     * @return
     */
    @Override
    public List<OMQuery> findQueryByCustomerName(String customerName) {
        return omQueryRepository.findQueryByCustomerName(customerName);
    }

    /**
     * @param status
     * @return
     */
    @Override
    public List<OMQuery> findQueryByStatus(String status) {

    return omQueryRepository.findQueryByStatus(status);
    }

    /**
     * @param customerName
     * @param status
     * @return
     */
//    @Override
//    public List<OMQuery> findPOByCustomerNameAndStatus(String customerName, String status) {
//
//      return tempPORepository.findPOByCustomerNameAndStatus(customerName,status);
//
//    }

//    public List<PurchaseOrderTemp> findPOByDate(Date todayDate, String status){
//
//
//        return tempPORepository.findPOByDate(todayDate,status);
//    }

    /**
     * @return
     */
    @Override
    public List<OMQuery> findAll() {

        return omQueryRepository.findAll();

    }


    @Override
    public OMQuery findAndUpdateQueryByReqID (OMQuery omQuery){

        Query query = new Query().addCriteria(Criteria.where("_id").is(omQuery.getRequestID()));
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        Update updateDefinition = new Update().set("status",omQuery.getStatus());
        if(omQuery.getQuery() !=null || "".equalsIgnoreCase(omQuery.getQuery()))
            updateDefinition.set("query",omQuery.getQuery());
        if(omQuery.getResponseDate() !=null)
            updateDefinition.set("responseDate",omQuery.getResponseDate());

        return mongoTemplate.findAndModify(query,updateDefinition,options,OMQuery.class);
    }


}
