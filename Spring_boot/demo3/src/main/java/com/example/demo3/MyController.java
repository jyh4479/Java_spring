package com.example.demo3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Validator (1)";
    }

    @RequestMapping("/insertForm")
    public String insert1() {

        return "createPage";
    }

    /*@RequestMapping("/create")
    public String insert2(@ModelAttribute("dto") ContentDto contentDto, BindingResult result) {
        String page = "createDonePage";
        System.out.println(contentDto);

        ContentValidator validator = new ContentValidator();
        validator.validate(contentDto, result);
        if (result.hasErrors()) {
            page = "createPage";
        }

        return page;
    }*/

    @RequestMapping("/create")
    public String insert2(@ModelAttribute("dto") @Valid ContentDto contentDto, //--> @Valid를 통한 검즘 //--> 어노테이션으로 처리해도 이건 쓰나?
                          BindingResult result)
    {
        String page = "createDonePage";
        System.out.println(contentDto);

        //ContentValidator validator = new ContentValidator(); --> 강한 결합이 되어버림
        //validator.validate(contentDto, result);

        if (result.hasErrors()) {
            System.out.println("getAllErros : " + result.getAllErrors());

            if (result.getFieldError("writer") != null) {
                System.out.println("1:"+result.getFieldError("writer").getCode());
            }
            if (result.getFieldError("content") != null) {
                System.out.println("2:"+result.getFieldError("content").getCode());
            }

            page = "createPage";
        }

        return page;
    }

    //@InitBinder //-->어노테이션 사용으로 인해 주석처리
    //protected void initBinder(WebDataBinder binder){
     //   binder.setValidator(new ContentValidator());
    //}
}

/* --> form data 받는 controller
@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Form 데이터 전달받아 사용하기";
    }
 
    @RequestMapping("/test1")
    public String test1(HttpServletRequest httpServletRequest, Model model) {
		
    	String id = httpServletRequest.getParameter("id");
		String name = httpServletRequest.getParameter("name");
		//Cookie[] cookie = httpServletRequest.getCookies(); --> 쿠키받기 가능함

		model.addAttribute("id", id);
        model.addAttribute("name", name);
        //System.out.println(cookie);

        return "test1";       
    }

    @RequestMapping("/test2")
    public String test2(@RequestParam("id") String id,
    		            @RequestParam("name") String name,
    		            Model model)
    {
    	// 파라미터가 많아지면 불편해진다.
		model.addAttribute("id", id);
        model.addAttribute("name", name);

        return "test2";       
    }

    @RequestMapping("/test3") //--> member의 getter setter는 얘때문에 사용 (커맨드객체) --> lombok사용하며 커맨드객체를 간소화할수있음
    public String test3(Member member, Model model)
    {
    	// 파라미터와 일치하는 빈을 만들어서 사용할 수 있다.
    	// View 페이지에서 model 을 사용하지 않고 member를 사용한다.
        return "test3";       
    }
    
    // 패스 자체에 변수를 넣어 줄 수도 있다.
	@RequestMapping("/test4/{studentId}/{name}")
	public String getStudent(@PathVariable String studentId,
		                     @PathVariable String name,
		                     Model model)
    {
		model.addAttribute("id", studentId);
		model.addAttribute("name", name);
		return "test4";
	}

}
 */
