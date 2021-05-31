package com.project.composite.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.composite.entity.ContractInfo;
import com.project.composite.service.ContractInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 合同Controller
 *
 * @Author Gentlest
 * @Date 2021/3/4 11:53
 */
@Controller
@RequestMapping("/contract")
public class ContractController {

    private final ContractInfoService contractInfoService;

    @Autowired
    public ContractController(ContractInfoService contractInfoService) {
        this.contractInfoService = contractInfoService;
    }

    @PostMapping("/getInfo")
    public String queryContract(@RequestParam("contractNum") String contractNum, Model model) {
        List<ContractInfo> contractList = contractInfoService.queryContractByContractNum(contractNum);
        model.addAttribute("contracts", contractList);
        return "index";
    }

    @ResponseBody
    @PostMapping("/page")
    public String queryPageContract(@RequestParam("start") String start,
                                    @RequestParam("size") String size,
                                    @RequestParam("commitTime") String commitTime) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(contractInfoService.pageQueryContract(commitTime, start, size));
    }
}
