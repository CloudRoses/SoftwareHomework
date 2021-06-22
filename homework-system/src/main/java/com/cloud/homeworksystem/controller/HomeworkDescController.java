package com.cloud.homeworksystem.controller;

import com.cloud.homeworksystem.bean.*;
import com.cloud.homeworksystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeworkDescController {
    @Autowired
    HomeworkDescServiceImpl homeworkDescServiceImpl;

    @Autowired
    CourseServiceImpl courseServiceImpl;

    @Autowired
    ScServiceImpl scServiceImpl;

    @Autowired
    HomeworkServiceImpl homeworkServiceImp;

    @Autowired
    HomeworkDescHomeworkServiceImpl homeworkDescHomeworkServiceImpl;

    @PostMapping("homework_create_action")
    public String homeworkCreateAction(HttpServletRequest req, HttpServletResponse res,HttpSession session){
        String hid=(String)req.getParameter("hid");
        String name=(String)req.getParameter("name");
        String path=(String)req.getParameter("path");
        Teacher tea=(Teacher)session.getAttribute("user");
        BigInteger tid=tea.getId();
        String cid=(String)req.getParameter("cid");
        String date=req.getParameter("date");

        HomeworkDesc homeworkDesc=new HomeworkDesc();
        homeworkDesc.setHid(new BigInteger(hid));
        homeworkDesc.setName(name);
        homeworkDesc.setPath(path);
        homeworkDesc.setTid(tid);
        homeworkDesc.setCid(new BigInteger(cid));
        try {
            homeworkDesc.setDate(new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        homeworkDescServiceImpl.insertHom(homeworkDesc);
        return "tea/homework_create_ok";
    }

    @RequestMapping("homework_view_tea")
    public String homeworkViewTea(HttpSession session,Model model){
        Teacher teacher=(Teacher)session.getAttribute("user");
        List<HomeworkDesc> homeworkdescs=new ArrayList<>();
        homeworkdescs=homeworkDescServiceImpl.getAllHomByTid(teacher.getId());
        model.addAttribute("homeworkdescs",homeworkdescs);

        return "tea/homework_view_tea";
    }

    @RequestMapping("homework_view_stu")
    public String homeworkViewStu(HttpSession session,Model model){
        Student student=(Student)session.getAttribute("user");
        List<Sc> scs=scServiceImpl.getScBySid(student.getId());
        List<HomeworkDesc> homeworkDescs=new ArrayList<>();
        for(Sc sc:scs){
            List<HomeworkDesc> homeworkDesc=homeworkDescServiceImpl.getAllHomByCid(sc.getCid());
            homeworkDescs.addAll(homeworkDesc);
        }


        List<HomeworkDescHomework> homeworkDescHomeworks=homeworkDescHomeworkServiceImpl.selectStudentHomeworkStatus(student.getId());
        //List<Sc> scs=scServiceImpl.getScBySid(student.getId());
        //List<HomeworkDesc> homeworkdescs=new ArrayList<>();
        //List<Homework> homeFisSta=new ArrayList<>();
        /*for(Sc sc:scs){
            List<HomeworkDesc> temps=new ArrayList<>();
            temps=homeworkDescServiceImpl.getAllHomByCid(sc.getCid());
            homeworkdescs.addAll(temps);
        }

        for(HomeworkDesc homeworkDesc:homeworkdescs){
            Homework tempHomework=new Homework();
            tempHomework=homeworkServiceImp.getHomFisSta(new BigInteger("2010"),homeworkDesc.getHid(),student.getId());
            if(tempHomework!=null) {
                homeFisSta.add(tempHomework);
            }else{
                Homework homework=new Homework();
                homeFisSta.add(homework);
            }//if-else
        }//for

        model.addAttribute("homeworkdescs",homeworkdescs);
        model.addAttribute("homefissta",homeFisSta);
        */
        model.addAttribute("homeworkdescs",homeworkDescs);
        model.addAttribute("homeworkstatus",homeworkDescHomeworks);
        return "stu/homework_view_stu";
    }


    @RequestMapping("homework_student_view_tea")
    public String homeworkStudentViewTea(HttpSession session,Model model,HttpServletRequest req){
        String cid=(String)req.getParameter("cid");
        String hid=(String)req.getParameter("hid");
        List<HomeworkStudentTea> allStudentHomework=homeworkDescHomeworkServiceImpl.selectAllStudentHomework(new BigInteger(cid),
                new BigInteger(hid));

        model.addAttribute("homeworkStudents",allStudentHomework);
        return "tea/homework_student_view_tea";
    }

    @RequestMapping("score_upload")
    public String scoreUpload(HttpServletRequest req){
        String cid=(String)req.getParameter("cid");
        String hid=(String)req.getParameter("hid");
        String sid=(String)req.getParameter("sid");
        String score=(String)req.getParameter("score");

        Homework homework=new Homework();
        homework.setCid(new BigInteger(cid));
        homework.setHid(new BigInteger(hid));
        homework.setSid(new BigInteger(sid));
        homework.setScore(new Integer(score));

        homeworkServiceImp.updateHom(homework);

        return "tea/score_upload_ok_tea";
    }

}
