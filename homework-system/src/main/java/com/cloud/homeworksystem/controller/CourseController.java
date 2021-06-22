package com.cloud.homeworksystem.controller;

import com.cloud.homeworksystem.bean.Course;
import com.cloud.homeworksystem.bean.Sc;
import com.cloud.homeworksystem.bean.Student;
import com.cloud.homeworksystem.bean.Teacher;
import com.cloud.homeworksystem.services.CourseServiceImpl;
import com.cloud.homeworksystem.services.ScServiceImpl;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    CourseServiceImpl courseServiceImpl;

    @Autowired
    ScServiceImpl scServiceImpl;

    @PostMapping("course_create")
    public Object courseCreate(HttpServletRequest req, HttpServletResponse res,HttpSession session){
        Course course=new Course();

        String cid=req.getParameter("cid");
        String name=req.getParameter("cname");
        Teacher teacher=(Teacher)session.getAttribute("user");
        BigInteger tid=teacher.getId();

        course.setCid(new BigInteger(cid));
        course.setName(name);
        course.setTid(tid);
        courseServiceImpl.insertCou(course);

        return "tea/course_create_ok";
    }

    @RequestMapping("courses")
    public String courseAll(Model model){
        List<Course> courses=new ArrayList<>();
        courses=courseServiceImpl.getAllCourse();
        model.addAttribute("courses",courses);

        return "courses";
    }

    @RequestMapping("courses_tea")
    public String courseTea(Model model,HttpSession session){
        List<Course> courses=new ArrayList<>();
        Teacher teacher=(Teacher)session.getAttribute("user");
        courses=courseServiceImpl.getTeaCourse(teacher.getId());
        model.addAttribute("courses",courses);

        return "tea/courses_tea";
    }

    @RequestMapping("courses_stu")
    public String courseStu(Model model,HttpSession session){
        List<Course> courses=new ArrayList<>();
        //List<Sc> scs=new ArrayList<>();
        Student student=(Student)session.getAttribute("user");
        List<Sc> scs=scServiceImpl.getScBySid(student.getId());

        for(Sc sc:scs){
            Course course=new Course();
            course=courseServiceImpl.getCouById(sc.getCid());
            courses.add(course);
        }
        model.addAttribute("courses",courses);

        return "stu/courses_stu";
    }

}
