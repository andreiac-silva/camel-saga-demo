package com.saga.payment.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saga.payment.model.HotelRoomMilesCost;
import com.saga.payment.model.HotelRoomMilesCost.Type;


@Repository
public interface HotelRoomMilesCostRepository extends CrudRepository<HotelRoomMilesCost, Long> {

	HotelRoomMilesCost findFirstByCodeAndType(String code, Type type);
}
