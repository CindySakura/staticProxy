package service.impl;

import dao.Student;
import service.IStudentService;

public class IStudentServiceImpl implements IStudentService {
    @Override
    public void save() {
        System.out.println("保存学生信息");
    }

    @Override
    public Student query() {
        System.out.println("查询学生信息");
        return null;
    }

}
