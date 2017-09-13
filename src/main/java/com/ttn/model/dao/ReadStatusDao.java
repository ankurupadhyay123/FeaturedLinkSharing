package com.ttn.model.dao;

import org.springframework.stereotype.Component;

/**
 * Created by ankur on 7/16/2017.
 */

@Component
public interface ReadStatusDao {
    String updateReadStatus(int readitemid,int userid);
}
