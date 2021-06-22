package com.cloud.homeworksystem.controller;

import com.cloud.homeworksystem.bean.Student;
import com.cloud.homeworksystem.bean.Teacher;
import com.cloud.homeworksystem.services.StudentServiceImpl;
import com.cloud.homeworksystem.services.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;

@Controller
public class LoginController {
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @RequestMapping(value={"/"})
    public String toLogin(){
        return "stu/login";
    }

    @RequestMapping("/LoginCheck")
    public String LoginSuccess(Model model, HttpServletRequest req, HttpServletResponse res,HttpSession session){
        //先查询看该用户是否存在
        String id=req.getParameter("id");
        String password=req.getParameter("password");

        Student stu=studentServiceImpl.getStuById(new BigInteger(id));
        if(stu!=null && stu.getPassword().equals(password)){ //  如果查询的用户存在
            System.out.println(stu.toString());
            session.setAttribute("user",stu);
            return "stu/main";
        }
        else{
            //返回到登录页面
            model.addAttribute("data","该用户不存在，请先注册");
            return "stu/login";
        }
    }

    @RequestMapping("/LoginCheck_Sys")
    public String LoginSysSuccess(Model model, HttpServletRequest req, HttpServletResponse res,HttpSession session){
        //先查询看该用户是否存在
        String id=req.getParameter("id");
        String password=req.getParameter("password");

        Teacher tea=teacherServiceImpl.getTeaById(new BigInteger(id));
        if(tea!=null && tea.getPassword().equals(password)){ //  如果查询的用户存在
            System.out.println(tea.toString());
            session.setAttribute("user",tea);
            return "tea/main_sys";
        }
        else{
            //返回到登录页面
            model.addAttribute("data","该用户不存在，请先注册");
            return "tea/login_sys";
        }
    }


    //学生登录界面
    @RequestMapping("/register")
    public String toRegister(){
        return "stu/register";
    }
    @RequestMapping("/Register")
    public String toRegisterSuccess(Model model,HttpServletRequest req,HttpServletResponse res){
        //将账号密码加入到数据库中
        String id=req.getParameter("id");
        String name=req.getParameter("username");
        String password=req.getParameter("password");
        String password2=req.getParameter("password2");
        if(!password.equals(password2)){
            model.addAttribute("passwordError","密码不匹配");
            return "stu/register";
        }
        Student student=new Student();
        student.setId(new BigInteger(id));
        student.setName(name);
        student.setPassword(password);
        int insert=studentServiceImpl.insertStu(student);
        System.out.println("数据插入成功！");
        model.addAttribute("data","注册成功，请登录！");
        return "stu/login";
    }
    //教师登录界面
    @RequestMapping("/register_sys")
    public String toRegisterSys(){
        return "tea/register_sys";
    }
    @RequestMapping("/Register_Sys")
    public String toRegisterSysSuccess(Model model,HttpServletRequest req,HttpServletResponse res){
        //将账号密码加入到数据库中
        String id=req.getParameter("id");
        String name=req.getParameter("username");
        String password=req.getParameter("password");
        String password2=req.getParameter("password2");
        if(!password.equals(password2)){
            model.addAttribute("passwordError","密码不匹配");
            return "tea/register_sys";
        }
        Teacher teacher=new Teacher();
        teacher.setId(new BigInteger(id));
        teacher.setName(name);
        teacher.setPassword(password);
        int insert=teacherServiceImpl.insertTea(teacher);
        System.out.println("数据插入成功！");
        model.addAttribute("data","注册成功，请登录！");
        return "tea/login_sys";
    }
}
