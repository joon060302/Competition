package Competition;

import java.lang.reflect.Array;
import java.util.*;
//doesn't work
public class ACSL0506_4 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String nodeCoord = sc.nextLine();
        int[][] node = new int[((nodeCoord.length()-3)/4)][2];
        int[][] endNode = new int [1][4];

        int counter = 0;

        int maxX=0; int maxY=0;

        for(int i=0; i<nodeCoord.length()-3; i = i +4){
            node[counter][0] = Character.getNumericValue(nodeCoord.charAt(i));
            node[counter][1] = Character.getNumericValue(nodeCoord.charAt(i+2));
            if (maxX < node[counter][0]){
                maxX = node[counter][0];
            }
            if (maxY < node[counter][1]){
                maxY = node[counter][1];
            }
            counter++;
        }

        for(int i=0; i<endNode.length; i++){
            String temp = sc.nextLine();
            endNode[i][0] = Character.getNumericValue(temp.charAt(0));
            endNode[i][1] = Character.getNumericValue(temp.charAt(2));
            endNode[i][2] = Character.getNumericValue(temp.charAt(4));
            endNode[i][3] = Character.getNumericValue(temp.charAt(6));
        }

        int[][] graph = new int[maxX+1][maxY+1];

        for(int i=0; i<node.length; i++){
            graph[node[i][0]][node[i][1]] = 1;
        }

        ArrayList<Integer>[] sol = new ArrayList[2];

        System.out.println(Arrays.deepToString(graph));

        for(int i=0; i<endNode.length; i++){
            ArrayList<Integer> solx = new ArrayList<Integer>();
            ArrayList<Integer> soly = new ArrayList<Integer>();
            solx.add(endNode[0][0]);
            soly.add(endNode[0][1]);
            sol = findPath(endNode[0][0], endNode[0][1], endNode[0][2], endNode[0][3], graph, solx, soly);
            
            for(int j=0; j<solx.size(); j++){
                System.out.print(solx.get(j)+ "," + soly.get(j) + ",");
            }
        }
    }

    public static ArrayList<Integer>[] findPath (int startX, int startY, int endX, int endY, int[][] board, ArrayList<Integer> solx, ArrayList<Integer> soly){

        if (startX == solx.get(solx.size()-1) && startY == soly.get(soly.size()-1)){
            solx.add(-1);
            soly.add(-1);
            ArrayList<Integer>[] sol = new ArrayList[2];
            sol[0] = solx;
            sol[1] = soly;
            return sol;
        }
        else if (startX == endX && startY == endY){
            solx.add(endX);
            soly.add(endY);
            ArrayList<Integer>[] sol = new ArrayList[2];
            sol[0] = solx;
            sol[1] = soly;
            return sol;
        }
        else {
            if(startX < endX){
                if (startY < endY){
                    if (board[startX+1][startY+1] == 1){
                        board[startX+1][startY+1] = 2;
                        startX++;
                        startY++;
                    }
                    else if (board[startX+1][startY] == 1){
                        board[startX+1][startY] = 2;
                        startX++;
                    }
                    else if (board[startX+1][startY-1] == 1){
                        board[startX+1][startY-1] = 2;
                        startX++;
                        startY--;
                    }
                }
                else if (startY > endY){
                    if (board[startX+1][startY-1] == 1){
                        board[startX+1][startY-1] = 2;
                        startX++;
                        startY--;
                    }
                    else if (board[startX+1][startY] == 1){
                        board[startX+1][startY] = 2;
                        startX++;
                    }
                    else if (board[startX+1][startY+1] == 1){
                        board[startX+1][startY+1] = 2;
                        startX++;
                        startY++;
                    }
                }
                else if (startY == endY){
                    if (board[startX+1][startY] == 1){
                        board[startX+1][startY] = 2;
                        startX++;
                    }
                    else if (board[startX+1][startY+1] == 1){
                        board[startX+1][startY+1] = 2;
                        startX++;
                        startY++;
                    }
                    else if (board[startX+1][startY-1] == 1){
                        board[startX+1][startY-1] = 2;
                        startX++;
                        startY--;
                    }
                }
            }
            else if(startX > endX){
                if (startY < endY){
                    if (board[startX-1][startY+1] == 1){
                        board[startX-1][startY+1] = 2;
                        startX--;
                        startY++;
                    }
                    else if (board[startX-1][startY] == 1){
                        board[startX-1][startY] = 2;
                        startX--;
                    }
                    else if (board[startX-1][startY-1] == 1){
                        board[startX-1][startY-1] = 2;
                        startX--;
                        startY--;
                    }
                }
                else if (startY > endY){
                    if (board[startX-1][startY-1] == 1){
                        board[startX-1][startY-1] = 2;
                        startX--;
                        startY--;
                    }
                    else if (board[startX-1][startY] == 1){
                        board[startX-1][startY] = 2;
                        startX--;
                    }
                    else if (board[startX-1][startY+1] == 1){
                        board[startX-1][startY+1] = 2;
                        startX--;
                        startY++;
                    }
                }
                else if (startY == endY){
                    if (board[startX-1][startY] == 1){
                        board[startX-1][startY] = 2;
                        startX--;
                    }
                    else if (board[startX-1][startY+1] == 1){
                        board[startX-1][startY+1] = 2;
                        startX--;
                        startY++;
                    }
                    else if (board[startX-1][startY-1] == 1){
                        board[startX-1][startY-1] = 2;
                        startX--;
                        startY--;
                    }
                }
            }
            else if(startX == endX){
                if (startY < endY){
                    if (board[startX][startY+1] == 1){
                        board[startX][startY+1] = 2;
                        startY++;
                    }
                    else if (board[startX][startY] == 1){
                        board[startX][startY] = 2;
                    }
                    else if (board[startX][startY-1] == 1){
                        board[startX][startY-1] = 2;
                        startY--;
                    }
                }
                else if (startY > endY){
                    if (board[startX][startY-1] == 1){
                        board[startX][startY-1] = 2;
                        startY--;
                    }
                    else if (board[startX][startY] == 1){
                        board[startX][startY] = 2;
                    }
                    else if (board[startX][startY+1] == 1){
                        board[startX][startY+1] = 2;
                        startY++;
                    }
                }
                else if (startY == endY){
                    if (board[startX][startY] == 1){
                        board[startX][startY] = 2;
                    }
                    else if (board[startX][startY+1] == 1){
                        board[startX][startY+1] = 2;
                        startY++;
                    }
                    else if (board[startX][startY-1] == 1){
                        board[startX][startY-1] = 2;
                        startY--;
                    }
                }
            }

            solx.add(startX);
            soly.add(startY);

            return findPath (startX, startY, endX, endY, board, solx, soly);
        }
    }
}
