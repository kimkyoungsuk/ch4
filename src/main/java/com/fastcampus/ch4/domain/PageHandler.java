package com.fastcampus.ch4.domain;

public class PageHandler {
    int totalCnt; // 총 게시물 갯수
    int pageSize; // 한페이지 크기
    int naviSize = 10; // 페이지 내비게이션의 크기
    int totalPage; // 전체 페이지의 갯수
    int page; // 현재 페이지
    int beginPage; //내비게이션의 첫번째 페이지
    int endPage; //내비게이션의 마지막 페이지
    boolean showPrew; //이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
    boolean showNext; //다음 페이지로 이동하는 링크를 보여줄 것인지의 여부

    public PageHandler(int totalCnt, int page){
        this(totalCnt, page, 10);
    }
    public PageHandler(int totalCnt, int page, int pageSize){
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);  //게시물 총갯수/한페이지 크기
        beginPage = page / naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize -1, totalPage);
        showPrew = beginPage != 1;
        showNext = endPage != totalPage;

    }
    void print(){
        System.out.println("page = " + page);
        System.out.print(showPrew ? "[Prew]" : "");
        for(int i = beginPage; i <= endPage; i++){
            System.out.print(i + " ");
        }
        System.out.println(showNext ? "[Next]" : "");

    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrew=" + showPrew +
                ", showNext=" + showNext +
                '}';
    }
}
