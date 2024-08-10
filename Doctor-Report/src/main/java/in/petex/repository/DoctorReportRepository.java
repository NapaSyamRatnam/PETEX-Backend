package in.petex.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import in.petex.entity.DoctorReportEntity;

@Repository
public interface DoctorReportRepository extends JpaRepository<DoctorReportEntity, Long> {

    List<DoctorReportEntity> findByDate(LocalDate date);

    

    List<DoctorReportEntity> findByDateBetween(LocalDate start, LocalDate end);

   
    default List<DoctorReportEntity> findByDateYear(int year) {
        // Define the start and end dates for the given year
        LocalDate startOfYear = LocalDate.of(year, 1, 1);
        LocalDate endOfYear = LocalDate.of(year, 12, 31);

        // Call the existing method to filter by date range
        return findByDateBetween(startOfYear, endOfYear);
    }

    @Query("SELECT d FROM DoctorReportEntity d WHERE MONTH(d.date) = :month")
    List<DoctorReportEntity> findByDateMonth(@Param("month") int month);

    @Query("SELECT d FROM DoctorReportEntity d WHERE YEAR(d.date) = :year AND MONTH(d.date) = :month")
    List<DoctorReportEntity> findByDateYearAndDateMonth(@Param("year") int year, @Param("month") int month);

    @Query("SELECT d FROM DoctorReportEntity d WHERE d.gender = :gender")
    List<DoctorReportEntity> findByGender(@Param("gender") String gender);



}
