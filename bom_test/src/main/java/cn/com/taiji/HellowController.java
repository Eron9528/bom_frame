package cn.com.taiji;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ Author     ：ShaoWei Sun.
 * @ Date       ：Created in 20:58 2018/11/16
 */
@RestController
@RequestMapping("hello")
public class HellowController {

    /**
     * 接收普通请求参数
     * http://localhost:8080/hello/show16?name=linuxsir
     * url参数中的name必须要和@RequestParam("name")一致
     * @return
     */
    @RequestMapping("show16")
    public ModelAndView test16(@RequestParam("name")String name){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg", "接收普通的请求参数：" + name);
        return mv;
    }

    /**
     * 接收普通请求参数
     * http://localhost:8080/hello/show17
     * url中没有name参数不会报错、有就显示出来
     * @return
     */
    @RequestMapping("show17")
    public ModelAndView test17(@RequestParam(value="name",required=false)String name){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg", "接收普通请求参数：" + name);
        return mv;
    }

    /**
     * 接收普通请求参数
     * http://localhost:8080/hello/show18?name=998 显示为998
     * http://localhost:8080/hello/show18?name 显示为hello
     * @return
     */
    @RequestMapping("show18")
    public ModelAndView test18(@RequestParam(value="name",required=true,defaultValue="hello")String name){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg", "接收普通请求参数：" + name);
        return mv;
    }

}