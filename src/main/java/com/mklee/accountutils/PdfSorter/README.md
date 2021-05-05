# Corporate-tax pdf sorter

- 법인세 신고서 작성 위한 pdf 문서들을 특정 순서로 정렬

- input: 정렬안된신고문서모음.zip -> output: 정렬된문서.pdf
  - zip 압축해제(common)
  - pdf 파일 전체 체크(법인세신고서)
  - pdf 파일 정렬(common) 
    - 제목판별기준(common) 
    - 정렬 기준(법인세신고서)

- pdf 파일 전체 체크

- 제목판별기준
  1. 파일이름
  2. 컨텍스트가 있는 상태에서 pdf 파싱 

- 정렬 기준
  - 정렬전에 제공되어야함
  - csv 파일?
