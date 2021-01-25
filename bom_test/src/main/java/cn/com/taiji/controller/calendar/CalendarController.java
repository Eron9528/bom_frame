package cn.com.taiji.controller.calendar;

import cn.com.taiji.domain.calendar.Calendar;
import cn.com.taiji.dto.Result;
import cn.com.taiji.service.calendar.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("calendar")
@CrossOrigin
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping("getCalendar")
    public Result getCalendar(){
        List<Calendar> calendarList = calendarService.getCalendar();
        return new Result(calendarList);
    }
}
