package com.cloud.homeworksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
    @RequestMapping("/left")
    public String leftHtml(){
        return "stu/left";
    }

    @RequestMapping("/left_sys")
    public String leftSysHtml(){return "tea/left_sys";}

    @RequestMapping("/right")
    public String rightHtml(){
        return "stu/right";
    }

    @RequestMapping("/right_sys")
    public String rightSysHtml(){return "tea/right_sys";}

    @RequestMapping("/my")
    public String myHtml(){
        return "my";
    }

    @RequestMapping("/upload")
    public String uploadHtml(){
        return "stu/upload";
    }

    @RequestMapping("/login")
    public String login(){
        return "stu/login";
    }

    @RequestMapping("/login_sys")
    public String login_sys(){
        return "tea/login_sys";
    }

    @RequestMapping("/course_create_sys")
    public String course_sys(){
        return "tea/course_sys";
    }

    @RequestMapping("course_chose")
    public String course_chose(){
        return "stu/course_chose";
    }

    @RequestMapping("homework_create")
    public String homework_create(){
        return "tea/homework_create";
    }

    @RequestMapping("homework_student_view_tea_form")
    public String homework_student_view_tea_form(){return "tea/homework_student_view_tea_form";}

    @RequestMapping("score_form")
    public String score_form(){return "tea/score_form";}
}
