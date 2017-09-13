package com.ttn.model.service.ServiceInterface;

import com.ttn.beans.Resources;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ankur on 7/21/2017.
 */
@Service
public interface RescentShareOnHomePageService {
    List<Resources> getResources();
}
