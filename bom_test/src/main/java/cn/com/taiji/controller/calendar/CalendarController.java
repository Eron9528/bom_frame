package cn.com.taiji.controller.calendar;

import cn.com.taiji.domain.calendar.Calendar;
import cn.com.taiji.domain.calendar.Picture;
import cn.com.taiji.dto.Result;
import cn.com.taiji.service.calendar.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("calendar")
@CrossOrigin
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    //得到排班表结果
    @GetMapping("getCalendar")
    public Result getCalendar(){
        List<Calendar> calendarList = calendarService.getCalendar();
        return new Result(calendarList);
    }

    // 上传图片
    @PutMapping("uploadPic")
    public Result uploadPic(@RequestParam(value="img") MultipartFile file) {
        StringBuilder builder = new StringBuilder();
        builder.append(UUID.randomUUID().toString().replaceAll("-", ""));
        String contentType = file.getContentType();
        if (contentType.equals("image/png")){
            builder.append(".png");
        }else if (contentType.equals("image/jpeg")){
            builder.append(".jpeg");
        }else if (contentType.equals("gif/jpeg")){
            builder.append(".gif");
        }else {
            return new Result(false, 200,"请选择.png.jpg格式的图片");
        }
        boolean bool = calendarService.save(file);
        return new Result(bool);
    }

    // 导入排班中查询所有上传图片
    @GetMapping("getAllPicture")
    public Result getAllPicture(){
        List<Picture> pictures = calendarService.findAllPicture();
        return new Result(pictures);
    }

    @DeleteMapping("deletePicById/{id}")
    public Result deletePicById(@PathVariable("id") long id){
        Picture pic = calendarService.deletePicById(id);
        return new Result(pic);
    }


}
