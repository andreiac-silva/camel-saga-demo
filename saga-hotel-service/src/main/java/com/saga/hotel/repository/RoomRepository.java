package com.saga.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saga.hotel.model.Room;
import com.saga.hotel.model.Room.Status;
import com.saga.hotel.model.Room.Type;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

	Room findFirstByHotelCodeAndStatusAndType(String hotelCode, Status status, Type type);
}
