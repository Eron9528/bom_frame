package cn.com.taiji.service.calendar;

import cn.com.taiji.domain.calendar.Calendar;
import cn.com.taiji.domain.calendar.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CalendarService {

    /**
     * @描述  得到
     * @创建人 Mayu
     * @创建时间 2021/1/25
    */
    List<Calendar> getCalendar();

    /**
     * @描述   保存导入图片
     * @创建人 Mayu
     * @创建时间 2021/1/26
    */
    boolean save(MultipartFile file);

    /**
     * @描述   查询得到所有的图片
     * @创建人 Mayu
     * @创建时间 2021/1/26
    */
    List<Picture> findAllPicture();

    /**
     * @描述  删除图片
     * @创建人 Mayu
     * @创建时间 2021/1/26
    */
    Picture deletePicById(long id);
}
