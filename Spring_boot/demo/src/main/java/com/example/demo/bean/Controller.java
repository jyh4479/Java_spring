package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    Member member1;

    @Autowired
    @Qualifier("printerB")
    Printer printer;

    @Autowired
    Member member2;

    @RequestMapping("/")
    public @ResponseBody String root(){
        member1.print();
        member1.setPrinter(printer);
        member1.print();
        return "Annotation 사용하기";
    }

    @GetMapping("/printA")
    public String A(){
        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);

        Member member1=(Member)context.getBean("member1");
        member1.print();

        Member member2 = context.getBean("hello", Member.class);
        member2.print();

        Printer printer=context.getBean("printerB",Printer.class);
        member1.setPrinter(printer);
        member1.print();

        return "실행성공";
    }
}
