package com.insshop.controller;


import com.insshop.dto.inquiry.Inquiry;
import com.insshop.dto.inquiry.InquirySaveRequest;
import com.insshop.dto.inquiry.Type;
import com.insshop.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cs")
public class CustomerServiceController {

    private final InquiryService inquiryService;

    @GetMapping
      public String showCustomerServiceHomel(){

        return "customer-service/home";
    }

    @GetMapping("delivery")
    public String showDelivery(Model model){

        model.addAttribute("inquirys",inquiryService.findInquiresByType(Type.DELIVERY));

        return "customer-service/delivery-list";
    }

    @GetMapping("delivery/register")
    public String showDeliveryRegisterForm(Model model){

//        model.addAttribute("inquiry", new Inquiry());
        model.addAttribute("inquiry", new InquirySaveRequest());

        return "customer-service/delivery-register-form";
    }

    @GetMapping("order")
    public String showExchangeReturn(Model model){

        model.addAttribute("inquirys",inquiryService.findInquiresByType(Type.ORDER));

        return "customer-service/exchange-return-list";
    }

    @GetMapping("order/register")
    public String showExchangeReturnRegisterForm(Model model){

//        model.addAttribute("inquiry", new Inquiry());
//        폼테그 말고 다른거
//        인풋용 디티오
        model.addAttribute("inquiry", new InquirySaveRequest());

        return "customer-service/exchange-return-register-form";
    }

    @GetMapping("payment")
    public String showPaymet(Model model){

        model.addAttribute("inquirys",inquiryService.findInquiresByType(Type.PAYMENT));

        return "customer-service/payment-list";
    }

    @GetMapping("payment/register")
    public String showPaymetRegisterForm(Model model){

//        model.addAttribute("inquiry", new Inquiry());
        model.addAttribute("inquiry", new InquirySaveRequest());

        return "customer-service/payment-register-form";
    }

    @GetMapping("product")
    public String showProduct(Model model){

        model.addAttribute("inquirys",inquiryService.findInquiresByType(Type.PRODUCT));

        return "customer-service/product-list";
    }

    @GetMapping("product/register")
    public String showProductRegisterForm(Model model){

//        model.addAttribute("inquiry", new Inquiry());
        model.addAttribute("inquiry", new InquirySaveRequest());

        return "customer-service/product-register-form";
    }

    @GetMapping("inquiry/{id}")
    public String showInquiryDetail(Model model, @PathVariable("id") Long id){

        Inquiry inquiry = inquiryService.findById(id);

        model.addAttribute("inquiry",inquiry);

        switch (inquiry.getType()){
            case ORDER -> {
                return "customer-service/exchange-return";
            }
            case PAYMENT -> {
                return "customer-service/payment-delivery";
            }
            default -> {
                return "customer-service/product";
            }
        }
    }

    @GetMapping("inquiry/{id}/response")
    public void showInquiryReponse(Model model, @PathVariable("id") Long id){

        Inquiry inquiry = inquiryService.findById(id);

        model.addAttribute("inquiry",inquiry);

        ;;
    }

    @PostMapping("inquiry/register")
    public String registerInquiry(InquirySaveRequest inquiry){

        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>" + inquiry);

        inquiryService.save(inquiry);

        switch (inquiry.getType()){
            case ORDER -> {
                return "redirect:/cs/exchange-return";
            }
            case PAYMENT -> {
                return "redirect:/cs/payment-delivery";
            }
            default -> {
                return "redirect:/cs/product";
            }
        }
    }


    @PatchMapping("inquiry/{id}/delete")
    public String deleteInquiry(@PathVariable("id") Long id){

        inquiryService.updateStatusToDeleted(id);

        return "redirect:/cs";
    }

}
