package Object;

public class Board {
    public static void main(String[] args) {
        var board = new BoardEx();
        board.setTitle("내 게시글 입니다.");
        System.out.println(board.getTitle());
        System.out.println(board);
        System.out.println(board.toString());

    }
}

class BoardEx extends Object{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "BoardEx{" +
                "title='" + title + '\'' +
                '}';
    }
}
