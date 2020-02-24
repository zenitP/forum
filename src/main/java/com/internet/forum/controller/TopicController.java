package com.internet.forum.controller;

import com.internet.forum.domain.Topic;
import com.internet.forum.repos.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TopicController {

    @Autowired
    private TopicRepo topicRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "main";
    }


    @GetMapping("/topics")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){

        Iterable<Topic> topics;

        if(filter != null && !filter.isEmpty()) {
            topics = topicRepo.findByName(filter);


        }else {
            topics = topicRepo.findAll();
        }

        model.addAttribute("f", filter);
        model.addAttribute("topics", topics);

        return "topics";
    }

    @PostMapping("/topics")
    public String add(@RequestParam(required = false, defaultValue = "") String filter, @RequestParam String name, Map<String, Object> model){

        Topic topic = new Topic(name);

        if(!name.isEmpty()&&name!=null) {
            topicRepo.save(topic);
        }

        Iterable<Topic> topics = topicRepo.findAll();

        model.put("f", filter);
        model.put("topics", topics);

        return "topics";
    }

}