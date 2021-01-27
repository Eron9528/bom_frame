package cn.com.taiji.service.calendar.impl;

import cn.com.taiji.domain.calendar.Calendar;
import cn.com.taiji.domain.calendar.Picture;
import cn.com.taiji.domain.calendar.PictureRepository;
import cn.com.taiji.domain.calendar.dict.CalendarView;
import cn.com.taiji.service.calendar.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public List<Calendar> getCalendar(String name) {
        List<CalendarView> calendars = new ArrayList<>();

        return null;
    }

    @Override
    public boolean save(MultipartFile file) {
        try {
            byte[] byt = file.getBytes();
            Picture picture = new Picture();
            picture.setUrl(file.getName());  // 将图片存到服务器中需要用到 url 地址
            picture.setFileName(file.getName());
            picture.setContent(byt);
            picture.setUploadTime(LocalDateTime.now());
            pictureRepository.save(picture);

            
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

//    https://www.weizhixi.com/article/59.html
//    // 识别图片
//    public void analisy() {
//        File imageFile = new File("C:/Users/XQ/Desktop/en.png");
//        BufferedImage image = ImageIO.read(imageFile);
//        //对图片进行处理
//        image = convertImage(image);
//        ITesseract instance = new Tesseract();//JNA Interface Mapping
//        String result = instance.doOCR(image); //识别
//        System.out.println(result);
//    }}

    @Override
    public List<Picture> findAllPicture() {
        // 需不需要做转换
        return pictureRepository.findAll();
    }

    @Override
    public Picture deletePicById(long id) {
        Picture pic = pictureRepository.findById(id).orElse(null);
        pictureRepository.delete(pic);
        return pic;
    }
}
