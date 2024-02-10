package com.narayan.springdata.service;

import com.narayan.springdata.entity.Department;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department updateDepartment( Department department, Long departmentId );

    void deleteDepartmentbyId(Long departmentId);
}
