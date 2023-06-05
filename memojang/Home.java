package memojang;

import java.util.Scanner;

public class Home {
    private Scanner sc;
    private MemoList memoList;

    public MemoList getMemoList(){
        return memoList;
    }

    public Home() {
        sc = new Scanner(System.in);
        memoList = new MemoList();
    }

    public Scanner getScanner(){
        return sc;
    }

    public void start() {
        while(true) {
            // 0. 메모장 옵션 출력
            printOptions();
            // 옵션 번호 입력받기
            int choice = selectNum();


            switch(choice) {
                // 1. 입력 (구현)
                case 1 -> {

                    Memo memo = writeMemo();
                    // 글 생성 후 메모리스트에 저장
                    memoList.addMemo(memo);
                }

                // 2. 목록 보기 (구현)
                case 2 -> {
                    memoList.printMemoList();
                }


                // 3. 수정 (구현)
                case 3 -> {
                    // (수정할) 글 번호 입력 받기
                    // 존재 시 수정, 아닐 시 메시지 출력
                    while((choice = selectNum()) > memoList.getCount())
                        System.out.println("번호에 맞는 글이 존재하지 않습니다.");

                    // 비밀 번호 확인. 일치 시, 내용 수정. 불일치 시, 메시지 출력
                    System.out.print("비밀번호를 입력해주세요: ");
                    String password = sc.nextLine();
                    Memo memo = memoList.getMemo(choice);
                    if (memo.getPassword().equals(password)) {
                        memoList.editMemo(choice);
                    } else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    }
                }

                // 4. 삭제 (구현)
                case 4 -> {
                    // (삭제할) 글 번호 입력 받기
                    sc = new Scanner(System.in);
                    System.out.print("삭제할 번호를 입력해주세요 : ");
                    choice = sc.nextInt();

                    // 존재하지 않을 시, 아닐 시 메시지 출력
                    while(choice > memoList.getCount()) {
                        System.out.println("번호에 맞는 글이 존재하지 않습니다.");
                        choice = sc.nextInt();
                    }

                    // 비밀 번호 확인. 일치 여부 판단 후 기능 실행
                    System.out.print("비밀번호를 입력해주세요: ");
                    String password = sc.nextLine();
                    Memo memo = memoList.getMemo(choice);
                    if (memo.getPassword().equals(password)) {
                        memoList.deleteMemo(choice);
                    } else {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                    }
                }

                // 5. 종료
                case 5 -> {
                    System.out.println("메모장을 종료합니다.");
                    System.exit(0);
                }
            }
        }
    }

    // 메모장 옵션 출력
    public void printOptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------\n");
        sb.append("\t[메모장 시작 페이지]\t\n");
        sb.append("1. 입력\n2. 목록 보기\n3. 수정\n4. 삭제\n5. 종료\n");
        sb.append("-------------------------\n");
        System.out.print(sb);
    }
    // 번호 입력받기
    public int selectNum() {
        System.out.print("번호를 입력해주세요: ");
        return sc.nextInt();
    }

    // 메모 작성하기 (구현)
    public Memo writeMemo() {
        Scanner scanner = new Scanner(System.in);

        // (1) 글 번호 불러오기
        int idx = memoList.getCount() + 1;

        // (2) 이름 입력
        System.out.print("이름 : ");
        String name = scanner.nextLine();

        // (3) 비밀번호 입력
        System.out.print("비밀번호 : ");
        String password = scanner.nextLine();

        // (4) 내용 입력
        System.out.print("내용 : ");
        String post = scanner.nextLine();

        // (5) 입력된 내용 Memo 생성자로 전달 후 반환
        return new Memo(idx, name, password, post);
    }
}
