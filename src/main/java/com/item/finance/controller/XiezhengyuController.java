package com.item.finance.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.News;
import com.item.finance.bean.NewsType;
import com.item.finance.services.NewsService;
import com.item.finance.services.NewsTypeService;

@Controller
public class XiezhengyuController {
@Autowired
private NewsService newsService;
@Autowired
private NewsTypeService newsTypeService;
@RequestMapping("/show")
public String login(Map map){
return "WEB-INF/backstage/show";
}
@RequestMapping("/NewsRight")
public String NewsRight(){
return "WEB-INF/backstage/NewsRight";
}
@RequestMapping("/listNews")
public String listNews(Map map){
List<News> list = this.newsService.listNews(map);
map.put("list",list);
List<NewsType> listt=this.newsTypeService.listNewsType(map);
map.put("listt", listt);
return "WEB-INF/backstage/NewsRight";
}
//添加/saveNews",
@RequestMapping("/saveNews" )
public String saveNews(News n,int tid){
n.setAddTime(new Date());
NewsType type=this.newsTypeService.selectGetById(tid+"");
n.setNewsType(type);
n.setAddId(1);
n.setClickNumber(1);
this.newsService.save(n);
return "redirect:listNews";
}
}
