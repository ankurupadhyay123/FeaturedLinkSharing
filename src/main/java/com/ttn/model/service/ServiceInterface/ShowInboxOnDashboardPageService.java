package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ankur on 7/13/2017.
 */
@Service
public interface ShowInboxOnDashboardPageService {
    String getResources(String username, int firstresultindex);

}
