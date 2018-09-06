package com.zero.cr.service.impl;

import com.zero.cr.dao.UserMapper;
import com.zero.cr.pojo.User;
import com.zero.cr.service.UserService;
import com.zero.cr.utils.MyMapper;
import com.zero.cr.utils.Util;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Hxf
 * @version V1.0
 * @Title:
 * @Description: Test
 * @date
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public MyMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public Long getUserFollowSum(Long userId) {
        return userMapper.getUserFollowSum(userId);
    }

    @Override
    public User login(String username, String password) {
        return (User) userMapper.selectByExample(User.builder().username(username).password(password).build());
    }

    @Override
    public List<User> getSubjectUserTop3(long subjectId) {
        return userMapper.getSubjectUserTop3(subjectId);
    }

    /*@Override
    public boolean save(User query) {
        if (query != null) {
            userMapper.save(query);
            return true;
        }
        return false;
    }*/

    /*    @Override
        public boolean updateUser(User user, HttpServletRequest request) throws Exception {
            String imgSrc = "\\images\\upload";
            String serverSavePath = request.getServletContext().getRealPath("/img/");
            System.out.println("serverSavePath:" + serverSavePath);
            File file = new File(serverSavePath);
            if (!file.exists()) {
                file.mkdirs();
            }

            String fileName = user.getUsername() + ".png";
            String fullFileName = serverSavePath + "\\" + fileName;

            String headImg = user.getHeadImg().substring(user.getHeadImg().indexOf(",") + 1);
            byte[] bytes = Base64Utils.decodeFromString(headImg);
            //创建输出流对象
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fullFileName));
            bos.write(bytes);
            bos.flush();
            bos.close();

            String userHeadImg = imgSrc.replace("\\", "/").substring(1) + "/" + fileName;
            user.setHeadImg(userHeadImg);

            userMapper.updateByPrimaryKeySelective(user);
            return true;
        }
     */
    @Override
    public boolean updateUser(User user, HttpServletRequest request, String userToken) throws Exception {

        if (Util.token2user(userToken) == null || user == null) {
            return false;
        }
        if (user.getHeadImg() != null && !user.getHeadImg().equals(Objects.requireNonNull(Util.token2user(userToken)).getHeadImg())) {

            String imgSrc = "\\images\\upload";
            String serverSavePath = "D:\\Code\\IDEA_Java\\svn\\cr\\src\\main\\resources\\static\\images\\upload";
            File file = new File(serverSavePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            String fileName = new Date().getTime() + ".png";
            String fullFileName = serverSavePath + "\\" + fileName;
            String headImg = user.getHeadImg().substring(user.getHeadImg().indexOf(",") + 1);
            byte[] bytes = Base64Utils.decodeFromString(headImg);
            //创建输出流对象
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fullFileName));
            bos.write(bytes);
            bos.flush();
            bos.close();
            String userHeadImg = imgSrc.replace("\\", "/").substring(1) + "/" + fileName;
            user.setHeadImg(userHeadImg);
        }

        userMapper.updateByPrimaryKeySelective(user);
        return true;
    }

}
