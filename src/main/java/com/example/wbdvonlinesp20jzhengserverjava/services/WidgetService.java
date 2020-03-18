package com.example.wbdvonlinesp20jzhengserverjava.services;
import com.example.wbdvonlinesp20jzhengserverjava.models.Topic;
import com.example.wbdvonlinesp20jzhengserverjava.models.Widget;
import com.example.wbdvonlinesp20jzhengserverjava.repositories.TopicRepository;
import com.example.wbdvonlinesp20jzhengserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    TopicRepository topicRepository;

    public Widget createWidget(Integer tid, Widget newWidget) {
        Topic topic = topicRepository.findById(tid).get();
        newWidget.setTopic(topic);
        return widgetRepository.save(newWidget);
    }

    public List<Widget> findWidgetsForTopic(Integer tid) {
        return widgetRepository.findWidgetsForTopic(tid);
    }

    public Widget findWidgetById(Integer wid) {
        return widgetRepository.findWidgetById(wid);
    }

    public List<Widget> findAllWidgets() {
        return widgetRepository.findAllWidgets();
    }

    public int updateWidget(Integer wid, Widget updatedWidget) {
        Widget widgetToUpdate = widgetRepository.findWidgetById(wid);
        widgetToUpdate.setTitle(updatedWidget.getTitle());
        widgetToUpdate.setSize(updatedWidget.getSize());
        widgetToUpdate.setText(updatedWidget.getText());
        widgetToUpdate.setType(updatedWidget.getType());
        widgetToUpdate.setListType(updatedWidget.getListType());
        widgetToUpdate.setSrc(updatedWidget.getSrc());

        widgetRepository.save(widgetToUpdate);
        return 1;
    }

    public int deleteWidget(Integer wid) {
        widgetRepository.deleteById(wid);
        return 1;
    }

    public int moveWidget(Integer wFid, Integer wTid) {
        Widget widgetFrom = widgetRepository.findWidgetById(wFid);
        Widget widgetTo = widgetRepository.findWidgetById(wTid);

        System.out.println(widgetFrom.getWidgetOrder()+ " "+ widgetTo.getWidgetOrder());

        int temOrder = widgetTo.getWidgetOrder();
        widgetTo.setWidgetOrder(widgetFrom.getWidgetOrder());
        widgetFrom.setWidgetOrder(temOrder);
        System.out.println(wFid+ " "+ wTid);
        System.out.println(widgetFrom.getWidgetOrder()+ " "+ widgetTo.getWidgetOrder());

        widgetRepository.save(widgetFrom);
        widgetRepository.save(widgetTo);

        return 1;
    }
}
