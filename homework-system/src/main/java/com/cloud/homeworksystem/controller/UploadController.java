package com.cloud.homeworksystem.controller;

import com.cloud.homeworksystem.bean.Homework;
import com.cloud.homeworksystem.bean.HomeworkDesc;
import com.cloud.homeworksystem.bean.Student;
import com.cloud.homeworksystem.services.HomeworkDescServiceImpl;
import com.cloud.homeworksystem.services.HomeworkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

@RestController
public class UploadController {
    @Autowired
    HomeworkServiceImpl homeworkServiceImpl;

    @Autowired
    HomeworkDescServiceImpl homeworkDescServiceImpl;

    @PostMapping("/singleUpload")
    public Object upload(@RequestParam("file")MultipartFile file, HttpServletRequest req,HttpSession session){
        String hid=req.getParameter("hid");
        String cid=req.getParameter("cid");
        HomeworkDesc homeworkDesc=homeworkDescServiceImpl.getHomByCidHid(new BigInteger(cid),new BigInteger(hid));
        String path=homeworkDesc.getPath();

        saveFile(file,path);
        saveHomStatus(req,session);
        return "ok";
    }

    @PostMapping("/multiUpload")
    public Object multiUpload(@RequestParam("file")MultipartFile[] files,HttpServletRequest req,HttpSession session){
        String hid=req.getParameter("hid");
        String cid=req.getParameter("cid");
        HomeworkDesc homeworkDesc=homeworkDescServiceImpl.getHomByCidHid(new BigInteger(cid),new BigInteger(hid));
        String path=homeworkDesc.getPath();

        System.out.println("文件的个数:"+files.length);
        for (MultipartFile f : files){
            saveFile(f,path);
        }
        saveHomStatus(req,session);
        return "ok";
    }

    private Object saveFile(MultipartFile file,String path){
        if (file.isEmpty()){
            return "未选择文件";
        }
        String filename = file.getOriginalFilename(); //获取上传文件原来的名称
        //String filePath = "C:/Other/";
        File temp = new File(path);
        if (!temp.exists()){
            temp.mkdirs();
        }

        File localFile = new File(path+filename);
        try {
            file.transferTo(localFile); //把上传的文件保存至本地
            System.out.println(file.getOriginalFilename()+" 上传成功");
        }catch (IOException e){
            e.printStackTrace();
            return "上传失败";
        }

        return "ok";
    }

    private Object saveHomStatus(HttpServletRequest req,HttpSession session){
        String cid=req.getParameter("cid");
        String hid=req.getParameter("hid");

        Student student=(Student)session.getAttribute("user");

        Homework homework=new Homework();
        homework.setCid(new BigInteger(cid));
        homework.setHid(new BigInteger(hid));
        homework.setSid(student.getId());

        homeworkServiceImpl.insertHom(homework);

        return "ok";
    }
}