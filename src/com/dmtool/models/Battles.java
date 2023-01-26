package com.dmtool.models;

import java.time.LocalDateTime;

public class Battles { // Stretch Goal
	
	int battleId; // Battle ID
	int encounterId; // Encounter ID Battle is associated with
	LocalDateTime createdDate; // LocalDateTime the Battle was created
	String initiativeOrder; // List of Player and Monster names in initiative order delimited by '|' character

}
