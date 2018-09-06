package com.zero.cr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zero.cr.dao.PointMapper;
import com.zero.cr.dao.SubjectCustomMapper;
import com.zero.cr.dao.SubjectMapper;
import com.zero.cr.pojo.Point;
import com.zero.cr.pojo.Subject;
import com.zero.cr.service.SubjectService;
import com.zero.cr.utils.MyMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date
 */

@Service
public class
SubjectServiceImpl extends BaseServiceImpl<Subject> implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;

    @Resource
    private SubjectCustomMapper subjectCustomMapper;

    @Resource
    private PointMapper pointMapper;

    @Override
    public MyMapper<Subject> getMapper() {
        return subjectMapper;
    }

    @Override
    public PageInfo queryAllSubject(Integer pageNum , Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String, Object>> list = subjectCustomMapper.queryAllSubject();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * @param subjectId
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> querySubjectById(Integer subjectId) throws Exception {
        Map<String, Object> subject = subjectCustomMapper.querySbjectAndUserBySubjectId(subjectId);
        List<String> images = new ArrayList<>();
        //获取数据库对应的路径
        String dbImg = (String) subject.get("img");
        System.out.println(dbImg);
        StringBuffer sb = new StringBuffer();
        //拼接目录
        String separator = File.separator;
       // sb.append("E:").append(separator).append("cr").append(separator).append("target").append(separator).append("classes").append(separator).append("static").append(separator).append(dbImg);
        sb.append("D:\\Code\\IDEA_Java\\svn\\cr\\src\\main\\resources\\static\\").append(dbImg);

        System.out.println(sb.toString());

        File file = new File(sb.toString());

        //获取该文件夹下所有文件的File对象
        File[] files = file.listFiles();

        //如果该目录为空，则直接返回
        if (file == null || files == null) {
            return subject;
        }
        //遍历获取每一个文件的File对象
        for (File f : files) {
            images.add(dbImg + "/" + f.getName());
        }
        //封装进map
        subject.put("images", images);

        return subject;
    }

    /**
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public int addSubject(Map<String, Object> map) throws Exception {

        //为该主题创建一个图片存放目录
        String directory = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        String separator = File.separator;
        //D:\Code\IDEA_Java\svn\cr\src\main\resources\static\subject_images
        /*sb.append("E:").append(separator).append("cr").append(separator).append("src").append(separator).append("main").append(separator).append("resources")
                .append(separator).append("static").append(separator).append("subject_images").append(separator).append(directory);*/
        String src = "D:\\Code\\IDEA_Java\\svn\\cr\\src\\main\\resources\\static\\subject_images\\" + directory;
        //创建目录
        File file = new File(src);
        if (!file.exists()) {
            file.mkdirs();
        }

        //拆分
        String[] imgs = map.get("imgStr").toString().split("%%");

        //遍历图片数组，存入文件
        for (String img : imgs) {
            if(img == null || img.length()<1){
                break;
            }
            String sImg = img.split(",")[1];
            int i = sImg.lastIndexOf("\"");
            String newStr = sImg.substring(0, i);

            byte[] bytes = Base64Utils.decodeFromString(newStr);
            //创建输出流对象
            String fileName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file + "/" + fileName));
            bos.write(bytes);
            bos.flush();
            bos.close();
        }

        //新目录
        String newIngSrc = "subject_images/" + directory;

        Point point = new Point();
        point.setLat(map.get("lat")==null?null:Float.parseFloat((String) map.get("lat"))); //Float.parseFloat((String) map.get("lat"))
        point.setLng(map.get("lng")==null?null:Float.parseFloat((String) map.get("lng")));
        point.setCreateTime(new Date());
        pointMapper.insert(point);

        Subject subject = new Subject();
        subject.setTitle((String) map.get("title"));
        subject.setTopicId(map.get("topicId")==null?null:Long.parseLong((String) map.get("topicId")));   //Long.parseLong((String) map.get("topicId"))
        subject.setImg(newIngSrc);
        subject.setMileageTotal(24000.00);
        subject.setUserId(map.get("userId")==null?null:Long.parseLong((String) map.get("userId")));
        subject.setStartTime(new Date());
        subject.setPointId(point.getPointId());
        subject.setContent((String) map.get("content"));

        return subjectMapper.insertSelective(subject);
    }

    @Override
    public List<Map<String, Object>> queryAllSubjectNear(Float lat, Float lng) throws Exception {
        return subjectCustomMapper.querySubjectNear(lat , lng);
    }


}
