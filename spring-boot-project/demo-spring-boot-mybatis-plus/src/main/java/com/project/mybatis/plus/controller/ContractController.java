package com.project.mybatis.plus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 合同Controller
 *
 * @Author Gentlest
 * @Date 2021/3/24 11:12
 */
@Slf4j
@Controller
public class ContractController extends BaseController {

    @Resource
    private ContractService contractService;

    @GetMapping("/contract")
    public String list() {
        return "contract/list";
    }

    @PostMapping("/getContract")
    @ResponseBody
    public String contractList(@RequestParam(value = "beginDate") Date beginDate,
                               @RequestParam(value = "endDate") Date endDate) throws JsonProcessingException {
        QueryWrapper<ContractInfo> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>(16);
        ObjectMapper mapper = new ObjectMapper();
        wrapper.between("TIME_BA", beginDate, endDate);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", contractService.count(wrapper));
        map.put("data", contractService.getBaseMapper().selectList(wrapper));
        return mapper.writeValueAsString(map);
    }
}
