package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

    /**
     * A list of the active games
     */
    private static List<Game> games = new ArrayList<>();
    private static List<Team> teams = new ArrayList<>();
    private static List<Player> players = new ArrayList<>();

    /*
     * Holds the next game identifier
     */
    private static long nextGameId = 1;
    private long nextTeamId = 1;
    private long nextPlayerId = 1;
    private static GameService service = null;

    // Private constructor to prevent external instantiation
    private GameService() {
        //
    }

    public static GameService getInstance() {
        if (service == null) {
            service = new GameService();
        }
        return service;
    }

    /**
     * Construct a new game instance
     *
     * @param name the unique name of the game
     * @return the game instance (new or existing)
     */
    public Game addGame(String name) {
        // Implement iterator pattern to check for existing games with the same name
        for (Game game : games) {
            if (game.getName().equals(name)) {
                return game; // Return the existing game instance
            }
        }

        // If not found, make a new game instance and add to the list of games
        Game newGame = new Game(nextGameId++, name);
        games.add(newGame);

        // Return the new/existing game instance to the caller
        return newGame;
    }

    /**
     * Construct a new team instance
     *
     * @param name the unique name of the team
     * @return the team instance (new or existing)
     */
    public Team addTeam(String name) {
        // Implement iterator pattern to check for existing teams with the same name
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team; // Return the existing team instance
            }
        }

        // If not found, make a new team instance and add to the list of teams
        Team newTeam = new Team(nextTeamId++, name);
        teams.add(newTeam);

        // Return the new/existing team instance to the caller
        return newTeam;
    }

    /**
     * Construct a new player instance
     *
     * @param name the unique name of the player
     * @return the player instance (new or existing)
     */
    public Player addPlayer(String name) {
        // Implement iterator pattern to check for existing players with the same name
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player; // Return the existing player instance
            }
        }

        // If not found, make a new player instance and add to the list of players
        Player newPlayer = new Player(nextPlayerId++, name);
        players.add(newPlayer);

        // Return the new/existing player instance to the caller
        return newPlayer;
    }

    /**
     * Returns the game instance at the specified index.
     * <p>
     * Scope is package/local for testing purposes.
     * </p>
     *
     * @param index index position in the list to return
     * @return requested game instance
     */
    Game getGame(int index) {
        return games.get(index);
    }

    /**
     * Returns the game instance with the specified id.
     *
     * @param id unique identifier of game to search for
     * @return requested game instance
     */
    public Game getGame(long id) {
        // Implement iterator pattern to search for a game with the specified id
        for (Game game : games) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null; // Return null if not found
    }

    /**
     * Returns the game instance with the specified name.
     *
     * @param name unique name of game to search for
     * @return requested game instance
     */
    public Game getGame(String name) {
        // Implement iterator pattern to search for a game with the specified name
        for (Game game : games) {
            if (game.getName().equals(name)) {
                return game;
            }
        }
        return null; // Return null if not found
    }

    /**
     * Returns the number of games currently active
     *
     * @return the number of games currently active
     */
    public int getGameCount() {
        return games.size();
    }

}