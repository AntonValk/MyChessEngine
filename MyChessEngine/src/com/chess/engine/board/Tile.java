/**
 * Tile class
 * @author Antonios Valkanas
 * Version 1.0
 * Created on: Dec. 11 2017
 * Last edit: Dec. 11 2017
 */

package com.chess.engine.board;

import java.util.HashMap;
import java.util.Map;
import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

public abstract class Tile {	
	// final keyword used in variables to make class immutable
	// which means that all empty tiles that are valid can be created up-front
	// so when we are looking for an empty tile we can search it in cache instead of creating it

	protected final int tileCoordinate;	// can only be accessed by its sub-classes, cannot be modified

	private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
		
	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles(){
		
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		
		for(int i = 0; i < BoardUtils.NUM_TILES; i++){
			emptyTileMap.put(i,  new EmptyTile(i));
		}
		
		return ImmutableMap.copyOf(emptyTileMap); // Could have used Collections.unmodifiableMap(emptyTileMap);	
		// This makes use of Guava library; could have also used return emptyTileMap;
		// ImmutableMap is used so that the map cannot be modified.
		
	}
	
	public static Tile createTile(final int tileCoordinate, final Piece piece){
		// if the piece is not null return occupied tile coordinate & piece 
		// otherwise create empty tile from map
		/*
		 * Ternary Conditional Operator
		 * int opening_time = (day == SUNDAY) ? 12 : 9;
		 * int opening_time;
		 *	if (day == SUNDAY)
    	 *		opening_time = 12;
		 *	else
    	 *		opening_time = 9;
		 */
		return piece != null ? new OccupiedTile(tileCoordinate, piece): EMPTY_TILES_CACHE.get(tileCoordinate);
	}
	
	private Tile(final int tileCoordinate){
		this.tileCoordinate = tileCoordinate;
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile{

		private EmptyTile(final int coordinate){
			super(coordinate);
		}

		@Override
		public boolean isTileOccupied(){
			return false;
		}

		@Override
		public Piece getPiece(){
			return null;
		}

	}
	
	public static final class OccupiedTile extends Tile{
		
		private final Piece pieceOnTile;	// cannot reference variable from outside unless getPiece gets called.
		
		private OccupiedTile(int coordinate, final Piece pieceOnTile){
			super(coordinate);
			this.pieceOnTile = pieceOnTile;
		}
		
		@Override
		public boolean isTileOccupied(){
			return true;
		}

		@Override
		public Piece getPiece(){
			return pieceOnTile;
		}
		
		
	}

}
