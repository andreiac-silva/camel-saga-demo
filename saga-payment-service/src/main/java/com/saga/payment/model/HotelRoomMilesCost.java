package com.saga.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.saga.payment.exception.NumberOfGuestsNotAllowed;

@Entity
@Table(name = "hotel_room_miles_cost")
public class HotelRoomMilesCost extends MilesCost {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private Type type;

	public enum Type {

		SINGLE(1), 
		DOUBLE(2), 
		TRIPLE(3), 
		QUAD(4);

		private final int numberOfGuests;

		private Type(int numberOfGuests) {
			this.numberOfGuests = numberOfGuests;
		}

		public int numberOfGuests() {
			return numberOfGuests;
		}

		public static Type findByNumberOfVacancies(final Integer vacancies) throws NumberOfGuestsNotAllowed {

			for (Type type : values()) {
				if (type.numberOfGuests() == vacancies) {
					return type;
				}
			}

			throw new NumberOfGuestsNotAllowed();
		}
	}
}
