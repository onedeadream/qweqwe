package com.Obrabotka.IT.controllers;

import com.Obrabotka.IT.models.*;
import com.Obrabotka.IT.repository.AcceptRequestRepository;
import com.Obrabotka.IT.repository.OperationRepository;
import com.Obrabotka.IT.repository.RequestRepository;
import com.Obrabotka.IT.service.OperationService;
import com.Obrabotka.IT.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RequestController {
    @Autowired
    RequestService requestService;
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    OperationRepository operationRepository;
    @Autowired
    AcceptRequestRepository acceptRequestRepository;
    @Autowired
    OperationService operationService;

    @GetMapping("/claim_request")
    public String OperationList(@AuthenticationPrincipal Requests requests,
                                Model model) {
        model.addAttribute("allRequest", requestService.findAllRequest());
        model.addAttribute("requests", requests);
        model.addAttribute("operationForm", new Operation());
        return "claim_request";
    }
    @PostMapping("/claim_request")
    public String AddRequest(@AuthenticationPrincipal User user,
                             @RequestParam(required = true, defaultValue = "" ) Long requestId,
                             @RequestParam(required = true, defaultValue = "" ) String action,
                             Model model) {

        if (action.equals("accept")) {
            Requests requests = requestRepository.findById(requestId).get();
            Operation operation = operationService.findOperationById(requests.getOperId());
            operation.setEmployment("Busy");

            AcceptRequest acceptRequest = new AcceptRequest();

            acceptRequest.setTime(requests.getTime());
            acceptRequest.setOperation(requests.getOperation());
            acceptRequest.setData(requests.getData());
            acceptRequest.setFirstName(requests.getFirstName());
            acceptRequest.setLastName(requests.getLastName());

            requestService.deleteReq(requestId);
            acceptRequestRepository.save(acceptRequest);
        }
        if (action.equals("reject")){
            requestService.deleteReq(requestId);
        }

        return "redirect:/claim_request";
    }

    @PostMapping("/claim_request_add")
    public String addOperation(@ModelAttribute("operationForm")@Valid Operation operationForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "claim_request";
        }

        operationRepository.save(operationForm);

        return "redirect:/claim_request";
    }
}