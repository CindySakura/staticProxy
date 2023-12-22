package service;

import dao.Student;

public interface IStudentService {
    /**
     * 添加学生
     */
    void save();

    /**
     * 查询学生
     * @return
     */
    Student query();
}
