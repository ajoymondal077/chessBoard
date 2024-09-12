import java.awt.*;
import javax.swing.*;
public class chessBoardGUI{
    public static void main(String args[])
    {
        JFrame frame = new JFrame("Chess Board");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel chessBoard = new JPanel();
        chessBoard.setLayout(new GridLayout(8,8));
        boolean isWhite = true;

        ImageIcon blackRook = scaleImage("images/black rook.png", 80, 80);
        ImageIcon blackKnight = scaleImage("images/black knight.png", 80, 80);
        ImageIcon blackBishop = scaleImage("images/black bishop.png", 80, 80);
        ImageIcon blackQueen = scaleImage("images/black queen.png", 80, 80);
        ImageIcon blackKing = scaleImage("images/black king.png", 80, 80);
        ImageIcon blackPawn = scaleImage("images/black pawn.png", 80, 80);

        ImageIcon whiteRook = scaleImage("images/white rook.png", 80, 80);
        ImageIcon whiteKnight = scaleImage("images/white knight.png", 80, 80);
        ImageIcon whiteBishop = scaleImage("images/white bishop.png", 80, 80);
        ImageIcon whiteQueen = scaleImage("images/white queen.png", 80, 80);
        ImageIcon whiteKing = scaleImage("images/white king.png", 80, 80);
        ImageIcon whitePawn = scaleImage("images/white pawn.png", 80, 80);


        JLabel[][] chessBoardSquares = new JLabel[8][8];

        for(int row = 0;row<8;row++)
        {
            for(int col = 0;col<8;col++)
            {
                JPanel square = new JPanel(new BorderLayout());
                if(isWhite)
                {
                    square.setBackground(Color.WHITE);
                }
                else{
                    square.setBackground(Color.GRAY);
                }
                chessBoard.add(square);
                isWhite = !isWhite;

                JLabel pieceLabel = new JLabel();
                if(row == 0)
                {
                    if(col == 0 || col == 7)
                    {
                        pieceLabel.setIcon(blackRook);
                    }
                    if(col == 1 || col == 6)
                    {
                        pieceLabel.setIcon(blackKnight);
                    }
                    if(col == 2 || col == 5)
                    {
                        pieceLabel.setIcon(blackBishop);
                    }
                    if(col == 3)
                    {
                        pieceLabel.setIcon(blackQueen);
                    }
                    if(col == 4)
                    {
                        pieceLabel.setIcon(blackKing);
                    }
                }
                else if(row == 1)
                {
                    pieceLabel.setIcon(blackPawn);
                }
                else if(row == 6)
                {
                    pieceLabel.setIcon(whitePawn);
                }
                else if(row == 7)
                {
                    if(col == 0 || col == 7)
                    {
                        pieceLabel.setIcon(whiteRook);
                    }
                    if(col == 1 || col == 6)
                    {
                        pieceLabel.setIcon(whiteKnight);
                    }
                    if(col == 2 || col == 5)
                    {
                        pieceLabel.setIcon(whiteBishop);
                    }
                    if(col == 3)
                    {
                        pieceLabel.setIcon(whiteQueen);
                    }
                    if(col == 4)
                    {
                        pieceLabel.setIcon(whiteKing);
                    }
                }

                square.add(pieceLabel);
                chessBoard.add(square);
            }
            isWhite = !isWhite; 
        }
        frame.add(chessBoard,BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static ImageIcon scaleImage(String path,int width,int height)
    {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}