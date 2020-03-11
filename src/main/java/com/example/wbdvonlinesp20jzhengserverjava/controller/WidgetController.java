package com.example.wbdvonlinesp20jzhengserverjava.controller;

import com.example.wbdvonlinesp20jzhengserverjava.models.Widget;
import com.example.wbdvonlinesp20jzhengserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class WidgetController {

    @Autowired
    WidgetService widgetService;

    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidget(@PathVariable("topicId") Integer tid, @RequestBody Widget widget) {
        return widgetService.createWidget(tid, widget);
    }

    @GetMapping("/api/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("topicId") Integer tid) {
        return widgetService.findWidgetsForTopic(tid);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
        return widgetService.findWidgetById(wid);
    }

    @PutMapping("/api/widgets/{widgetId}")
    public int updateWidget(@PathVariable("widgetId") Integer wid,
                            @RequestBody Widget widget) {
        return widgetService.updateWidget(wid, widget);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public int deleteWidget(@PathVariable("widgetId") Integer wid) {
        return widgetService.deleteWidget(wid);
    }

}
