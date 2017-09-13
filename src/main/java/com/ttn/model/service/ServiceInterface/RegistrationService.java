package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.User;
import org.springframework.stereotype.Service;

/**
 * Created by ankur on 7/15/2017.
 */
@Service
public interface RegistrationService {
    User register(User user);
}
