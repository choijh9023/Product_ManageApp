package com.ssg.productservice.dto; // 패키지 선언

import lombok.AllArgsConstructor; // 필요한 라이브러리 import
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max; // 필요한 라이브러리 import
import javax.validation.constraints.Min; // 필요한 라이브러리 import
import javax.validation.constraints.Positive; // 필요한 라이브러리 import

@Builder // 빌더 패턴을 생성하기 위한 Lombok 애노테이션
@Data // Getter, Setter, toString 등을 자동으로 생성하기 위한 Lombok 애노테이션
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자를 자동으로 생성하기 위한 Lombok 애노테이션
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 자동으로 생성하기 위한 Lombok 애노테이션
public class PageRequestDTO { // 클래스 선언

    @Builder.Default // 기본값 설정을 위한 Lombok 애노테이션
    @Min(value = 1) // 최소값 제한을 위한 Validation 애노테이션
    @Positive // 양수 여부를 확인하기 위한 Validation 애노테이션
    private int page = 1; // 페이지 번호를 저장하는 변수, 기본값은 1

    @Builder.Default // 기본값 설정을 위한 Lombok 애노테이션
    @Min(value = 10) // 최소값 제한을 위한 Validation 애노테이션
    @Max(value = 100) // 최대값 제한을 위한 Validation 애노테이션
    @Positive // 양수 여부를 확인하기 위한 Validation 애노테이션
    private int size = 10; // 페이지 크기를 저장하는 변수, 기본값은 10

    private String link; // 링크를 저장하는 변수
    private String[] types; // 타입을 저장하는 배열 변수
    private String keyword; // 키워드를 저장하는 변수


    public int getSkip() { // skip 값을 계산하여 반환하는 메서드
        return (page - 1) * 10; // 페이지 번호에 따라 skip 값 계산
    }

    public String getLink() { // 링크를 생성하고 반환하는 메서드
        if (link == null) { // 링크가 null인 경우
            StringBuilder builder = new StringBuilder(); // StringBuilder 객체 생성
            builder.append("page=" + this.page); // 페이지 번호 추가
            builder.append("&size=" + this.size); // 페이지 크기 추가
            link = builder.toString(); // 링크 생성
        }
        return link; // 링크 반환
    }


}
