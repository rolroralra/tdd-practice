package com.example.tdd.debit;

import static com.example.tdd.debit.CardValidity.THEFT;
import static com.example.tdd.debit.CardValidity.VALID;
import static org.junit.jupiter.api.Assertions.*;

import com.example.tdd.debit.repository.AutoDebitInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AutoDebitRegisterTest {
    private AutoDebitRegister register;

    @BeforeEach
    void setUp() {
        CardNumberValidator validator = new CardNumberValidator();
        AutoDebitInfoRepository repository = null;
        register = new AutoDebitRegister(validator, repository);
    }

    @Disabled("Test Double 없이 테스트를 실행하면 외부 의존성으로 인해 테스트가 실패합니다.")
    @Test
    void validCard() {
        // 업체에서 받은 테스트용 유효한 카드 번호 사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234123412341234");
        RegisterResult result = this.register.register(req);
        assertEquals(VALID, result.getValidity());
    }

    @Disabled("Test Double 없이 테스트를 실행하면 외부 의존성으로 인해 테스트가 실패합니다.")
    @Test
    void theftCard() {
        // 업체에서 받은 도난 테스트용 카드 번호 사용
        AutoDebitReq req = new AutoDebitReq("user1", "1234567890123456");
        RegisterResult result = this.register.register(req);
        assertEquals(THEFT, result.getValidity());
    }
}