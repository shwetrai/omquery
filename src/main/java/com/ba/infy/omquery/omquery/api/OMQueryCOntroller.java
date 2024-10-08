package com.ba.infy.omquery.omquery.api;

import com.ba.infy.omquery.omquery.api.model.OMQuery;
import com.ba.infy.omquery.omquery.api.model.OMQueryList;
import com.ba.infy.omquery.omquery.api.model.RespMessage;
import com.ba.infy.omquery.omquery.api.service.OMQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class OMQueryCOntroller {

    @Autowired
    RespMessage respMessage;

    @Autowired
    OMQueryServiceImpl omQueryServiceImpl;

    @Autowired
    OMQueryList omQueryList;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/omquery/create")
    public RespMessage createTempPO (@RequestBody OMQuery omQuery) {

        try{
            Date dt = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String rquestID= "OMQReq"+df.format(dt);
            omQuery.setRequestID(rquestID);
            omQuery.setRequestDate(dt);

            omQueryServiceImpl.createQuery(omQuery);
            respMessage.setRespMessage(" Request "+rquestID+" for query has been created");
        }catch (Exception ex){
            respMessage.setRespMessage(ex.getMessage());
        }
        return respMessage;
    }

    @GetMapping(value = "/omquery/status/{status}")
    public OMQueryList getOMQueryByStatus(@PathVariable ("status") String status){

        omQueryList.setInstances(omQueryServiceImpl.findQueryByStatus(status));

        return omQueryList;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/omquery/update")
    public RespMessage updateTempPO (@RequestBody OMQuery omQuery) {
        try{
            omQueryServiceImpl.findAndUpdateQueryByReqID(omQuery);
            respMessage.setRespMessage("OM Query updated");
        }catch (Exception ex){
            respMessage.setRespMessage(ex.getMessage());
        }
        return respMessage;
    }
}
