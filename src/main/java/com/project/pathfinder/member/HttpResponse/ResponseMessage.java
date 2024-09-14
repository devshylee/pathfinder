package com.project.pathfinder.member.HttpResponse;

public class ResponseMessage {
    public static final String MEMBER_POST_SUCCESS = "회원 등록 성공";
    public static final String MEMBER_POST_FAIL = "회원 등록 실패";
    public static final String MEMBER_POST_MISSING_INFO = "회원 등록 실패 : 비어있는 요소가 입력됨";
    public static final String MEMBER_POST_DUPLICATE = "회원 등록 실패 : 이미 같은 아이디가 존재함";

    public static final String MEMBER_READ_SUCCESS = "회원 조회 성공";
    public static final String MEMBER_READ_FAIL = "회원 조회 실패";

    public static final String MEMBER_UPDATE_SUCCESS = "회원 정보 수정 성공";
    public static final String MEMBER_UPDATE_FAIL = "회원 정보 수정 실패";

    public static final String MEMBER_DELETE_SUCCESS = "회원 삭제 성공";
    public static final String MEMBER_DELETE_FAIL = "회원 삭제 실패";

}
