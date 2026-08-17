package com.example.shift;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
	List<Shift> findByNameAndDateStartingWith(String name, String datePrefix);
}