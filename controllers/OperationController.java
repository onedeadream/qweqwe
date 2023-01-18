package com.Obrabotka.IT.controllers;

import com.Obrabotka.IT.models.Operation;
import com.Obrabotka.IT.models.Requests;
import com.Obrabotka.IT.models.Role;
import com.Obrabotka.IT.models.User;
import com.Obrabotka.IT.repository.OperationRepository;
import com.Obrabotka.IT.repository.RequestRepository;
import com.Obrabotka.IT.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperationController {
    @Autowired
    private OperationService operationService;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private OperationRepository operationRepository;

    @GetMapping("/send_request")
    public String OperationList(@AuthenticationPrincipal Operation operations,
                           Model model) {
        model.addAttribute("allOperation", operationService.findAllOperation());
        model.addAttribute("operations", operations);
        return "send_request";
    }

    @PostMapping("/send_request")
    public String AddRequest(@AuthenticationPrincipal User user,
                             @RequestParam(required = true, defaultValue = "" ) Long operationId,
                             @RequestParam(required = true, defaultValue = "" ) String action,
                             Model model) {

        if (action.equals("request")) {
            Operation operation = operationRepository.findById(operationId).get();
            Requests requests = new Requests();
            requests.setOperation(operation.getOperations());
            requests.setTime(operation.getTime());
            requests.setFirstName(user.getFirst_name());
            requests.setLastName(user.getLast_name());
            requests.setOperId(operationId);
            requests.setData(operation.getData());
            requestRepository.save(requests);
        }

        if (action.equals("delete")) {
            operationService.deleteOperation(operationId);
        }

        return "redirect:/send_request";
    }

    @GetMapping("/send_request/{data}")
    public String getData(@AuthenticationPrincipal Operation operation,
                          @PathVariable("data") String data, Model model){
        model.addAttribute("getData", operationService.dataGetList(data));
        model.addAttribute("operation", operation);
        return "send_request";
    }
}
