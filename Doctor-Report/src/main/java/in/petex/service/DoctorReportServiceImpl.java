package in.petex.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.petex.entity.DoctorReportEntity;
import in.petex.repository.DoctorReportRepository;

@Service
public class DoctorReportServiceImpl implements DoctorReportService {

    @Autowired
    private DoctorReportRepository doctorReportRepository;

    @Override
    public Boolean save(DoctorReportEntity report) {
        try {
            doctorReportRepository.save(report);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); 
            return false;
        }
    }

    @Override
    public void delete(Long customerId) {
        doctorReportRepository.deleteById(customerId);
    }

    @Override
    public DoctorReportEntity getReportById(Long customerId) {
        Optional<DoctorReportEntity> optionalReport = doctorReportRepository.findById(customerId);
        return optionalReport.orElse(null);
    }

    @Override
    public List<DoctorReportEntity> getAllReport() {
        return doctorReportRepository.findAll();
    }
    
 

    @Override
    public List<DoctorReportEntity> findByDate(LocalDate date) {
        return doctorReportRepository.findByDate(date);
    }

    @Override
    public List<DoctorReportEntity> findByMonth(int month) {
        return doctorReportRepository.findByDateMonth(month);
    }

    @Override
    public List<DoctorReportEntity> findByYear(int year) {
        return doctorReportRepository.findByDateYear(year);
    }

    @Override
    public List<DoctorReportEntity> findByMonthAndYear(int month, int year) {
        return doctorReportRepository.findByDateYearAndDateMonth(year, month);
    }
    
    @Override
    public List<DoctorReportEntity> getDoctorReportsByGender(String gender) {
        return doctorReportRepository.findByGender(gender);
    }
 

   
}
