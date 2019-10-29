package leetcode;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;++i){
            int bitVector=0;
            for(int j=0;j<col;++j){
                if(board[i][j]!='.'){
                    int num=board[i][j]-'0';
                    if(num>9)   return false;
                    if(((bitVector>>num)&1)==0){
                        bitVector|=(1<<num);
                    }else{
                        return false;
                    }
                }
            }
        }
        for(int i=0;i<row;++i){
            int bitVector=0;
            for(int j=0;j<col;++j){
                if(board[j][i]!='.'){
                    int num=board[j][i]-'0';
                    if(num>9)   return false;
                    if(((bitVector>>num)&1)==0){
                        bitVector|=(1<<num);
                    }else{
                        return false;
                    }
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int bitVector=0;
                for(int x=0;x<3;x++){
                    for(int y=0;y<3;y++){
                        if(board[i*3+x][j*3+y]!='.'){
                            int num=board[i*3+x][j*3+y]-'0';
                            if(num>9)   return false;
                            if(((bitVector>>num)&1)==0){
                                bitVector|=(1<<num);
                            }else{
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
    }

}
