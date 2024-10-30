
package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Mobile;

public interface MobileDao extends JpaRepository<Mobile, Integer> {

}
