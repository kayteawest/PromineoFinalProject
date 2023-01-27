package com.dmtool.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dmtool.models.CreateEncounterRequest;
import com.dmtool.models.Encounters;

public interface IEncountersController {
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	int createEncounter( @RequestBody CreateEncounterRequest createEncounterRequest);
	
	@GetMapping("/{encounterId}")
	@ResponseStatus(code = HttpStatus.OK)
	Encounters getEncounter(@PathVariable int encounterId);
	
	@PutMapping("/{encounterId}/playerCharacters/{playerCharacterId}")
	@ResponseStatus(code = HttpStatus.OK)
	void addPlayerCharacter(@PathVariable int encounterId, @PathVariable int playerCharacterId);
	
	@DeleteMapping("/{encounterId}/playerCharacters/{playerCharacterId}")
	@ResponseStatus(code = HttpStatus.OK)
	void removePlayerCharacter(@PathVariable int encounterId, @PathVariable int playerCharacterId);
	
	@DeleteMapping("/{encounterId}")
	@ResponseStatus(code = HttpStatus.OK)
	void deleteEncounter( @PathVariable int encounterId);

}
