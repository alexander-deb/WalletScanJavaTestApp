package com.example.microservice.controllers;

import com.example.microservice.DAO.RequestDAO;
import com.example.microservice.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class RequestController {
    private RequestDAO requestdao;

    @Autowired
    public RequestController(RequestDAO requestdao) {
        this.requestdao = requestdao;
    }

    @GetMapping("/")
    public String helloPage() {
        return "index";

    }

    @GetMapping("/request")
    public String getRequest(@RequestParam(value = "address", required = false) String address, Model model) throws IOException {
        if (address != null) {
            Request request = new Request(address);
            requestdao.saveRequest(request);
            model.addAttribute("count", request.getTransactions());
            model.addAttribute("address", request.getAddress());
            model.addAttribute("time", request.getTime_sent());
            return "req";
        }
        return "badReq";
    }

    @GetMapping("/show_all_requests")
    public String getRequest(Model model) {
        model.addAttribute("requests", requestdao.showAll());
        return "show";

    }




}
