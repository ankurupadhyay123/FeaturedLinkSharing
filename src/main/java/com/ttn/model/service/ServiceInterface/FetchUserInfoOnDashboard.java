package com.ttn.model.service.ServiceInterface;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ankur on 7/16/2017.
 */
@Service
public interface FetchUserInfoOnDashboard {
    List<?> userInfoService(int id);
}
