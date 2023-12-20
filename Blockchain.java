package com.servlets;

import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Blockchain
 */
@WebServlet("/Blockchain")

public class Blockchain extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Blockchain blockchain;

    public Blockchain(int i) {
        super();
        blockchain = new Blockchain(4); // Initialize with difficulty level
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            request.setAttribute("chain", blockchain.getChain());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (action.equals("mine")) {
            blockchain.addBlock(new Block(((Object) blockchain.getChain()), blockchain.getLatestBlock().getHash(),
                    "Sample Transaction"));
            response.sendRedirect("BlockchainServlet");
        }
    }

	private void addBlock(Block block) {
		// TODO Auto-generated method stub
		
	}

	private Block getLatestBlock() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getChain() {
		// TODO Auto-generated method stub
		return null;
	}
}