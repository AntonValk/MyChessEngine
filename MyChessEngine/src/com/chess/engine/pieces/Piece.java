/**
 * Piece class
 * @author Antonios Valkanas
 * Version 1.0
 * Created on: Dec. 11 2017
 * Last edit: Dec. 11 2017
 */


package com.chess.engine.pieces;

import java.util.List;
import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public abstract class Piece {

	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	
	Piece(final int piecePosition, final Alliance pieceAlliance){
		this.pieceAlliance = pieceAlliance;
		this.piecePosition = piecePosition;
	}
	
	public abstract List<Move> calculateLegalMoves(final Board board);
}
