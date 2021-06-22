package com.cloud.homeworksystem.controller;

import com.cloud.homeworksystem.bean.Sc;
import com.cloud.homeworksystem.bean.Student;
import com.cloud.homeworksystem.services.ScServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ScController {
    @Autowired
    ScServiceImpl scServiceImpl;

    @RequestMapping("course_chose_action")
    public String course_chose(HttpServletRequest req,HttpSession session){
        Sc sc=new Sc();
        Student student=(Student)session.getAttribute("user");
        sc.setCid(new BigInteger(req.getParameter("cid")));
        sc.setSid(student.getId());

        scServiceImpl.insertSc(sc);

        return "ok";
    }

}
