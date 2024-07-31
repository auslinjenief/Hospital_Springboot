package com.AJ.Hostpital;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PatientRepo extends JpaRepository<PatientModel, Integer>{
	@Query(nativeQuery = true,value="getAll")
	public List<PatientModel> AllPatient();
	
	@Query(nativeQuery = true,value="getOne :id")
	public PatientModel OnePatient(@Param("id")int id);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "insertPatient :name, :age, :gender")
	public void createPatient(@Param("name") String name, @Param("age") int age, @Param("gender") String gender);

	@Modifying
	@Transactional
    @Query(nativeQuery = true,value = "updatePatient :id, :name, :age, :gender")
    public void patientupdate(@Param("id") int id, @Param("name") String name, @Param("age") int age, @Param("gender") String gender);

	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "deletePatient :id")
	public void patientDelete(@Param("id")int id);
}
