package com.stephen.repositories;

import com.stephen.models.Attendance;
import com.stephen.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findAttendanceByEmployee(Employee employee);

}
