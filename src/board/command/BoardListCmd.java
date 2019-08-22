package board.command;

import board.model.*;
import javax.servlet.http.*;
import java.util.*;

public class BoardListCmd implements BoardCmd{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<BoardDTO> list;
		//DAO의 메소드를 통해서 list에 전달함
		BoardDAO dao = new BoardDAO();
		
		int pageCnt=0;
		String curPage = request.getParameter("curPage");
		if(curPage==null) curPage="1";
		pageCnt = dao.boardPageCnt();
		request.setAttribute("pageCnt", pageCnt);
		
		list = dao.boardList(curPage);
		request.setAttribute("boardList", list);
	}
}
