package com.ttn.model.dao;

import org.springframework.stereotype.Component;

/**
 * Created by ankur on 7/16/2017.
 */
@Component
public interface CheckUniqueTopicPerUserDao {
    boolean checkAvailability(String topicname,String username);
}
