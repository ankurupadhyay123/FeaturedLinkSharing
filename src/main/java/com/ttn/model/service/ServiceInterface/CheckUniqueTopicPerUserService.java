package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

/**
 * Created by ankur on 7/16/2017.
 */
@Service
public interface CheckUniqueTopicPerUserService {
    String checkAvailabilityOfTopic(String topicname,String username);
}
