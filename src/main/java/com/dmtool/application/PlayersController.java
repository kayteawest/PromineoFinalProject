package com.dmtool.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dmtool.interfaces.IPlayerCharactersDataAccessLayer;
import com.dmtool.interfaces.IPlayersController;
import com.dmtool.interfaces.IPlayersDataAccessLayer;
import com.dmtool.models.CreatePlayerCharacterRequest;
import com.dmtool.models.CreatePlayerRequest;
import com.dmtool.models.Player;
import com.dmtool.models.PlayerCharacter;
import com.dmtool.models.UpdatePlayerCharacterRequest;
import com.dmtool.models.UpdatePlayerRequest;

@RestController
public class PlayersController implements IPlayersController {

	@Autowired
	private IPlayersDataAccessLayer playersDataAccess;

	@Autowired
	private IPlayerCharactersDataAccessLayer playerCharactersDataAccess;

	@Override
	public int createPlayer(CreatePlayerRequest createPlayerRequest) {

		int playerId = playersDataAccess.insertPlayer(createPlayerRequest.getPlayerName());

		CreatePlayerCharacterRequest[] characterRequests = createPlayerRequest.getCharacters();

		if (characterRequests != null) {

			for (CreatePlayerCharacterRequest characterRequest : characterRequests) {

				createPlayerCharacter(playerId, characterRequest);
			}

		}

		return playerId;
	}

	@Override
	public int createPlayerCharacter(int playerId, CreatePlayerCharacterRequest createPlayerCharacterRequest) {

		return playerCharactersDataAccess.insertPlayerCharacter(playerId,
				createPlayerCharacterRequest.getCharacterName(), createPlayerCharacterRequest.getInitiativeBonus());
	}

	@Override
	public Player getPlayer(int playerId) {

		return playersDataAccess.selectPlayerById(playerId);
	}

	@Override
	public PlayerCharacter getPlayerCharacter(int playerId, int playerCharacterId) {

		return playerCharactersDataAccess.selectPlayerCharacterById(playerCharacterId);
	}

	@Override
	public void updatePlayer(int playerId, UpdatePlayerRequest updatePlayerRequest) {

		playersDataAccess.updatePlayerById(playerId, updatePlayerRequest.getPlayerName());
	}

	@Override
	public void updatePlayerCharacter(int playerId, int playerCharacterId,
			UpdatePlayerCharacterRequest updatePlayerCharacterRequest) {

		playerCharactersDataAccess.updatePlayerCharacterById(playerCharacterId,
				updatePlayerCharacterRequest.getPlayerCharacterName(),
				updatePlayerCharacterRequest.getInitiativeBonus());
	}

	@Override
	public void deletePlayer(int playerId) {

		playersDataAccess.deletePlayerById(playerId);
	}

	@Override
	public void deletePlayerCharacter(int playerId, int playerCharacterId) {

		playerCharactersDataAccess.deletePlayerCharacterById(playerCharacterId);
	}
}
