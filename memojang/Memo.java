package memojang;

import java.util.*;

public class Memo {
    private static int num;        // 글 번호
    private String name;    // 작성자 이름
    private String password;// 비밀번호
    private String post;    // 게시글
    private String time;    // 작성일 (컴퓨터 시스템 시간 기준)

    public Memo(int num, String name, String password, String post) {
        this.num = num;
        this.name = name;
        this.password = password;
        this.post = post;
        time = dateFormat(Calendar.getInstance());
    }

    public static int getNum() { return num; }
    public String getName(){
        return name;
    }
    public String getPost(){
        return post;
    }
    public String getPassword(){
        return password;
    }
    public String getTime(){
        return time;
    }


    // 작성일 형식 반환 함수
    public String dateFormat(Calendar today) {
        return today.get(Calendar.YEAR)+"-" + (today.get(Calendar.MONTH)+1)+"-"
                + today.get(Calendar.DATE)+"-" + today.get(Calendar.HOUR)+":"
                + today.get(Calendar.MINUTE)+":" + today.get(Calendar.SECOND);
    }

    // 글 수정 작업 (구현)
    public void editPost() {
        // post(내용) 변경
        // time(시간)을 새로 수정
    }
}
