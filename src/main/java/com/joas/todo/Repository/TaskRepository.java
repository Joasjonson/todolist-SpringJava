package com.joas.todo.Repository;


import com.joas.todo.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.joas.todo.Model.Task;
import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(Status status);

}
