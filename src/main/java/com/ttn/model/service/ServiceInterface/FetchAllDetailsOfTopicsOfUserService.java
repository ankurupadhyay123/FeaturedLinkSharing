package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

/**
 * Created by ankur on 7/21/2017.
 */
@Service
public interface FetchAllDetailsOfTopicsOfUserService {
String getTopicsOfuser(String userName,String currentUserName,int firstresultindex);
Long  getSubscriptionCount(int topicId);
Long getPostCount(int topicId);
}
