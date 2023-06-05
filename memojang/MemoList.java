package memojang;

import java.util.LinkedList;
import java.util.Scanner;

public class MemoList {
    private int count;
    private static LinkedList<Memo> list;

    public MemoList() {
        count = 0;
        this.list = new LinkedList<>();

    }

    // 메모 전체 조회 - Getter
    public static LinkedList<Memo> getMemoList() { return list; }

    // 메모 전체 조회 - Setter
    public void setMemoList(LinkedList<Memo> memoList) {
        this.list = memoList;
    }

    // 작성 최신순 메모 출력 (구현)
    public void printMemoList() {
        for (Memo memo : list) {
            System.out.println("번호: " + memo.getNum());
            System.out.println("이름: " + memo.getName());
            System.out.println("내용: " + memo.getPost());
            System.out.println("작성일: " + memo.getTime());
            System.out.println("--------------------");
        }
    }

    // 메모 1건 추가 (구현)
    public void addMemo(Memo memo){
        //기존 메모 쓰기와 다른점이 무엇인가요?
        // 기존 list에 Memo 추가
    }

    // 글 수정/삭제 시, 글 번호를 받아서 해당 메모를 반환 (구현)
    public Memo getMemo(int idx) {
        //수정삭제 클릭시
        // 글목록을 띄우고번호를 적는 칸을 생성
        //idx
        // list에서 idx에 해당하는 Memo 반환하기
        return null;
    }

    // 메모 1건 수정 (구현)
    public void editMemo(int idx) {
        // list에서 idx에 해당하는 Memo 가져오기
        // 해당 Memo의 게시글(post) 필드 갱신
    }

    // 메모 1건 삭제 (구현)
    public void deleteMemo(int idx) {
        Home home = new Home();
        Scanner sc =home.getScanner();
        // list에서 idx에 해당하는 Memo 가져오기
            list.remove(sc);
        }
        // list에서 해당 memo를 제거
        // 글 삭제 후 글 번호 재지정 작업

        // count 수정
//        minusCount();


    // 글 삭제 후 Memo의 num 필드 수정 (구현)
    public void editMemoNum(int idx){
        return;
    }

    public int getCount() {
        return count;
    }

    // 글 삭제 후 count 값 수정
    public void minusCount(){
        count--;
    }
}
