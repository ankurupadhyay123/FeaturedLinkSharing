package com.ttn.controller;

import com.ttn.model.service.ServiceInterface.RescentShareOnHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 7/15/2017.
 */
@Controller

public class LogoutController {
    @Autowired
    RescentShareOnHomePageService rescentShareOnHomePageService;
    private HttpSession session;

    @RequestMapping(value = "/logout")
    public ModelAndView logOut(HttpServletRequest request){
        session = request.getSession();
        session.invalidate();
/*
        view = new ModelAndView();
        Map<String,Object> userModel = new HashMap<>();
        String errorMessage = "You are successfully logged out";
        userModel.put("recentResourceList",resourceService.getRecentResources());
        userModel.put("logoutMessage",errorMessage);
        view = new ModelAndView("welcome",userModel);
*/
        ModelAndView view= new ModelAndView("welcome");
        view.addObject("recentresources",rescentShareOnHomePageService.getResources());
        view.addObject("message","You are logged out successfully");
        return view;
    }
}
