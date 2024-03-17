package com.ssg.productservice.dto; // 패키지 선언

import lombok.Builder; // 필요한 클래스 import
import lombok.Getter;
import lombok.ToString;

import java.util.List; // java.util 패키지에서 List 클래스 import

@Getter // 모든 필드에 대한 getter 생성을 위한 Lombok 애노테이션
@ToString // toString() 메서드를 생성하기 위한 Lombok 애노테이션
public class PageResponseDTO<E> { // 제네릭 타입 E를 갖는 클래스 선언

    private int page; // 정수형 변수 page 선언
    private int size; // 정수형 변수 size 선언
    private int total; // 정수형 변수 total 선언
    private int start; // 정수형 변수 start 선언
    private int end; // 정수형 변수 end 선언
    private boolean prev; // 불리언 변수 prev 선언
    private boolean next; // 불리언 변수 next 선언
    private List<E> dtoList; // DTO의 리스트인 dtoList 선언

    @Builder(builderMethodName = "withAll") // 메서드 이름을 명시하는 롬복 빌더 애노테이션
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) { // 매개변수를 갖는 생성자 선언
        this.page = pageRequestDTO.getPage(); // PageRequestDTO 객체로부터 페이지 번호 할당
        this.size = pageRequestDTO.getSize(); // PageRequestDTO 객체로부터 페이지 크기 할당

        this.total = total; // 총 아이템 수 할당
        this.dtoList = dtoList; // DTO의 리스트 할당

        // 페이지네이션을 위한 시작과 끝 인덱스 계산
        this.end = (int) (Math.ceil(this.page / 10.0)) * 10;
        this.start = this.end - 9;
        int last = (int)(Math.ceil((total / ( double) size)));
        this.end = end > last ? last : end;

        // 이전 페이지와 다음 페이지 여부 결정
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
