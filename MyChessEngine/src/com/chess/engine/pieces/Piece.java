/**
 * Piece class
 * @author Antonios Valkanas
 * Version 1.0
 * Created on: Dec. 11 2017
 * Last edit: Dec. 11 2017
 */


package com.chess.engine.pieces;

import java.util.Collection;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public abstract class Piece {

	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	protected final Boolean isFirstMove;
	
	Piece(final int piecePosition, final Alliance pieceAlliance){
		this.pieceAlliance = pieceAlliance;
		this.piecePosition = piecePosition;
		// TODO: fix this later
		this.isFirstMove = false;
	}
	
	public Alliance getPieceAlliance(){
		return this.pieceAlliance;
	}
	
	public boolean isFirstMove() {
		return this.isFirstMove;
	}
	
	public abstract Collection<Move> calculateLegalMoves(final Board board);
}
