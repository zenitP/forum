package com.internet.forum.controller;

import com.internet.forum.config.MvcConfig;
import com.internet.forum.domain.Message;
import com.internet.forum.domain.Topic;
import com.internet.forum.domain.User;
import com.internet.forum.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@Transactional
public class MessageController {

    @Value("${upload.path}")
    private String uploadPath; 

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/topics/{topics}/messages")
    public String main(
            @RequestParam(required = false) String filter2,
            @PathVariable Topic topics,
            Model model){

        Iterable<Message> messages;


        if(filter2 != null && !filter2.isEmpty()) {
            messages = messageRepo.findByTag(filter2);
        }else {
            messages = messageRepo.findAll();
        }


        model.addAttribute("topics", topics);
        model.addAttribute("filter3", filter2);
        model.addAttribute("messages", messages);

        return "messages";
    }

    @PostMapping("/topics/{topics}/messages")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            @RequestParam(required = false) String filter2,
            @PathVariable Topic topics,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model
    ) throws IOException {

        
        Message message = new Message(text, tag, user, topics);
        String FullName = uploadPath;    // изображения по папкам +"/"+topics.getName();

        if(file != null && !file.getOriginalFilename().isEmpty()){
            File uploadDir = new File(FullName);

            if(!uploadDir.exists()){
                uploadDir.mkdir();

            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile+"."+file.getOriginalFilename();

            file.transferTo(new File(FullName+"/"+resultFileName)); 

            message.setFilename(resultFileName);
        }

        if(!text.isEmpty()&&text!=null&&!tag.isEmpty()&&tag!=null) {

            message.setDate(new Date().toString());
            messageRepo.save(message);
        }


        Iterable<Message> messages = messageRepo.findAll();

        model.put("filter3", filter2);
        model.put("messages", messages);

        return "messages";
    }
}
