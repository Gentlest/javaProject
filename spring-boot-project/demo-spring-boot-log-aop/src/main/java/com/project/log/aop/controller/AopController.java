package com.project.log.aop.controller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.project.log.aop.annotation.PermissionAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

/**
 * @Author Gentlest
 * @Description 测试Controller
 * @Date 2021/2/24 15:17
 */
@Slf4j
@RestController
public class AopController {
    @PermissionAccess()
    @GetMapping("/test")
    public Dict test(@RequestParam(required = false, name = "who") String who) {
        return Dict.create().set("who", StrUtil.isBlank(who) ? "me" : who);
    }


    @PostMapping("/testJson")
    public Dict testJson(@RequestBody Map<String, Object> map) {
        String jsonStr = JSONUtil.toJsonStr(map);
        log.info(jsonStr);

        return Dict.create().set("Json", map);

    }
}
