package com.zero.cr.pojo;

import com.zero.cr.service.SubjectService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mr.H
 * @className SubjectCustom
 * @Date 2018/8/23 15:54
 * @Version v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectCustom extends Subject{
    private SubjectService subjectService;
}
