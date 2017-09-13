package com.ttn.model.dao;

import com.ttn.beans.ReadingItem;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ankur on 7/21/2017.
 */
@Component
public interface ShowPostOnUserProfilePageDao {
    List<ReadingItem> getResources(String username, int firstresultindex);

}
