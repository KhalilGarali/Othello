import java.util.ArrayList;
import java.util.List;

public class PlayablePosition extends Position {
	
	
	
	public boolean isTherePiece(Position[][] board,int x, int y) {
		if((board[x][y].getPiece()==Position.BLACK) || (board[x][y].getPiece()==Position.WHITE) 
				|| (board[x][y].getPiece()==Position.UNPLAYABLE)) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	
	public List<Position> getAffectedPieces(Position[][] board, int x, int y,Player p) {
		List <Position> list = new ArrayList<Position>();
		int columnIterator = y;
		int rowIterator = x;
		//to the right
		while(columnIterator <7) {
			columnIterator++;
			Position affected = board[x][columnIterator];
			if (p.getPlayer()==1) {
			if(affected.getPiece()==Position.WHITE) {
				list.add(affected);
				continue;
			}
			if(affected.getPiece()==Position.BLACK) {
				break;
			}
			}
			else {
				if(affected.getPiece()==Position.BLACK) {
					list.add(affected);
					continue;
				}
				if(affected.getPiece()==Position.WHITE) {
					break;
				}
				
			}
		}
		// to the left
		while(columnIterator >0) {
			columnIterator--;
			Position affected = board[x][columnIterator];
			if(p.getPlayer()==1) {
			if(affected.getPiece()==Position.WHITE) {
				list.add(affected);
				continue;
			}
			if(affected.getPiece()==Position.BLACK) {
				break;
			}
			}
		else {
			if(affected.getPiece()==Position.BLACK) {
				list.add(affected);
				continue;
			}
			if(affected.getPiece()==Position.WHITE) {
				break;
			}
		}
			
		}
		//above
		while(rowIterator>0) {
			rowIterator--;
			Position affected = board[rowIterator][y];
			if(p.getPlayer()==1) {
			if(affected.getPiece()==Position.WHITE) {
				list.add(affected);
				continue;
			}
			if(affected.getPiece()==Position.BLACK) {
				break;
			}
			}
			else {
				if(affected.getPiece()==Position.BLACK) {
					list.add(affected);
					continue;
				}
				if(affected.getPiece()==Position.WHITE) {
					break;
				}
				
			}
			
		}
		//below
				while(rowIterator <7) {
					rowIterator++;
					Position affected = board[rowIterator][y];
					if(p.getPlayer()==1) {
					if(affected.getPiece()==Position.WHITE) {
						list.add(affected);
						continue;
					}
					if(affected.getPiece()==Position.BLACK) {
						break;
					}
					}
					else {
						if(affected.getPiece()==Position.BLACK) {
							list.add(affected);
							continue;
						}
						if(affected.getPiece()==Position.WHITE) {
							break;
						}
					}
					
				}
				
				//down right
				while(rowIterator <7 && columnIterator<7) {
					rowIterator++;
					columnIterator++;
					Position affected = board[rowIterator][columnIterator];
					
					if(p.getPlayer()==1) {
					if(affected.getPiece()==Position.WHITE) {
						list.add(affected);
						continue;
					}
					if(affected.getPiece()==Position.BLACK) {
						break;
					}
					}
					else {
						if(affected.getPiece()==Position.BLACK) {
							list.add(affected);
							continue;
						}
						if(affected.getPiece()==Position.WHITE) {
							break;
						}
					}
					
				}
				//down left
				while(rowIterator <7 && columnIterator<7) {
					rowIterator++;
					columnIterator--;
					Position affected = board[rowIterator][columnIterator];
					if(p.getPlayer()==1) {
					if(affected.getPiece()==Position.WHITE) {
						list.add(affected);
						continue;
					}
					if(affected.getPiece()==Position.BLACK) {
						break;
					}
					}
					else {
						if(affected.getPiece()==Position.BLACK) {
							list.add(affected);
							continue;
						}
						if(affected.getPiece()==Position.WHITE) {
							break;
						}
					}
					
				}
				//up left
				while(rowIterator >0 && columnIterator>0) {
					rowIterator--;
					columnIterator--;
					Position affected = board[rowIterator][columnIterator];
					if(p.getPlayer()==1) {
					if(affected.getPiece()==Position.WHITE) {
						list.add(affected);
						continue;
					}
					if(affected.getPiece()==Position.BLACK) {
						break;
					}
					}
					else {
						if(affected.getPiece()==Position.BLACK) {
							list.add(affected);
							continue;
						}
						if(affected.getPiece()==Position.WHITE) {
							break;
						}
					}
					
				}
				//up right
				while(rowIterator >0 && columnIterator<7) {
					rowIterator--;
					columnIterator++;
					Position affected = board[rowIterator][columnIterator];
					if(p.getPlayer()==1) {
					if(affected.getPiece()==Position.WHITE) {
						list.add(affected);
						continue;
					}
					if(affected.getPiece()==Position.BLACK) {
						break;
					}
					}
					else {
						if(affected.getPiece()==Position.BLACK) {
							list.add(affected);
							continue;
						}
						if(affected.getPiece()==Position.WHITE) {
							break;
						}
					}
					
				}
		
		return list;
		
	}
	public boolean canFlip(Position[][] board, int x, int y,Player p) {
		int columnIterator = y;
		int rowIterator = x;
		//to the right
		while(columnIterator <7) {
			columnIterator++;
			Position affected = board[x][columnIterator];
			if (p.getPlayer()==1) {
			if(affected.getPiece()==Position.WHITE) {
				continue;
			}
			else if(affected.getPiece()==Position.BLACK) {
				return true;
			}
			else {
				return false;
			}
			}
			else {
				if(affected.getPiece()==Position.BLACK) {
					continue;
				}
				else if(affected.getPiece()==Position.WHITE) {
					return true;
				}
				else {
					return false;
				}
				
			}
		}
		//to the left;
		while(columnIterator >0) {
			columnIterator--;
			Position affected = board[x][columnIterator];
			if (p.getPlayer()==1) {
			if(affected.getPiece()==Position.WHITE) {
				continue;
			}
			else if(affected.getPiece()==Position.BLACK) {
				return true;
			}
			else {
				return false;
			}
			}
			else {
				if(affected.getPiece()==Position.BLACK) {
					continue;
				}
				else if(affected.getPiece()==Position.WHITE) {
					return true;
				}
				else {
					return false;
				}
				
			}
		}
		//above
		while(rowIterator >0) {
			rowIterator--;
			Position affected = board[rowIterator][y];
			if (p.getPlayer()==1) {
			if(affected.getPiece()==Position.WHITE) {
				continue;
			}
			else if(affected.getPiece()==Position.BLACK) {
				return true;
			}
			else {
				return false;
			}
			}
			else {
				if(affected.getPiece()==Position.BLACK) {
					continue;
				}
				else if(affected.getPiece()==Position.WHITE) {
					return true;
				}
				else {
					return false;
				}
				
			}
		}
		//below
		while(rowIterator <7) {
			rowIterator++;
			Position affected = board[rowIterator][y];
			if (p.getPlayer()==1) {
			if(affected.getPiece()==Position.WHITE) {
				continue;
			}
			else if(affected.getPiece()==Position.BLACK) {
				return true;
			}
			else {
				return false;
			}
			}
			else {
				if(affected.getPiece()==Position.BLACK) {
					continue;
				}
				else if(affected.getPiece()==Position.WHITE) {
					return true;
				}
				else {
					return false;
				}
				
			}
		}
		//down right
		while(rowIterator <7 && columnIterator<7) {
			rowIterator++;
			columnIterator++;
			Position affected = board[rowIterator][columnIterator];
			if (p.getPlayer()==1) {
			if(affected.getPiece()==Position.WHITE) {
				continue;
			}
			else if(affected.getPiece()==Position.BLACK) {
				return true;
			}
			else {
				return false;
			}
			}
			else {
				if(affected.getPiece()==Position.BLACK) {
					continue;
				}
				else if(affected.getPiece()==Position.WHITE) {
					return true;
				}
				else {
					return false;
				}
				
			}
		}
		
		//down left
				while(rowIterator <7 && columnIterator<7) {
					rowIterator++;
					columnIterator--;
					Position affected = board[rowIterator][columnIterator];
					if (p.getPlayer()==1) {
					if(affected.getPiece()==Position.WHITE) {
						continue;
					}
					else if(affected.getPiece()==Position.BLACK) {
						return true;
					}
					else {
						return false;
					}
					}
					else {
						if(affected.getPiece()==Position.BLACK) {
							continue;
						}
						else if(affected.getPiece()==Position.WHITE) {
							return true;
						}
						else {
							return false;
						}
						
					}
				}
				//up right
				while(rowIterator >0 && columnIterator<7) {
					rowIterator--;
					columnIterator++;
					Position affected = board[rowIterator][columnIterator];
					if (p.getPlayer()==1) {
					if(affected.getPiece()==Position.WHITE) {
						continue;
					}
					else if(affected.getPiece()==Position.BLACK) {
						return true;
					}
					else {
						return false;
					}
					}
					else {
						if(affected.getPiece()==Position.BLACK) {
							continue;
						}
						else if(affected.getPiece()==Position.WHITE) {
							return true;
						}
						else {
							return false;
						}
						
					}
				}
				
				//up let
				while(rowIterator >0 && columnIterator >0) {
					rowIterator--;
					columnIterator--;
					Position affected = board[rowIterator][columnIterator];
					if (p.getPlayer()==1) {
					if(affected.getPiece()==Position.WHITE) {
						continue;
					}
					else if(affected.getPiece()==Position.BLACK) {
						return true;
					}
					else {
						return false;
					}
					}
					else {
						if(affected.getPiece()==Position.BLACK) {
							continue;
						}
						else if(affected.getPiece()==Position.WHITE) {
							return true;
						}
						else {
							return false;
						}
						
					}
				}

		
		
		return true;
		
	}
	
	public void flip(List<Position> affectedPieces) {
		for(int i =0;i<affectedPieces.size();i++) {
			Position spot = affectedPieces.get(i);
			if(spot.getPiece()==Position.BLACK) {
				spot.setPiece(WHITE);
				affectedPieces.remove(i);
			}
			else {
				spot.setPiece(BLACK);
				affectedPieces.remove(i);
			}
		}
		
	}
	
	public boolean canPlay(Position[][] board,int x, int y, Player p) {
		
		if(isTherePiece(board,x,y)==true 	||( board[x+1][y].getPiece()==Position.EMPTY
											&& board[x-1][y].getPiece()==Position.EMPTY
											&& board[x][y+1].getPiece()==Position.EMPTY
											&& board[x][y-1].getPiece()==Position.EMPTY
											&& board[x+1][y+1].getPiece()==Position.EMPTY
											&& board[x-1][y-1].getPiece()==Position.EMPTY
											&& board[x+1][y-1].getPiece()==Position.EMPTY
											&& board[x-1][y+1].getPiece()==Position.EMPTY)
			|| canFlip(board,x,y,p)== false){
			return false;
		}
		
		else {
			flip(getAffectedPieces(board,x,y,p));
			
		}
		return true;
	}
}


