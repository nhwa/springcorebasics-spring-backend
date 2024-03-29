package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 자동으로 component가 붙은 클래스들을 스프링 컨테이너에 등록
// 이전코드를 유지하기 위해 임의로 AppConfig, TestConfig와 같은 설정정보를 컴포넌트 스캔 대상에서 제외함
@ComponentScan(
        //탐색할 패키지의 시작 위치를 지정한다. : basepackages 쓰지말고 config파일 최상단에 위치시키는걸 권장
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes =  Configuration.class)
)
public class AutoAppConfig {

    // 빈 등록 충돌이 나면 오류시 스프링 부트 에러
    // => 빈등록시 충돌이 나지 않도록 설정하는게 개발하는데 중요한 원칙!
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
