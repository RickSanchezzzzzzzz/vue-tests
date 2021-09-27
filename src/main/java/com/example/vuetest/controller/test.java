package com.example.vuetest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class test {

    @RequestMapping("/songinfo")
    public List<String> tests(String search){
        String path = "D:/localhost/vue-tests/src/main/resources/static/网易云音乐包"; // 路径
        File f = new File(path);//获取路径  F:\测试目录
        List<String> musicFile = new ArrayList<>();

        if (!f.exists()) {
            System.out.println(path + " not exists");//不存在就输出
            return musicFile;
        }

        File[] fa = f.listFiles();//用数组接收  F:\笔记总结\C#, F:\笔记总结\if语句.txt
        //获取数组中的第i个
        for (File fs : fa) {//循环遍历
            if (!fs.isDirectory()) {
                if(search != null || !search.equals("")){
                    if(fs.getName().contains(search)){
                        musicFile.add(fs.getName());
                    }
                }else {
                    musicFile.add(fs.getName());
                }
            }
        }
        return musicFile;
    }
}
