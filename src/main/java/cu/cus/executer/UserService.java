package cu.cus.executer;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public UserService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Long id) throws Throwable {
        // Исправленная логика для получения сотрудника по id
        return (Employee) employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with ID " + id + " not found"));
    }


    // Другие методы сервиса...
}
