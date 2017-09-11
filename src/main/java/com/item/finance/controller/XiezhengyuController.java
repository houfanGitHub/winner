package com.item.finance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.News;
import com.item.finance.services.NewsService;

@Controller
@RequestMapping("/xzy")
public class XiezhengyuController {
@Autowired
private NewsService newsService;
@RequestMapping("/show")
public String login(Map map){
return "WEB-INF/backstage/show";
}
@RequestMapping("/NewsRight")
public String NewsRight(){
return "WEB-INF/backstage/NewsRight";
}
//查询
@RequestMapping("/listNews")
public String listNews(Map map){
List<News> list = this.newsService.listNews(map);
map.put("list",list);
return "WEB-INF/backstage/NewsRight";
}
}
