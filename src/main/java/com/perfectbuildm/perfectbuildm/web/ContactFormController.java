package com.perfectbuildm.perfectbuildm.web;

import com.perfectbuildm.perfectbuildm.event.ContactSuccessfullEventImpl;
import com.perfectbuildm.perfectbuildm.model.ContactFormBindingModel;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class ContactFormController {

    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ContactFormController(ModelMapper modelMapper, ApplicationEventPublisher applicationEventPublisher) {
        this.modelMapper = modelMapper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @ModelAttribute("contactModel")
    public ContactFormBindingModel contactFormBindingModel() {
        return new ContactFormBindingModel();
    }

    @PostMapping("/contact")
    public String makeContact(@Valid ContactFormBindingModel contactModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        boolean hasSent = true;

        String ownerEmail = "taurus.ali47@gmail.com";

        ContactSuccessfullEventImpl event = new ContactSuccessfullEventImpl(ownerEmail,contactModel.getName(),contactModel.getEmail(),contactModel.getPhone(),contactModel.getMessage());

        try {
            applicationEventPublisher.publishEvent(event);
        } catch (Exception ex) {
            hasSent = false;
        }


        redirectAttributes
                .addFlashAttribute("contactModel", contactModel)
                .addFlashAttribute("org.springframework.validation.BindingResult.contactModel", bindingResult)
                .addFlashAttribute("sent",hasSent);

        return "redirect:/";
    }

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

}
