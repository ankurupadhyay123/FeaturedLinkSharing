package com.ttn.model.dao;

import org.springframework.stereotype.Component;

/**
 * Created by ankur on 7/15/2017.
 */
@Component
public interface FetchUserProfilePicDao {
    byte[] fetchUserProfilePic(String uname);
}
