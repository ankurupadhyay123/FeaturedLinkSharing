package com.ttn.model.Impdao;

import com.ttn.model.dao.FetchUserInfoOnDashboardDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankur on 7/16/2017.
 */
@Component
public class FetchUserInfoOnDashboardDaoimp implements FetchUserInfoOnDashboardDao {
    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }
    public List<?> userInfo(int id) {
        Session session=getSession();
        String topicFetch="select count(*) from Topic where createdBy.id =:uid";
        Query topicCount=session.createQuery(topicFetch);
        topicCount.setInteger("uid",id);
        List<Long> list=new ArrayList();
        list.add((Long)topicCount.uniqueResult());
        String subscription="select count(*) from Susbcription where user.id =:uid";
        Query subscriptionCount =session.createQuery(subscription);
        subscriptionCount.setInteger("uid",id);
        list.add((Long)subscriptionCount.uniqueResult());
        return list;
    }
}
