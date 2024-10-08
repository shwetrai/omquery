package com.ba.infy.omquery.omquery.api.service;

import com.ba.infy.omquery.omquery.api.model.OMQuery;

import java.util.List;

public interface OMQueryService {


    String createQuery( OMQuery omQuery);
    List<OMQuery> findQueryByCustomerName(String customerName);

    List<OMQuery> findQueryByStatus(String status);
//    List<PurchaseOrderTemp> findPOByCustomerNameAndStatus(String customerName, String status);

//    List<PurchaseOrderTemp> findPOByDate(Date todayDate, String status);

    List<OMQuery> findAll();

    public OMQuery findAndUpdateQueryByReqID (OMQuery omQuery);




}
