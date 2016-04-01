package com.estsoft.movie_reservation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.estsoft.bookshop.vo.BookVo;
import com.estsoft.movie_reservation.vo.MovieVo;

public class MovieDao {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//1. 드라이버 로드
			Class.forName( "com.mysql.jdbc.Driver" );

			//2. Connection 얻기
			String url = "jdbc:mysql://localhost/webdb";
			conn = DriverManager.getConnection( url, "webdb", "webdb" );

		} catch (ClassNotFoundException ex) {
			System.out.println( "드라이버를 찾을 수 없습니다:" + ex );
		}		
		return conn;
	}
	
	public void insert( MovieVo movieVo ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// DB 연결 가져오기
			conn = getConnection();
			
			//Statement 준비
			String sql = "insert into movie values(  null, ? )";
			pstmt = conn.prepareStatement( sql );
			
			// bind
			pstmt.setString( 1, movieVo.getTitle() );
			
			// SQL 실행
			pstmt.executeUpdate();
			
		} catch( SQLException ex ) {
			System.out.println( "SQL 오류:" + ex );
		} finally {
			// 자원정리(clean-up)
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}		
	}
	
	public List<MovieVo> getList() {
		List<MovieVo> list = new ArrayList<MovieVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql ="SELECT no, title FROM movie ORDER BY a.no ASC";
			rs = stmt.executeQuery( sql );
			while( rs.next() ) {
				Long no = rs.getLong( 1 );
				String title = rs.getString( 2 );
				
				MovieVo movieVo = new MovieVo();
				movieVo.setNo( no );
				movieVo.setTitle( title );
				list.add( movieVo );
			}
			
		} catch( SQLException ex ) {
			System.out.println( "error : " + ex );
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
		return list;
	}	
}