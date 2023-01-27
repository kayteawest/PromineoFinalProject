package com.dmtool.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dmtool.models.CreatePlayerCharacterRequest;
import com.dmtool.models.CreatePlayerRequest;
import com.dmtool.models.PlayerCharacters;
import com.dmtool.models.Players;
import com.dmtool.models.UpdatePlayerCharacterRequest;
import com.dmtool.models.UpdatePlayerRequest;

public interface IPlayersController {
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	int createPlayer ( @RequestBody CreatePlayerRequest createPlayerRequest);
	
	@PostMapping("/{playerId}/playerCharacters/create")
	@ResponseStatus(code = HttpStatus.OK)
	int createPlayerCharacter( @PathVariable int playerId, @RequestBody CreatePlayerCharacterRequest createPlayerCharacterRequest);
	
	@GetMapping("/{playerId}")
	@ResponseStatus(code = HttpStatus.OK)
	Players getPlayer(@PathVariable int playerId);
	
	@GetMapping("/{playerId}/playerCharacters/{playerCharacterId}")
	@ResponseStatus(code = HttpStatus.OK)
	PlayerCharacters getPlayerCharacter( @PathVariable int playerId, @PathVariable int playerCharacterId);
	
	@PatchMapping("/{playerId}")
	@ResponseStatus(code = HttpStatus.OK)
	void updatePlayer( @PathVariable int playerId, @RequestBody UpdatePlayerRequest updatePlayerRequest);
	
	@PatchMapping("/{playerId}/playerCharacters/{playerCharacterId}")
	@ResponseStatus(code = HttpStatus.OK)
	void updatePlayerCharacter( @PathVariable int playerId, @PathVariable int playerCharacterId, @RequestBody UpdatePlayerCharacterRequest updatePlayerCharacterRequest);
	
	@DeleteMapping("/{playerId}")
	@ResponseStatus(code = HttpStatus.OK)
	void deletePlayer( @PathVariable int playerId);
	
	@DeleteMapping("/{playerId}/playerCharacters/{playerCharacterId}")
	@ResponseStatus(code = HttpStatus.OK)
	void deletePlayerCharacter( @PathVariable int playerId, @PathVariable int playerCharacterId);

}
