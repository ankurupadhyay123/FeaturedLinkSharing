package com.ttn.controller;

import com.ttn.beans.Susbcription;
import com.ttn.beans.Topic;
import com.ttn.model.dao.ShowGlobalTopicDao;
import com.ttn.model.service.ServiceInterface.*;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.Oneway;
import javax.mail.internet.ContentType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by ankur on 7/9/2017.
 */
@Controller
public class TopicController {

    @Autowired
    CreateTopicService createTopicService;
    @Autowired
    FindPublicTopicsService findPublicTopicsService;
    @Autowired
    ShowInboxOnDashboardPageService showInboxOnDashboardPageService;
    @Autowired
    CheckUniqueTopicPerUserService checkUniqueTopicPerUserService;
    @Autowired
    FetchSubscribedTopics fetchSubscribedTopics;
    @Autowired
    ServiceToUnsubscribe serviceToUnsubscribe;
    @Autowired
    ServiceToSubscribe serviceToSubscribe;
    @Autowired
    ShowGlobalTopicDao showGlobalTopicDao;
    @Autowired
    ChangeTopicNameService changeTopicNameService;
    @Autowired
    DeleteTopic deleteTopic;
    static String topicname;

    @RequestMapping(value = "/createtopic", method = RequestMethod.POST)
    public @ResponseBody
    String creatTopic(@ModelAttribute Topic topic, HttpSession session) {

        int userid = (Integer) session.getAttribute("userid");
        return createTopicService.createTopic(topic, userid);
    }

    @RequestMapping(value = "/findpublictopic", method = RequestMethod.GET)
    public @ResponseBody
    List<Topic> getPublicTopics(HttpServletRequest request) {
        System.out.println("inside find public topic");
        return findPublicTopicsService.getpublictopics(request.getParameter("term"));
    }

    @RequestMapping(value = "/showtopicpage")
    public ModelAndView topicPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mav = new ModelAndView("ShowTopicPage");
        topicname = request.getParameter("term");
        mav.addObject("resources", showInboxOnDashboardPageService.getResources(topicname, 0));
        mav.addObject("topicname", topicname);
        return mav;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadPDFResource(HttpServletRequest request,
                                    HttpServletResponse response) {
        try {
            String fileName = request.getParameter("fileName");
            System.out.println("controller");
            System.out.println(fileName);

            fileName = "file:///" + fileName;
            URL url = new URL(fileName);
            final URLConnection connection = url.openConnection();
            final InputStream is = connection.getInputStream();
            OutputStream outStream = response.getOutputStream();
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", fileName.substring(74));
            response.setHeader(headerKey, headerValue);
            int data;
            byte b[] = new byte[999999];
            while ((data = is.read(b)) != -1) {
                byte tmp[] = ArrayUtils.subarray(b, 0, data);
                outStream.write(tmp);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping(value = "/uniquetopiccheck", method = RequestMethod.POST)
    public @ResponseBody
    String checkTopicAvailability(HttpServletRequest request) {
        return checkUniqueTopicPerUserService.checkAvailabilityOfTopic(request.getParameter("name"),
                (String) request.getSession().getAttribute("uname"));
    }

    @RequestMapping(value = "/fetchSubscribedTopics", method = RequestMethod.GET)
    public @ResponseBody
    List<Susbcription> getSubscribedTopics(HttpSession session, HttpServletRequest request) {
        return fetchSubscribedTopics.getTopics(request.getParameter("term"), (String) session.getAttribute("uname"));
    }

    @RequestMapping(value = "/unsubscribeToTopic", method = RequestMethod.GET)
    public @ResponseBody
    String unsubscribe(HttpServletRequest request, HttpSession session) {
        int topicid = Integer.parseInt(request.getParameter("tid"));
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        return serviceToUnsubscribe.unsubscribe(topicid, userid);
    }

    @RequestMapping(value = "/subscribetotopic", method = RequestMethod.GET)
    public @ResponseBody
    String subscribe(HttpSession session, HttpServletRequest request) {
        int userid = Integer.parseInt(session.getAttribute("userid").toString());
        System.out.println("@" + request.getParameter("tid") + "@");
        int topicid = Integer.parseInt(request.getParameter("tid"));
        return serviceToSubscribe.subscribe(topicid, userid);
    }

    @RequestMapping(value = "/showglobaltopic", method = RequestMethod.GET)
    public ModelAndView showglobaltopic(@RequestParam("topicname") String topicname) {
        ModelAndView modelAndView = new ModelAndView("TopicShowPage");
        modelAndView.addObject("globalresource", showGlobalTopicDao.getResources(topicname));
        return modelAndView;
    }

    @RequestMapping(value = "/changetopicname", method = RequestMethod.GET)
    public @ResponseBody
    String changeTopicName(HttpServletRequest request) throws IOException {
     return changeTopicNameService.changeTopicName(Integer.parseInt(request.getParameter("tid")),request.getParameter("tname") );
    }
    @RequestMapping(value = "/deletetopic",method = RequestMethod.GET)
    public @ResponseBody String deleteTopic(@RequestParam("tid") int tid)
    {
        return deleteTopic.deleteTopic(tid);
    }
}

