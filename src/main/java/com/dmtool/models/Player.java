package com.dmtool.models;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Player {

	int playerId; // Player ID
	String playerName; // Player name
	LocalDateTime createdDate; // LocalDateTime the Player was created

	public Player() {

	}

	public Player(int playerId, String playerName, LocalDateTime createdDate) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.createdDate = createdDate;
	}

}
