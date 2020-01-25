package com.dfbz.xbhy.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.dfbz.xbhy.entity.TestJson;
import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.entity.UserFocus;
import com.dfbz.xbhy.mapper.UserFocusMapper;
import com.dfbz.xbhy.mapper.UserMapper;
import com.dfbz.xbhy.service.UserFocusService;
import com.dfbz.xbhy.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class usertest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    UserFocusMapper focusMapper;
    @Autowired
    UserFocusService focusService;

    @Autowired
    HttpSession session;

    @Test
    public void testuser() {
        HashMap<String, Object> o = new HashMap<>();
        o.put("realName", "东");
        System.out.println(userMapper.LookUser(o));

//        List<User> users = userMapper.selectAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
    }

    @Test
    public void testFocus() {
        User user = userService.toLookUser("1");

        System.out.println(user);

//        HashMap<String, Object> o = new HashMap<>();
//        o.put("realName", "东");
//        PageInfo<User> userPageInfo = userService.LookUser(o);
//        System.out.println(userPageInfo);

    }

    @Test
    public void focusMapper() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        List<UserFocus> userFoci = focusMapper.myUser("1");
        for (UserFocus userFocus : userFoci) {
            System.out.println(userFocus);
        }
    }

    @Test
    public void eee() {
        int[] arr = {98, 23, 34, 57, 56, 46, 78};
        int size = arr.length;
        int temp;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;

            System.out.println(arr[i]);
        }
    }

    @Test
    public void test() {
        String jsonstr = "{'a':'123','s':'456','d':'789'}";
        JSONObject jsonObject = JSONObject.parseObject(jsonstr);
        TestJson json = JSONObject.parseObject(jsonObject.toJSONString(), new TypeReference<TestJson>() {});
        //TestJson 是实体类
        System.out.println(json);
        System.out.println(json.getA());
        System.out.println(jsonstr);
    }
}
