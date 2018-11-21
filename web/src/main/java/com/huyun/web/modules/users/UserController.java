package com.huyun.web.modules.users;

import com.github.pagehelper.PageInfo;
import com.huyun.redis.RedisServer;
import com.huyun.users.model.Users;

import com.huyun.users.service.UsersService;
import com.huyun.users.service.impl.UsersServiceImpl;
import com.huyun.web.schedule.util.ScheduleUtil;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users/users")
public class UserController {

    @Autowired
    UsersService usersService;
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private RedisServer redisServer;

    @RequestMapping("/list")
    public ModelAndView list(ModelMap map){

        return new ModelAndView("users/users/list",map);
    }
    @GetMapping("/list")
    @ResponseBody
    public Map<String,Object> loadData(Integer page, Integer rows, String key){
        Map<String, Object> maps=new HashMap<String, Object>();
        maps.put("username",key);
        redisServer.set("1","redisS");
        PageInfo<Users> list=usersService.selectAllUsers(page,rows,maps);
        Map<String, Object> map=new HashMap<String, Object>();
         map.put("page",list);
        return map;
    }

    @GetMapping("/userlist")
    @ResponseBody
    public List<Users> select(){

        List<Users> list = usersService.selectAll();
        redisServer.set("1",list);
        try {
            //定时任务测试
//            ScheduleUtil.buildCreateGoodTimer(scheduler);
//            ScheduleUtil.buildGoodStockTimer(scheduler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
