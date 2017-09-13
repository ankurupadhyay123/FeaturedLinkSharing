package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

/**
 * Created by ankur on 7/21/2017.
 */
@Service
public interface ShowPostOnUserProfilePageService {
   String getResources(String username, int firstresultindex);

}
