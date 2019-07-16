package com.saga.hotel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.saga.hotel.exception.NumberOfGuestsNotAllowed;

@Entity
@Table(name = "room")
public class Room implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_hotel")
	private Hotel hotel;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private Type type;

	public Room() {
	}

	public Room(final Hotel hotel, final Status status, final Type type) {
		this.hotel = hotel;
		this.status = status;
		this.type = type;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void changeToAvailable() {
		this.status = Status.AVAILABLE;
	}

	public void changeToUnavailable() {
		this.status = Status.UNAVAILABLE;
	}

	public boolean isAvailable() {
		return Status.AVAILABLE.equals(this.status);
	}

	public enum Status {

		AVAILABLE, UNAVAILABLE
	}

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
